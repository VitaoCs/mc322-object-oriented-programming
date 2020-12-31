import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Admin extends Usuario {

    public Admin(int id, String login, String email, String senha, String descricao, GregorianCalendar dataAtivacao,
            boolean status, Perfil perfil) {
        super(id, login, email, senha, descricao, dataAtivacao, status, perfil);
    }

    public void desabilitarGrupo(Grupo grupo) {
        grupo.setStatus(this, false);
        System.out.print("Grupo desabilitado!! \n");
    }

    public Grupo criarGrupo(boolean visibilidade, int id, String nome, String descricao, boolean status,
            GregorianCalendar dataCriacao) {
        Grupo grupo;
        if (this instanceof Admin) {
            if (visibilidade) {
                grupo = new GrupoPublico(id, nome, descricao, this, status, dataCriacao);
            } else {
                grupo = new GrupoPrivado(id, nome, descricao, this, status, dataCriacao);
            }

            ArrayList<Grupo> grupos = this.getTodosGrupos();
            grupos.add(grupo);
            this.setGrupos(grupos);

            return grupo;
        } else {
            System.out.print("Somente usuários Admin podem criar ou remover grupos");
        }
        return null;
    }
}
