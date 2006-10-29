package editortest.text;

public class FixText extends Text {
	
	public FixText(String text) {
		changeContent(0, getLength(), text);
	}
}
