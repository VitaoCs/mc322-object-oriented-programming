import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Grupo {
	protected int id;
	protected String nome;
	protected String descricao;
	protected final Usuario dono;
	protected boolean status;
	protected GregorianCalendar dataCriacao;
	protected ArrayList<Usuario> usuarios;
	protected ArrayList<Usuario> admin;
	private ArrayList<Mensagem> mensagens;

	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.mensagens = new ArrayList<Mensagem>();
		this.usuarios = new ArrayList<Usuario>();
		this.admin = new ArrayList<Usuario>();

		this.usuarios.add(dono);
		this.admin.add(dono);
	}

	public Grupo(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status,
			GregorianCalendar dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.mensagens = new ArrayList<Mensagem>();
		this.usuarios = new ArrayList<Usuario>();
		this.admin = new ArrayList<Usuario>();

		this.usuarios.add(dono);
		this.admin.add(dono);

		for (Usuario usuario : membros) {
			this.usuarios.add(usuario);
		}
	}

	public Grupo(Scanner scanner, Usuario dono, boolean isPrivate) {
		System.out.println("Preencha os dados a seguir para a criacao do grupo");
		System.out.print("Nome: ");
		String nome = scanner.next();

		System.out.print("Descricao: ");
		String descricao = scanner.next();

		System.out.print("Id [inteiro]: ");
		int id = scanner.nextInt();

		System.out.println("\nGrupo criado!\n");

		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.status = true;
		this.dataCriacao = new GregorianCalendar();
		this.mensagens = new ArrayList<Mensagem>();
		this.usuarios = new ArrayList<Usuario>();
		this.admin = new ArrayList<Usuario>();

		this.usuarios.add(dono);
		this.admin.add(dono);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getDono() {
		return this.dono;
	}

	public String getDonoLogin() {
		return dono.getLogin();
	}

	public int getDonoId() {
		return dono.getId();
	}

	public ArrayList<Mensagem> getMensagens() {
		return this.mensagens;
	}

	public void addMensagem(Mensagem mensagem) {
		this.mensagens.add(mensagem);
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(Admin admin, boolean status) {
		this.status = status;
	}

	public GregorianCalendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ArrayList<Usuario> getUsuarios(Usuario user) {
		boolean isAdmin = user instanceof Admin;
		if (user == this.dono || isAdmin) {
			return this.usuarios;
		} else {
			return null;
		}
	}

	public void setUsuarios(Usuario user, ArrayList<Usuario> usuarios) {
		boolean isAdmin = user instanceof Admin;
		if (user == this.dono || isAdmin) {
			this.usuarios = usuarios;
		}
	}

	public void removerUsuario(Usuario user, Usuario removeUser) {
		boolean isAdmin = user instanceof Admin;
		if (user == this.dono || isAdmin) {
			int index = this.usuarios.indexOf(removeUser);
			this.usuarios.remove(index);
		}
	}

	public String usuariosToString() {
		String out = "";
		out = out + "*****************************\n";
		for (Usuario user : usuarios) {
			out = out + user.toString();
		}

		out = out + "*****************************\n";
		return out;
	}

	@Override
	public String toString() {
		String out = "Grupo: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		out = out + usuariosToString();
		return out;
	}
}
