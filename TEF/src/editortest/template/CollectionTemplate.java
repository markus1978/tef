package editortest.template;

import editortest.controller.CursorMovementStrategy;
import editortest.controller.IDeleteEventHandler;
import editortest.controller.IProposalHandler;
import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.view.CompoundText;
import editortest.view.FixText;
import editortest.view.Text;

public abstract class CollectionTemplate<ElementModelType> extends PropertyTemplate<ElementModelType> {
	
	public class MarkFlag {		
	}
	
	class RemoveTextEventListener implements IDeleteEventHandler {
		
		private final ICollection fModel;	
		private final ElementModelType fElement;
		private final Text fCollectionText;
		
		public RemoveTextEventListener(final ICollection model, final ElementModelType element, Text collectionText) {
			super();
			fModel = model;
			fElement = element;
			fCollectionText = collectionText;
		}

		public void handleEvent(Text text) {
			boolean equals = false;
			Object before = null;
			Object after = null;
			loop: for (Object o: fModel) {
				if (equals) {
					after = o;
					break loop;
				} else if (o.equals(fElement)) {
					equals = true;
				} else {
					before = o;
				}
			}
			if (after != null) {
				fCollectionText.setElement(CollectionTextElement.class, new CollectionTextElement(after));
			} else if (before != null) {
				fCollectionText.setElement(CollectionTextElement.class, new CollectionTextElement(before));
			} 
			fModel.remove(fElement);
			getElementTemplate().deleteModel(fElement);				
		}	
	}	
	
	class CollectionModelEventListener extends RetifyCursorPositionModelEventListener {
		private final IModelElement fModel;
		private final CompoundText collectionText;
		private CompoundText actualListText;
		
		public CollectionModelEventListener(final IModelElement model, 
				final CompoundText collectionText, CompoundText actualListText) {
			super(collectionText);
			this.collectionText = collectionText;
			this.actualListText = actualListText;
			fModel = model;
		}

		@Override
		public void propertyChanged(Object obj, String property) {
			if (property == getProperty()) {
				CollectionTextElement currentElement = actualListText.getElement(CollectionTextElement.class);
				CursorMarker cursorMarker;
				if (currentElement != null) {
					cursorMarker = new CursorMarker(currentElement.getObject());
				} else {
					cursorMarker = new CursorMarker(null);
				}
				actualListText.removeElement(CollectionTextElement.class);
				CompoundText replaceListText = createValueView(fModel, cursorMarker);
				collectionText.replaceText(actualListText, replaceListText);
				actualListText = replaceListText;
				if (cursorMarker.markedText != null) {
					setNewCursorPosition(cursorMarker.markedText, 0);
				} else {
					setNewCursorPosition(collectionText, 0);
				}
			}
		}
	}
	
	class ValueChangeListener implements IValueChangeListener<ElementModelType> {
		private final IModelElement fModel;
		private final ElementModelType fElement;
		public ValueChangeListener(final IModelElement model, final ElementModelType element) {
			super();
			fModel = model;
			fElement = element;
		}
		public void valueChanges(ElementModelType newValue) {
			((ICollection)fModel.getValue(getProperty())).replace(fElement, newValue);	
		}		
	}
	
	class CursorMarker {
		private final Object fMarker;
		Text markedText;
		
		CursorMarker(Object marker) {
			fMarker = marker;
		}
	}
	
	private final ValueTemplate<ElementModelType> fElementTemplate;
	private final String fSeparator;
	private final boolean fSeparateLast;
	
	public CollectionTemplate(ElementTemplate elementTemplate, String property, String separator, boolean separateLast) {
		super(elementTemplate, property);
		fElementTemplate = createElementTemplate();
		fElementTemplate.setPropertyTemplate(this);
		fSeparator = separator;
		fSeparateLast = separateLast;
	}
	
	protected abstract ValueTemplate createElementTemplate();
	
	protected abstract IProposalHandler 
			createSeedTextEventListenet(ICollection<ElementModelType> list, int position, Text collectionText);
	
	protected ValueTemplate<ElementModelType> getElementTemplate() {
		return fElementTemplate;
	}
	
	@Override
	public Text createView(final IModelElement model) {
		final CompoundText result = new CompoundText();
		CompoundText listText = createValueView(model, new CursorMarker(null));
		result.addText(listText);
		model.addChangeListener(new CollectionModelEventListener(model, result, listText));
		return result;
	}
	
	private CompoundText createValueView(final IModelElement model, CursorMarker cursorMarker) {
		final CompoundText result = new CompoundText();		
		ICollection<ElementModelType> list = (ICollection<ElementModelType>)model.getValue(getProperty());
		Text nullSeed = new FixText("");		
		nullSeed.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(false, true));
		nullSeed.addElement(IProposalHandler.class, createSeedTextEventListenet(list, 0, result));
		result.addText(nullSeed);	
		boolean first = true;
		int i = 0;
		loop: for (ElementModelType element: list) {		
			CompoundText elementText = new CompoundText();
			if (element.equals(cursorMarker.fMarker)) {
				cursorMarker.markedText = elementText;
			}
			if (!fSeparateLast && !first) {
				elementText.addText(new FixText(fSeparator));
			}
			first = false;
			Text elementValueText = fElementTemplate.createView(element, new ValueChangeListener(model, element));
			if (elementValueText == null) {				
				continue loop;
			}			
			elementText.addText(elementValueText);						
			if (fSeparateLast) {
				elementText.addText(new FixText(fSeparator));
			}
			elementText.addElement(IProposalHandler.class, createSeedTextEventListenet(list, ++i, result));
			elementText.setElement(MarkFlag.class, new MarkFlag());
			result.addText(elementText);			
			elementText.addElement(IDeleteEventHandler.class, new RemoveTextEventListener(list, element, result));	
		}
		return result;
	}
}
