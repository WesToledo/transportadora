package Modelo;

public class Cliente {
	private Integer id;
	private String nome;
	private String endereco;
	private String cpf;
	

	public Cliente() {
	}
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String d) {
		this.cpf = d;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + "]";
	}

		

}
