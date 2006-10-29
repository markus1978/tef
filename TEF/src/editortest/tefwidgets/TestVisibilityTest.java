package editortest.tefwidgets;

import java.util.List;
import java.util.Vector;

import editortest.text.ChangeText;
import editortest.text.Proposal;
import editortest.text.TextEvent;
import editortest.text.TextEventListener;

public class TestVisibilityTest extends ChangeText {
	
	private boolean set = false;
	
	static final TextEventListener fSetAVisibilityHandler = new TextEventListener<TestVisibilityTest>() {
		public boolean handleEvent(TextEvent e, TestVisibilityTest context) {
			if ((e.getBegin() == 0) && (e.getText().equals("private ") || 
					e.getText().equals("public "))) {			
				context.setText(e.getText());
				context.set = true;
				return true;
			} else {
				return false;
			}
		}
		
		public List<Proposal> getProposals(int offset, TestVisibilityTest context) {
			List<Proposal> result = new Vector<Proposal>();
			if (offset == 0 && !context.set) {
				result.add(new Proposal("public", "public "));
				result.add(new Proposal("private", "private "));
			}
			return result;
		}				
	};
	
	static final TextEventListener fRemoveAVisibilityHandler = new TextEventListener<TestVisibilityTest>() {
		public boolean handleEvent(TextEvent e, TestVisibilityTest context) {
			if (e.getBegin() == e.getEnd() && e.getText().equals("")) {
				context.setText("");
				context.set = false;
				return true;
			} else {
				return false;
			}
		}

		public boolean verifyEvent(TextEvent e, TestVisibilityTest context) {
			if (e.getText().equals("") && e.getBegin() != e.getEnd() && context.set) {
				e.setBegin(0);
				e.setEnd(context.getLength());
				return true;
			} else {
				return false;
			}
		}
		
	};
	
	public TestVisibilityTest() {
		addEventHandler(fSetAVisibilityHandler);
		addEventHandler(fRemoveAVisibilityHandler);
	}

	/*
	@Override
	public boolean handleEvent(TextEvent e) {
		if ((e.getBegin() == 0) && (e.getText().equals("private ") || e.getText().equals("public "))) {			
			setText(e.getText());
			set = true;
			return true;			
		} else if (e.getText().equals("")) {
			setText("");
			set = false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean verifyEvent(TextEvent e) {
		if (e.getText().equals("") && e.getBegin() != e.getEnd() && set) {
			e.setBegin(0);
			e.setEnd(getLength());
			return true;
		} else {
			return false;
		}
	}
	*/		
}
