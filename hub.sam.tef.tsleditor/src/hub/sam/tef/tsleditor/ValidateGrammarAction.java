package hub.sam.tef.tsleditor;

import hub.sam.tef.editor.text.ITefEditorStatusListener;
import hub.sam.tef.editor.text.TextEditor;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.rcc.lexer.LexerBuilder;
import hub.sam.tef.rcc.parsertables.AbstractParserTables;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;
import hub.sam.tef.tsl.Syntax;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.ResourceAction;

/**
 * This action formats the text in the editor according to the layout defined as
 * part of the syntax used for this editor.
 */
public class ValidateGrammarAction extends ResourceAction implements ITefEditorStatusListener {

	/**
	 * This is used to connect the action with all the strings in the messages
	 * properties file of the TEF plug-in.
	 */
	public final static String MESSAGE_KEYS_PREFIX = "ValidateGrammar.";
	
	/**
	 * This is used to connect the action with the command defined as extension
	 * point in this plug/in.
	 */
	public final static String ACTION_DEFINITION_ID = "hub.sam.tef.ValidateGrammar";
	
	private final TextEditor fEditor;
	
	public ValidateGrammarAction(TextEditor editor) {
		super(TslEditorPlugin.getMessagesBundle(), MESSAGE_KEYS_PREFIX);
		fEditor = editor;
		fEditor.addEditorStatusListener(this);
		setActionDefinitionId(ACTION_DEFINITION_ID);		
	}

	@Override
	public void run() {
		Assert.isTrue(fEditor != null && !fEditor.hasError());
		final StringBuffer results = new StringBuffer();
		
		results.append("=== Validation report begins ===\n");
		try {
			Resource resource = fEditor.getCurrentModel();			
			Syntax tslSyntax = ((Syntax)resource.getContents().get(0));
			for(PrimitiveTypeDescriptor primitiveTypeDescr: 
				PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
					primitiveTypeDescr.addRulesToATslSyntax(tslSyntax);
			}
			
			hub.sam.tef.rcc.syntax.Syntax syntax = tslSyntax.getRccSyntax();
						
			for (PrimitiveTypeDescriptor primitiveTypeDescriptor: 
					PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
				primitiveTypeDescriptor.addRulesToARccSyntax(tslSyntax, syntax);
			}
						
			results.append(syntax.toString() + "\n");
			
			SyntaxSeparation separation = new SyntaxSeparation(syntax);				
			/* LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());*/			
					
			AbstractParserTables.out = new PrintStream(new OutputStream() {
				@Override
				public void write(int b) throws IOException {
					results.append(new Character((char)b));
				}				
			});
			
			new LALRParserTables(separation.getParserSyntax());
						
			AbstractParserTables.out = System.err;
		} catch (Exception ex) {
			results.append("Error during grammar validation: " + ex.getLocalizedMessage());
		}
		results.append("=== Validation report ends ===\n");
		
		PresentValidateGrammarResultsDialog resultDialog = 
				new PresentValidateGrammarResultsDialog(
						fEditor.getSite().getShell(),
						results.toString());
		resultDialog.open();
	}	
		
	/**
	 * Is action is only activated when the edited text is error free.
	 */
	@Override
	public void errorStatusChanged(TextEditor editor) {
		setEnabled(!editor.hasError());
	}

	public void dispose() {
		fEditor.removeEditorStatusListener(this);
	}
	
	private class PresentValidateGrammarResultsDialog extends MessageDialog {
		
		private final String results;

		public PresentValidateGrammarResultsDialog(Shell parentShell, String results) {
			super(parentShell, "Validate Grammar Results", null, 
					null, INFORMATION,
	                new String[] { IDialogConstants.OK_LABEL }, 0);
			this.results = results;
		}

		@Override
		protected Control createMessageArea(Composite composite) {
			TextViewer resultViewer = new TextViewer(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
			resultViewer.getTextWidget().setLayoutData(new GridData(GridData.FILL_BOTH));
			resultViewer.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
			resultViewer.setEditable(false);
			resultViewer.setDocument(new Document());
			
			resultViewer.getDocument().set(results);						
			return composite;
		}		
	}
}
