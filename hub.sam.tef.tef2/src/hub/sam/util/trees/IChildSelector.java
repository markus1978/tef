package hub.sam.util.trees;

public interface IChildSelector<TreeType extends ITree> {

	public boolean selectChild(TreeType node);
}
