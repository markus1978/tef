package editortest.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.editors.text.StorageDocumentProvider;

public abstract class TEFDocumentProvider extends StorageDocumentProvider {

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		return new AnnotationModel();
	}
	
}
