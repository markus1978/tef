package hub.sam.tef.controllers;

import hub.sam.tef.views.Text;

public interface ICursorPostionProvider {
	
	public void setNewCursorPosition(Text text, int offset);
	
	public void addCarretDrift(int value);
}
