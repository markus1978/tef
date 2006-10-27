package editortest.widgets;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

public class ChangeText extends Text {
			
	public void setText(String text) {
		changeContent(0, getLength(), text);		
	}

}
