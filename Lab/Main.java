// Questao: Tente modificar o valor da dono de um grupo (que e um atributo final). Crie um setter se necessario.
// Foi possivel fazer a modificacao? Explique.
// Resposta: Apesar de tentar modificar e pegar a excecao num bloco try/catch, ao criar um setter para um atributo final o java
// acusa erro, nao compilando. Isso se deve pelo atributo dono ser final, podendo ser declarado (atribuido valor) apenas uma unica vez
// durante a instanciacao do objeto

// Questao: Agora, no metodo main, crie uma variavel final do tipo Grupo, e instancie ela com os valores que preferir. Tente modificar
// algum atributo do objeto atraves de um setter, como o atributo referente ao id. Foi possivel modificar esse atributo, mesmo
// com o objeto sendo final? Por que?
// Resposta: Foi possível modificar o atributo ja que o objeto em si e final, porem seus atributos (tirando o usuario), nao.
// Portanto se quisermos atribuir um outro grupo para o objeto instanciado nao teria como, ja que ele em si e final

// Questao: Se ao inves de usar ArrayList para definir a lista de membros da classe Grupo tivessemos usado um array, o que mudaria
// na implementação? Poderiamos continuar adicionado membros como fizemos? Haveria alguma limitação? Discuta as
// desvantagens dessa solução.
// Resposta: Utilizando um array teriamos que instanciar o seu tamanho, ja que ele nao e dinamico como um ArrayList. Alem de ter
// um tamanho fixo, seria necessario tratar os itens do array direto pelo seu index (ja no ArrayList funciona em esquema de fila,
// podemos simplesmente dar um .add ou .remove nos elementos).

// Questao: Qual o principal beneficio da heranca?
// Resposta: Implementar classes mais especializadas partindo de uma classe generica/global, reutilizando codigo

// Questao: Adicione final na classe Grupo. O que aconteceu com o código? Por que isso aconteceu? Em vez de Grupo ser final e se
// definirmos GrupoPublico como final?
// Resposta: O codigo nao compila e acusa erro na hora que queremos herdar a classe Grupo nas classes GrupoPrivado e GrupoPublico.
// Isso acontece pois nao podemos estabelecer heranca numa classe final.

// Questao: Por que definimos os métodos adicionaMembro e removeMembro nas classes filhas e não na classe mãe (Grupo)?
// Resposta: Porque a implementacao e diferente entre as classes GrupoPublico e GrupoPrivado. Por ter um comportamento distinto entre
// essas duas classes, nao podemos tratar como um metodo "padrao" q pode ser herdado por todas elas. Ja que nessas classes cada metodo
// e mais especializado com um difeente comportamento, entao ele deve ser declarado nessas classes mais especializadas

import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		GregorianCalendar defaultDate = new GregorianCalendar(2020, 9, 2);

		Usuario firstUser = new Usuario(1234, "firstLogin", "firstEmail", "firstPassword", "defaultDescription01", defaultDate, true);
		Usuario secondUser = new Usuario(1234, "secondLogin", "secondEmail", "secondPassword", "defaultDescription02", defaultDate, true);
		Usuario thirdUser = new Usuario(1234, "thirdLogin", "thirdEmail", "thirdPassword", "defaultDescription03", defaultDate, true);
		Usuario fourthUser = new Usuario(1234, "fourthLogin", "fourthEmail", "fourthPassword", "defaultDescription04", defaultDate, true);

		Admin admin = new Admin(0000, "ADMIN", "adminEmail", "adminPassword", "adminDescription", defaultDate, true);

		ArrayList<Usuario> membros = new ArrayList<Usuario>();
		membros.add(secondUser);
		membros.add(thirdUser);

		GrupoPublico publicGroup = new GrupoPublico(01, "Grupo Publico", "Primeiro grupo publico", firstUser, membros, true, new GregorianCalendar());

		ArrayList<Usuario> membros2 = new ArrayList<Usuario>();
		membros2.add(thirdUser);
		membros2.add(fourthUser);

		GrupoPrivado privateGroup = new GrupoPrivado(02, "Grupo Privado", "Primeiro grupo privado", secondUser, membros2, true, new GregorianCalendar());

		System.out.print(publicGroup.toString());
		System.out.print(privateGroup.toString());

		// O dono de um grupo não pode ser modificado
		// Codigo comentado pois acusava erro de compilacao
		// try {
		// 	publicGroup.setDono(thirdUser);
		// } catch (Exception e) {
		// 	System.out.print("Erro, atributo final nao pode ser modificado:\n");
		// 	System.out.print(e + "\n");
		// }

		// Apenas um admin pode mudar o status de um grupo
		// Codigo comentado pois acusava erro de compilacao, firstUser nao e Admin
		// publicGroup.setStatus(firstUser, false);
		admin.desabilitarGrupo(publicGroup);
		System.out.print(publicGroup.toString());

		// Apenas o dono de um grupo privado pode inserir ou remover usuários
		privateGroup.adicionaMembro(thirdUser, firstUser);
		privateGroup.adicionaMembro(secondUser, firstUser);
		System.out.print(privateGroup.toString());
	}
}
