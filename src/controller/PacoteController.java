package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.PacoteDao;
import Modelo.Pacote;

@ManagedBean
@ViewScoped
public class PacoteController {

	private Pacote pacote = new Pacote();

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public void gravar() {

		PacoteDao dao = new PacoteDao();

		try {

			if (pacote.getId() == null) {
				dao.adiciona(pacote);

			} else {
				dao.atualiza(pacote);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pacote = new Pacote();

	}

	public List<Pacote> getListaPacote() {
		List<Pacote> lista = null;

		try {
			lista = new PacoteDao().listaTodos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void remover(Pacote p) {
		try {
			new PacoteDao().remove(p.getId());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void carregar(Pacote p) {
		pacote = p;
	}

}
