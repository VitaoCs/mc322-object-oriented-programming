public enum Labels {
    TO_DO ("TO DO", "#fc0303"),
    DOING ("DOING", "#03fc1c"),
    DONE ("DONE", "#fcb103");

    private final String rotulo;
    private final String cor;

    Labels(String rotulo, String descricao) {
        this.rotulo = rotulo;
        this.cor = cor;
    }

    public String getAtributos() {
		return rotulo + ", cor: " + cor;
	}
}
