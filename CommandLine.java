public class CommandLine {
	private String command;
	private String arguments;

	CommandLine(String line) {
		String[] stringCommand = line.split(" ", 2);
		this.command = stringCommand[0];
		if(stringCommand.length >= 2) {
			this.arguments = stringCommand[1];
		}
	}

	public String getCommand() {
		return command;
	}

	public String getArguments() {
		return arguments;
	}

	public boolean hasArgument() {
		return arguments != null;
	}
}