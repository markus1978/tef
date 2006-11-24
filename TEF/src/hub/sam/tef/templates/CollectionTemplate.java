package hub.sam.tef.templates;

import hub.sam.tef.controllers.AbstractRequestHandler;
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
	class RemoveTextEventListener extends AbstractRequestHandler<ElementModelType>
			implements IDeleteEventHandler {
		
		private final ICollection fModel;			
		private final Text fCollectionText;
		
		public RemoveTextEventListener(final IModelElement owner, String property, 
					final ICollection model, final ElementModelType element, Text collectionText) {
			super(owner, property, element);			
			fModel = model;			
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
				} else if (o.equals(getValue())) {
					equals = true;
				} else {
					before = o;
				}
			}
			if (after != null) {
				fCollectionText.setElement(CollectionCursorPositionMarker.class, new CollectionCursorPositionMarker(after));
			} else if (before != null) {
				fCollectionText.setElement(CollectionCursorPositionMarker.class, new CollectionCursorPositionMarker(before));
			}
			getModel().getCommandFactory().remove(getOwner(), getProperty(), getValue()).execute();
			//fModel.remove(fElement);
			//getElementTemplate().deleteModel(fElement);				
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
				CollectionCursorPositionMarker currentElement = actualListText.getElement(CollectionCursorPositionMarker.class);
								
				if (currentElement == null) {
					currentElement = new CollectionCursorPositionMarker(null);
				} 
				actualListText.removeElement(CollectionCursorPositionMarker.class);
				CompoundText replaceListText = createValueView(fModel, currentElement);
				collectionText.replaceText(actualListText, replaceListText);
				actualListText = replaceListText;
				if (currentElement.getMarkedText() != null) {
					setNewCursorPosition(currentElement.getMarkedText(), 0);
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
	class ValueChangeListener extends AbstractRequestHandler<ElementModelType> 
			implements IValueChangeListener<ElementModelType> {
		
		public ValueChangeListener(final IModelElement model, String property, final ElementModelType element) {
			super(model, property, element);			
		}
		public void valueChanges(ElementModelType newValue) {
			getModel().getCommandFactory().replace(getOwner(), getProperty(), getValue(), newValue).execute();
			//((ICollection)fModel.getValue(getProperty())).replace(fElement, newValue);	
		}		
	}
	
	class CursorMarker {
		private final int fPosition;
		private final Object fObject;
		Text markedText;
		
		CursorMarker(int position) {
			fPosition = position;
			fObject = null;
		}
	
		CursorMarker(Object object) {
			fPosition = -1;
			fObject = object;
		}
		
		boolean isMarked(int index, Object obj) {
			if (fPosition == -1) {
				return fObject.equals(obj);
			} else {
				return fPosition == index;
			}
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
	protected abstract IProposalHandler createSeedTextEventListenet(IModelElement owner, 
			String property, ICollection<ElementModelType> list, int position, Text collectionText);
	
	protected final ValueTemplate<ElementModelType> getElementTemplate() {
		return fElementTemplate;
	}
	
	@Override
	public Text createView(final IModelElement model) {
		final CompoundText result = new CompoundText();
		CompoundText listText = createValueView(model, new CollectionCursorPositionMarker(null));
		new CollectionModelEventListener(model, result, listText); // activates itself once the view is shown
		result.addText(listText);		
		return result;
	}
	
	private CompoundText createValueView(final IModelElement model, CollectionCursorPositionMarker cursorMarker) {
		final CompoundText result = new CompoundText();		
		ICollection<ElementModelType> list = (ICollection<ElementModelType>)model.getValue(getProperty());
		Text nullSeed = new FixText("");		
		nullSeed.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(false, true));
		nullSeed.addElement(IProposalHandler.class, createSeedTextEventListenet(model, getProperty(), list, 0, result));
		result.addText(nullSeed);	
		boolean first = true;
		int i = 0;
		loop: for (ElementModelType element: list) {		
			CompoundText elementText = new CompoundText();			
			cursorMarker.mark(i, element, elementText);
			if (!fSeparateLast && !first) {
				elementText.addText(new FixText(fSeparator));
			}
			first = false;
			Text elementValueText = fElementTemplate.createView(element, 
					new ValueChangeListener(model, getProperty(), element));
			if (elementValueText == null) {				
				continue loop;
			}			
			elementText.addText(elementValueText);						
			if (fSeparateLast) {
				elementText.addText(new FixText(fSeparator));
			}
			elementText.addElement(IProposalHandler.class, createSeedTextEventListenet(model, getProperty(),
					list, ++i, result));
			elementText.setElement(MarkFlag.class, new MarkFlag());
			result.addText(elementText);			
			elementText.addElement(IDeleteEventHandler.class, 
					new RemoveTextEventListener(model, getProperty(), list, element, result));	
		}
		return result;
	}
}
