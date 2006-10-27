package editortest.tefwidgets;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import editortest.model.ModelEventListener;
import editortest.model.Set;
import editortest.template.AbitraryTemplate;
import editortest.widgets.CompoundText;
import editortest.widgets.FixText;
import editortest.widgets.Proposal;
import editortest.widgets.Text;
import editortest.widgets.TextEvent;
import editortest.widgets.TextEventListener;

public class Abitrary extends CompoundText {		
	
	private final Text end;		
	private final Collection<Text> fSeeds = new Vector<Text>();
	private final Collection<TextEventListener> fListener = 
			new Vector<TextEventListener>();

	public Abitrary() {
		super();		
		end = new FixText("");
		Text fBeginSeed = new FixText("");
		fSeeds.add(fBeginSeed);
		addText(fBeginSeed);
		addText(end);
	}	
	
	public void addElement(Text text) {
		addTextBefore(end, text);
		Text newSeed = new FixText("");
		for(TextEventListener listener: fListener) {
			newSeed.addEventHandler(listener);
		}
		fSeeds.add(newSeed);
		addTextBefore(end, newSeed);
	}	 
		
	@Override
	public void addEventHandler(TextEventListener eventHandler) {
		fListener.add(eventHandler);
		for(Text seed: fSeeds) {
			seed.addEventHandler(eventHandler);
		}
	}
}
