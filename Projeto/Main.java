import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Usuario user = new Usuario(scanner);
		WhatsApp whats = new WhatsApp("2.2.1", 5, 2);
		whats.init(scanner);

		scanner.close();
	}
}
