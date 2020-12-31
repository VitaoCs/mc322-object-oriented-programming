
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cartao implements Comparable<Cartao> {
	static private int numeroCartoes = 0;
	private int id;
	private int visibilidade;
	private String nome;
	private Usuario dono;
	private boolean invitationOnly;
	private GregorianCalendar dataCriacao;
	private Labels label;
	private String assunto;
	private Usuario responsavel;
	private int prioridade;

	public Cartao(int id, int visibilidade, String nome, Usuario dono, boolean invitationOnly,
			GregorianCalendar dataCriacao, Labels label, String assunto, Usuario responsavel, int prioridade) {
		this.numeroCartoes = ++numeroCartoes;
		this.id = id;
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.dono = dono;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
		this.label = label;
		this.assunto = assunto;
		this.responsavel = responsavel;
		this.prioridade = prioridade;
	}

	public Cartao(int id, int visibilidade, String nome, Usuario dono, boolean invitationOnly, String assunto, Usuario responsavel, int prioridade) {
		this.numeroCartoes = ++numeroCartoes;
		this.id = id;
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.dono = dono;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = new GregorianCalendar();
		this.label = Labels.TO_DO;
		this.assunto = assunto;
		this.responsavel = responsavel;
		this.prioridade = prioridade;
	}

	public static int getNumeroCartoes() {
		return numeroCartoes;
	}

	public void setNumeroCartoes(int numeroCartoes) {
		this.numeroCartoes = numeroCartoes;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVisibilidade() {
		return this.visibilidade;
	}

	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getDono() {
		return this.dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public String getDonoLogin() {
		return dono.getLogin();
	}

	public String getResponsavelLogin() {
		return responsavel.getLogin();
	}

	public boolean getInvitationOnly() {
		return this.invitationOnly;
	}

	public void setInvitationOnly(boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}

	public GregorianCalendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Labels getLabel() {
		return this.label;
	}

	public void setLabel(Labels label) {
		this.label = label;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Usuario getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public int getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	private Usuario createDefaultDono() {
		return new UsuarioComum(0000, "login_default", "email_default", "senha_default", "descricao_default",
				new GregorianCalendar(), true, new Perfil());
	}

	public int compareTo(Cartao other) {
		int thisPrioridade = this.prioridade;
		int otherPrioridade = other.getPrioridade();

		// menor o valor, mais prioritário
		if (thisPrioridade > otherPrioridade) {
			return 1;
		} else if (thisPrioridade < otherPrioridade) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		String out = "ID Cartao: " + getId() + "\n";
		out = out + " label: " + getLabel().getAtributos() + "\n";
		out = out + " nome: " + getNome() + "\n";
		out = out + " assunto: " + getAssunto() + "\n";
		out = out + " responsavel: " + getResponsavelLogin() + "\n";
		out = out + " prioridade: " + getPrioridade() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " exclusivo por convite: " + getInvitationOnly() + "\n";
		out = out + " visibilidade: " + getVisibilidade() + "\n";
		out = out + " numero de cartoes: " + getNumeroCartoes() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		return out;
	}
}
