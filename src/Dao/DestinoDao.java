package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Modelo.Destino;

public class DestinoDao {

	public void adiciona(Destino d) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Destino(des_Referencia, des_Endereco, des_Numero, des_Bairro, des_Cep )"
				+ "VALUES (?, ?, ?, ?, ?,?)";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, d.getNomeReferencia());
		comandoSql.setString(2, d.getEndereco());
		comandoSql.setInt(3, Integer.parseInt(d.getNumero()));
		comandoSql.setString(4, d.getBairro());
		comandoSql.setString(5, d.getCep());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Destino d) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Destino SET des_Referencia=?,des_Endereco=?, des_Numero=?, des_Bairro=?,des_Cep=?"
				+ " WHERE idDestino=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, d.getNomeReferencia());
		comandoSql.setString(2, d.getEndereco());
		comandoSql.setInt(3, Integer.parseInt(d.getNumero()));
		comandoSql.setString(4, d.getBairro());
		comandoSql.setString(5, d.getCep());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Destino WHERE idDestino=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public List<Destino> listaTodos() throws ClassNotFoundException, SQLException {
		List<Destino> lista = new LinkedList<Destino>();

		String sql = "SELECT * FROM destino";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);

		ResultSet rs = comandoSql.executeQuery();

		while (rs.next()) {
			Destino d = new Destino();
			d.setId(rs.getInt("idDestino"));
			
			d.setNomeReferencia(rs.getString("des_Referencia"));
			d.setEndereco(rs.getString("des_Endereco"));
			d.setNumero((rs.getString("des_Numero")));
			d.setBairro(rs.getString("des_Bairro"));
			d.setCep(rs.getString("des_Cep"));
			

			lista.add(d);
		}

		return lista;
	}

	public Destino listaPorId(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Destino WHERE idDestino=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		ResultSet rs = comandoSql.executeQuery();

		Destino d = null;

		if (rs.next()) {
			d = new Destino();
			d.setId(rs.getInt("idDestino"));
			d.setNomeReferencia(rs.getString("des_Referencia"));
			d.setEndereco(rs.getString("des_Endereco"));
			d.setNumero((rs.getString("des_Numero")));
			d.setBairro(rs.getString("des_Bairro"));
			d.setCep(rs.getString("des_Cep"));
		}

		return d;
	}

}
