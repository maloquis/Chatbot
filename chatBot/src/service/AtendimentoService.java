package service;

import dao.AtendimentoDao;
import pacote.Atendimento;

public class AtendimentoService {

	AtendimentoDao dao = new AtendimentoDao();
	public int Criar_Ate(Atendimento atd) {
		return dao.cadastroAtendimento(atd);
	}
}
