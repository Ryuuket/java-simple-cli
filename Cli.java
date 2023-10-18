import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;      

public class Cli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command[] = scanner.nextLine().split(" ", 2); // Get input from console as an array of strings
			String output = "";; // A variable named output of type String
			if(command[0].equals("date")) {
				output = java.time.LocalDate.now().toString();  
			} else if(command[0].equals("time")) {
				output = java.time.LocalTime.now().toString();
			} else if(command[0].equals("date")) {
				output = java.time.LocalDateTime.now().toString();
			} else if(command[0].equals("useraccount")) {
				output = System.getProperty("user.name");
			} else if(command[0].equals("userhome")) {
				output = System.getProperty("user.home");
			} else if(command[0].equals("os")) {
				StringBuilder sb = new StringBuilder();
				sb.append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.version")).append(")");
				output = sb.toString();
			} else if(command[0].equals("printenv")) {
				if(command.length == 1) {
					Map <String, String> environmentVariables = System.getenv();
					StringBuilder sb = new StringBuilder();
					for (Map.Entry<String, String> entry : environmentVariables.entrySet()) {
						sb.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
					}
					output = sb.toString();
				} else if(command.length > 1) {
					output = System.getenv(command[1]);
					if(output == null) {
						output = "";
					}
				}
			} else if(command[0].equals("echo") ||command[0].equals("print")) {
				if(command.length > 1) {
					output = command[1];
				}
			} else if(command[0].equals("ls")) {
				if(command.length > 1) {
					File path = new File(command[1]);
					String contents[] = path.list();
					StringBuilder sb = new StringBuilder();
					if(contents != null) {
						for(int i=0; i<contents.length; i++) {
							sb.append(contents[i]).append(System.lineSeparator());
						} 
						output = sb.toString();
					} else {
						output = "Not a directory.";
					}
				} else {
					output = "Not a directory.";
				}
			} else if(command[0].equals("exit") || command[0].equals("logout")) {
				break; // Forces exit of the while loop
			} else {
				// String concatenation
				output = "Command '" + command[0] + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}
}