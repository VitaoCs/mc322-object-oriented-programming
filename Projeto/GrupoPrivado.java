import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPrivado extends Grupo {

	public GrupoPrivado(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status,
			GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, membros, status, dataCriacao);
	}

	public GrupoPrivado(Scanner scanner, Usuario dono) {
		super(scanner, dono, true);
	}

	@Override
	public String toString() {
		String out = "GrupoPrivado: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		out = out + usuariosToString();
		return out;
	}
}
