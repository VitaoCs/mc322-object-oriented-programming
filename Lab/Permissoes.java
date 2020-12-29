public enum Permissoes {
	ADICIONAR_MEMBROS(01, "Permite a um usuário adicionar novos membros ao grupo."),
	REMOVER_MEMBROS(02, "Permite a um usuário remover novos membros ao grupo."),
	ALTERAR_PERMISSAO(03, "Permite a um usuário alterar a permissão de outros usuários no grupo."),
	VISUALIZAR_INFO(04,
			"Permite a um usuário visualizar as seguintes informações do grupo: Nome, Dono, Status e Membros Pertencentes."),
	CRIAR_CARTAO(05, "Apenas usuários com esta permissão poderão criar cartões.");

	private final int id;
	private final String descricao;

	Permissoes(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getAtributos() {
		String out = "Permissao: id " + id + "\n";
		out = out + descricao + "\n";
		return out;
	}
}
