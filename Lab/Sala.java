
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sala {
    static private int numeroSalas = 0;
    private int id;
    private int capacidadeMaxima;
    private int numeroUsuarios;
    private String descricao;
    private Usuario dono;
    private boolean ingressoAutomatico;
    private GregorianCalendar dataCriacao;

    public Sala(int capacidadeMaxima, int numeroUsuarios, String descricao, Usuario dono, boolean ingressoAutomatico, GregorianCalendar dataCriacao) {
		this.numeroSalas = ++numeroSalas;
        this.id = this.numeroSalas;
        this.capacidadeMaxima = capacidadeMaxima;
        this.numeroUsuarios = numeroUsuarios;
        this.descricao = descricao;
        this.dono = dono;
        this.ingressoAutomatico = ingressoAutomatico;
        this.dataCriacao = dataCriacao;
    }
    
    public Sala(int capacidadeMaxima, int numeroUsuarios, String descricao, boolean ingressoAutomatico, GregorianCalendar dataCriacao) {
		this.numeroSalas = ++numeroSalas;
        this.id = this.numeroSalas;
        this.capacidadeMaxima = capacidadeMaxima;
        this.numeroUsuarios = numeroUsuarios;
        this.descricao = descricao;
        this.dono = this.createDefaultDono();
        this.ingressoAutomatico = ingressoAutomatico;
        this.dataCriacao = dataCriacao;
    }

    public Sala(Scanner scanner) {
        System.out.println("Preencha os dados a seguir para a criacao da sala");
		System.out.print("Capacidade maxima: ");
        int capacidadeMaxima = scanner.nextInt();

        System.out.print("Numero de usuarios: ");
        int numeroUsuarios = scanner.nextInt();   

        System.out.print("Descricao da sala: ");
        String descricao = scanner.next();

        System.out.print("Sala com ingresso automatico? [y/n]: ");
        String ingressoAutomaticoInput = scanner.next();
        boolean ingressoAutomatico = (ingressoAutomaticoInput == "y");

		System.out.print("Data de criação da sala [dd/mm/aaaa]: ");
        String data = scanner.next();

        System.out.println("Sala criada!");
    
        int diaData = Integer.parseInt(data.substring(0, 2));
        int mesData = Integer.parseInt(data.substring(3, 5)) - 1;
        int anoData = Integer.parseInt(data.substring(6));

		this.numeroSalas = ++numeroSalas;
        this.id = this.numeroSalas;
        this.capacidadeMaxima = capacidadeMaxima;
        this.numeroUsuarios = numeroUsuarios;
        this.descricao = descricao;
        this.dono = this.createDefaultDono();
        this.ingressoAutomatico = ingressoAutomatico;
        this.dataCriacao = new GregorianCalendar(anoData, mesData, diaData);
	}
    
    public Sala() {
		this.numeroSalas = ++numeroSalas;
        this.id = this.numeroSalas;
        this.capacidadeMaxima = 30;
        this.numeroUsuarios = 30;
        this.descricao = "Default description";
        this.dono = this.createDefaultDono();
        this.ingressoAutomatico = true;
        this.dataCriacao = new GregorianCalendar();
	}
    
    public static int getNumeroSalas() {
        return numeroSalas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getNumeroUsuarios() {
        return numeroUsuarios;
    }

    public void setNumeroUsuarios(int numeroUsuarios) {
        this.numeroUsuarios = numeroUsuarios;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getDono() {
		return dono;
	}
	
	public void setDono(Usuario dono) {
		this.dono = dono;
    }
    
    public String getDonoLogin() {
        return dono.getLogin();
    }

    private Usuario createDefaultDono() {
        return new UsuarioComum(0000, "login_default", "email_default", "senha_default", new GregorianCalendar(), true, new Perfil());
    }
	
    public boolean getIngressoAutomatico() {
        return ingressoAutomatico;
    }
    
    public void setIngressoAutomatico(boolean ingressoAutomatico) {
        this.ingressoAutomatico = ingressoAutomatico;
    }

	public GregorianCalendar getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
    }

    public boolean salaCheia() {
        return this.numeroUsuarios >= this.capacidadeMaxima;
    }

    public boolean salaVazia() {
        return this.numeroUsuarios <= 0;
    }
    
    public boolean adicionarUsuario(int numeroUsuarios) {
        int numeroUsuariosFuturo = this.numeroUsuarios + numeroUsuarios;
        if (!this.salaCheia() && numeroUsuariosFuturo <= this.capacidadeMaxima) {
            this.numeroUsuarios = numeroUsuariosFuturo;
            System.out.println(numeroUsuarios + "usuarios adicionados");
            return true;
        }

        System.out.println("Erro ao adicionar usuarios, capacidade maxima da sala atingida");
        return false;
    }
    
    public boolean adicionarUsuario() {
        if (!this.salaCheia()) {
            this.numeroUsuarios++;
            System.out.println("Usuario adicionado");
            return true;
        }

        System.out.println("Erro ao adicionar usuario, capacidade maxima da sala atingida");
        return false;
    }
    
    public boolean removerUsuario(int numeroUsuarios) {
        int numeroUsuariosFuturo = this.numeroUsuarios - numeroUsuarios;
        if (!this.salaVazia() && numeroUsuariosFuturo >= 0) {
            this.numeroUsuarios = numeroUsuariosFuturo;
            System.out.println(numeroUsuarios + "usuarios removidos");
            return true;
        }

        System.out.println("Sala nao possui " + numeroUsuarios + " usuarios para serem removidos");
        return false;
    }
    
    public boolean removerUsuario() {
        if (!this.salaVazia()) {
            this.numeroUsuarios--;
            System.out.println("Usuario removido");
            return true;
        }

        System.out.println("Sala nao possui usuario para ser removido");
        return false;
    }

    @Override
    public String toString(){
		String out = "ID Sala: " + getId() + "\n";
		out = out + " numero salas: " + getNumeroSalas() + "\n";
        out = out + " capacidade maxima: " + getCapacidadeMaxima() + "\n";
        out = out + " numero usuarios: " + getNumeroUsuarios() + "\n";
        out = out + " dono: " + getDonoLogin() + "\n";
        out = out + " ingresso automatico: " + getIngressoAutomatico() + "\n";
		out = out + " data criacao: " + getDataCriacao().getTime() + "\n";
        out = out + " descricao: " + getDescricao() + "\n";
		return out ;
	}
}
