import java.util.GregorianCalendar;

public class Mensagem {

	//atributos da classe
	protected String texto;
	protected Usuario usuario;
	protected GregorianCalendar data;


	//construtores
	public Mensagem(String texto, Usuario usuario, GregorianCalendar data) {	
		this.texto = texto; 
		this.usuario = usuario;
		this.data = data;
	}

	public Mensagem(String texto, Usuario usuario) {	
		this.texto = texto; 
		this.usuario = usuario;
		this.data = new GregorianCalendar;
	}


	//métodos de get e set		
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
		
				
	public Usuario getUsuario() {
		return this.usuario;
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


	//método tostring
	@Override
	public String toString(){
		String out = "Usuario: " + getUsuario().login + "\n";
		out = out + " Mensagem: " + getTexto() + "\n";
		out = out + " Enviado: " + getData().getTime() + "\n";
		return out;
	}			
		
}
