package hub.sam.tef.contentassist;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.Utilities;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;

import java.util.ResourceBundle;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;

public class ContentAssistTestEditor extends TextEditor {

	private Syntax fSyntax = null;
	
	/**
	 * Configures this editor. It sets an appropriate document provider and
	 * source viewer configuration based on the implementation of
	 * {@link this#createMetaModelPackages(), this#createSyntax(),
	 * this#createSemanticsProvider()}.
	 */
	public ContentAssistTestEditor() {
		super();		
		setSourceViewerConfiguration(new SourceViewerConfiguration() {
			private ContentAssistant fContentAssistant = null;
			@Override
			public IContentAssistant getContentAssistant(
					ISourceViewer sourceViewer) {
				if (fContentAssistant == null) {
					fContentAssistant = new ContentAssistant();
					fContentAssistant.setContentAssistProcessor(
							new TestContentAssistProcessor(ContentAssistTestEditor.this),							
							IDocument.DEFAULT_CONTENT_TYPE);
				}
				return fContentAssistant;
			}			
		});
	}
	
	public Syntax getSyntax() {
		if (fSyntax == null) {
			try {
				fSyntax = Utilities.loadSyntaxDescription(
						TEFPlugin.getDefault().getBundle(),
						"resources/models/cc-testsyntax.tslt", 
						new EPackage[] {});
			} catch (TslException e) {
				throw new RuntimeException(e);
			}
		}
		return fSyntax;
	}
	
	/**
	 * Creates additional actions. In this implementation this is the action
	 * that triggers content assist.
	 */
	@Override
	protected void createActions() {	
		super.createActions();
		IAction action = createContentAssistAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", action);		
	}		
	
	/**
	 * @return the content assist action.
	 */
	private IAction createContentAssistAction() {		
		ResourceBundle resourceBundle = TEFPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "ContentAssistProposal", 
				this, ISourceViewer.CONTENTASSIST_PROPOSALS);
	}
}
