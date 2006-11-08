package editortest.editor;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;

import editortest.EditorTestPlugin;
import editortest.text.Text;
import editortest.text.visitors.ComputeCursorPositionVisitor;
import editortest.text.visitors.ComputeSelectionVisitor;

public abstract class TEFEditor extends TextEditor {
	
	private int carretDrift = 0;
		
	public TEFEditor() {
		super();
		setSourceViewerConfiguration(new TEFConfiguration());
		setDocumentProvider(createDocumentProvider());		
	}
	
	protected abstract TEFDocumentProvider createDocumentProvider();

	@Override
	public final void createPartControl(Composite parent) {
		super.createPartControl(parent);
		((TEFDocument)getSourceViewer().getDocument()).setEditor(this);		
	}

	@Override
	protected void createActions() {	
		super.createActions();
		IAction action = createAction();
		
		String actionId = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(actionId);
		setAction("ContentAssistProposal", action);
	}		
	
	private IAction createAction() {
		ResourceBundle resourceBundle = EditorTestPlugin.getDefault().getResourceBundle();
		return new TextOperationAction(resourceBundle, "ContentAssistProposal", 
				this, ISourceViewer.CONTENTASSIST_PROPOSALS);
	}

	private final Annotation fObjectMarker = new Annotation("testeditor.currentobjectmarker", false, "A MARK");
	private Text currentSelectedObject = null;
	private Position currentObjectMarkerPosition = null;
	private Annotation[] currentOccurencesMarker = null;
	private int currentCaretPos = 0; 
	
	@Override
	protected final void handleCursorPositionChanged() {
		ISourceViewer viewer = getSourceViewer();
		// carret drift
		currentCaretPos += carretDrift;
		int newCursorPos = viewer.getTextWidget().getCaretOffset() + carretDrift;
		
		// get valid positions
		ComputeCursorPositionVisitor cursorVisitor = new ComputeCursorPositionVisitor(
				newCursorPos, newCursorPos != currentCaretPos - 1, true);
		((TEFDocument)viewer.getDocument()).getDocument().process(cursorVisitor, newCursorPos);
		newCursorPos = cursorVisitor.getResult();
		currentCaretPos = newCursorPos;
		
		// set new cursor pos
		viewer.getTextWidget().setCaretOffset(newCursorPos);				
		carretDrift = 0;
		
		super.handleCursorPositionChanged();				
		int offset = viewer.getTextWidget().getCaretOffset();
		
		// actual object marker
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)viewer.getDocument()).getDocument().process(visitor, offset);
		Text selectedText = visitor.getResult();
		if (selectedText == currentSelectedObject) {
			return;
		} else {
			currentSelectedObject = selectedText;
		}
		IRegion region = new Region(selectedText.getAbsolutOffset(0), selectedText.getLength());
		IAnnotationModel model = viewer.getAnnotationModel();
	
		if (region != null) {
			Position newObjectMarkerPosition = new Position(region.getOffset(), region.getLength());
			if (!newObjectMarkerPosition.equals(currentObjectMarkerPosition)) {
				model.removeAnnotation(fObjectMarker);
				model.addAnnotation(fObjectMarker, newObjectMarkerPosition);
				currentObjectMarkerPosition = newObjectMarkerPosition;
			}
		} else {
			model.removeAnnotation(fObjectMarker);
		}		
		
		// occurences markers
		if (currentOccurencesMarker != null) {
			for (int i = 0; i < currentOccurencesMarker.length; i++) {
				model.removeAnnotation(currentOccurencesMarker[i]);
			}
		}
		IRegion[] occurencePositions = ((TEFDocument)viewer.getDocument()).getOccurence(selectedText);
		currentOccurencesMarker = new Annotation[occurencePositions.length];
		int i = 0;
		for (IRegion occurenceMarker: occurencePositions) {
			currentOccurencesMarker[i] = new Annotation("testeditor.occurencesmarker", false, "A OCCURENCE");
			model.addAnnotation(currentOccurencesMarker[i], new Position(occurenceMarker.getOffset(), occurenceMarker.getLength()));
			i++;
		}		
	}	
	
	public final void addCarretDrift(int drift) {
		this.carretDrift += drift;
	}
}
