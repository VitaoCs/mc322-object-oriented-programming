import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Admin extends Usuario {

  public Admin(String login, String email, String senha, GregorianCalendar dataAtivacao, boolean status) {
    super(login, email, senha, dataAtivacao, status);
  }

  public Admin(Scanner scanner) {
    super(scanner);
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
