package ceisaSystem;

public class Item {
	private String nome;
	private int id;
	private int estoque;
	private double valorInvestidoUnitario;
	private double precoVendaAtacado;
	private double precoVendaVarejo;
	
	public Item(String nome, int estoque, double valorInvestidoUnitario, double precoVendaAtacado,
			double precoVendaVarejo) {
		this.nome = nome;
		this.estoque = estoque;
		this.valorInvestidoUnitario = valorInvestidoUnitario;
		this.precoVendaAtacado = precoVendaAtacado;
		this.precoVendaVarejo = precoVendaVarejo;
	}
	
	public double valorEmEstoque() {
		return valorInvestidoUnitario * estoque;
	}
	
	public void adicionarAoEstoque(int valor) {
		estoque += valor;
	}
	public void removerDoEstoque(int valor) {
		estoque -= valor;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getValorInvestidoUnitario() {
		return valorInvestidoUnitario;
	}
	public void setValorInvestidoUnitario(double valorInvestidoUnitario) {
		this.valorInvestidoUnitario = valorInvestidoUnitario;
	}
	public double getPrecoVendaAtacado() {
		return precoVendaAtacado;
	}
	public void setPrecoVendaAtacado(double precoVendaAtacado) {
		this.precoVendaAtacado = precoVendaAtacado;
	}
	public double getPrecoVendaVarejo() {
		return precoVendaVarejo;
	}
	public void setPrecoVendaVarejo(double precoVendaVarejo) {
		this.precoVendaVarejo = precoVendaVarejo;
	}
	
}
