package hub.sam.tef.templates;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.AST;
import hub.sam.tef.parse.IASTBasedModelUpdater;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.parse.ModelUpdateConfiguration;
import hub.sam.tef.parse.TextBasedAST;
import hub.sam.tef.parse.TextBasedUpdatedAST;
import hub.sam.tef.treerepresentation.ITreeRepresentationFromModelProvider;
import hub.sam.tef.treerepresentation.ModelBasedTreeContent;
import hub.sam.tef.treerepresentation.TreeRepresentation;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

public class CollectionTemplateSemantics implements ISyntaxProvider, IASTBasedModelUpdater, ITreeRepresentationFromModelProvider {

	private final CollectionTemplate fTemplate;
		
	protected CollectionTemplateSemantics(final CollectionTemplate template) {
		super();
		fTemplate = template;
	}

	public String getNonTerminal() {
		return fTemplate.getValueTemplate().getAdapter(ISyntaxProvider.class).getNonTerminal() + "_sequence";
	}

	public String[][] getRules() {
		ISyntaxProvider valueSyntaxProvider = fTemplate.getValueTemplate().getAdapter(ISyntaxProvider.class);
		if (fTemplate.fSeparator != null) {
			if (fTemplate.fSeparateLast) {
				return new String[][] {
						new String[] { getNonTerminal(), "'" + fTemplate.fSeparator + "'" },
						new String[] { getNonTerminal(), getNonTerminal(), "'" +fTemplate.fSeparator + "'", valueSyntaxProvider.getNonTerminal() } 
				};
			} else {
				return new String[][] {
						new String[] { getNonTerminal(), valueSyntaxProvider.getNonTerminal() },
						new String[] { getNonTerminal(), getNonTerminal(), "'" + fTemplate.fSeparator + "'", valueSyntaxProvider.getNonTerminal() } 
				};
			}
		} else {
			return new String[][] {
					new String[] { getNonTerminal(), valueSyntaxProvider.getNonTerminal() },
					new String[] { getNonTerminal(), getNonTerminal(),  valueSyntaxProvider.getNonTerminal() } 
			};
		}
	}	
	
	public TextBasedAST createAST(TextBasedAST parent, IModelElement model, Text text) {
		List<Text> elements = new Vector<Text>();		
		for(Text elementText: ((CompoundText)((CompoundText)text).getTexts().get(0)).getTexts()) {
			if (elementText instanceof CompoundText) {
				for (Text subText: ((CompoundText)elementText).getTexts()) {
					if (subText.getElement(Template.class) != null) {
						elements.add(subText);
					}
				}
			}
		}
		
		if (elements.size() == 0) {
			return null;
		}
		for (int i = 0; i < elements.size(); i++) {
			TextBasedAST valueNode = new TextBasedAST(elements.get(i));			
			TextBasedAST sequenceNode = new TextBasedAST(text);
			sequenceNode.addChild(valueNode);
			parent.addChild(sequenceNode);
			parent = sequenceNode;						
		}
		return null;
	}
	
	public TreeRepresentation createTreeRepresentation(TreeRepresentation parent, String property, Object model) {
		ICollection elements = (ICollection)((IModelElement)model).getValue(property);
		int i = 0;
		TreeRepresentation oldParent = parent;
		for (Object element: elements) {
			ModelBasedTreeContent contents = new ModelBasedTreeContent(fTemplate, (IModelElement)model);
			TreeRepresentation treeRepresentation = new TreeRepresentation(contents);
			
			parent = treeRepresentation;			
			
			fTemplate.getValueTemplate().getAdapter(ITreeRepresentationFromModelProvider.class).
					createTreeRepresentation(parent, null, (IModelElement)element);
						
			if (fTemplate.fSeparator != null && i+1 < elements.size()) {
				contents.addContent(fTemplate.fSeparator);
			}			
			i++;
			
			((ModelBasedTreeContent)oldParent.getElement()).addContent(contents);
			oldParent.addChild(treeRepresentation);
			parent = oldParent;
		}
		if (fTemplate.fSeparateLast && fTemplate.fSeparator != null) {
			ModelBasedTreeContent contents = new ModelBasedTreeContent(fTemplate, (IModelElement)model);
			TreeRepresentation treeRepresentation = new TreeRepresentation(contents);
										
			contents.addContent(fTemplate.fSeparator);
			
			((ModelBasedTreeContent)parent.getElement()).addContent(contents);
			parent.addChild(treeRepresentation);
			parent = treeRepresentation;
		}
		return parent;		
	}

	public void executeModelUpdate(ModelUpdateConfiguration configuration) {		
		List<TextBasedUpdatedAST> allValueNodes = (List)
				collectAllValueNodes((AST)configuration.getAst(), new Vector<AST>());
		if (configuration.isHasOldParent()) {
			List<TextBasedAST> allOldValueNodes = (List)
				collectAllValueNodes((AST)configuration.getAst().getParent().getElement().getChild(configuration.getProperty()), new Vector<AST>());								
			
			int actualPosition = 0;
			int actualPositionInOldValue = 0;
			for(TextBasedUpdatedAST valueNode: allValueNodes) {
				if (valueNode.getElement() == null) {
					// its a new value insert at position
					fTemplate.getValueTemplate().getAdapter(IASTBasedModelUpdater.class).
							executeModelUpdate(configuration.createCollectionConfiguration(valueNode, actualPosition));
					actualPosition++;
				} else {
					int positionInOldValues = allOldValueNodes.indexOf(valueNode.getElement());
					if (positionInOldValues != -1) {
						// remove values from actionalPosition(incl) to actualPosition + positionInOldValue - actutualPositionInOldValues(excl)
						for(int i = actualPositionInOldValue; i < positionInOldValues - actualPositionInOldValue; i++) {
							fTemplate.getModel().getCommandFactory().remove(configuration.getOwner(), 
									configuration.getProperty(), allOldValueNodes.get(i)).execute();
						}
						actualPosition++;
						actualPositionInOldValue = positionInOldValues + 1;
					} else {
						// treat as new value, insert at position
						fTemplate.getValueTemplate().getAdapter(IASTBasedModelUpdater.class).
						executeModelUpdate(configuration.createCollectionConfiguration(valueNode, actualPosition));
						actualPosition++;
					}
				}
			}
			// delete everything behind actualPositionInOldValue
			for(int i = actualPositionInOldValue; i < allOldValueNodes.size(); i++) {
				fTemplate.getModel().getCommandFactory().remove(configuration.getOwner(), 
						configuration.getProperty(), allOldValueNodes.get(i).getModelElement()).execute();
			}
		} else {
			for(TextBasedUpdatedAST valueNode: allValueNodes) {
				fTemplate.getValueTemplate().getAdapter(IASTBasedModelUpdater.class).
						executeModelUpdate(configuration.createCollectionConfiguration((TextBasedUpdatedAST)valueNode));	
			}
		}					
	}
	
	private AST getTailNode(AST<? extends AST, Text> ast) {
		for (AST child: ast.getChildNodes()) {
			if (child.getSymbol().equals(ast.getSymbol())) {
				return child;
			}
		}
		return null;
	}

	private AST getValueNode(AST<? extends AST, Text> ast) {
		for (AST child: ast.getChildNodes()) {
			if (!child.getSymbol().equals(ast.getSymbol())) {
				return child;
			}
		}
		// primitive value TODO
		throw new RuntimeException("assert");
	}
	
	private Collection<AST> collectAllValueNodes(AST<AST, Text> head, Collection<AST> nodes) {
		nodes.add(getValueNode(head));
		AST tail = getTailNode(head);
		if (tail != null) {
			collectAllValueNodes(tail, nodes);
		}
		return nodes;
	}
}
