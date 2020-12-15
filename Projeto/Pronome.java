public enum Pronome {
	HOMEM ("H", "homem"),
	MULHER ("M", "mulher"),   
	NEUTRO ("N", "neutro"),
	OUTRO ("O", "outro");

	private final String sigla;
	private final String descricao;

	Pronome(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getSigla() {
		return sigla;
	}
}
