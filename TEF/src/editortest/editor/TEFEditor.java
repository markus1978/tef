package editortest.editor;

import java.util.ResourceBundle;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;


import editortest.EditorTestPlugin;
import editortest.mof.template.TestMofDocument;
import editortest.text.ComputeSelectionVisitor;
import editortest.text.Document;
import editortest.text.HandleEventVisitor;
import editortest.text.TextEvent;
import editortest.text.VerifyEventVisitor;

public class TEFEditor extends TextEditor {
	
	private int carretDrift = 0;
	
	public TEFEditor() {
		super();
		setSourceViewerConfiguration(new TEFConfiguration());
		setDocumentProvider(new TEFDocumentProvider());		
	}		
	
	
	
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		((EclipseDocument)getSourceViewer().getDocument()).setEditor(this);
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
	private Position currentObjectMarkerPosition = null;
	
	@Override
	protected void handleCursorPositionChanged() {
		ISourceViewer viewer = getSourceViewer();
		viewer.getTextWidget().setCaretOffset(
				viewer.getTextWidget().getCaretOffset() + carretDrift);
		carretDrift = 0;
		
		super.handleCursorPositionChanged();
				
		int offset = viewer.getTextWidget().getCaretOffset();			
		ComputeSelectionVisitor visitor = new ComputeSelectionVisitor(offset);
		((EclipseDocument)viewer.getDocument()).getDocument().process(visitor, offset);
		IRegion region = visitor.getResult();
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
	}	
	
	public void addCarretDrift(int drift) {
		this.carretDrift += drift;
	}
}
