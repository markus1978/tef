package hub.sam.tef.ocl.templates;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.utilities.PredefinedType;

import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.ocl.annotations.TypeHelper;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ElementTemplateSemantics;
import hub.sam.tef.templates.Template;

public abstract class AbstractIteratorExpTemplate extends ElementTemplate {

	private final String postFix;
	
	public AbstractIteratorExpTemplate(Template template, String postFix) {
		super(template, template.getModel().getMetaElement("IteratorExp"));
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
		IteratorExp exp = (IteratorExp)((EMFModelElement)modelElement).getEMFObject();
		
		String iteratorName = exp.getName();		
		CollectionType predefinedSourceType = TypesFactory.eINSTANCE.createCollectionType(TypeHelper.getTypeFor(exp.getSource()));
		EOperation operation = null;
		
		for(Object operationAsObj: predefinedSourceType.getOperations()) {
			if (((EOperation)operationAsObj).getName().equals(iteratorName)) {
				operation = (EOperation)operationAsObj;
			}
		}
			
		EClassifier actualType = TypeHelper.getTypeFor(exp.getBody());
		if (actualType == null) {
			return null;
		}
		if (operation != null) {			
			EClassifier requiredType = ((EParameter)operation.getEParameters().iterator().next()).getEType();				
			if (!TypeHelper.isAssignableFrom(requiredType, actualType)) {
				return "wrong arguments for '" + operation.getName() + "'";
			}	
		} else {
			int code = predefinedSourceType.getOperationCodeFor(iteratorName);
			EClassifier requiredType = getTypeForIterator(predefinedSourceType, code);		
			if (!TypeHelper.isAssignableFrom(requiredType, actualType)) {
				return "wrong arguments for '" + iteratorName + "'";
			}
		}
		return null;
	}
	
	private static  EClassifier getTypeForIterator(CollectionType type, int code) {
		switch(code) {
		case PredefinedType.EXISTS:				
		case PredefinedType.FOR_ALL:
		case PredefinedType.ONE:
		case PredefinedType.ANY:			
			return TypesFactory.eINSTANCE.createPrimitiveBoolean();
		case PredefinedType.SELECT:			
		case PredefinedType.IS_UNIQUE:			
		case PredefinedType.REJECT:
			return type.getElementType();
		case PredefinedType.COLLECT:			
		case PredefinedType.COLLECT_NESTED:
		case PredefinedType.SORTED_BY:						
		case PredefinedType.CLOSURE:
		default:
			return TypesFactory.eINSTANCE.createAnyType();				
		}
	}
}
