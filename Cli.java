import java.util.Scanner;

public class Cli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			CommandLine command = new CommandLine(scanner.nextLine()); // Get input from console as an array
			String output = "";
			if(command.getCommand().equals("date")) {
				output = Commands.date();
			} else if(command.getCommand().equals("time")) {
				output = Commands.time();
			} else if(command.getCommand().equals("datetime")) {
				output = Commands.dateTime();
			} else if(command.getCommand().equals("useraccount")) {
				output = Commands.userAccount();
			} else if(command.getCommand().equals("userhome")) {
				output = Commands.userHome();
			} else if(command.getCommand().equals("os")) {
				output = Commands.os();
			} else if(command.getCommand().equals("printenv")) {
				output = Commands.printEnv(command);
			} else if(command.getCommand().equals("echo") || command.getCommand().equals("print")) {
				output = Commands.echo(command);
			} else if(command.getCommand().equals("ls")) {
				output = Commands.ls(command);
			} else if(command.getCommand().equals("exit") || command.getCommand().equals("logout")) {
				break; // Forces exit of the while loop
			} else {
				// String concatenation
				output = String.format("Command '%s' not found.", command.getCommand());
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}
}