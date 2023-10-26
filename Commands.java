import java.io.File;    
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;   

public class Commands {
	public static String date() {
		return java.time.LocalDate.now().toString(); 
	}

	public static String time() {
		return java.time.LocalTime.now().toString();
	}

	public static String dateTime() {
		return java.time.LocalDateTime.now().toString();
	}

	public static String userAccount() {
		return System.getProperty("user.name");
	}

	public static String userHome() {
		return System.getProperty("user.home");
	}

	public static String os() {
		return System.getProperty("os.name") + String.format(" (%s)", System.getProperty("os.version"));
	}

	public static String printEnv(CommandLine command) {
		if(command.hasArgument()) {
			String output = System.getenv(command.getArguments());
			if(output == null) {
				output = "";
			}
			return output;
		} else {
			Map <String, String> environmentVariables = System.getenv();
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> entry : environmentVariables.entrySet()) {
				sb.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
			}
			return sb.toString();
		}
	}

	public static String echo(CommandLine command) {
		if(command.hasArgument()) {
			return command.getArguments();
		}
		return "";
	}

	public static String ls(CommandLine command) {
		if(command.hasArgument()) {
			File path = new File(command.getArguments());
			String contents[] = path.list();
			StringBuilder sb = new StringBuilder();
			if(contents != null) {
				for(int i=0; i<contents.length; i++) {
					sb.append(contents[i]).append(System.lineSeparator());
				} 
				return sb.toString();
			} 
		}
		return "Not a directory.";
	}
}