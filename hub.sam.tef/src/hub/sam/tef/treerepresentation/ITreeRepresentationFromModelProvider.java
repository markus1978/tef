package hub.sam.tef.treerepresentation;


public interface ITreeRepresentationFromModelProvider {
	
	public TreeRepresentation createTreeRepresentation(TreeRepresentation parent, String property, Object model);

}
