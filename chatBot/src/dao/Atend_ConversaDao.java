package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pacote.Atend_Conversa;

public class Atend_ConversaDao {

	public int Atendimento_conversa(Atend_Conversa conv) {

		String sqlInsert = "INSERT INTO Atendimento_conversa ( idatendimento_ac, idconversa_ac) VALUES (?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, conv.getId_atendimento());
			stm.setInt(2, conv.getId_conversa());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int SelctAten() {

		Atend_Conversa conv = new Atend_Conversa();
		Atend_ConversaDao dao = new Atend_ConversaDao();
		String sqlSelect = "SELECT ID_Atendimento FROM atendimento ORDER BY ID_Atendimento  DESC LIMIT 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					conv.setId_atendimento(rs.getInt("ID_Atendimento"));
				} else {
					conv.setId_atendimento(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		String sqlSelect2 = "SELECT ID_conversa FROM conversa ORDER BY ID_conversa  DESC LIMIT 1";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect2);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					conv.setId_conversa(rs.getInt("ID_conversa"));
				} else {
					conv.setId_conversa(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return dao.Atendimento_conversa(conv);

	}
}
