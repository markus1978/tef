package editortest.template;

import java.util.List;

import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.Text;
import editortest.text.visitors.IProposalListener;
import editortest.text.visitors.ITextEventListener;
import editortest.text.visitors.TextEvent;

public abstract class CollectionTemplate<ElementModelType> extends PropertyTemplate<ElementModelType> {
	
	class RemoveTextEventListener implements ITextEventListener {
		
		private final ICollection fModel;	
		private final ElementModelType fElement;
		
		public RemoveTextEventListener(final ICollection model, final ElementModelType element) {
			super();
			fModel = model;
			fElement = element;
		}

		private boolean deleteElement(Text text) {
			return fModel.remove(text.getAttachement("model"));
		}
		
		private boolean canDeleteElement(Text text) {
			return (text.getAttachement("model") != null);
		}
		
		private Text selectDeleteElement(Text text, TextEvent event) {
			if ((event.getText() == null || event.getText().equals("")) && event.getBegin() != event.getEnd()) {
				CompoundText listText = (CompoundText)text;
				List<Text> beginTexts = listText.getInnerTextAt(event.getBegin());
				List<Text> endTexts = listText.getInnerTextAt(event.getBegin());				
				for (Text beginText: beginTexts) {
					if (beginText.getLength() > 0 && endTexts.contains(beginText)) {
						return beginText;					
					}				
				}
			}			
			return null;
			
		}

		public boolean handleEvent(Text text, TextEvent event) {
			if ((event.getText() == null || event.getText().equals("")) && event.getBegin() != event.getEnd()) {
				fModel.remove(fElement);
				event.setBegin(0);
				event.setEnd(text.getLength());
				event.setText("");
				getElementTemplate().deleteModel(fElement);
				return true;
			} else {
				return false;
			}
		}

		public boolean verifyEvent(Text text, TextEvent event) {
			if ((event.getText() == null || event.getText().equals("")) && event.getBegin() != event.getEnd()) {
				return true;
			} else {
				return false;
			}
		}		
	}
	
	class MyModelEventListener extends ModelEventListener {
		private final IModelElement fModel;
		private final CompoundText collectionText;
		private CompoundText actualListText;
		
		public MyModelEventListener(final IModelElement model, 
				final CompoundText collectionText, CompoundText actualListText) {
			super();
			this.collectionText = collectionText;
			this.actualListText = actualListText;
			fModel = model;
		}

		@Override
		public void propertyChanged(Object obj, String property) {
			if (property == getProperty()) {					
				CompoundText replaceListText = createValueView(fModel);
				collectionText.replaceText(actualListText, replaceListText);
				actualListText = replaceListText;
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
	
	protected abstract IProposalListener 
			createSeedTextEventListenet(ICollection<ElementModelType> list, int position);
	
	protected ValueTemplate<ElementModelType> getElementTemplate() {
		return fElementTemplate;
	}
	
	@Override
	public Text createView(final IModelElement model) {
		final CompoundText result = new CompoundText();
		CompoundText listText = createValueView(model);
		result.addText(listText);
		model.addChangeListener(new MyModelEventListener(model, result, listText));
		return result;
	}
	
	private CompoundText createValueView(final IModelElement model) {
		final CompoundText result = new CompoundText();		
		ICollection<ElementModelType> list = (ICollection<ElementModelType>)model.getValue(getProperty());
		Text nullSeed = new FixText("");		
		nullSeed.putAttachment("hold", "");
		nullSeed.addProposalHandler(createSeedTextEventListenet(list, 0));
		result.addText(nullSeed);	
		boolean first = true;
		int i = 0;
		loop: for (ElementModelType element: list) {		
			CompoundText elementText = new CompoundText();
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
			Text newSeedText = new FixText("");
			newSeedText.putAttachment("hold", "");
			newSeedText.addProposalHandler(createSeedTextEventListenet(list, ++i));
			elementText.addText(newSeedText);			
			result.addText(elementText);
			elementText.addEventHandler(new RemoveTextEventListener(list, element));	
		}
		return result;
	}
}
