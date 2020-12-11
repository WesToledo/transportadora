package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Modelo.Pacote;

public class PacoteDao {

	public void adiciona(Pacote p) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Pacote (pac_Nome, Valor, pac_Peso, pac_Unidade)" + "VALUES (?, ?, ?, ?)";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, p.getNome());
		comandoSql.setDouble(2, p.getValor());
		comandoSql.setDouble(3, p.getPeso());
		comandoSql.setString(4, p.getUnidade());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Pacote p) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Pacote SET pac_Nome=?, Valor=?, pac_Peso=?, pac_Unidade=? WHERE idPacote=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, p.getNome());
		comandoSql.setDouble(2, p.getValor());
		comandoSql.setDouble(3, p.getPeso());
		comandoSql.setString(4, p.getUnidade());
		comandoSql.setInt(5, p.getId());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Pacote WHERE idPacote=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public List<Pacote> listaTodos() throws ClassNotFoundException, SQLException {
		List<Pacote> lista = new LinkedList<Pacote>();

		String sql = "SELECT * FROM Pacote";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);

		ResultSet rs = comandoSql.executeQuery();

		while (rs.next()) {
			Pacote p = new Pacote();
			p.setId(rs.getInt("idPacote"));
			p.setNome(rs.getString("pac_Nome"));
			p.setValor(rs.getDouble("Valor"));
			p.setPeso(rs.getDouble("pac_Peso"));
			p.setUnidade(rs.getString("pac_Unidade"));

			lista.add(p);
		}

		return lista;
	}

	public Pacote listaPorId(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Pacote WHERE idPacote=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		ResultSet rs = comandoSql.executeQuery();

		Pacote p = null;

		if (rs.next()) {
			p = new Pacote();
			p.setId(rs.getInt("idPacote"));
			p.setNome(rs.getString("pac_Nome"));
			p.setValor(rs.getDouble("Valor"));
			p.setPeso(rs.getDouble("pac_Peso"));
			p.setUnidade(rs.getString("pac_Unidade"));

		}

		return p;
	}
}
