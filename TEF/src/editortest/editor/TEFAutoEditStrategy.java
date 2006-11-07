package editortest.editor;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

import editortest.text.TextEvent;
import editortest.text.visitors.VerifyEventVisitor;

public class TEFAutoEditStrategy implements IAutoEditStrategy {

	public void customizeDocumentCommand(IDocument document,
			DocumentCommand command) {
		TextEvent textAdd = new TextEvent(document, command.offset, command.offset + 
				command.length, command.text);
		VerifyEventVisitor visitor = new VerifyEventVisitor(textAdd);
		((TEFDocument)document).getDocument().process(visitor, textAdd.getBegin());
		boolean accept = visitor.getResult();
		command.doit = true;
		if (accept) {			
			command.offset = textAdd.getBegin();
			command.length = textAdd.getEnd() - textAdd.getBegin();
			command.text = textAdd.getText();
		} else {
			command.shiftsCaret = false;
			command.length = 0;
			command.text = "";
		}
	}
}
