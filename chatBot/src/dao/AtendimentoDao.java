package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pacote.Atendimento;

public class AtendimentoDao {
	
	public int cadastroAtendimento(Atendimento atd) {
		String sqlInsert = "INSERT INTO Atendimento( Status_Atendimento,Id_Cliente, Id_Atendente) VALUES (?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, atd.getStatus());
			stm.setInt(2,atd.getId_cliente());
			stm.setInt(3, atd.getId_atendente());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					atd.setId_atendimento(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atd.getId_atendimento();
	}
}