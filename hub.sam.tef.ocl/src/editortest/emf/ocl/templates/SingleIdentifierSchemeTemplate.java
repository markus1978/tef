package editortest.emf.ocl.templates;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.templates.CommonSchemeTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ISchemeASTProvider;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class SingleIdentifierSchemeTemplate extends CommonSchemeTemplate {

	public SingleIdentifierSchemeTemplate(Template template) {
		super(template, template.getModel().getMetaElement("OCLExpression"));	
	}

	@Override
	protected ElementTemplate[] createAlternatives() {
		return new ElementTemplate[] {
			new VariableExpTemplate(this),
			new ImplicitSelfPropertyCallTemplate(this),
			//new TypeExpressionTemplate(this),			
		};
	}

	@Override
	protected ElementTemplate createSchemeTemplate() {
		return new SchemeTemplate(this);
	}
	
	@Override
	public boolean isTemplateFor(IModelElement model) {
		// TODO maybe this can be generalised?
		return model.getMetaElement().equals(getModel().getMetaElement("VariableExp"));
	}


	@Override
	protected ElementTemplate selectAlternative(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {				
		Object result = null;
		try {
			result = context.getIdentifierResolver().resolveIdentifier(getModel(),
					(ASTElementNode)tree.getFirstChild().getFirstChild(), owner, context.getNewModel(),
					getModel().getMetaElement("Variable"), "refferedVariable");
		} catch (CouldNotResolveIdentifierException ex) {
			// empty
		}
		if (result == null) {
			// it is not a variable, it has to be a property of self
			for (ElementTemplate template: getAlternativeTemplates()) {
				if (template instanceof ImplicitSelfPropertyCallTemplate) {
					return template;
				}
			}
		} else {
			for (ElementTemplate template: getAlternativeTemplates()) {
				if (template instanceof VariableExpTemplate) {
					return template;
				}
			}
		}
		throw new RuntimeException("unreachable");
	}
			
	@Override
	protected void adoptTree(ASTElementNode tree, ElementTemplate alternative) {
		if (alternative instanceof ImplicitSelfPropertyCallTemplate) {
			((ASTElementNode)tree).changeNodeKey("referredVariable", "referredProperty");
		}
	}



	class SchemeTemplate extends ElementTemplate {

		public SchemeTemplate(Template template) {
			super(template, template.getModel().getMetaElement("VariableExp")); 
		}

		@Override
		public Template[] createTemplates() {
			return new Template[] { new SingleValueTemplate<IModelElement>(this,
					"referredVariable") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement(
							"Variable")) {
						@Override
						protected ElementTemplate getElementTemplate() {
							return new VariableTemplate(this);
						}
					};
				}
			} };
		}
		
		@Override
		public <T> T getAdapter(Class<T> adapter) {
			if (ISchemeASTProvider.class == adapter) {
				final IASTProvider regularASTProvider = super.getAdapter(IASTProvider.class);
				return (T)Proxy.newProxyInstance(ISchemeASTProvider.class.getClassLoader(), new Class[] { ISchemeASTProvider.class }, new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {						
						return method.invoke(regularASTProvider, args);
					}					
				});
			} else if (IASTProvider.class == adapter) {
				return (T)SingleIdentifierSchemeTemplate.this.getAdapter(IASTProvider.class);
			} else {
				return super.getAdapter(adapter);
			}
		}

		@Override
		protected String getAlternativeSymbol() {
			return "SingleIdentifierScheme";
		}				
	}
}
