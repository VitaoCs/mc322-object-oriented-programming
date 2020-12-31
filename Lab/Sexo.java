public enum Sexo {
	HOMEM("H", "homem"), MULHER("M", "mulher");

	private final String sigla;
	private final String descricao;

	Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getAtributos() {
		return sigla + ", " + descricao;
	}
}
