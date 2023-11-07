import java.util.Scanner;

public class Cli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			CommandLine command = new CommandLine(scanner.nextLine()); // Get input from console as an array
			String cmd = command.getCommand();
			String output = "";
			if(cmd.equals("date")) {
				output = Commands.date();
			} else if(cmd.equals("time")) {
				output = Commands.time();
			} else if(cmd.equals("datetime")) {
				output = Commands.dateTime();
			} else if(cmd.equals("useraccount")) {
				output = Commands.userAccount();
			} else if(cmd.equals("userhome")) {
				output = Commands.userHome();
			} else if(cmd.equals("os")) {
				output = Commands.os();
			} else if(cmd.equals("printenv")) {
				output = Commands.printEnv(command);
			} else if(cmd.equals("echo") || cmd.equals("print")) {
				output = Commands.echo(command);
			} else if(cmd.equals("ls")) {
				output = Commands.ls(command);
			} else if(cmd.equals("cat")) {
				output = Commands.cat(command);
			} else if(cmd.equals("exit") || cmd.equals("logout")) {
				break; // Forces exit of the while loop
			} else {
				// String concatenation
				output = String.format("Command '%s' not found.", cmd);
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}
}