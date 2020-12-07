import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Usuario user = new Usuario(scanner);

		scanner.close();
	}
}
