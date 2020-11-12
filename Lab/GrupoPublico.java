
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPublico extends Grupo {
	
	public GrupoPublico(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, membros, status, dataCriacao);
	}

	public void adicionaMembro(Usuario novoMembro) {
		if (getStatus()) {
			ArrayList<Usuario> membrosAtuais = getMembros();
			membrosAtuais.add(novoMembro);
			setMembros(membrosAtuais);
		}
	}

	public void removeMembro(Usuario membro) {
		if (getStatus()) {
			ArrayList<Usuario> membrosAtuais = getMembros();
			int index = membrosAtuais.indexOf(membro);
			membrosAtuais.remove(index);
			setMembros(membrosAtuais);
		}
	}

    @Override
    public String toString(){
		String out = "GrupoPublico: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";

		int numberMembers = getNumeroMembros();
		if (numberMembers > 0) {
			out = out + " membros: " + numberMembers;
			out = numberMembers > 1 ? out + " , sendo eles: \n" : out + " , sendo ele: \n";
			out = out + "*****************************\n";
			for (Usuario user : getMembros()) {
				out = out + user.toString();
			}
			out = out + "*****************************\n";
		}
		return out ;
	}
}