/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef;

import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.controllers.VerifyEventVisitor;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;


public class TEFAutoEditStrategy implements IAutoEditStrategy {

	public void customizeDocumentCommand(IDocument document,
			DocumentCommand command) {
		TextEvent textAdd = new TextEvent(command.offset, command.offset + command.length, command.text);
		VerifyEventVisitor visitor = new VerifyEventVisitor(textAdd);
		((TEFDocument)document).getModelDocument().getDocumentText().process(visitor, textAdd.getBegin());
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
