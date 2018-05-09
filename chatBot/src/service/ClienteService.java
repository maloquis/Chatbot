package service;

import dao.ClienteDao;
import pacote.Atend_Conversa;
import pacote.Atendimento;
import pacote.Cliente;
import pacote.Conversa;
import pacote.Resposta;

public class ClienteService {
	
	
	public ClienteDao dao = new ClienteDao();

	
	Cliente cli = new Cliente();
	Resposta resp = new Resposta();
	
	public Cliente carregar(int id){
		return dao.carregarCliente(id);
	}

	public int criarCliente(Cliente cli) {
		
		return dao.cadastroCliente(cli);
		
	}
	
	AtendimentoService as = new AtendimentoService();
	Atendimento atd = new Atendimento();
	
	public int CriarAtendCliente(Atendimento atds) {
		as.Criar_Ate(atds);
		return  atd.getId_atendimento();
	}
	
	Conversa conv = new Conversa();
	ConversaService cs = new ConversaService();
	
	 Atend_ConversaService At = new  Atend_ConversaService();

	public int Conversa0(Conversa conv) {
		cs.Conversa01(conv);
		return   conv.getId_conversa() ;
	}
	
}
