package editortest.template.text;

import java.util.Collection;
import java.util.Vector;

import editortest.text.CompoundText;
import editortest.text.FixText;
import editortest.text.Text;
import editortest.text.visitors.IProposalListener;

@Deprecated
public class Abitrary extends CompoundText {		
	
	private final Text end;		
	private final Collection<Text> fSeeds = new Vector<Text>();
	private final Collection<IProposalListener> fListener = 
			new Vector<IProposalListener>();

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
		for(IProposalListener listener: fListener) {
			newSeed.addProposalHandler(listener);
		}
		fSeeds.add(newSeed);
		addTextBefore(end, newSeed);
	}	 
		
	@Override
	public void addProposalHandler(IProposalListener eventHandler) {
		fListener.add(eventHandler);
		for(Text seed: fSeeds) {
			seed.addProposalHandler(eventHandler);
		}
	}
}
