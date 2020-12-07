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
	private static final String[] NOMES_USUARIO = new String[] {"Maria", "Joao", "Jose", "Clara", "Julia", "Carla", "Ana", "Camila"};
	private static final String[] EMAIL_USUARIO = new String[] {"@gmail.com", "@hotmail.com", "@outlook.com"};
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
		int value = (int)(Math.random()*((max-min)+1))+min;
		System.out.println("**********************************" + value);
		return value;

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
	}

	private void menuPrincipal(Scanner scanner) {
		System.out.println("Esse é o menu da plataforma");
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
					menuPrincipal(scanner);
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
