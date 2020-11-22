
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPrivado extends Grupo {
	
	public GrupoPrivado(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> permissaoAdicionar, ArrayList<Usuario> permissaoRemover, ArrayList<Usuario> permissaoAlterar, ArrayList<Usuario> permissaoVisualizar, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, permissaoAdicionar, permissaoRemover, permissaoAlterar, permissaoVisualizar, status, dataCriacao);
	}

	public GrupoPrivado(int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, status, dataCriacao);
	}

	public GrupoPrivado(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, membros, status, dataCriacao, true);
	}

	public void adicionaMembro(Usuario dono, Usuario novoMembro, Permissoes permissao) {
		boolean isDono = dono == getDono();
		if (getStatus() && isDono) {
			ArrayList<Usuario> membrosAtuais = getPermissaoVisualizar();
			membrosAtuais.add(novoMembro);
			setPermissaoVisualizar(membrosAtuais);
		} else {
			System.out.print("Grupo desativado ou usuário não é o dono!! \n");
		}
	}

	public void removeMembro(Usuario dono, Usuario membro) {
		boolean isDono = dono == getDono();
		if (getStatus() && isDono) {
			ArrayList<Usuario> membrosAtuais = getPermissaoVisualizar();
			int index = membrosAtuais.indexOf(membro);
			if (index >= 0) {
				membrosAtuais.remove(index);
				setPermissaoVisualizar(membrosAtuais);
			}
		} else {
			System.out.print("Grupo desativado ou usuário não é o dono!! \n");
		}
	}

	public void adicionarPermissao(Usuario dono, Usuario membro, ArrayList<Permissoes> permissoesUsuario) {
		boolean isDono = dono == getDono();
		if (getStatus() && isDono) {
			for (Permissoes permissao : permissoesUsuario) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				usuarios.add(membro);
				setUsuariosPermissoes(usuarios, permissao);
			}
		}
	}

	public void removerPermissao(Usuario dono, Usuario membro, ArrayList<Permissoes> permissoesUsuario) {
		boolean isDono = dono == getDono();
		if (getStatus() && isDono) {
			for (Permissoes permissao : permissoesUsuario) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				int index = usuarios.indexOf(membro);
				if (index >= 0) {
					usuarios.remove(index);
					setUsuariosPermissoes(usuarios, permissao);
				}
			}
		}
	}

    @Override
    public String toString(){
		String out = "GrupoPrivado: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		out = out + usuariosToString();
		return out ;
	}
}
