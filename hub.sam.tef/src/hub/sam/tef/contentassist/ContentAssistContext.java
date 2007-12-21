package hub.sam.tef.contentassist;

import org.eclipse.emf.ecore.EObject;

import hub.sam.tef.editor.text.TextEditor;

public class ContentAssistContext {

	private final int fCompletionOffset;
	private final String identifierPrefix;
	private final TextEditor fEditor;
	private final EObject fCompletionObject;

	public ContentAssistContext(int completionOffset, String identifierPrefix,
			EObject completionObject,
			TextEditor editor) {
		super();
		fCompletionOffset = completionOffset;
		this.identifierPrefix = identifierPrefix;
		fEditor = editor;
		fCompletionObject = completionObject;
	}

	public String getIdentifierPrefix() {
		return identifierPrefix;
	}

	public int getCompletionOffset() {
		return fCompletionOffset;
	}
	
	public TextEditor getEditor() {
		return fEditor;
	}

	public EObject getCompletionObject() {
		return fCompletionObject;
	}		
}
