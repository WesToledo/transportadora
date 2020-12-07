package Modelo;

public class FormaPagamento {

	private Integer id;

	private String nome;
	private double onus;
	private int diasCompensacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getOnus() {
		return onus;
	}

	public void setOnus(double onus) {
		this.onus = onus;
	}

	public int getDiasCompensacao() {
		return diasCompensacao;
	}

	public void setDiasCompensacao(int diasCompensacao) {
		this.diasCompensacao = diasCompensacao;
	}

}
