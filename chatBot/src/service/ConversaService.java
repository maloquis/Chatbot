package service;

import dao.ConversaDao;
import pacote.Conversa;

public class ConversaService {
	
	ConversaDao dao = new ConversaDao();

	public int Conversa01(Conversa conv) {
		return dao.guardar_respostata(conv);
	}
}
