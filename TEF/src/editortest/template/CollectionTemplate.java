package editortest.template;

import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.IProposalListener;
import editortest.text.Text;

public abstract class CollectionTemplate<ElementModelType> extends PropertyTemplate<ICollection<ElementModelType>> {
	
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

	@Override
	public void updateProperty(Text view, IModelElement model, ICollection<ElementModelType> value) {
		// empty
	}
	
	private CompoundText createValueView(final IModelElement model) {
		final CompoundText result = new CompoundText();		
		ICollection<ElementModelType> list = (ICollection<ElementModelType>)model.getValue(getProperty());
		Text nullSeed = new FixText("");		
		nullSeed.addProposalHandler(createSeedTextEventListenet(list, 0));
		result.addText(nullSeed);	
		boolean first = true;
		int i = 0;
		for (ElementModelType element: list) {										
			if (!fSeparateLast && !first) {
				result.addText(new FixText(fSeparator));
			}
			Text elementText = fElementTemplate.createView(element, model);
			if (elementText != null) {
				result.addText(elementText);						
				if (fSeparateLast) {
					result.addText(new FixText(fSeparator));
				}
				Text newSeedText = new FixText("");
				newSeedText.addProposalHandler(createSeedTextEventListenet(list, ++i));
				result.addText(newSeedText);			
			}
			first = false;
		}
		return result;
	}
}
