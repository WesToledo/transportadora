package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.DestinoDao;
import Modelo.Destino;

@ManagedBean
@ViewScoped
public class DestinoController {

	private Destino Destino = new Destino();

	public void setDestino(Destino Destino) {
		this.Destino = Destino;
	}

	public void gravar() {
		DestinoDao dao = new DestinoDao();

		try {
			if (Destino.getId() == null) {
				dao.adiciona(Destino);
			} else {
				dao.atualiza(Destino);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Destino = new Destino();

	}

	public List<Destino> getListaDestino() {
		List<Destino> lista = null;

		try {
			lista = new DestinoDao().listaTodos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Destino getDestino() {
		return Destino;
	}

	public void remover(Destino d) {
		try {
			new DestinoDao().remove(d.getId());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void carregar(Destino d) {
		Destino = d;
	}

}
