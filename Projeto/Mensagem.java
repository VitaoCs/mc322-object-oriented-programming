import java.io.Serializable;
import java.util.GregorianCalendar;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mensagem implements Serializable {

	// atributos da classe
	private static final long serialVersionUID = 302L;
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

	public Mensagem(String texto, Usuario usuario, Grupo grupo) {
		this.texto = texto;
		this.usuario = usuario;
		this.status = true;
		this.data = new GregorianCalendar();

		addMensagemToDataBase(this, grupo.getId());
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

	private void addMensagemToDataBase(Mensagem msg, int grupoId) {
		String msgRepo = "dataBase/grupos/" + grupoId;
		String msgPath = msgRepo + "/mensagems.dat";
		File file = new File(msgRepo);
		if (!file.exists()) {
			if(file.mkdirs()) {
				writeMessageToDataBase(msg, msgPath);
			}
		} else {
			writeMessageToDataBase(msg, msgPath);
		}
	}

	private void writeMessageToDataBase(Mensagem msg, String msgPath) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(msgPath));
			
			output.writeObject(msg);
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
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
