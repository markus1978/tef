package editortest.widgets;

import java.util.List;
import java.util.Vector;

public class CompoundText extends Text {

	private final List<Text> texts = new Vector<Text>();			

	protected final void changeContent(Text inner, int begin, int end, String text) {
		int offset = getBeginOf(inner);
		changeContent(begin + offset, end + offset, text);
	}
	
	protected final String getContent(Text inner, int begin, int end) {
		int offset = getBeginOf(inner);
		return getContent(begin + offset, end + offset);
	}	
	
	@Override
	public final void process(ITextVisitor visitor, int atOffset) {
		for (Text innerText: visitor.decentInto(this)) {
			innerText.process(visitor, getBeginOf(innerText));
		}
		visitor.visitCompoundText(this, atOffset);
	}

	public void addText(Text text) {
		texts.add(text);
		text.setContainer(this);
	}
	
	public void addTextBefore(Text before, Text text) {
		if (before == null) {
			texts.add(text);
		} else {
			texts.add(texts.indexOf(before), text);		
		}
		text.setContainer(this);
	}
	
	public void addText(int offset, Text text) {
		List<Text> atOffset = getInnerTextAt(offset);
		if (atOffset.size() == 0) {
			addTextBefore(null, text);
		} else {
			addTextBefore(atOffset.get(0), text);
		}
	}
	
	protected List<Text> getInnerTextAt(int offset) {
		List<Text> result = new Vector<Text>();
		int pos = 0;
		loop: for (Text inner: texts) {
			int nextPos = pos + inner.getLength();
			if (offset >= pos && offset <= nextPos) {
				result.add(inner);
				if (offset != pos && offset != nextPos) {
					break loop;
				}
			}			
			pos = nextPos;
		}	
		return result;
	}
	
	protected int getBeginOf(Text innerText) {
		int pos = 0;
		for (Text inner: texts) {
			if (inner == innerText) {
				return pos;
			} else {
				pos += inner.getLength();
			}
		}
		return -1;
	}
}
