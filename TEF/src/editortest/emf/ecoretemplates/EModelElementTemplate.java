package editortest.emf.ecoretemplates;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import editortest.controller.Proposal;
import editortest.emf.model.EMFMetaModelElement;
import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.template.ChoiceTemplate;
import editortest.template.ElementTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.template.whitespaces.LayoutElementTemplate;
import editortest.template.whitespaces.LayoutManager;
import editortest.view.DocumentText;

public abstract class EModelElementTemplate extends ElementTemplate {

	public EModelElementTemplate(DocumentText document, IMetaModelElement metaModel) {
		super(document, metaModel);
	}

	public EModelElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);
	}

	protected Template[] getAnnotationTemplates() {
		return new Template[] {
			new LayoutElementTemplate(this, LayoutManager.INDENT),
			new TerminalTemplate(this, "annotations"),
			new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK),
			new TerminalTemplate(this, ": [\n"),
			new SequenceTemplate<IModelElement>(this, "eAnnotations", "\n", true) {
				@Override
				protected ValueTemplate<IModelElement> createElementTemplate() {
					return new EAnnotationTemplate(this);
				}
			},
			new LayoutElementTemplate(this, LayoutManager.END_BLOCK),
			new LayoutElementTemplate(this, LayoutManager.INDENT),
			new TerminalTemplate(this, "]\n")
		};
	}
	
	public Template[] getNameTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new StringTemplate(this);
				}					
			},
			new TerminalTemplate(this, ", ")
		};
	}
	
	@Override
	public Template[] createTemplates() {
		Template[] t1 = new Template[] {
				new LayoutElementTemplate(this, LayoutManager.INDENT),
				new TerminalTemplate(this, getElementKeyWord() + " ", TerminalTemplate.KEY_WORD_HIGHLIGHT),
		};
		Template[] t1x2x2 = getNameTemplates();
		Template[] t1x2 = getReferenceTemplates();
		if (t1x2 == null) {
			t1x2 = new Template[]{};
		}
		Template[] contents = getContentsTemplates();
		if (contents != null) {
			Template[] t1x3 = new Template[] {
					new TerminalTemplate(this, "\n"),
					new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK),
			};
			Template[] t2 = getAnnotationTemplates();
		    Template[] t3 = new Template[] {
		    		new LayoutElementTemplate(this, LayoutManager.END_BLOCK),
		    		new LayoutElementTemplate(this, LayoutManager.INDENT),
		    		new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK, "{\n"),
		    };
		    Template[] t4 = getContentsTemplates();
		    Template[] t5 = new Template[] {	    			    
		    		new LayoutElementTemplate(this, LayoutManager.END_BLOCK),
		    		new LayoutElementTemplate(this, LayoutManager.INDENT),
		    		new TerminalTemplate(this, "}")
			};
		    return concat(new Template[][]{ t1,t1x2x2,  t1x2, t1x3, t2, t3, t4, t5});
		} else {
			return concat(new Template[][]{ t1, t1x2x2, t1x2});
		}
	}
	
	abstract Template[] getReferenceTemplates();
	abstract String getElementKeyWord();
	abstract Template[] getContentsTemplates();
	
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}
	
	protected static Template[] concat(Template[][] ts) {		
		Collection<Template> result = new Vector<Template>();
		for(Template[] t: ts) {
			for(Template s: t) {
				result.add(s);
			}
		}
		return result.toArray(new Template[]{});
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return property.equals("name");
	}
	
	
}
