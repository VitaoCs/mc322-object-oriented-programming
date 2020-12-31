import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Collections;

public abstract class Usuario {
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private GregorianCalendar dataAtivacao;
	private boolean status;
	private ArrayList<Grupo> grupos;
	private Perfil perfil;

	public Usuario(int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao,
			boolean status, Perfil perfil) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.dataAtivacao = dataAtivacao;
		this.status = status;
		this.grupos = new ArrayList<Grupo>();
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String nome) {
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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumeroGrupos() {
		return this.grupos.size();
	}

	public ArrayList<Grupo> getTodosGrupos() {
		return this.grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo getGrupo(Grupo grupo) {
		int index = this.grupos.indexOf(grupo);
		return this.grupos.get(index);
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	private Grupo getGrupoById(int id) {
		for (Grupo grupo : grupos) {
			if (grupo.getId() == id) {
				return grupo;
			}
		}

		return null;
	}

	public abstract Grupo criarGrupo(boolean visibilidade, int id, String nome, String descricao, boolean status,
			GregorianCalendar dataCriacao);

	public void removeGrupo(Usuario user, Grupo group) {
		if (this.grupos.size() > 0 && user instanceof Admin) {
			int index = this.grupos.indexOf(group);
			this.grupos.remove(index);
		} else {
			System.out.print("Erro ao remover grupo. Somente usuários Admin podem criar ou remover grupos");
		}
	}

	public void adicionarGrupo(Grupo grupo) {
		this.grupos.add(grupo);
	}

	public void criarCartao(int id, int visibilidade, String nome, boolean invitationOnly, String assunto,
			Usuario responsavel, int prioridade) {
		boolean isGrupoMembro = false;
		Grupo grupo = getGrupoById(id);

		ArrayList<Usuario> membros = grupo.getMembros();
		for (Usuario membro : membros) {
			if (membro == responsavel)
				isGrupoMembro = true;
		}
		if (grupo != null && isGrupoMembro) {
			grupo.adicionarCartao(this,
					new Cartao(id, visibilidade, nome, this, invitationOnly, assunto, responsavel, prioridade));
		} else {
			System.out.print("Id de grupo nao existente");
		}
	}

	public void executarTarefaDeMaiorPrioridade() {
		ArrayList<Cartao> cartoesTO_DO = new ArrayList<Cartao>();

		for (Grupo grupo : this.grupos) {
			ArrayList<Cartao> cartoes = grupo.getCartoesAFazer();

			for (Cartao cartao : cartoes) {
				if (cartao.getResponsavel() == this) cartoesTO_DO.add(cartao);
			}
		}

		if (cartoesTO_DO.size() > 0) {
			Collections.sort(cartoesTO_DO);
		}

		Cartao cartaoPriorizado = cartoesTO_DO.get(0);
		cartaoPriorizado.setLabel(Labels.DONE);
		Grupo grupoCartao = this.getGrupoById(cartaoPriorizado.getId());
		grupoCartao.mudarStatusDONE(cartaoPriorizado);
	}

	@Override
	public String toString() {
		String out = getLogin() + " (id: " + getId() + " )\n";
		out = out + " email: " + getEmail() + "\n";
		out = out + " senha: " + getSenha() + "\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " data ativacao: " + getDataAtivacao().getTime() + "\n";
		out = out + " status: " + getStatus() + "\n";

		int numberGroups = getNumeroGrupos();
		if (numberGroups > 0) {
			out = out + " membro de " + numberGroups;
			out = numberGroups > 1 ? out + " grupos\n" : out + " grupo\n";
		}
		return out;
	}
}
