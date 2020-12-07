package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import Modelo.Veiculo;


public class VeiculoDao {
	
	public void adiciona(Veiculo v) throws ClassNotFoundException, SQLException {
		String sql = 
			"INSERT INTO veiculo (vei_Modelo, vei_Placa, vei_Marca)" + 
			"VALUES (?, ?, ?)";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, v.getModelo());
		comandoSql.setString(2,  v.getPlaca());
		comandoSql.setString(3, v.getMarca());
		
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Veiculo p) throws ClassNotFoundException, SQLException {
		String sql = 
			"UPDATE Veiculo SET vei_Modelo=?, vei_Marca=?,vei_Placa=? WHERE idVeiculo=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, p.getModelo());
		comandoSql.setString(2,  p.getPlaca());
		comandoSql.setString(3, p.getMarca());
		comandoSql.setInt(4, p.getId());
		
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = 
			"DELETE FROM Veiculo WHERE idVeiculo=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public List<Veiculo>listaTodos() throws ClassNotFoundException, SQLException{
		List<Veiculo> lista = new LinkedList <Veiculo> ();
		
		String sql = "SELECT * FROM Veiculo";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Veiculo p = new Veiculo();
			p.setId(rs.getInt("idVeiculo"));
			p.setPlaca(rs.getString("vei_Placa"));
			p.setModelo(rs.getString("vei_Modelo"));
			p.setMarca(rs.getString("vei_Marca"));
			
			
			lista.add(p);
		}
		
		return lista;
	}
	

	
	public Veiculo listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM Veiculo WHERE idVeiculo=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Veiculo p = null;
		
		if (rs.next()) {
			p = new Veiculo();
			p.setId(rs.getInt("idVeiculo"));
			p.setPlaca(rs.getString("vei_Placa"));
			p.setModelo(rs.getString("vei_Modelo"));
			p.setMarca(rs.getString("vei_Marca"));
		}
		
		return p;
	}
}
