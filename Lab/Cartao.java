
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cartao {
    static private int numeroCartoes = 0;
    private int id;
    private int visibilidade;
    private String nome;
    private Usuario dono;
    private boolean invitationOnly;
    private GregorianCalendar dataCriacao;

    public Cartao(int numeroCartoes, int id, int visibilidade, String nome, Usuario dono, boolean invitationOnly, GregorianCalendar dataCriacao) {
		this.numeroCartoes = ++numeroCartoes;
        this.id = this.numeroCartoes;
        this.visibilidade = visibilidade;
        this.nome = nome;
        this.dono = dono;
        this.invitationOnly = invitationOnly;
        this.dataCriacao = dataCriacao;
    }

    public Cartao(Scanner scanner) {
        System.out.println("Preencha os dados a seguir para a criacao do cartao");
		System.out.print("Visibilidade do cartao: ");
        int visibilidadeCartao = scanner.nextInt();

        System.out.print("Nome do cartao: ");
        String nomeCartao = scanner.next();   

        System.out.print("Cartao exclusivo por convite? [y/n]: ");
        String invitationInput = scanner.next();
		boolean invitationOnlyCartao = invitationInput == "y";

		System.out.print("Data de criação do cartao [dd/mm/aaaa]: ");
        String data = scanner.next();

        System.out.println("Cartao criado!");
    
        int diaData = Integer.parseInt(data.substring(0, 2));
        int mesData = Integer.parseInt(data.substring(3, 5)) - 1;
        int anoData = Integer.parseInt(data.substring(6));

        this.numeroCartoes = ++numeroCartoes;
        this.id = this.numeroCartoes;
        this.visibilidade = visibilidadeCartao;
        this.nome = nomeCartao;
        this.dono = this.createDefaultDono();
        this.invitationOnly = invitationOnlyCartao;
        this.dataCriacao = new GregorianCalendar(anoData, mesData, diaData);
    }
    
    public Cartao() {
		this.numeroCartoes = ++numeroCartoes;
        this.id = this.numeroCartoes;
        this.visibilidade = 0000;
        this.nome = "nome_cartao_default";
        this.dono = this.createDefaultDono();
        this.invitationOnly = true;
        this.dataCriacao = new GregorianCalendar();
	}

	public static int getNumeroCartoes() {
		return numeroCartoes;
	}

	public void setNumeroCartoes(int numeroCartoes) {
		this.numeroCartoes = numeroCartoes;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVisibilidade() {
		return this.visibilidade;
	}

	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getDono() {
		return this.dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
    }
    
    public String getDonoLogin() {
        return dono.getLogin();
    }

	public boolean getInvitationOnly() {
		return this.invitationOnly;
	}

	public void setInvitationOnly(boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}

	public GregorianCalendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
    }
    
    private Usuario createDefaultDono() {
        return new Usuario(0000, "login_default", "email_default", "senha_default", new GregorianCalendar(), true);
    }

    @Override
    public String toString(){
		String out = "ID Cartao: " + getId() + "\n";
		out = out + " numero de cartoes: " + getNumeroCartoes() + "\n";
        out = out + " visibilidade: " + getVisibilidade() + "\n";
        out = out + " nome: " + getNome() + "\n";
        out = out + " dono: " + getDonoLogin() + "\n";
        out = out + " exclusivo por convite: " + getInvitationOnly() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
		return out ;
	}
}
