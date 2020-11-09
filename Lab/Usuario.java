import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario {
    private int id;
    private String login;
    private String email;
	private String senha;
	private String descricao;
    private GregorianCalendar dataAtivacao;
	private boolean status;
	private ArrayList<Grupo> grupos;

    public Usuario(int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao, boolean status) {
		this.id = id;
		this.login = login; 
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.dataAtivacao = dataAtivacao;
		this.status = status;
		this.grupos = new ArrayList<Grupo>();
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

	public Grupo getGrupo(Grupo grupo) {
		int index = this.grupos.indexOf(grupo);
		return this.grupos.get(index);
	}

	public void criarGrupo(boolean isPrivate, int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		ArrayList<Usuario> membros = new ArrayList<Usuario>();
		membros.add(dono);

		if (isPrivate) {
			this.grupos.add(new GrupoPrivado(id, nome, descricao, dono, membros, status, dataCriacao));
		} else {
			this.grupos.add(new GrupoPublico(id, nome, descricao, dono, membros, status, dataCriacao));
		}
	}

	public void removerGrupo(Grupo group) {
		if (this.grupos.size() > 0) {
			int index = this.grupos.indexOf(group);
			this.grupos.remove(index);
		}
	}

    @Override
    public String toString(){
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
		return out ;
	}
}
