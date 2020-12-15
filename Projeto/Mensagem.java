import java.util.GregorianCalendar;

public class Mensagem {

	// atributos da classe
	protected String texto;
	protected Usuario usuario;
	protected Boolean status;
	protected GregorianCalendar data;

	// construtores
	public Mensagem(String texto, Usuario usuario, GregorianCalendar data) {
		this.texto = texto;
		this.usuario = usuario;
		this.status = true;
		this.data = data;
	}

	public Mensagem(String texto, Usuario usuario) {
		this.texto = texto;
		this.usuario = usuario;
		this.status = true;
		this.data = new GregorianCalendar();
	}

	// métodos de get e set
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String getLoginUsuario() {
		return this.usuario.getLogin();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GregorianCalendar getData() {
		return this.data;
	}

	public void setDataCriacao(GregorianCalendar data) {
		this.data = data;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Usuario user, Boolean status) {
		boolean isAdmin = user instanceof Admin;
		if (user == this.usuario || isAdmin) {
			this.status = status;
		}
	}

	@Override
	public String toString() {
		String out = "Usuario: " + getLoginUsuario() + "\n";
		out = out + " Mensagem: " + getTexto() + "\n";
		out = out + " Enviado: " + getData().getTime() + "\n";

		return out;
	}

}
