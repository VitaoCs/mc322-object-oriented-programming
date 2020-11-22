// Questao: Ha alguma diferenca entre utilizar atributos final e Enumeracoes ? Explique.
// Resposta: Sim, podemos instanciar uma enumeracao contendo uma serie de atributos de acordo com cada constante declarada
// sendo mais facil a utilizacao ao longo do codigo

// Questao: Na main tente instanciar uma nova Permissao (enum) com a palavra-chave new, o que acontece? Qual seria o motivo desse
// resultado?
// Resposta: O compilador acusa erro pois tipos enum nao podem sem instanciados (nao podemos criar novos objetos do tipo enum).

// Questao: Sobre os relacionamentos entre as classes: Em teoria, qual o tipo de relacionamento entre as Grupo(Privado e Público)
// e Usuario? E entre Usuario e Sala? (Lembre-se que relacionamentos são classificados em: Associação, Agregação e
// Composição.)
// Resposta: Em teoria a relação entre Grupo e Usuario e de Agregacao. Ja entre Usuario e Sala e de Composicao. 

// Questao: Qual a multiplicidade dos relacionamentos citados na questão anterior?
// Resposta: Entre Grupo e Uusario e de Muitos e Muitos (um grupo pode ter muitos usuarios e um usuario pode tem muitos grupos).
// A mesma multiplicidade ocorre entre Uusario e Sala.


import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		GregorianCalendar defaultDate = new GregorianCalendar(2020, 9, 2);

		Perfil firstProfile = new Perfil(Sexo.HOMEM, defaultDate, "Catanduva", Estado.AMAZONAS, "(17)3693-3696", "First profile description", "image.png");

		Usuario firstUser = new Usuario(1234, "firstLogin", "firstEmail", "firstPassword", "defaultDescription01", defaultDate, true);
		Usuario secondUser = new Usuario(1234, "secondLogin", "secondEmail", "secondPassword", "defaultDescription02", defaultDate, true);
		Usuario thirdUser = new Usuario(1234, "thirdLogin", "thirdEmail", "thirdPassword", "defaultDescription03", defaultDate, true);
		Usuario fourthUser = new Usuario(1234, "fourthLogin", "fourthEmail", "fourthPassword", "defaultDescription04", defaultDate, true);

		Admin firstAdmin = new Admin(0001, "ADMIN1", "adminEmail1", "adminPassword1", "adminDescription1", defaultDate, true);
		Admin secondAdmin = new Admin(0002, "ADMIN2", "adminEmail2", "adminPassword2", "adminDescription2", defaultDate, true);

		ArrayList<Usuario> membros = new ArrayList<Usuario>();
		membros.add(secondUser);
		membros.add(thirdUser);

		GrupoPublico publicGroup = new GrupoPublico(01, "Grupo Publico", "Primeiro grupo publico", firstUser, membros, true, new GregorianCalendar());

		ArrayList<Usuario> membros2 = new ArrayList<Usuario>();
		membros2.add(thirdUser);
		membros2.add(fourthUser);

		GrupoPrivado privateGroup = new GrupoPrivado(02, "Grupo Privado", "Primeiro grupo privado", secondUser, membros2, true, new GregorianCalendar());

		System.out.print("\n***** Para melhor visualizacao dos resultado no console\n");
		System.out.print("***** comente as linhas de acordo com cada cenario de teste\n");

		System.out.print("\n\n----->Alteracao da classe Profile contendo as duas classes enum Sexo e Estado: \n");
		System.out.print(firstProfile.toString());

		System.out.print("\n\n----->Grupo Publico: \n");
		System.out.print(publicGroup.toString());

		System.out.print("\n\nAdicione novos membros e imprima o resultado obtido: \n");
		publicGroup.adicionaMembro(firstUser, fourthUser, publicGroup.getUsuarioPermissao(firstUser).get(0));
		System.out.print(publicGroup.toString());

		System.out.print("\n\nRemova membros e imprima o resultado obtido: \n");
		publicGroup.removeMembro(firstUser, secondUser);
		System.out.print(publicGroup.toString());

		System.out.print("\n\nAlterar permissão de membros do grupo: \n");
		ArrayList<Permissoes> permissoes = new ArrayList<Permissoes>();
		permissoes.add(Permissoes.ADICIONAR_MEMBROS);
		permissoes.add(Permissoes.REMOVER_MEMBROS);
		publicGroup.removerPermissao(firstUser, thirdUser, permissoes);
		System.out.print(publicGroup.toString());

		System.out.print("\n\n----->Grupo Privado: \n");
		System.out.print(privateGroup.toString());

		System.out.print("\n\nAlterar permissão de membros do grupo: \n");
		ArrayList<Permissoes> permissao = new ArrayList<Permissoes>();
		permissao.add(Permissoes.VISUALIZAR_INFO);
		privateGroup.removerPermissao(secondUser, fourthUser, permissao);
		System.out.print(privateGroup.toString());

		// Parte comentada pois acusava erro de compilacao
		// Permissoes test = new Permissoes("02","TEST");
	}
}
