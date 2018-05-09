package pacote;

import java.util.ArrayList;
import java.util.List;

import dao.ChatBDao;
import service.ClienteService;

public class ChatB {

	public List<Conversa> conversas;
	

	public ChatB() {
		conversas = new ArrayList<>();
	}
	ChatBDao bot = new ChatBDao();
	public void addConversa(String pergunta, String resposta) {
		conversas.add(new Conversa(pergunta, resposta));
		//bot.guardar_respostata(pergunta, resposta);
		
		// para passar conversa para o banco
		Conversa conv = new Conversa();
		conv.setPergunta(pergunta);
		conv.setResposta(resposta);
		
		ClienteService cl = new ClienteService();
		cl.Conversa0(conv);
		
	}

	public List<Conversa> getConversas() {
		return new ArrayList<>(conversas);
	}

	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}