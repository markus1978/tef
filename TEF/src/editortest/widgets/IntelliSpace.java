package editortest.widgets;

public class IntelliSpace extends ChangeText {
	
	private boolean showspace = true;

	public IntelliSpace(final Text dependant) {
		super();
		showspace = dependant.getLength() != 0;
		if (showspace) {
			setText(" ");
		} else {
			setText("");
		}		
		dependant.addTextChangeListener(new ITextChangeListener() {
			public void textChanged(Text changedText) {
				if (changedText.getLength() == 0 && showspace) {
					showspace = false;
					setText("");
				} else if (changedText.getLength() != 0 && !showspace){
					showspace = true;
					setText(" ");			
				}		
			}			
		});		
	}	
}
