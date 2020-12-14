
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
	protected ArrayList<GrupoPublico> gruposPublicos;
	protected ArrayList<GrupoPrivado> gruposPrivados;
	private ArrayList<Usuario> permissaoAdicionar;
	private ArrayList<Usuario> permissaoRemover;
	private ArrayList<Usuario> permissaoAlterar;
	private ArrayList<Usuario> permissaoVisualizar;
	
	
	public Grupo(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> permissaoAdicionar, ArrayList<Usuario> permissaoRemover, ArrayList<Usuario> permissaoAlterar, ArrayList<Usuario> permissaoVisualizar, boolean status, GregorianCalendar dataCriacao) {
		this.id = id;
		this.nome = nome; 
		this.descricao = descricao;
		this.dono = dono;
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.permissaoAdicionar = permissaoAdicionar;
		this.permissaoRemover = permissaoRemover;
		this.permissaoAlterar = permissaoAlterar;
		this.permissaoVisualizar = permissaoVisualizar;
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Usuario> admin = new ArrayList<Usuario>();
		usuarios.add(dono);
		admin.add(dono);
		
	}

	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		ArrayList<Usuario> permissaoAdicionar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoRemover = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoAlterar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoVisualizar = new ArrayList<Usuario>();


		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Usuario> admin = new ArrayList<Usuario>();
		
		permissaoAdicionar.add(dono);
		permissaoRemover.add(dono);
		permissaoAlterar.add(dono);
		permissaoVisualizar.add(dono);
		
		usuarios.add(dono);
		admin.add(dono);

		this.id = id;
		this.nome = nome; 
		this.descricao = descricao;
		this.dono = dono;
		this.permissaoAdicionar = permissaoAdicionar;
		this.permissaoRemover = permissaoRemover;
		this.permissaoAlterar = permissaoAlterar;
		this.permissaoVisualizar = permissaoVisualizar;
		this.status = status;
		this.dataCriacao = dataCriacao;
	}

	public Grupo(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status, GregorianCalendar dataCriacao, boolean isPrivate) {
		ArrayList<Usuario> permissaoAdicionar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoRemover = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoAlterar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoVisualizar = new ArrayList<Usuario>();
		

		ArrayList<GrupoPublico> gruposPublicos = new ArrayList<GrupoPublico>();
		ArrayList<GrupoPrivado> gruposPrivados = new ArrayList<GrupoPrivado>();

		if (isPrivate) {
			permissaoAdicionar.add(dono);
			permissaoRemover.add(dono);
			permissaoAlterar.add(dono);
			permissaoVisualizar.add(dono);
			
			for (Usuario user : membros) {
				permissaoVisualizar.add(user);
			}
		} else {
			membros.add(dono);

			for (Usuario user : membros) {
				permissaoAdicionar.add(user);
				permissaoRemover.add(user);
				permissaoAlterar.add(user);
				permissaoVisualizar.add(user);
			}
		}
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Usuario> admin = new ArrayList<Usuario>();
		
		usuarios.add(dono);
		admin.add(dono);

		this.id = id;
		this.nome = nome; 
		this.descricao = descricao;
		this.dono = dono;
		this.permissaoAdicionar = permissaoAdicionar;
		this.permissaoRemover = permissaoRemover;
		this.permissaoAlterar = permissaoAlterar;
		this.permissaoVisualizar = permissaoVisualizar;
		this.status = status;
		this.dataCriacao = dataCriacao;
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

	public ArrayList<Usuario> getUsuariosPermissoes(Permissoes permissao) {
		switch (permissao) {
			case ADICIONAR_MEMBROS:
				return this.permissaoAdicionar;
			case REMOVER_MEMBROS:
				return this.permissaoRemover;
			case ALTERAR_PERMISSAO:
				return this.permissaoAlterar;
			case VISUALIZAR_INFO:
				return this.permissaoVisualizar;
			default:
				System.out.print("Tipo de permissao errada!! \n");
				return this.permissaoVisualizar;
		}
	}

	public void setUsuariosPermissoes(ArrayList<Usuario> usuarios, Permissoes permissao) {
		switch (permissao) {
			case ADICIONAR_MEMBROS:
				this.permissaoAdicionar = usuarios;
				break;
			case REMOVER_MEMBROS:
				this.permissaoRemover = usuarios;
				break;
			case ALTERAR_PERMISSAO:
				this.permissaoAlterar = usuarios;
				break;
			case VISUALIZAR_INFO:
				this.permissaoVisualizar = usuarios;
				break;
			default:
				System.out.print("Tipo de permissao errada!! \n");
				break;
		}
	}

	public ArrayList<Usuario> getPermissaoAdicionar() {
		return this.permissaoAdicionar;
	}

	public void setPermissaoAdicionar(ArrayList<Usuario> permissaoAdicionar) {
		this.permissaoAdicionar = permissaoAdicionar;
	}

	public ArrayList<Usuario> getPermissaoRemover() {
		return this.permissaoRemover;
	}

	public void setPermissaoRemover(ArrayList<Usuario> permissaoRemover) {
		this.permissaoRemover = permissaoRemover;
	}

	public ArrayList<Usuario> getPermissaoAlterar() {
		return this.permissaoAlterar;
	}

	public void setPermissaoAlterar(ArrayList<Usuario> permissaoAlterar) {
		this.permissaoAlterar = permissaoAlterar;
	}

	public ArrayList<Usuario> getPermissaoVisualizar() {
		return this.permissaoVisualizar;
	}

	public void setPermissaoVisualizar(ArrayList<Usuario> permissaoVisualizar) {
		this.permissaoVisualizar = permissaoVisualizar;
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

	public ArrayList<Permissoes> getUsuarioPermissao(Usuario usuario) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<Permissoes> permissoesUsuario = new ArrayList<Permissoes>();

		index.add(permissaoAdicionar.indexOf(usuario));
		index.add(permissaoRemover.indexOf(usuario));
		index.add(permissaoAlterar.indexOf(usuario));
		index.add(permissaoVisualizar.indexOf(usuario));
		for (int i = 0; i < index.size(); i++){
			if (index.get(i) >= 0) {
				permissoesUsuario.add(Permissoes.values()[i]);
			}
		}

		return permissoesUsuario;
	}

	public String usuariosToString() {
		String out = "";
		for (Permissoes permissao : Permissoes.values()) {
			out = out + "*****************************\n";
			out = out + " Usuarios com permissao: " + permissao + "\n";
			ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
			for (Usuario user : usuarios) {
				out = out + user.toString();
			}
		}
		out = out + "*****************************\n";
		return out;
	}

    @Override
    public String toString(){
		String out = "Grupo: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		out = out + usuariosToString();
		return out;
	}
}
