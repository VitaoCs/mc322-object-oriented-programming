import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		WhatsApp whats = new WhatsApp("1.0.0", 6, 4);
		whats.init(scanner);

		scanner.close();
	}
}
