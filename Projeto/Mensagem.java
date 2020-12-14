import java.util.GregorianCalendar;

public class Mensagem {

	//atributos da classe
	protected String texto;
	protected Usuario usuario;
	protected GregorianCalendar data;


	//construtor
	public Mensagem(String texto, Usuario usuario, GregorianCalendar data) {	
		this.texto = texto; 
		this.usuario = usuario;
		this.data = data;
	}


	//métodos de get e set		
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
		
				
	public String getUsuario() {
		return this.usuario.login;
	}

	public void setUsuario(String login) {
		this.usuario.login = login;
	}
		
		
	public GregorianCalendar getData() {
		return this.data;
	}

	public void setDataCriacao(GregorianCalendar data) {
		this.data = data;
	}


	//método tostring
	@Override
	public String toString(){
		String out = "Usuario: " + getUsuario() + "\n";
		out = out + " Mensagem: " + getTexto() + "\n";
		out = out + " Enviado: " + getData().getTime() + "\n";
		return out;
	}			
		
}
