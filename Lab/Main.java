// Questao: Explique o que e polimorfismo, qual sua importancia e por que deve ser utilizado.
// Resposta: Polimorfismo e quando uma classe mais especializada sobrescreve metodos de sua classe extendida e os objetos
// declarados sabem diferenciar a chamada da funcao (da classe especializada ou da classe mais generica) de acordo com a
// instancia do objeto.

// Questao: Como é o funcionamento do polimorfismo na linguagem Java?
// Resposta: Atraves da sobrescrita de metodos entre classes que extendem uma outra.

// Questao: O que acontece se instanciarmos uma subclasse em uma variável da superclasse e tentarmos chamar um método que não
// foi implementado na superclasse? Como você resolveria essa situação?
// Resposta: Implementaria o metodo na subclasse, ja que o polimorfismo, o metodo seria chamado dinamicamente na subclasse.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		GregorianCalendar defaultDate = new GregorianCalendar(2020, 9, 2);
		GregorianCalendar dataExpiracao = new GregorianCalendar(2021, 8, 12);

		// Criando instancia do Perfil para indicar o uso das enums Sexo e Estado
		Perfil firstProfile = new Perfil(Sexo.HOMEM, defaultDate, "Catanduva", Estado.AMAZONAS, "(17)3693-3696",
				"First profile description", "image.png");

		// Criando instancias dos Usuarios, Admin e UsuarioConvidado
		Usuario firstUser = new Usuario(1234, "firstLogin", "firstEmail", "firstPassword", "defaultDescription01",
				defaultDate, true);
		Usuario secondUser = new Usuario(1234, "secondLogin", "secondEmail", "secondPassword", "defaultDescription02",
				defaultDate, true);
		Usuario thirdUser = new Usuario(1234, "thirdLogin", "thirdEmail", "thirdPassword", "defaultDescription03",
				defaultDate, true);
		Usuario fourthUser = new Usuario(1234, "fourthLogin", "fourthEmail", "fourthPassword", "defaultDescription04",
				defaultDate, true);
		Admin firstAdmin = new Admin(0001, "ADMIN1", "adminEmail1", "adminPassword1", "adminDescription1", defaultDate,
				true);
		Admin secondAdmin = new Admin(0002, "ADMIN2", "adminEmail2", "adminPassword2", "adminDescription2", defaultDate,
				true);
		UsuarioConvidado usuarioConvidado = new UsuarioConvidado(1234, "fifthLogin", "fifthEmail", "fifthPassword",
				"defaultDescription05", defaultDate, true, dataExpiracao);

		// Criando array de membros para popular os grupos
		ArrayList<Usuario> membros = new ArrayList<Usuario>();
		membros.add(secondUser);
		membros.add(thirdUser);
		ArrayList<Usuario> membros2 = new ArrayList<Usuario>();
		membros2.add(thirdUser);
		membros2.add(fourthUser);

		// Criando grupo privado e publico
		Grupo publicGroup = firstAdmin.criaGrupo(true, 01, "Grupo Publico", "Primeiro grupo publico", true,
				new GregorianCalendar());
		Grupo privateGroup = secondAdmin.criaGrupo(false, 02, "Grupo Privado", "Primeiro grupo privado", true,
				new GregorianCalendar());

		System.out.print("\n***** Para melhor visualizacao dos resultado no console\n");
		System.out.print("***** comente as linhas de acordo com cada cenario de teste\n");

		System.out.print("\n\n----->Alteracao da classe Profile contendo as duas classes enum Sexo e Estado: \n");
		System.out.print(firstProfile.toString());

		System.out.print("\n\n----->Grupo Publico: \n");
		System.out.print(publicGroup.toString());

		System.out.print("\n\nAdicione novos membros e imprima o resultado obtido: \n");
		for (Usuario membro : membros) {
			publicGroup.adicionaMembro(firstAdmin, membro, Permissoes.ADICIONAR_MEMBROS);
		}
		publicGroup.adicionaMembro(firstAdmin, fourthUser, Permissoes.ADICIONAR_MEMBROS);
		System.out.print(publicGroup.toString());

		System.out.print("\n\nRemova membros e imprima o resultado obtido: \n");
		publicGroup.removeMembro(firstAdmin, secondUser);
		System.out.print(publicGroup.toString());

		System.out.print("\n\nAlterar permissão de membros do grupo: \n");
		ArrayList<Permissoes> permissoes = new ArrayList<Permissoes>();
		permissoes.add(Permissoes.ADICIONAR_MEMBROS);
		permissoes.add(Permissoes.REMOVER_MEMBROS);
		publicGroup.removerPermissao(firstAdmin, thirdUser, permissoes);
		System.out.print(publicGroup.toString());

		System.out.print("\n\n----->Grupo Privado: \n");
		for (Usuario membro : membros2) {
			privateGroup.adicionaMembro(secondAdmin, membro, Permissoes.ADICIONAR_MEMBROS);
		}
		privateGroup.adicionaMembro(secondAdmin, secondUser, Permissoes.ADICIONAR_MEMBROS);
		System.out.print(privateGroup.toString());

		System.out.print("\n\nAlterar permissão de membros do grupo: \n");
		ArrayList<Permissoes> permissao = new ArrayList<Permissoes>();
		permissao.add(Permissoes.VISUALIZAR_INFO);
		privateGroup.removerPermissao(secondAdmin, fourthUser, permissao);
		System.out.print(privateGroup.toString());
	}
}
