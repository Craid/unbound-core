package de.unbound.game.mode;

public abstract class AbstractCommandHandler {
	
	public void handleInput() {
		String[] commands = getCommands();
		for (String command : commands){
			handleCommand(command);
		}
	}

	public abstract String[] getCommands();
	
	public abstract void handleCommand(String command);

}
