
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
	private ArrayList<Usuario> membros;
	private ArrayList<Cartao> cartoesAFazer;
	private ArrayList<Cartao> cartoesFeitos;
	private boolean status;
	private GregorianCalendar dataCriacao;

	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		ArrayList<Usuario> permissaoAdicionar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoRemover = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoAlterar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoVisualizar = new ArrayList<Usuario>();
		ArrayList<Usuario> permissaoCriarCartao = new ArrayList<Usuario>();


		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Usuario> admin = new ArrayList<Usuario>();
		
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
		this.membros = new ArrayList<Usuario>();
		this.cartoesAFazer = new ArrayList<Cartao>();
		this.cartoesFeitos = new ArrayList<Cartao>();
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

	public ArrayList<Usuario> getMembros() {
		return this.membros;
	}

	public void setMembros(ArrayList<Usuario> membros) {
		this.membros = membros;
	}

	public void adicionarMembro(Usuario membro) {
		this.membros.add(membro);
	}

	public void removerMembro(Usuario membro) {
		int index = this.membros.indexOf(membro);
		if (index >= 0) this.membros.remove(index);
	}

	public ArrayList<Cartao> getCartoesAFazer() {
		return this.cartoesAFazer;
	}

	public void setCartoesAFazer(ArrayList<Cartao> cartoesAFazer) {
		this.cartoesAFazer = cartoesAFazer;
	}

	public ArrayList<Cartao> getCartoesFeitos() {
		return this.cartoesFeitos;
	}

	public void setCartoesFeitos(ArrayList<Cartao> cartoesFeitos) {
		this.cartoesFeitos = cartoesFeitos;
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

	private void guardarCartao(Cartao cartao) {
		Labels label = cartao.getLabel();
		if (label == Labels.TO_DO) {
			this.cartoesAFazer.add(cartao);
		} else if (label == Labels.DONE) {
			this.cartoesFeitos.add(cartao);
		}
	}

	public void adicionarCartao(Usuario usuario, Cartao cartao) {
		if (getStatus()) {
			ArrayList<Usuario> usuariosPermitidos = getUsuariosPermissoes(Permissoes.CRIAR_CARTAO);
			int index = usuariosPermitidos.indexOf(usuario);
			if (index >= 0) {
				guardarCartao(cartao);
			} else {
				System.out.print("Usuario nao possui a permissao de criar cartao!!");
			}
		}
	}

	public void mudarStatusDONE(Cartao cartao) {
		int index = cartoesAFazer.indexOf(cartao);
		if (index >= 0) {
			cartoesAFazer.remove(index);
			cartoesFeitos.add(cartao);
		}
	}

	public String cartoesToString() {
		String out = "";
		if (cartoesAFazer.size() > 0) {
			out = out + "*****************************\n";
			out = out + " Cartoes TO_DO: \n";
			for (Cartao cartao : cartoesAFazer) {
				out = out + cartao.toString();
				out = out + "*****************************\n";
			}
		}
		
		if (cartoesFeitos.size() > 0) {
			out = out + "*****************************\n";
			out = out + " Cartoes DONE: \n";
			for (Cartao cartao : cartoesFeitos) {
				out = out + cartao.toString();
				out = out + "*****************************\n";
			}
		}
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
