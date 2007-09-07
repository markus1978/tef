package hub.sam.tef.completion;

import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.documents.ILanguageModelProvider;

public class CompletionContext {

	private final String fContent;
	private final ILanguageModelProvider fLanguageModelProvider;
	private final IDocumentModelProvider fDocumentModelProvider;	
	private String identifierPrefix = "";

	public CompletionContext(final String content, final ILanguageModelProvider languageModelProvider, final IDocumentModelProvider documentModelProvider) {
		super();
		fContent = content;
		fLanguageModelProvider = languageModelProvider;
		fDocumentModelProvider = documentModelProvider;
	}

	public String getContent() {
		return fContent;
	}

	public String getIdentifierPrefix() {
		return identifierPrefix;
	}

	public void setIdentifierPrefix(String identifierPrefix) {
		this.identifierPrefix = identifierPrefix;
	}

	public IDocumentModelProvider getDocumentModelProvider() {
		return fDocumentModelProvider;
	}

	public ILanguageModelProvider getLanguageModelProvider() {
		return fLanguageModelProvider;
	}	
	
	
	public int getCompletionOffset() {
		return fContent.length();
	}
	
}
