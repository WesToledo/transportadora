package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.VeiculoDao;
import Modelo.Veiculo;

@ManagedBean
@ViewScoped
public class VeiculoController {
	private Veiculo veiculo = new Veiculo();
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void gravar() {
				
		VeiculoDao dao = new VeiculoDao();
		
		try {
			
			
			if(veiculo.getId() == null) {
			dao.adiciona(veiculo);
			
			} else {
				dao.atualiza(veiculo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		veiculo = new  Veiculo();
	
		
	}
	
	public List<Veiculo> getListaVeiculo()
	{
		List<Veiculo> lista = null;
		
		try {
			lista = new VeiculoDao().listaTodos();
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void remover(Veiculo p) {
		try {
			new VeiculoDao().remove(p.getId());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void carregar(Veiculo p) {
		veiculo = p;
	}
		
				
	
	
}
