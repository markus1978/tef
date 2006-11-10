package editortest.editor;

import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Vector;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;

import editortest.EditorTestPlugin;
import editortest.model.AbstractModelElement;
import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
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
	private Text currentSelectedText = null;
	private IModelElement currentSelectedModelElement = null;
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
				
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((TEFDocument)viewer.getDocument()).getDocument().process(visitor, offset);
		Text selectedText = visitor.getResult();
		if (selectedText == currentSelectedText) {
			return;
		} else {
			currentSelectedText = selectedText;
		}
		IAnnotationModel model = viewer.getAnnotationModel();
		
		markSelectedText(selectedText, model);
		markOccurences(selectedText, model);
	}

	private void markSelectedText(Text selectedText, IAnnotationModel model) {
		IRegion region = new Region(selectedText.getAbsolutOffset(0), selectedText.getLength());	
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
	}

	private void markOccurences(Text selectedText, IAnnotationModel model) {
		IRegion[] occurencePositions = null;
		IModelElement modelElement = null;
		
		while(selectedText != null && modelElement == null) {
			modelElement = (IModelElement)selectedText.getAttachement(AbstractModelElement.OCCURENCE_MODEL);
			selectedText = selectedText.getContainer();			
		}
		if (currentSelectedModelElement == modelElement || (modelElement != null && modelElement.equals(currentSelectedModelElement))) {
			return;
		} else {
			currentSelectedModelElement = modelElement;
		}
		
		if (currentOccurencesMarker != null) {
			for (int i = 0; i < currentOccurencesMarker.length; i++) {
				model.removeAnnotation(currentOccurencesMarker[i]);
			}
		}
		
		if (modelElement != null) {
			Text[] occurences =  modelElement.getRegisteredOccureces();			
			occurencePositions = new IRegion[occurences.length];
			for (int i = 0; i < occurences.length; i++) {
				occurencePositions[i] = new Region(occurences[i].getAbsolutOffset(0), occurences[i].getLength());
			}

			currentOccurencesMarker = new Annotation[occurencePositions.length];
			int i = 0;
			for (IRegion occurenceMarker: occurencePositions) {
				currentOccurencesMarker[i] = new Annotation("testeditor.occurencesmarker", false, "A OCCURENCE");
				model.addAnnotation(currentOccurencesMarker[i], new Position(occurenceMarker.getOffset(), occurenceMarker.getLength()));
				i++;
			}
		}
	}	
	
	public final void addCarretDrift(int drift) {
		this.carretDrift += drift;
	}
}
