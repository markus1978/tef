package editortest.editor;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;

import editortest.EditorTestPlugin;
import editortest.controller.ComputeCursorPositionVisitor;
import editortest.view.DocumentText;

public abstract class TEFEditor extends TextEditor {
	
	public static final String INSERT_ELEMENT = "tef.insertElement";
	public static final String DELETE_ELEMENT = "tef.deleteElement";
	
	private int cursorDrift = 0;
	private int currentCursortPosition = 0;
	
	private Occurences fOccurences = null;
	private SelectedElementMarker fSelectedElementMarker = null;	
		
	public TEFEditor() {
		super();				
		setSourceViewerConfiguration(new TEFSourceViewerConfiguration());
		setDocumentProvider(createDocumentProvider());		
	}
	
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// this may change with future eclipse versions
		fAnnotationAccess= getAnnotationAccess();
		fOverviewRuler= createOverviewRuler(getSharedColors());

		ISourceViewer viewer= new TEFSourceViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);
		return viewer;
	}
	
	protected abstract TEFDocumentProvider createDocumentProvider();

	@Override
	public final void createPartControl(Composite parent) {
		super.createPartControl(parent);
		((TEFDocument)getSourceViewer().getDocument()).setEditor(this, (TEFSourceViewer)getSourceViewer());	
		fOccurences = new Occurences((TEFSourceViewer)getSourceViewer());
		fSelectedElementMarker = new SelectedElementMarker((TEFSourceViewer)getSourceViewer());
	}

	@Override
	protected void createActions() {	
		super.createActions();
		IAction action = createContentAssistAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", action);
		
		IAction insertElement = createElementInsertAction();
		insertElement.setActionDefinitionId(INSERT_ELEMENT);
		setAction(INSERT_ELEMENT, insertElement);
		
		IAction deleteElement = createDeleteElementAction();
		deleteElement.setActionDefinitionId(DELETE_ELEMENT);
		setAction(DELETE_ELEMENT, deleteElement);
	}		
	
	private IAction createContentAssistAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "ContentAssistProposal", 
				this, ISourceViewer.CONTENTASSIST_PROPOSALS);
	}
	
	private IAction createElementInsertAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "InsertElement", this, 
				TEFSourceViewer.INSERT_ELEMENT);
	}
	
	private IAction createDeleteElementAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "DeleteElement", this, 
				TEFSourceViewer.DELETE_ELEMENT);
	}
	
	@Override
	protected final void handleCursorPositionChanged() {
		ISourceViewer viewer = getSourceViewer();		
		currentCursortPosition += cursorDrift;		
		DocumentText document = ((TEFDocument)viewer.getDocument()).getDocument();
		int newCursorPos = getValidCursorPosition(viewer.getTextWidget().getCaretOffset()+ cursorDrift, document);
		
		viewer.getTextWidget().setCaretOffset(newCursorPos);				
		cursorDrift = 0;
		
		super.handleCursorPositionChanged();						
		fSelectedElementMarker.setActualCursorPosition();
		fOccurences.setActualCursorPosition();
	}

	private int getValidCursorPosition(int newCursorPos, DocumentText document) {
		ComputeCursorPositionVisitor cursorVisitor = new ComputeCursorPositionVisitor(
				newCursorPos, newCursorPos > currentCursortPosition, true);
		document.process(cursorVisitor, newCursorPos);
		newCursorPos = cursorVisitor.getResult();
		currentCursortPosition = newCursorPos;
		return newCursorPos;
	}

	
	public final void addCarretDrift(int drift) {
		this.cursorDrift += drift;
	}
}
