package hub.sam.tef.parse;

import hub.sam.tef.templates.Template;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.ITextVisitor;
import hub.sam.tef.views.Text;
import hub.sam.util.trees.AbstractTree;

import java.util.List;
import java.util.Vector;

public class ASTTree extends AbstractTree<ASTTree, Text> {

	private final Text fText;
	//private List<ITree<Text>> children = null;
	
	public static ASTTree createASTTree(DocumentText document) {
		CompoundText text = document;
		while (text.getElement(Template.class) == null && text.getTexts().get(0) instanceof CompoundText) {
			text = (CompoundText)text.getTexts().get(0);
		}
		if (text.getElement(Template.class) == null) {
			return null;
		} else {
			return new ASTTree(text);
		}
	}
	
	private ASTTree(Text text) {
		Template template = text.getElement(Template.class);
		this.fText = text;
	}
	
	class FindChildren implements ITextVisitor {

		private final List<ASTTree> children = new Vector<ASTTree>();
		
		public Iterable<Text> decentInto(CompoundText text) {
			if (textNodeIsASTNode(text) && text != fText) {
				return new Vector<Text>();
			} else {
				return text.getTexts();
			}
		}

		public void visitText(Text visitedText, int atOffset) {
			if (textNodeIsASTNode(visitedText) && visitedText != fText) {
				children.add(new ASTTree(visitedText));
			}
 		}
		
		public void visitCompoundText(CompoundText visitedText, int atOffset) {
			visitText(visitedText, atOffset);
		}
	}
	
	public List<ASTTree> getChildNodes() {	
		List<ASTTree> children = null;
		if (fText instanceof CompoundText) {
			FindChildren childrenFinder = new FindChildren();
			((CompoundText)fText).process(childrenFinder, 0);
			children = childrenFinder.children;
		} else {
			children = new Vector<ASTTree>();
		}
		return children;
	}
	
	public String getSymbol() {
		return getTemplate().getNonTerminal();
	}
	
	private static final boolean textNodeIsASTNode(Text text) {
		return text.getElement(Template.class) != null;
	}
	
	
	public final Template getTemplate() {
		return fText.getElement(Template.class);
	}

	public ASTTree getParent() {
		Text parent = fText.getContainer();
		while(true) {
			if (parent == null) {
				return null;
			} else {
				if (textNodeIsASTNode(parent)) {
					return new ASTTree(parent); 
				} else {
					parent = parent.getContainer();
				}
			}
		}
	}

	public Text getElement() {
		return fText;
	}

	@Override
	public String toString() {
		return getTemplate().getNonTerminal() + ":" + getElement().getContent();
	}
	
}
