package hub.sam.tef.editor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.Document;

public class ModelDocument extends Document {
	private final Resource fResource;

	public ModelDocument(Resource resource) {
		super();
		fResource = resource;
	}

	public Resource getResource() {
		return fResource;
	}
	
	
}
