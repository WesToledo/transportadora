package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.copy.ClienteDao;

import Modelo.Cliente;

@ManagedBean
@ViewScoped
public class ClienteController {
	private Cliente cliente = new Cliente();
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	public void gravar() {
				
		ClienteDao dao = new ClienteDao();
		
		try {
			
			
			if(cliente.getId() == null) {
			dao.adiciona(cliente);
			
			} else {
				dao.atualiza(cliente);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cliente = new  Cliente();
	
		
	}
	
	public List<Cliente> getListaCliente()
	{
		List<Cliente> lista = null;
		
		try {
			lista = new ClienteDao().listaTodos();
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void remover(Cliente p) {
		try {
			new ClienteDao().remove(p.getId());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void carregar(Cliente p) {
		cliente = p;
	}
		
				
	
	
}
