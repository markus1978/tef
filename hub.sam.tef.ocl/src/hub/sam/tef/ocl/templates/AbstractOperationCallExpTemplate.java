package editortest.emf.ocl.templates;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;

import editortest.emf.ocl.annotations.TypeHelper;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ElementTemplateSemantics;
import hub.sam.tef.templates.Template;

public abstract class AbstractOperationCallExpTemplate extends ElementTemplate {

	private final String postFix;
	
	public AbstractOperationCallExpTemplate(Template template, String postFix) {
		super(template, template.getModel().getMetaElement("OperationCallExp"));
		this.postFix = postFix;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (ISyntaxProvider.class == adapter) {
			return (T)new MySyntaxProvider(this);
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	class MySyntaxProvider extends ElementTemplateSemantics {
		public MySyntaxProvider(ElementTemplate elementTemplate) {
			super(elementTemplate);		
		}
		
		@Override
		public String getNonTerminal() {	
			return super.getNonTerminal() + postFix;
		}				
	}

	@Override
	public String check(IModelElement modelElement) {
		OperationCallExp exp = (OperationCallExp)((EMFModelElement)modelElement).getEMFObject();
		EOperation operation = exp.getReferredOperation();
		if (operation != null) {
			EList arguments = exp.getArgument();
			EList parameters = operation.getEParameters();
			if (arguments.size() != parameters.size()) {
				return "'" + operation.getName() + "' requires a different numbers of arguments";
			}
			int i = 0;
			for(Object parameterAsObj: parameters) {
				EParameter parameter = (EParameter)parameterAsObj;
				EClassifier requiredType = parameter.getEType();
				EClassifier actualType = TypeHelper.getTypeFor((OCLExpression)arguments.get(i));
				if (actualType == null) {
					return null;
				}
				if (!TypeHelper.isAssignableFrom(requiredType, actualType)) {
					return "wrong arguments for '" + operation.getName() + "'";
				}
				i++;
			}
			return null;
		} else {
			return null;
		}
	}
}
