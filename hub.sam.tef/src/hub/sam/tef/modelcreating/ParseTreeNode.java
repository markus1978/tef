package hub.sam.tef.modelcreating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.Position;

/**
 * A node of a parse tree. It maintains a list of children, the range covered by
 * this parse tree in the original text, and the text that this parse tree was
 * created from.
 */
public abstract class ParseTreeNode {
	
	private final List<ParseTreeNode> fChildNodes = new ArrayList<ParseTreeNode>();
	private Position fPosition = null;
	private String fText;
	private ParseTreeNode parent = null;
	private Object additionalValue = null;

	protected final void addChildNode(ParseTreeNode childNode) {
		fChildNodes.add(childNode);
		childNode.parent = this;
	}

	/**
	 * @return the position in the parsed string that is covered by this parse
	 *         node.
	 */
	public final Position getPosition() {
		return fPosition;
	}

	protected final void setPosition(Position position) {
		fPosition = position;
	}

	protected final void setText(String text) {
		fText = text;
	}

	public final List<ParseTreeNode> getChildNodes() {
		return Collections.unmodifiableList(fChildNodes);
	}


	/**
	 * @return the text that this node covers in the parsed document.
	 */
	public final String getNodeText() {
		int offset = fPosition.getOffset();		
		return fText.substring(offset, offset + fPosition.getLength());
	}	

	/**
	 * Is used to visit the hole parse tree for the purpose of creating a model
	 * from the parsed text. It triggers the according binding semantics for
	 * visited nodes. The tree is navigated top down, depth first.
	 * 
	 * @param context
	 *            the model creation context.
	 * @param actual
	 *            the model object that is currently be created. This is the
	 *            model object that represents the parent node.
	 * @return The model object that represents this parse tree node.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens during the model creating
	 *             process.
	 */
	public abstract Object createModel(IModelCreatingContext context,
			Object actual) throws ModelCreatingException;
	

	/**
	 * Is used to visit the hole parse tree for the purpose of evaluating
	 * action statements at create time.
	 * 
	 * @param context
	 *            the model creation context.
	 * @param actual
	 *            the model object that is currently be created. This is the
	 *            model object that represents the parent node.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens during the model creating
	 *             process.
	 */
	public abstract void postCreate(IModelCreatingContext contex) throws ModelCreatingException;
	
	/**
	 * Is used to visit the hole parse tree for the purpose of evaluating
	 * action statements at resolve time.
	 * 
	 * @param context
	 *            the model creation context.
	 * @param actual
	 *            the model object that is currently be created. This is the
	 *            model object that represents the parent node.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens during the model creating
	 *             process.
	 */
	public abstract void postResolve(IModelCreatingContext context) throws ModelCreatingException;

	/**
	 * Is used to visit the hole parse tree for the purpose of resolving
	 * references in a model that was created from the parsed text using
	 * {@link this#createModel(ModelCreatingContext, Object)}. It triggers the
	 * according binding semantics for visited nodes. The tree is navigated top
	 * down, depth first.
	 * 
	 * @param context
	 *            the model creation context.
	 * @param resolutionState
	 *            the current state of the resolution. See
	 *            {@link ResolutionState} for more information.
	 * @return The model object that represents this parse tree node.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens during the model creating
	 *             process.
	 */
	public abstract Object resolveModel(IModelCreatingContext context,
			ResolutionState resolutionState) throws ModelCreatingException;
	
	/**
	 * @return an string that represents the content of this tree node. Used for
	 *         toString().
	 */
	protected abstract String getNodeValueString();

	/**
	 * Prints this node and its children into a string buffer. Used for toString().
	 * 
	 * @param buffer
	 *            is the buffer.
	 * @param indent
	 *            is used to ident the resulting string.
	 */
	private void print(StringBuffer buffer, String indent) {
		buffer.append(indent);
		buffer.append(getNodeValueString());
		buffer.append("\n");
		for (ParseTreeNode childNode : fChildNodes) {
			childNode.print(buffer, indent + "  ");
		}
	}

	/**
	 * A textual tree representation is returned.
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		print(result, "");
		return result.toString();
	}	
	
	public ParseTreeNode getParent() {
		return parent;
	}

	public void aquireParents() {	
		for (ParseTreeNode child: fChildNodes) {
			child.parent = this;
			child.aquireParents();
		}		
	}
	
	public void looseParents() {
		parent = null;
		for (ParseTreeNode child: fChildNodes) {
			child.looseParents();
		}		
	}

	public Object getAdditionalValue() {
		return additionalValue;
	}

	public void setAdditionalValue(Object additionalValue) {
		this.additionalValue = additionalValue;
	}	
}
