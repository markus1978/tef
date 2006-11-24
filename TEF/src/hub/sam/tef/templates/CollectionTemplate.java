package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.IDeleteEventHandler;
import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.RetifyCursorPositionModelEventListener;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

/**
 * This is a base class for all Properties that have a collection of value to
 * represent.
 */
public abstract class CollectionTemplate<ElementModelType> extends PropertyTemplate<ElementModelType> {
	
	public class MarkFlag {		
	}
	
	/**
	 * This controller element is notified when the user selects a element for
	 * deletion. It will then remove the according value from the property's values.
	 */
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
	
	/**
	 * This controller element listenes to model changes. It is used to update
	 * the view when the properties values change, e.g. a value is addit or removed.
	 * It always causes the hole view to be replaced by a new representations.
	 * 
	 * It is responsible for placing the cursor at a meaningful (compared to the expected change
	 * in the representation) position afterwards.
	 */
	class CollectionModelEventListener extends RetifyCursorPositionModelEventListener {
		private final IModelElement fModel;
		private final CompoundText collectionText;
		private CompoundText actualListText;
		
		public CollectionModelEventListener(final IModelElement model, 
				final CompoundText collectionText, CompoundText actualListText) {
			super(model, collectionText);
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
				actualListText.update();
			}
		}
	}
	
	/**
	 * This listener is forwarded to the used value templates. When a value is changed
	 * this listener will replace the old value with the new own in the represented
	 * property's list of values.
	 */
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
		fSeparator = separator;
		fSeparateLast = separateLast;
	}
	
	/**
	 * Creates the template that provides representation for the lists values.
	 * 
	 * @return A ValueTemplate used to display the collection's values.
	 */
	protected abstract ValueTemplate createElementTemplate();
	
	@Deprecated
	protected abstract IProposalHandler 
			createSeedTextEventListenet(ICollection<ElementModelType> list, int position, Text collectionText);
	
	protected final ValueTemplate<ElementModelType> getElementTemplate() {
		return fElementTemplate;
	}
	
	@Override
	public Text createView(final IModelElement model) {
		final CompoundText result = new CompoundText();
		CompoundText listText = createValueView(model, new CursorMarker(null));
		new CollectionModelEventListener(model, result, listText); // activates itself once the view is shown
		result.addText(listText);		
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
