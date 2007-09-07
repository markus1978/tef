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
package hub.sam.tef.emf.model;

import java.util.Collection;
import java.util.Vector;

import hub.sam.tef.models.ICommand;

import org.eclipse.emf.common.command.Command;

public class EMFCommand implements ICommand {

	private final Command fCommand;
	
	public EMFCommand(final Command command) {
		super();
		fCommand = command;
	}

	public void execute() {
		if (!fCommand.canExecute()) {						
			throw new RuntimeException("cannot execute: " + fCommand.getDescription());
			//System.err.print("Command not executable....");
		}
		fCommand.execute();	
	}

	public Collection getResult() {
		Collection result = new Vector();
		for (Object singleResult: fCommand.getResult()) {
			result.add(EMFModel.getModelForEMFObject(singleResult));
		}
		return result;
	}
}
