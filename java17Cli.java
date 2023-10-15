import java.util.Scanner;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;      

public class Cli {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String command = scanner.nextLine(); // Get input from console as an array of strings
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} 
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
				case String s -> s.startsWith("printenv")
					String[] strTable = splitString(command, 0);
					if(strTable.length > 1 && System.getenv(strTable[1]) != null) {
						output = System.getenv(strTable[1]);
					}
					break;
				default:
					/*if (command.startsWith("printenv")) {
						String[] strTable = splitString(command, 0);
						if(strTable.length > 1 && System.getenv(strTable[1]) != null) {
							output = System.getenv(strTable[1]);
						}
						break;
					}
					if (command.startsWith("echo")) {
						String[] strTable = splitString(command, 0);
						for(int i = 1; i < strTable.length; i++) {
							output += strTable[i] + " ";
						}
						break;
					}*/
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