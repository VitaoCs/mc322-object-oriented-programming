// Questao: E possivel escrever uma classe sem escrever nenhum construtor? Por que?
// Resposta: Ao intanciar uma classe o Java automaticamente define um construtor para a mesma quando e intanciada.

// Questao: Um metodo estatico pode acessar uma variaval (atributo) nao estatico da classe? Por que?
// Resposta: Nao, um metodo estatico nao pode acessar atributos nao estaticos. Isso se deve ao encapsulamento dos
// objetos da classe, ja que um metodo estatico funcionaria como um metodo "global" para esses objetos, ele nao consegue
// acessar os atributos dos objetos instanciados.

// Questao: Um metodo nao estatico pode acessar uma variavel (atributo) estatico da classe? Por que?
// Resposta: Sim, pois um atributo estatico, como o proprio metodo estatico, como dito acima, funciona como se fosse algo
// "global" aos objetos instanciados da classe e, assim, pode ser acessado pelo metodo

import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		GregorianCalendar calendarFirstUser = new GregorianCalendar(2020, 9, 2);

		Usuario firstUser = new Usuario(1234, "firstLogin", "firstEmail", "firstPassword", "defaultDescription01", calendarFirstUser, true);
		Usuario secondUser = new Usuario(1234, "secondUser", "secondEmail", "secondPassword", "defaultDescription02", calendarFirstUser, true);
		Usuario thirdUser = new Usuario(1234, "thirdLogin", "thirdEmail", "thirdPassword", "defaultDescription03", calendarFirstUser, true);
		Usuario fourthUser = new Usuario(1234, "fourthLogin", "fourthEmail", "fourthPassword", "defaultDescription04", calendarFirstUser, true);

		firstUser.criarGrupo(false, 01, "Group01", "First created group", firstUser, true, new GregorianCalendar());
		secondUser.criarGrupo(true, 02, "Group02", "Second created group", secondUser, true, new GregorianCalendar());
	
		ArrayList<Grupo> firstUserGroups = firstUser.getTodosGrupos();
		Grupo firstGrupo = firstUser.getGrupo(firstUserGroups.get(0));
		System.out.println(firstGrupo.toString());

		ArrayList<Grupo> secondUserGroups = secondUser.getTodosGrupos();
		Grupo secondGrupo = secondUser.getGrupo(secondUserGroups.get(0));
		System.out.println(secondGrupo.toString());

		// scanner.close();
	}
}
