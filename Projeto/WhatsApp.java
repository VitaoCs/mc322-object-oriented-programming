import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class WhatsApp {
	private static final String ANSI_RESET = "\u001B[0m";
	// public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	// public static final String ANSI_GREEN = "\u001B[32m";
	// public static final String ANSI_YELLOW = "\u001B[33m";
	// public static final String ANSI_BLUE = "\u001B[34m";
	// public static final String ANSI_PURPLE = "\u001B[35m";
	// public static final String ANSI_CYAN = "\u001B[36m";
	// public static final String ANSI_WHITE = "\u001B[37m";
	// public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	// public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	// public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	// public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	// public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	// public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	private static final String[] NOMES_USUARIO = new String[] { "Maria", "Joao", "Jose", "Clara", "Julia", "Carla",
			"Ana", "Camila" };
	private static final String[] EMAIL_USUARIO = new String[] { "@gmail.com", "@hotmail.com", "@outlook.com" };
	private final String versao;
	private final int usuariosIniciais;
	private final int gruposPublicosIniciais;
	private ArrayList<Usuario> usuarios;
	// private static ArrayList<GrupoPublico> gruposPublicos;
	// private static ArrayList<GrupoPrivado> gruposPrivados;

	public WhatsApp(String versao, int usuarios, int grupos) {
		this.versao = versao;
		this.usuariosIniciais = usuarios;
		this.gruposPublicosIniciais = grupos;
		this.usuarios = new ArrayList<Usuario>();
		// this.gruposPublicos = new ArrayList<GrupoPublico>();
		// this.gruposPrivados = new ArrayList<GrupoPrivado>();
	}

	public String getVersao() {
		return this.versao;
	}

	private ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}

	private void addUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	private void criarBancoDeUsuarios() {
		for (int i = 0; i < usuariosIniciais; i++) {
			int randomNumber = getNumeroAleatorioNoIntervalo(0, 2);
			String login = NOMES_USUARIO[i];
			String email = login + EMAIL_USUARIO[randomNumber];
			String senha = "senha" + i + randomNumber;
			Usuario user = new Usuario(login, email, senha);
			usuarios.add(user);
		}
		System.out.println("Os seguintes usuarios foram criados para o testes:");
		imprimirUsuarios();
	}

	private void imprimirUsuarios() {
		for (Usuario user : usuarios) {
			System.out.println(user.toString());
		}
	}

	private void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private int getNumeroAleatorioNoIntervalo(int min, int max) {
		int value = (int) (Math.random() * ((max - min) + 1)) + min;
		return value;
	}

	private void mostrarGrupos(Usuario user) {
		System.out.println("******************************");
		ArrayList<Grupo> grupos = user.getTodosGrupos();
		for (Grupo grupo : grupos) {
			System.out.println(grupo.toString());
			System.out.println("******************************");
		}
	}

	private void mostrarUltimasMensagens(GrupoPublico grupo) {
		int maxMsg = 5;
		System.out.println("******************************");
		ArrayList<Mensagem> mensagens = grupo.getMensagens();
		for (Mensagem mensagem : mensagens) {
			System.out.println(grupo.toString());
			System.out.println("******************************");
			maxMsg--;
			if (maxMsg <= 0)
				break;
		}
	}

	private void mostrarUltimasMensagens(GrupoPrivado grupo) {
		int maxMsg = 5;
		System.out.println("******************************");
		ArrayList<Mensagem> mensagens = grupo.getMensagens();
		for (Mensagem mensagem : mensagens) {
			System.out.println(grupo.toString());
			System.out.println("******************************");
			maxMsg--;
			if (maxMsg <= 0)
				break;
		}
	}

	private String tratarMensagem(Scanner scanner, Usuario user, GrupoPrivado grupo) {
		System.out.println("Digite sua mensagem: ");
		try {
			String text = scanner.next();
			if (text = "") {
				telaGrupo(scanner, user, grupo);
			} else {
				ArrayList<Mensagem> mensagens = grupo.getMensagens();
				mensagens.add(new Mensagem(text, user));
				grupo.setMensagens(mensagens);
				mostrarUltimasMensagens(grupo);
			}
		} catch (Exception e) {
			System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
			telaGrupo(scanner, user, grupo);
		}
	}

	private String tratarMensagem(Scanner scanner, Usuario user, GrupoPublico grupo) {
		System.out.println("Digite sua mensagem: ");
		try {
			String text = scanner.next();
			if (text = "") {
				telaGrupo(scanner, user, grupo);
			} else {
				ArrayList<Mensagem> mensagens = grupo.getMensagens();
				mensagens.add(new Mensagem(text, user));
				grupo.setMensagens(mensagens);
				mostrarUltimasMensagens(grupo);
			}
		} catch (Exception e) {
			System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
			telaGrupo(scanner, user, grupo);
		}
	}

	private GrupoPublico getGrupoPorId(ArrayList<GrupoPublico> grupos, int id) {
		for (Grupo grupo : grupos) {
			if (grupo.getId().equals(id)) {
				return grupo;
			}
		}
		return null;
	}

	private GrupoPrivado getGrupoPorId(ArrayList<GrupoPrivado> grupos, int id) {
		for (Grupo grupo : grupos) {
			if (grupo.getId().equals(id)) {
				return grupo;
			}
		}
		return null;
	}

	private boolean isGrupoPrivado(int id) {
		for (Grupo grupo : gruposPrivados) {
			if (grupo.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private boolean isGrupoPublico(int id) {
		for (Grupo grupo : gruposPublicos) {
			if (grupo.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private void telaCriarUsuario(Scanner scanner) {
		limparTela();
		System.out.println("Crie seu usuario para acessar a expericencia da plataforma");
		Usuario user = new Usuario(scanner);
		addUsuario(user);
		System.out.print("Usuario criado, entrando na plataforma");
		for (int i = 0; i < 5; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
			}
			System.out.print(".");
		}
		System.out.print("\n");
		menuPrincipal(scanner, user);
	}

	private void telaAcessarGrupos(Scanner scanner, Usuario user) {
		limparTela();
		int option = 0;
		System.out.println("Selecione o id do grupo que quer mandar a mensagem:");
		mostrarGrupos(user);
		try {
			option = scanner.nextInt();
		} catch (Exception e) {
			System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
			menuPrincipal(scanner, user);
		}

		if (isGrupoPublico(option)) {
			GrupoPublico grupo = getGrupoPorId(gruposPublicos, option);
			telaGrupo(scanner, user, grupo);
		} else if (isGrupoPublico(option)) {
			GrupoPrivado grupo = getGrupoPorId(gruposPrivados, option);
			telaGrupo(scanner, user, grupo);
		} else {
			System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
			menuPrincipal(scanner, user);
		}
	}

	private void telaGrupo(Scanner scanner, Usuario user, GrupoPrivado grupo) {
		limparTela();
		int option = 0;
		System.out.println(ANSI_GREEN_BACKGROUND + "Grupo Privado" + ANSI_RESET);
		System.out.println(grupo.toString());
		mostrarUltimasMensagens(grupo);
		do {
			System.out.println("[1] Mandar uma mensagem");
			System.out.println("[2] Sair");
			System.out.print("Insira uma opcao: ");
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
				telaAcessarGrupos(scanner, user);
				break;
			}
			switch (option) {
				case 1:
					tratarMensagem(scanner, user, grupo);
					break;
				case 2:
					System.out.println("-----------------------------");
					telaAcessarGrupos(scanner, user);
					break;
				default:
					limparTela();
					System.out.println("Opcao invalida");
			}

		} while (option != 3);
	}

	private void telaGrupo(Scanner scanner, Usuario user, GrupoPublico grupo) {
		limparTela();
		int option = 0;
		System.out.println(ANSI_GREEN_BACKGROUND + "Grupo Privado" + ANSI_RESET);
		System.out.println(grupo.toString());
		mostrarUltimasMensagens(grupo);
		do {
			System.out.println("[1] Mandar uma mensagem");
			System.out.println("[2] Sair");
			System.out.print("Insira uma opcao: ");
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
				telaMandarMsg(scanner, user);
				break;
			}
			switch (option) {
				case 1:
					tratarMensagem(scanner, user, grupo);
					break;
				case 2:
					System.out.println("-----------------------------");
					telaMandarMsg(scanner, user);
					break;
				default:
					limparTela();
					System.out.println("Opcao invalida");
			}

		} while (option != 3);
	}

	private void menuPrincipal(Scanner scanner, Usuario user) {
		limparTela();
		int option = 0;
		System.out.println(ANSI_GREEN_BACKGROUND + "Bem vindx ao Menu Principal\n" + ANSI_RESET);
		System.out.println("Seus grupos:");
		mostrarGrupos(user);

		do {
			System.out.println("[1] Acessar um grupo");
			// System.out.println("[2] Deletar mensagem do grupo");
			System.out.println("[3] Criar um grupo");
			System.out.println("[4] Sair do grupo");
			System.out.println("[5] Adicionar admin no grupo");
			System.out.println("[6] Remover admin do grupo");
			System.out.println("[7] Deletar um grupo");
			System.out.println("[8] Adicionar usuario no grupo");
			System.out.println("[9] Remover usuario do grupo");
			System.out.println("[10] Pesquisar um grupo");
			System.out.println("[11] Sair");
			System.out.print("Insira uma opcao: ");
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
				break;
			}
			switch (option) {
				case 1:
					telaAcessarGrupos(scanner, user);
					break;
				case 2:
					break;
				case 3:
					telaCriarGrupo(scanner, user); // TO DO
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					System.out.println("-----------------------------");
					menuInicial(scanner);
					break;
				default:
					limparTela();
					System.out.println("Opcao invalida");
			}

		} while (option != 11);
	}

	private void menuInicial(Scanner scanner) {
		int option = 0;
		System.out.println(ANSI_GREEN_BACKGROUND + "Bem vindx ao WhatsApp!" + ANSI_RESET);
		do {
			System.out.println("[1] Entrar com um usuario");
			System.out.println("[2] Entrar com um administrador");
			System.out.println("[3] Sair");
			System.out.print("Insira uma opcao: ");
			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_RED + "Opcao invalida" + ANSI_RESET);
				break;
			}
			switch (option) {
				case 1:
					telaCriarUsuario(scanner);
					break;
				case 2:
					System.out.println("Tela Admin");
					break;
				case 3:
					System.out.println("-----------------------------");
					break;
				default:
					limparTela();
					System.out.println("Opcao invalida");
			}

		} while (option != 3);

	}

	public void init(Scanner scanner) {
		criarBancoDeUsuarios();
		menuInicial(scanner);
	}
}