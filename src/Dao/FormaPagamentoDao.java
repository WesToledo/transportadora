package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Modelo.FormaPagamento;

public class FormaPagamentoDao {

	public void adiciona(FormaPagamento f) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Forma_Pagamento(pag_Nome, pag_Tributario, pag_Dias_Compensacao)" + "VALUES (?, ?, ?)";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, f.getNome());
		comandoSql.setDouble(2, f.getOnus());
		comandoSql.setInt(3, f.getDiasCompensacao());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(FormaPagamento f) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE Forma_Pagamento SET pag_Nome=?, pag_Dias_Compensacao=?,pag_Tributario=? WHERE idForma_Pagamento=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, f.getNome());
		comandoSql.setInt(2, f.getDiasCompensacao());
		comandoSql.setDouble(3, f.getOnus());
		comandoSql.setInt(4, f.getId());

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Forma_Pagamento WHERE idForma_Pagamento=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public List<FormaPagamento> listaTodos() throws ClassNotFoundException, SQLException {
		List<FormaPagamento> lista = new LinkedList<FormaPagamento>();

		String sql = "SELECT * FROM forma_pagamento";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);

		ResultSet rs = comandoSql.executeQuery();

		while (rs.next()) {
			FormaPagamento f = new FormaPagamento();
			f.setId(rs.getInt("idForma_Pagamento"));
			f.setNome(rs.getString("pag_Nome"));
			f.setOnus(rs.getDouble("pag_Tributario"));
			f.setDiasCompensacao(rs.getInt("pag_Dias_Compensacao"));

			lista.add(f);
		}

		return lista;
	}

	public FormaPagamento listaPorId(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Forma_Pagamento WHERE idForma_Pagamento=?";

		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);

		ResultSet rs = comandoSql.executeQuery();

		FormaPagamento f = null;

		if (rs.next()) {
			f = new FormaPagamento();
			f.setId(rs.getInt("idForma_Pagamento"));
			f.setNome(rs.getString("pag_Nome"));
			f.setOnus(rs.getDouble("pag_Tributario"));
			f.setDiasCompensacao(rs.getInt("pag_Dias_Compensacao"));

		}

		return f;
	}

}
