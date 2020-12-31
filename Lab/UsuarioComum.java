import java.util.ArrayList;
import java.util.GregorianCalendar;

public class UsuarioComum extends Usuario {

	public UsuarioComum(int id, String login, String email, String senha, String descricao,
			GregorianCalendar dataAtivacao, boolean status, Perfil perfil) {
		super(id, login, email, senha, descricao, dataAtivacao, status, perfil);
	}

	@Override
	public Grupo criarGrupo(boolean visibilidade, int id, String nome, String descricao, boolean status,
			GregorianCalendar dataCriacao) {
		System.out.print("Usuario convidado nao pode criar grupo!!");
		return null;
	}

	@Override
	public String toString() {
		String out = getLogin() + " (id: " + getId() + " )\n";
		out = out + " email: " + getEmail() + "\n";
		out = out + " senha: " + getSenha() + "\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " data ativacao: " + getDataAtivacao().getTime() + "\n";
		out = out + " status: " + getStatus() + "\n";

		int numberGroups = getNumeroGrupos();
		if (numberGroups > 0) {
			out = out + " membro de " + numberGroups;
			out = numberGroups > 1 ? out + " grupos\n" : out + " grupo\n";
		}
		return out;
	}
}
