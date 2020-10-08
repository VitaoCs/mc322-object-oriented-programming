// Questao: Qual o impacto de se tentar mudar diretamente o valor do atributo login de um dos objetos Usuario
// no método main? Por quê?
// Resposta: O compilador acusa um erro "error: <atributo> has private access in Usuario" , ja que atributos
// com visibilidade "private" so podem ser alterados por metodos get/set da propria classe.

// Questao: Como você trataria o problema levantado na questao anterior? Quais seriam os prós e os contras
// desta nova abordagem? Que conceito de Orientação a Objetos estaria sendo ”quebrado” neste caso?
// Resposta: Temos duas tratativas possiveis: a primeira seria de alterar a visibilidade do atributo para "public",
// o que permite alterar seu valor fora da classe, podendo gerar problemas pois qualquer objeto da classe poderia
// alterar os valores dos atributos e fere tambem o encapsulamento proposto da classe em Java. A segunda abordagem,
// que foi a utilizada nesse laboratório, e a de criar metodos get/set para acessar e alterar os valores dos 
// atributos da classe, mantendo o encapsulamento e seguranca do codigo

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
