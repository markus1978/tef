package editortest.template;

import java.util.List;

import javax.swing.JPopupMenu.Separator;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.model.ISequence;
import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public abstract class SequenceTemplate extends PropertyTemplate {
	class SeedTextEventListener extends TextEventListener {
		private final int fListPosition;
		private final ISequence fModel;
		
		public SeedTextEventListener(final int listPosition, final ISequence model) {
			super();
			fListPosition = listPosition;
			fModel = model;
		}

		@Override
		public List<Proposal> getProposals(int offset, Text context) {
			return fElementTemplate.getProposals();
		}

		@Override
		public boolean handleEvent(TextEvent event, Text context) {
			boolean isProposed = false;
			loop: for (Proposal proposal: getProposals(event.getBegin(), context)) {
				if (proposal.getFReplaceProposal().equals(event.getText())) {
					isProposed = true;
					break loop;
				}
			}
			if (isProposed) {
				IModelElement newElement = fElementTemplate.createModelFromEvent(event);
				fModel.insert(fListPosition, newElement);
				return true;
			} else {
				return false;
			}
		}			
	}
	
	class ModelEventListener extends editortest.model.ModelEventListener {
		private final CompoundText fListText;
		private final ISequence fList;		

		public ModelEventListener(final CompoundText listText, final ISequence list) {
			super();
			fListText = listText;
			fList = list;
		}

		@Override
		public void elementAdded(Object element, int position) {
			addElement((IModelElement)element, position, fListText, fList);
		}		
	}
	
	private final Template fElementTemplate;
	private final String fSeparator;
	private final boolean fSeparateLast;
	
	public SequenceTemplate(IModel model, String property, IMetaModelElement metaModel,
			String separator, boolean separateLast) {
		super(model, property, metaModel);
		fElementTemplate = createElementTemplate();
		fSeparator = separator;
		fSeparateLast = separateLast;
	}
	
	private void addElement(IModelElement element, int position, CompoundText listText, ISequence model) {		
		CompoundText newText = new CompoundText();
		if (!fSeparateLast && position > 0) {
			newText.addText(new FixText(fSeparator));
		}
		newText.addText(fElementTemplate.createText((IModelElement)element));
		Text newSeedText = new FixText("");
		newText.addText(newSeedText);
		newSeedText.addEventHandler(new SeedTextEventListener(position + 1, model));
		if (fSeparateLast && position == model.size()) {
			newText.addText(new FixText(fSeparator));
		}
		
		listText.addTextAt(position, newText);
	}
	
	protected abstract Template createElementTemplate();

	@Override
	public IModelElement createModelFromEvent(TextEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text createText(IModelElement model) {
		CompoundText result = new CompoundText();
		CompoundText listText = new CompoundText();
		ISequence<IModelElement> list = (ISequence)model.getValue(getProperty());
		Text nullSeed = new FixText("");
		int i = 0;
		nullSeed.addEventHandler(new SeedTextEventListener(i, list));
		result.addText(nullSeed);
		result.addText(listText);
		for (IModelElement element: list) {
			i++;
			addElement(element, i, listText, list);
		}
		list.addChangeListener(new ModelEventListener(listText, list));
		return result;
	}

}
