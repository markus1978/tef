package hub.sam.tef;

import org.eclipse.jface.text.BadLocationException;

import hub.sam.tef.controllers.HandleEventVisitor;
import hub.sam.tef.controllers.IAnnotationModelProvider;
import hub.sam.tef.controllers.ICursorPostionProvider;
import hub.sam.tef.controllers.IModelRepresentationProvider;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.models.IModel;
import hub.sam.tef.templates.LayoutManager;
import hub.sam.tef.templates.Template;
import hub.sam.tef.views.DocumentText;

public abstract class TEFModelDocument implements IModelRepresentationProvider {

	private TEFDocument fEclipseDocument;	
	private DocumentText fDocumentText;		
	private IModel fModel;
	private LayoutManager fLayoutManager;
	private Template fTopLevelTemplate = null;
	private Object resource = null;
	
	private IAnnotationModelProvider fAnnotationModelProvider;
	private ICursorPostionProvider fCursorPositionProvider;
	
	private int actualReplace = -1;

	protected final void setEclipseDocument(TEFDocument document) {
		this.fEclipseDocument = document;
	}
	
	public void configure(IAnnotationModelProvider annotationModelProvider, ICursorPostionProvider cursorPositionProvider) {
		fAnnotationModelProvider = annotationModelProvider;
		fCursorPositionProvider = cursorPositionProvider;
		initializeContent();
	}

	public final void setContent(final IModel model, Object resource) {
		fModel = model;
		this.resource = resource;
	}
	
	protected void initializeContent() {
		fDocumentText = new DocumentText(this);		
		fTopLevelTemplate = createTopLevelTemplate(fAnnotationModelProvider, fCursorPositionProvider);
		initializeDocument(fDocumentText);	
		fDocumentText.update();
	}
	
	public Template getTopLevelTemplate() {
		return fTopLevelTemplate;
	}
	
	public IModel getModel() {
		return fModel;
	}
	
	/**
	 * Creates the DocumentText for this document. Must also create and set the 
	 * toplevel template for this document.
	 */
	public abstract void initializeDocument(DocumentText documentText);
	
	public abstract Template createTopLevelTemplate(IAnnotationModelProvider annotationModelProvider, 
			ICursorPostionProvider cursorPositionProvider);
	
	public String getContent() {
		return fDocumentText.getContent();
	}
	
	/**
	 * This is a new method, not known to the eclipse platform. It is used to handle document changes that
	 * were not directly triggered by the user. These changes come from the according DocumentText.
	 * We say this are changes "from below", in contradiction to changes "from above" {@link #replace(int, int, String)}.
	 */
	public final void doReplace(int pos, int length, String text) throws BadLocationException {
		//content.replace(pos, pos + length, text);
		////pos = changes.getIndexAfterChanges(pos);
		//StringBuffer newContent = new StringBuffer(content.toString());
		//changes.apply(newContent);
		//super.replace(0, getLength(), newContent.toString());		
		fEclipseDocument.doReplace(pos, length, text);		
		if (actualReplace != -1) {
			if (pos + length < actualReplace) {
				fCursorPositionProvider.addCarretDrift(text.length() - length);
			}
		}	
	}

	public final void replace(int pos, int length, String text) throws BadLocationException {
		if (length == 0 && text.length() == 0) {
			// this event wouldnt change anything
			return;
		}
		//int textPos = changes.getIndexBeforeChanges(pos);
		int textPos = pos;
		actualReplace = pos;		
		TextEvent textAdd = new TextEvent(/*this,*/ textPos, textPos+length, text); 				
		HandleEventVisitor visitor = new HandleEventVisitor(textAdd);
		fDocumentText.process(visitor, textAdd.getBegin());
		if (visitor.getResult()) {
			// event handled
			System.out.println("EVENT HANDLED");
			actualReplace = -1;
		} else {
			// event not handled, store this change, incorperate it into the displayed content
			System.out.println("EVENT NOT HANDLED");
			//Change change = new Change(pos, length, text);
			//changes.addChange(change);
			////content.replace(pos, pos + length, text);
			//super.replace(pos, length, text);
			actualReplace = -1;
			fEclipseDocument.switchModes(false);
			fEclipseDocument.replace(pos, length, text);
		}			
	}

	public final DocumentText getDocumentText() {
		return fDocumentText;
	}
	
	public void setCursorPositionProvider(ICursorPostionProvider cursorPositionProvider) {
		this.fCursorPositionProvider = cursorPositionProvider;
	}

	public LayoutManager getLayoutManager() {
		if (fLayoutManager == null) {
			fLayoutManager = new LayoutManager(fDocumentText);
		}
		return fLayoutManager;
	}
		
	protected Object getResource() {
		return resource;
	}
}
