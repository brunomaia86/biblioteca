package bibliotecafa7.modelo;

public enum Categoria {

	especial("Especial", 2.0), 
	normal("Normal", 1.0), 
	promocao("Promoção", 0.5);

	private Categoria(String nome, Double preco) {
		this.setNome(nome);
		this.preco = preco;
	}

	private String nome;
	private Double preco;

	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
