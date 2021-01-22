import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		
		//   Projeto 01 
		// Scanner scanner = new Scanner(System.in);
		// WhatsApp whats = new WhatsApp("1.0.0", 6, 4); whats.init(scanner);
		// scanner.close();

		new Janela("Mensagens Grupo", "Ler mensagens", "Insira o id do grupo");
		System.out.println("*******************************");
		new Janela("Usuarios", "Mostrar usuarios", "");
	}
}
