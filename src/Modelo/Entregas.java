package Modelo;

import java.util.ArrayList;

public class Entregas {

	private Integer id;
	private Cliente cliente;
	private Destino destino;
	private ArrayList<Pacote> pacotes;
	private double total;
	private FormaPagamento formaPagamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public ArrayList<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(ArrayList<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public void addPacote(Pacote pacote) {
		this.pacotes.add(pacote);
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
