
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Grupo {
    private int id;
    private String nome;
    private String descricao;
	private final Usuario dono;
	private ArrayList<Usuario> membros;
    private boolean status;
	private GregorianCalendar dataCriacao;
	
	public Grupo(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status, GregorianCalendar dataCriacao) {
		this.id = id;
		this.nome = nome; 
		this.descricao = descricao;
		this.dono = dono;
		this.membros = membros;
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

	public ArrayList<Usuario> getMembros() {
		return this.membros;
	}

	public void setMembros(ArrayList<Usuario> membros) {
		this.membros = membros;
	}

	public int getNumeroMembros() {
		return this.membros.size();
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public GregorianCalendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

    @Override
    public String toString(){
		String out = "Grupo: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";

		int numberMembers = getNumeroMembros();
		if (numberMembers > 0) {
			out = out + " membros: " + numberMembers;
			out = numberMembers > 1 ? out + " , sendo eles: \n" : out + " , sendo ele: \n";
			for (Usuario user : this.membros) {
				out = out + user.toString();
			}
		}
		return out ;
	}
}
