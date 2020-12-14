import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario {
	static private int numeroUsuarios = 0;
	private int id;
	private String login;
	private String email;
	private String senha;
	private GregorianCalendar dataAtivacao;
	private boolean status;
	private ArrayList<Grupo> grupos;

	public Usuario(String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status) {
		this.numeroUsuarios = ++numeroUsuarios;
		this.id = this.numeroUsuarios;
		this.login = login; 
		this.email = email;
		this.senha = senha;
		this.dataAtivacao = dataAtivacao;
		this.status = status;
		this.grupos = new ArrayList<Grupo>();
	}

	public Usuario(String login, String email, String senha, boolean status) {
		this.numeroUsuarios = ++numeroUsuarios;
		this.id = this.numeroUsuarios;
		this.login = login; 
		this.email = email;
		this.senha = senha;
		this.dataAtivacao = new GregorianCalendar();
		this.status = status;
		this.grupos = new ArrayList<Grupo>();
	}

	public Usuario(String login, String email, String senha) {
		this.numeroUsuarios = ++numeroUsuarios;
		this.id = this.numeroUsuarios;
		this.login = login; 
		this.email = email;
		this.senha = senha;
		this.dataAtivacao = new GregorianCalendar();
		this.status = true;
		this.grupos = new ArrayList<Grupo>();
	}

	public Usuario(Scanner scanner) {
		System.out.println("Preencha os dados a seguir para a criacao do usuario");
		System.out.print("Login: ");
		String login = scanner.next();

		System.out.print("Email: ");
		String email = scanner.next();   

		System.out.print("Senha: ");
		String senha = scanner.next();

		System.out.println("\nUsuario criado!\n");

		this.numeroUsuarios = ++numeroUsuarios;
		this.id = this.numeroUsuarios;
		this.login = login; 
		this.email = email;
		this.senha = senha;
		this.dataAtivacao = new GregorianCalendar();
		this.status = true;
		this.grupos = new ArrayList<Grupo>();

		System.out.println(this.toString());
	}
	
	public static int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}		
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public GregorianCalendar getDataAtivacao() {
		return dataAtivacao;
	}
	
	public void setDataAtivacao(GregorianCalendar dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(Admin admin, boolean status) {
		this.status = status;
	}

	public void adicionarGrupo(Grupo grupo) {
		this.grupos.add(grupo);
	}

	public void sairDoGrupo(Grupo grupo) {
		int index = grupos.indexOf(grupo);
		grupos.remove(index);
	}

	public void deletarGrupo(Grupo grupo) {
		int index = grupos.indexOf(grupo);
		if (index < 0) return;
		Grupo grupoToRemove = grupos.get(index);
		grupos.remove(index);
		grupoToRemove.setUsuarios(this, new ArrayList<Usuario>());
	}

	public void adicionarUsuario(Usuario newUser, Grupo grupo) {
		ArrayList<Usuario> usuariosAtuais = grupo.getUsuarios(this);
		if (usuariosAtuais.indexOf(newUser) >= 0) {
			usuariosAtuais.add(newUser);
			grupo.setUsuarios(this,usuariosAtuais);
			newUser.adicionarGrupo(grupo);
		}
	}

	public ArrayList<Grupo> getTodosGrupos() {
		return this.grupos;
	}


	@Override
	public String toString(){
		String out = getLogin() + " (id: " + getId() + " )\n";
		out = out + " email: " + getEmail() + "\n";
		out = out + " senha: " + getSenha() + "\n";
		out = out + " data ativacao: " + getDataAtivacao().getTime() + "\n";
		out = out + " status: " + getStatus() + "\n";

		return out ;
	}
}
