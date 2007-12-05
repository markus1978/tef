package hub.sam.tef.contentassist;

import hub.sam.tef.editor.text.TextEditor;

public class ContentAssistContext {

	private final int fCompletionOffset;
	private final String identifierPrefix;
	private final TextEditor fEditor;

	public ContentAssistContext(int completionOffset, String identifierPrefix,
			TextEditor editor) {
		super();
		fCompletionOffset = completionOffset;
		this.identifierPrefix = identifierPrefix;
		fEditor = editor;
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
	
}
