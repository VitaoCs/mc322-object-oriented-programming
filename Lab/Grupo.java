
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Grupo {
	private int id;
	private String nome;
	private String descricao;
	private final Usuario dono;
	private ArrayList<Usuario> permissaoAdicionar;
	private ArrayList<Usuario> permissaoRemover;
	private ArrayList<Usuario> permissaoAlterar;
	private ArrayList<Usuario> permissaoVisualizar;
	private ArrayList<Usuario> permissaoCriarCartao;
	private ArrayList<Cartao> cartoes;
	private boolean status;
	private GregorianCalendar dataCriacao;

	public Grupo(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> permissaoAdicionar,
			ArrayList<Usuario> permissaoRemover, ArrayList<Usuario> permissaoAlterar,
			ArrayList<Usuario> permissaoVisualizar, ArrayList<Usuario> permissaoCriarCartao, ArrayList<Cartao> cartoes,
			boolean status, GregorianCalendar dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.permissaoAdicionar = permissaoAdicionar;
		this.permissaoRemover = permissaoRemover;
		this.permissaoAlterar = permissaoAlterar;
		this.permissaoVisualizar = permissaoVisualizar;
		this.permissaoCriarCartao = permissaoCriarCartao;
		this.cartoes = cartoes;
		this.status = status;
		this.dataCriacao = dataCriacao;
	}

	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		ArrayList<Usuario> permissaoAdicionar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoRemover = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoAlterar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoVisualizar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoCriarCartao = new ArrayList<Usuario>();

		permissaoAdicionar.add(dono);
		permissaoRemover.add(dono);
		permissaoAlterar.add(dono);
		permissaoVisualizar.add(dono);
		permissaoCriarCartao.add(dono);

		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.permissaoAdicionar = permissaoAdicionar;
		this.permissaoRemover = permissaoRemover;
		this.permissaoAlterar = permissaoAlterar;
		this.permissaoVisualizar = permissaoVisualizar;
		this.permissaoCriarCartao = permissaoCriarCartao;
		this.cartoes = new ArrayList<Cartao>();
		this.status = status;
		this.dataCriacao = dataCriacao;
	}

	public Grupo(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status,
			GregorianCalendar dataCriacao, boolean isPrivate) {
		ArrayList<Usuario> permissaoAdicionar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoRemover = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoAlterar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoVisualizar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoCriarCartao = new ArrayList<Usuario>();

		if (isPrivate) {
			permissaoAdicionar.add(dono);
			permissaoRemover.add(dono);
			permissaoAlterar.add(dono);
			permissaoVisualizar.add(dono);
			permissaoCriarCartao.add(dono);

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
				permissaoCriarCartao.add(dono);
			}
		}

		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.permissaoAdicionar = permissaoAdicionar;
		this.permissaoRemover = permissaoRemover;
		this.permissaoAlterar = permissaoAlterar;
		this.permissaoVisualizar = permissaoVisualizar;
		this.permissaoCriarCartao = permissaoCriarCartao;
		this.cartoes = new ArrayList<Cartao>();
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
			case CRIAR_CARTAO:
				return this.permissaoCriarCartao;
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
			case CRIAR_CARTAO:
				this.permissaoCriarCartao = usuarios;
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
		for (int i = 0; i < index.size(); i++) {
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

	public void adicionaMembro(Usuario dono, Usuario novoMembro, Permissoes permissao) {
		if (getStatus()) {
			for (Permissoes permissoes : Permissoes.values()) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissoes);
				usuarios.add(novoMembro);
				setUsuariosPermissoes(usuarios, permissoes);
			}
		}
	}

	public void removeMembro(Usuario dono, Usuario membro) {
		if (getStatus()) {
			for (Permissoes permissao : Permissoes.values()) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				int index = usuarios.indexOf(membro);
				if (index >= 0) {
					usuarios.remove(index);
					setUsuariosPermissoes(usuarios, permissao);
				}
			}
		}
	}

	public void adicionarPermissao(Usuario dono, Usuario membro, ArrayList<Permissoes> permissoesUsuario) {
		if (getStatus()) {
			for (Permissoes permissao : permissoesUsuario) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				usuarios.add(membro);
				setUsuariosPermissoes(usuarios, permissao);
			}
		}
	}

	public void removerPermissao(Usuario dono, Usuario membro, ArrayList<Permissoes> permissoesUsuario) {
		if (getStatus()) {
			for (Permissoes permissao : permissoesUsuario) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				int index = usuarios.indexOf(membro);
				if (index >= 0) {
					usuarios.remove(index);
					setUsuariosPermissoes(usuarios, permissao);
				}
			}
		}
	}

	public void adicionarCartao(Usuario usuario, Cartao cartao) {
		if (getStatus()) {
			ArrayList<Usuario> usuariosPermitidos = getUsuariosPermissoes(Permissoes.CRIAR_CARTAO);
			int index = usuariosPermitidos.indexOf(usuario);
			if (index >= 0) {
				this.cartoes.add(cartao);
			} else {
				System.out.print("Usuario nao possui a permissao de criar cartao!!");
			}
		}
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
