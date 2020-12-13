public enum Estado {
    ACRE ("AC", "Acre"),
    ALAGOAS ("AL", "Alagoas"),
    AMAPA ("AP", "Amapa"),
    AMAZONAS ("AM", "Amazonas"),
    BAHIA ("BA", "Bahia"),
    CEARA ("CE", "Ceara"),
    DISTRITO_FEDERAL ("DF", "Distrito Federal"),
    ESPIRITO_SANTO ("ES", "Espirito Santo"),
    GOIAS ("GO", "Goias"),
    MARANHAO ("MA", "Maranhao"),
    MATO_GROSSO ("MT", "Mato Grosso"),
    MATO_GROSSO_SUL ("MS", "Mato Grosso do Sul"),
    MINAS_GERAIS ("MG", "Minas Gerais"),
    PARA ("PR", "Para"),
    PARAIBA ("PB", "Paraiba"),
    PARANA ("PR", "Parana"),
    PERNAMBUCO ("PE", "Pernambuco"),
    PIAUI ("PI", "Piaui"),
    RIO ("RJ", "Rio de Janeiro"),
    RIO_NORTE ("RN", "Rio Grande do Norte"),
    RIO_SUL ("RS", "Rio Grande do Sul"),
    RONDONIA ("RO", "Rondonia"),
    RORAIMA ("RR", "Roraima"),
    SANTA_CATARINA ("SC", "Santa Catarina"),
    SAO_PAULO ("SP", "Sao Paulo"),
    SERGIPE ("SE", "Sergipe"),
    TOCANTINS ("TO", "Tocantins");

    private final String sigla;
    private final String descricao;

    Estado(String sigla, String descricao) {
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
