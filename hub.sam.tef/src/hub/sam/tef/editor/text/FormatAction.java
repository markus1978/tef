/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
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

package hub.sam.tef.editor.text;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.texteditor.ResourceAction;

/**
 * This action formats the text in the editor according to the layout defined as
 * part of the syntax used for this editor.
 */
public class FormatAction extends ResourceAction implements ITefEditorStatusListener {

	/**
	 * This is used to connect the action with all the strings in the messages
	 * properties file of the TEF plug-in.
	 */
	public final static String MESSAGE_KEYS_PREFIX = "FormatAction.";
	/**
	 * This is used to connect the action with the command defined as extension
	 * point in this plug/in.
	 */
	public final static String ACTION_DEFINITION_ID = "hub.sam.tef.Format";
	
	private final TextEditor fEditor;
	

	public FormatAction(TextEditor editor) {
		super(TEFPlugin.getMessagesBundle(), MESSAGE_KEYS_PREFIX);
		fEditor = editor;
		fEditor.addEditorStatusListener(this);
		setActionDefinitionId(ACTION_DEFINITION_ID);
	}

	@Override
	public void run() {
		Assert.isTrue(fEditor != null && !fEditor.hasError());
		
		Resource resource = fEditor.getCurrentModel();
		PrettyPrinter printer = fEditor.createPrettyPrinter();
		
		// TODO select the proper layout manager
		printer.setLayout(new BlockLayout());

		EList<EObject> contents = resource.getContents();
		if (contents.size() != 1) {
			// TODO confirmation dialog;
		}
		EObject root = contents.get(0);
		try {
			PrettyPrintState result = printer.print(root);
			String newContent = result.toString();
			fEditor.updateCurrentText(newContent);
		} catch (ModelCreatingException e) {
			// TODO Error dialog
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}	
		
	/**
	 * Is action is only activated when the edited text is error free.
	 */
	public void errorStatusChanged(TextEditor editor) {
		setEnabled(!editor.hasError());
	}
	
	public void dispose() {
		fEditor.removeEditorStatusListener(this);
	}
}
