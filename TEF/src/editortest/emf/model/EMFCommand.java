package editortest.emf.model;

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
			//throw new RuntimeException("assert");
			System.err.print("Command not executable....");
		}
		fCommand.execute();	
	}
}
