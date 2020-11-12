import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Admin extends Usuario {

    public Admin(int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao, boolean status) {
		super(id, login, email, senha, descricao, dataAtivacao, status);
	}
    
    public void desabilitarGrupo(Grupo grupo) {
        grupo.setStatus(this, false);
        System.out.print("Grupo desabilitado!! \n");
    }
}
