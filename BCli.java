import java.util.Scanner;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;      

public class BCli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		loop: while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as an array of strings
			String arguments = "";
			if(command.indexOf(" ") != -1) {
				arguments = command.substring(command.indexOf(" ")+1);
				command = command.substring(0, command.indexOf(" "));
			}
			String output = ""; // A variable named output of type String
			switch(command) {
				case "date":
					output = java.time.LocalDate.now().toString();
					break;  
				case "time":
					output = java.time.LocalTime.now().toString();
					break;
				case "datetime":
					output = java.time.LocalDateTime.now().toString();
					break;
				case "useraccount":
					output = System.getProperty("user.name");
					break;
				case "userhome":
					output = System.getProperty("user.home");
					break;
				case "os":
					output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";;
					break;
				case "printenv":
					if(arguments != null && System.getenv(arguments) != null) {
						output = System.getenv(arguments);
					}
					break;
				case "echo":
					if(arguments != null) {
						output = arguments;
					}
					break;
				case "exit": 
					break loop; // Forces exit of the while loop
				default:
					// String concatenation
					output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
	}

	public static String[] splitString(String str, int number) {
		return str.split(" ", number);
	}
}