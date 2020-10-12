// Questao: E possivel escrever uma classe sem escrever nenhum construtor? Por que?
// Resposta: Ao intanciar uma classe o Java automaticamente define um construtor para a mesma quando e intanciada.

// Questao: Um metodo estatico pode acessar uma variaval (atributo) nao estatico da classe? Por que?
// Resposta: Nao, um metodo estatico nao pode acessar atributos nao estaticos. Isso se deve ao encapsulamento dos
// objetos da classe, ja que um metodo estatico funcionaria como um metodo "global" para esses objetos, ele nao consegue
// acessar os atributos dos objetos instanciados.

// Questao: Um metodo nao estatico pode acessar uma variavel (atributo) estatico da classe? Por que?
// Resposta: Sim, pois um atributo estatico, como o proprio metodo estatico, como dito acima, funciona como se fosse algo
// "global" aos objetos instanciados da classe e, assim, pode ser acessado pelo metodo

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Lab01: criar Usuario e Perfil
		GregorianCalendar calendarFirstUser = new GregorianCalendar(2020, 9, 2);
		GregorianCalendar calendarSecondUser = new GregorianCalendar(2019, 9, 2);

		Usuario firstUser = new Usuario(1234, "firstLogin", "firstEmail", "firstPassword", calendarFirstUser, true);
		Usuario secondUser = new Usuario(5678, "secondLogin", "secondEmail", "secondPassword", calendarSecondUser, false);

		Perfil firstProfile = new Perfil('M', calendarFirstUser, "Catanduva", "Sao Paulo", "(17)3693-3696", "First profile description", "image.png");
		Perfil secondProfile = new Perfil('F', calendarSecondUser, "Iracema", "Roraima", "(95)3636-3663", "Second profile description", "photo.jpg");

		System.out.println(firstUser.toString());
		System.out.println(secondUser.toString());

		System.out.println(firstProfile.toString());
		System.out.println(secondProfile.toString());

		// Lab02: criar Sala e Cartao
		Sala firstSala = new Sala(scanner);
		Sala secondSala = new Sala();
		System.out.println(firstSala.toString());
		System.out.println(secondSala.toString());

		Cartao firstCartao = new Cartao(scanner);
		Cartao secondCartao = new Cartao();
		System.out.println(firstCartao.toString());
		System.out.println(secondCartao.toString());
	

		scanner.close();
	}
}
