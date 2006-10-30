package editortest.model;

public interface IMetaModelElement {

	/**
	 * Returns true if the given element is an instance of this
	 * meta-element.
	 */
	public boolean isMetaModelFor(IModelElement e);
	
}
