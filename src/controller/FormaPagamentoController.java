package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.FormaPagamentoDao;
import Modelo.FormaPagamento;

@ManagedBean(name= "FormaPagamentoController")
@ViewScoped
public class FormaPagamentoController {

	private FormaPagamento formaPagamento = new FormaPagamento();

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void gravar() {
		FormaPagamentoDao dao = new FormaPagamentoDao();

		try {
			if (formaPagamento.getId() == null) {
				dao.adiciona(formaPagamento);
			} else {
				dao.atualiza(formaPagamento);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		formaPagamento = new FormaPagamento();

	}

	public List<FormaPagamento> getListaFormaPagamento() {
		List<FormaPagamento> lista = null;

		try {
			lista = new FormaPagamentoDao().listaTodos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void remover(FormaPagamento f) {
		try {
			new FormaPagamentoDao().remove(f.getId());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void carregar(FormaPagamento f) {
		formaPagamento = f;
	}

}
