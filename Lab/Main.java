// Questão: Qual foi a estratégia abordada: Interface, Classe Abstrata ou manutenção da classe concreta? Explique
// sua escolha.
// Resposta: A estratégia abordada foi de a classe Grupo ser mantida como esta atualmente, pelos seguintes motivos:
// 1 - As classes GrupoPublico e GrupoPrivado possuem os mesmo atributos e métodos entre sí, alterando apenas a
// sua implementação. Apesar de que poderíamos criar uma interface para "fechar o contrato" e definir os métodos
// que essas duas classes teriam, se estendessem essa interface, isso faria com que tivéssemos que implementar todos
// os atributos, getters e setters em ambas as classes, causando uma duplicação de código.
// 2 - Como as classes GrupoPublico e GrupoPrivado possuem apenas métodos com implementações diferentes sobrescrevendo
// (override) os métodos da classe Grupo, levaria a escolhermos transformá-la numa Classe Abstrata. Porém, como a classe
// Grupo possue métodos únicos que servem como utilitários para sua classe herdada (como o getUsuariosPermissoes e o
// setUsuariosPermissoes) isso impossibilita que ela seja transformada numa Classe Abstrata, já que se fosse, as classes
// que a herdam teriam que replicar esses métodos, causando uma repetição de código desnecessária.

// Questão: Em outra possível abordagem, a classe Usuário poderia ser implementada como uma Interface? Caso
// sim, por quê? Quais alterações seriam necessárias?
// Resposta: Não, pois a classe Usuário possui métodos comuns utilizados entre suas classes que a estendem. Caso fosse
// necessário transformar a classe Usuário numa interface, seria necessário trazer seus métodos para as classes que a
// implementam, aleḿ de levar os atributos da classe Usuário para as classes que antes a estendiam

import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		GregorianCalendar defaultDate = new GregorianCalendar(2020, 10, 2);
		GregorianCalendar dataExpiracao = new GregorianCalendar(2021, 8, 12);

		// Criando perfis para os usuarios
		Perfil profile_01 = new Perfil(Sexo.HOMEM, defaultDate, "Catanduva", Estado.AMAZONAS, "(17)3693-3696",
				"Profile description", "image_user_01.jpg");
		Perfil profile_02 = new Perfil(Sexo.MULHER, defaultDate, "Palmares", Estado.ALAGOAS, "(21)1234-5678",
				"Profile description", "image_user_02.png");
		Perfil profile_03 = new Perfil(Sexo.MULHER, defaultDate, "Olimpia", Estado.MARANHAO, "(35)9999-6666",
				"Profile description", "image_user_03.png");
		Perfil profile_04 = new Perfil(Sexo.HOMEM, defaultDate, "Ariranha", Estado.MATO_GROSSO, "(41)5555-6666",
				"Profile description", "image_user_04.png");
		Perfil profile_05 = new Perfil(Sexo.MULHER, defaultDate, "Araraquara", Estado.GOIAS, "(82)8787-3535",
				"Usuario Convidado description", "image_user_05.png");
		Perfil profile_admin_01 = new Perfil(Sexo.MULHER, defaultDate, "Campinas", Estado.PERNAMBUCO, "(82)8787-3535",
				"Admin description", "image_user_01.png");
		Perfil profile_admin_02 = new Perfil(Sexo.HOMEM, defaultDate, "Itapetininga", Estado.RIO_NORTE, "(82)8787-3535",
				"Admin description", "image_user_02.png");

		// Criando instancias dos Usuarios, Admin e UsuarioConvidado
		UsuarioComum user_01 = new UsuarioComum(1234, "firstLogin", "firstEmail", "firstPassword",
				"defaultDescription01", defaultDate, true, profile_01);
		UsuarioComum user_02 = new UsuarioComum(1234, "secondLogin", "secondEmail", "secondPassword",
				"defaultDescription02", defaultDate, true, profile_02);
		UsuarioComum user_03 = new UsuarioComum(1234, "thirdLogin", "thirdEmail", "thirdPassword",
				"defaultDescription03", defaultDate, true, profile_03);
		UsuarioComum user_04 = new UsuarioComum(1234, "fourthLogin", "fourthEmail", "fourthPassword",
				"defaultDescription04", defaultDate, true, profile_04);
		Admin admin_01 = new Admin(0001, "ADMIN1", "adminEmail1", "adminPassword1", "adminDescription1", defaultDate,
				true, profile_admin_01);
		Admin admin_02 = new Admin(0002, "ADMIN2", "adminEmail2", "adminPassword2", "adminDescription2", defaultDate,
				true, profile_admin_02);
		UsuarioConvidado user_convidado_01 = new UsuarioConvidado(1234, "fifthLogin", "fifthEmail", "fifthPassword",
				"defaultDescription05", defaultDate, true, dataExpiracao, profile_05);

		// Criando array de membros para popular os grupos
		ArrayList<Usuario> membros_01 = new ArrayList<Usuario>();
		membros_01.add(user_01);
		membros_01.add(user_02);
		membros_01.add(user_convidado_01);
		ArrayList<Usuario> membros_02 = new ArrayList<Usuario>();
		membros_02.add(user_03);
		membros_02.add(user_04);

		// Criando grupo privado e publico
		Grupo publicGroup = admin_01.criarGrupo(true, 01, "Grupo Publico", "Primeiro grupo publico", true,
				new GregorianCalendar());
		Grupo privateGroup = admin_02.criarGrupo(false, 02, "Grupo Privado", "Primeiro grupo privado", true,
				new GregorianCalendar());

		// Adicionando membros aos grupos criados
		for (Usuario membro : membros_01) {
			publicGroup.adicionaMembro(admin_01, membro, Permissoes.ADICIONAR_MEMBROS);
		}
		for (Usuario membro : membros_02) {
			privateGroup.adicionaMembro(admin_02, membro, Permissoes.ADICIONAR_MEMBROS);
		}

		// Imprimindo os grupos criados com seus membros e permissões
		System.out.print(publicGroup.toString());
		System.out.print(privateGroup.toString());

		// Criando 6 cartoes nos grupos
		// Grupo Publico 01: admin_01, user_01, user_02, user_convidado_01
		// Grupo Privado 02: admin_02, user_03, user_04
		user_01.criarCartao(01, 01, "Evento da festa", true, "Devemos criar o evento da festa para divulgação", user_01,
				1);
		user_02.criarCartao(01, 03, "Orçar gelo", true, "Cotar a quantidade de gelo correta para as tinas", user_01, 5);
		user_02.criarCartao(01, 04, "Criar flyer e artes", true,
				"Criar arte da festa e flyer para divulgar no Bandejao", user_01, 1);
		admin_02.criarCartao(02, 02, "Orçar bebidas", true, "Cotar destilados e cerveja", user_04, 1);
		admin_02.criarCartao(02, 05, "Alugar rep", true, "Tentar achar rep com piscina", user_04, 2);
		admin_02.criarCartao(02, 05, "Contratar segurança", true, "Um seguranca para a porta e dois rodando a festa",
				user_03, 3);

		System.out.print(publicGroup.cartoesToString());
		System.out.print(privateGroup.cartoesToString());

		// Executando os cartoes de acordo com a prioridade
		System.out.print("\n\n\n");
		user_01.executarTarefaDeMaiorPrioridade();
		// Note que aqui o algoritmo executa o primeiro cartao adicionado no array,
		// quando temos prioridades iguais
		System.out.print(publicGroup.cartoesToString());

		System.out.print("\n\n\n");
		user_01.executarTarefaDeMaiorPrioridade();
		user_01.executarTarefaDeMaiorPrioridade();
		user_04.executarTarefaDeMaiorPrioridade();
		user_04.executarTarefaDeMaiorPrioridade();
		user_03.executarTarefaDeMaiorPrioridade();
		// Todos os cartoes foram executados por ordem de prioridade
		System.out.print(publicGroup.cartoesToString());
		System.out.print(privateGroup.cartoesToString());
	}
}
