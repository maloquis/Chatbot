package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pacote.ChatB;
import pacote.Cliente;
import pacote.Conversa;

public class ChatBDao {

	//private static final String INSERT_ATENDENTE = "INSERT INTO atendente(Nome_Atendente, Email_Atendente, CPF_Atendente,"
	//		+ " RG_Atendente, Telefone_Atendente, Status_Atendente, Senha_Atendente ) VALUES (?, ?, ?,?, ?, ?, ?)";

	Cliente cli;

	public int guardar_respostata(String pergunta, String resposta) {
		ChatB chatb = new ChatB();
		;
		String sqlInsert = "INSERT INTO conversa(pergunta,respostas) VALUES (?,?)";

		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pergunta);
			stm.setString(2, resposta);
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					chatb.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Atendimento_conversa(2, chatb.getId());
	}

	public void cadastroAtendimento(int id_Cliente, int id_atendete) {
		String sqlInsert = "INSERT INTO Atendimento( Status_Atendimento,Id_Cliente, Id_Atendente) VALUES (?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, "Aberto");
			stm.setInt(2, id_Cliente);
			stm.setInt(3, id_atendete);
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
	}

	public int Atendimento_conversa(int id_atendimento, int id_conversa) {

		String sqlInsert = "INSERT INTO Atendimento_conversa ( idatendimento_ac, idconversa_ac) VALUES (?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, id_atendimento);
			stm.setInt(2, id_conversa);
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

	public String Ultima() {
		Conversa conv = new Conversa();

		String sqlSelect = "select pergunta from conversa order by id_conversa desc limit 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					conv.setPergunta(rs.getString("pergunta"));
				} else {
					conv.setPergunta(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return conv.getPergunta();
	}

	public String TirarEspeciais(String aux)
	{
		String nova = new String();
		
		for(int i = 0; i<aux.length(); i++) {
			if((aux.charAt(i) == ',') || (aux.charAt(i) == '.') || (aux.charAt(i) == ';') || (aux.charAt(i) == ':')
					|| (aux.charAt(i) == '/') || (aux.charAt(i) == '#') || (aux.charAt(i) == '?') || (aux.charAt(i) == '!')) {
			
			
			}else {
				nova += aux.charAt(i);
			}
		}
		
		return nova;
	}

}