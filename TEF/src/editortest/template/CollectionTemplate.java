package editortest.template;

import java.util.List;
import java.util.Vector;

import javax.sound.midi.Sequence;

import editortest.model.ICollection;
import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.model.ISequence;
import editortest.model.ModelEventListener;
import editortest.template.SequenceTemplate.SeedTextEventListener;
import editortest.template.text.Abitrary;
import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.IProposalListener;
import editortest.text.Proposal;
import editortest.text.Text;

public abstract class CollectionTemplate<ElementModelType> extends PropertyTemplate<ICollection<ElementModelType>> {
		
	class SeedTextEventListener implements IProposalListener {	
		private final ICollection fModel;
		
		public SeedTextEventListener(final ICollection model) {
			super();
			fModel = model;
		}

		public List<Proposal> getProposals(Text context, int offset) {
			return fElementTemplate.getProposals();
		}
		
		public boolean insertProposal(Text text, int offset, Proposal proposal) {
			if (getProposals(text, offset).contains(proposal)) {
				ElementModelType newElement = fElementTemplate.createModelFromProposal(proposal);
				fModel.add(newElement);
				return true;
			} else {
				return false;
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
	
	private CompoundText createValueView(final IModelElement model) {
		final CompoundText result = new CompoundText();		
		ICollection<ElementModelType> list = (ICollection<ElementModelType>)model.getValue(getProperty());
		Text nullSeed = new FixText("");		
		nullSeed.addProposalHandler(new SeedTextEventListener(list));
		result.addText(nullSeed);	
		boolean first = true;;
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
				newSeedText.addProposalHandler(new SeedTextEventListener(list));
				result.addText(newSeedText);			
			}
			first = false;
		}
		return result;
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

}
