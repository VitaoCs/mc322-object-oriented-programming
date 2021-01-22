import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPrivado extends Grupo implements TextoPorExtenso{

	public GrupoPrivado(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status,
			GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, membros, status, dataCriacao);
	}

	public GrupoPrivado(Scanner scanner, Usuario dono) {
		super(scanner, dono, true);
	}
	
	/*Apenas o dono ou o admin podem remover membro do Grupo Privado*/
	public void removerUsuario(Usuario user, Usuario removeUser) {
		boolean isAdmin = user instanceof Admin;
		if (user == this.dono || isAdmin) {
			int index = this.usuarios.indexOf(removeUser);
			this.usuarios.remove(index);
		}
	}

	@Override
	public String textoExtenso() {
		String out = "GrupoPrivado: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		out = out + usuariosToString();
		return out;
	}
}
