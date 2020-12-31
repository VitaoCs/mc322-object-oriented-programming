import java.util.GregorianCalendar;

public class Perfil {
	private Sexo sexo;
	private GregorianCalendar dataNascimento;
	private String cidade;
	private Estado estado;
	private String telefone;
	private String descricao;
	private String foto;

	public Perfil(Sexo sexo, GregorianCalendar dataNascimento, String cidade, Estado estado, String telefone,
			String descricao, String foto) {
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.descricao = descricao;
		this.foto = foto;
	}

	public Perfil() {
		this.sexo = Sexo.HOMEM;
		this.dataNascimento = new GregorianCalendar();
		this.cidade = "Catanduva";
		this.estado = Estado.AMAZONAS;
		this.telefone = "99999999";
		this.descricao = "perfil_default";
		this.foto = "foto_default";
	}

	public String getSexo() {
		return sexo.getAtributos();
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public GregorianCalendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado.getAtributos();
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		String out = " sexo: " + getSexo() + "\n";
		out = out + " data de nascimento: " + getDataNascimento().getTime() + "\n";
		out = out + " cidade: " + getCidade() + "\n";
		out = out + " estado: " + getEstado() + "\n";
		out = out + " telefone: " + getTelefone() + "\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " foto: " + getFoto() + "\n";
		return out;
	}
}
