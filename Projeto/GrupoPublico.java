import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPublico extends Grupo {
	
	public GrupoPublico(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> permissaoAdicionar, ArrayList<Usuario> permissaoRemover, ArrayList<Usuario> permissaoAlterar, ArrayList<Usuario> permissaoVisualizar, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, permissaoAdicionar, permissaoRemover, permissaoAlterar, permissaoVisualizar, status, dataCriacao);
	}

	public GrupoPublico(int id, String nome, String descricao, Usuario dono, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, status, dataCriacao);
	}

	public GrupoPublico(int id, String nome, String descricao, Usuario dono, ArrayList<Usuario> membros, boolean status, GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, membros, status, dataCriacao, false);
	}

	public GrupoPublico(Scanner scanner, Usuario dono) {
		super(scanner, dono, false);
	}

	public void adicionaMembro(Usuario dono, Usuario novoMembro, Permissoes permissao) {
		if (getStatus()) {
			for (Permissoes permissoes : Permissoes.values()) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissoes);
				usuarios.add(novoMembro);
				setUsuariosPermissoes(usuarios, permissoes);
			}
		}
	}

	public void removeMembro(Usuario dono, Usuario membro) {
		if (getStatus()) {
			for (Permissoes permissao : Permissoes.values()) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				int index = usuarios.indexOf(membro);
				if (index >= 0) {
					usuarios.remove(index);
					setUsuariosPermissoes(usuarios, permissao);
				}
			}
		}
	}

	public void adicionarPermissao(Usuario dono, Usuario membro, ArrayList<Permissoes> permissoesUsuario) {
		if (getStatus()) {
			for (Permissoes permissao : permissoesUsuario) {
				ArrayList<Usuario> usuarios = getUsuariosPermissoes(permissao);
				usuarios.add(membro);
				setUsuariosPermissoes(usuarios, permissao);
			}
		}
	}

	public void removerPermissao(Usuario dono, Usuario membro, ArrayList<Permissoes> permissoesUsuario) {
		if (getStatus()) {
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
		String out = "GrupoPublico: " + getNome() + " (id: " + getId() + " )\n";
		out = out + " descricao: " + getDescricao() + "\n";
		out = out + " dono: " + getDonoLogin() + "\n";
		out = out + " status: " + getStatus() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		out = out + usuariosToString();
		return out ;
	}
}
