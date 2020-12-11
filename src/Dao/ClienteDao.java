package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import Modelo.Cliente;


public class ClienteDao {
	
	public void adiciona(Cliente p) throws ClassNotFoundException, SQLException {
		String sql = 
			"INSERT INTO Cliente (cli_Nome, cli_endereco, cli_Cpf)" + 
			"VALUES (?, ?, ?)";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, p.getNome());
		comandoSql.setString(2,  p.getEndereco());
		comandoSql.setString(3, p.getCpf());
		
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Cliente p) throws ClassNotFoundException, SQLException {
		String sql = 
			"UPDATE Cliente SET cli_Nome=?, cli_Cpf=?,cli_endereco=? WHERE idCliente=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, p.getNome());
		comandoSql.setString(3,  p.getEndereco());
		comandoSql.setString(2, p.getCpf());
		comandoSql.setInt(4, p.getId());
		
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = 
			"DELETE FROM Cliente WHERE idCliente=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public List<Cliente>listaTodos() throws ClassNotFoundException, SQLException{
		List<Cliente> lista = new LinkedList <Cliente> ();
		
		String sql = "SELECT * FROM Cliente";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Cliente p = new Cliente();
			p.setId(rs.getInt("idCliente"));
			p.setEndereco(rs.getString("cli_endereco"));
			p.setNome(rs.getString("cli_Nome"));
			p.setCpf(rs.getString("cli_Cpf"));
			
			
			lista.add(p);
		}
		
		return lista;
	}
	

	
	public Cliente listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM Cliente WHERE idCliente=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Cliente p = null;
		
		if (rs.next()) {
			p = new Cliente();
			p.setId(rs.getInt("idCliente"));
			p.setNome(rs.getString("cli_nome"));
			p.setEndereco(rs.getString("cli_endereco"));
			p.setCpf(rs.getString("cli_cpf"));
			
		}
		
		return p;
	}
}
