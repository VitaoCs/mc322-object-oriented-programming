import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		/** Projeto 01
		* Scanner scanner = new Scanner(System.in);

		* WhatsApp whats = new WhatsApp("1.0.0", 6, 4);
		* whats.init(scanner);

		* scanner.close();
		**/


		Usuario user = new Usuario("login3", "email3", "senha3");
		ArrayList<Usuario> userArray = new ArrayList<Usuario>();
		userArray.add(user);
		GrupoPublico grupo = new GrupoPublico(01, "nomeGrupo", "descricao", user, userArray, true, new GregorianCalendar());
		new Mensagem("test", user, grupo);
		new Mensagem("test2", user, grupo);
		new Mensagem("test3", user, grupo);

		// read
		String messagesFile = "dataBase/grupos/" + grupo.getId() + "/mensagems.dat";
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(messagesFile));
			while (true) {
				Mensagem msg = (Mensagem) input.readObject();
				System.out.println(msg.toString());
			}
		} catch (EOFException e) {
			return;
		} catch (ClassNotFoundException er) {
			System.err.print("Classe incompatível");
			System.exit(1);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
