import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Admin extends Usuario {

    public Admin(int id, String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status, Grupo grupos) {
		super(login, email, senha, dataAtivacao, status, grupos);
	}
    
    public void deletarGrupo(Grupo grupo) {
    	grupo.setStatus(this, false);
    	
    }
    
    public void deletarUsuario(Usuario usuario) {
    	usuario.setStatus(this, false);
    }
    
    public void deletarMensagem(Mensagem mensagem) {
    	mensagem.setStatus(this, false);
    }
}