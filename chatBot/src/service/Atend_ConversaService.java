package service;

import dao.Atend_ConversaDao;
import pacote.Atend_Conversa;

public class Atend_ConversaService {
	
	Atend_ConversaDao dao =new Atend_ConversaDao();
	
	public int Atend(Atend_Conversa ac) {
		
		return dao.Atendimento_conversa(ac);
	}
	public void Select() {
		dao.SelctAten();
	}
}
