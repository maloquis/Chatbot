package controller;

import pacote.ChatB;
import pacote.Resposta;
import service.Atend_ConversaService;
import service.ChatService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChatBDao;

import java.io.IOException;

/**
 * Servlet implementation class ChatBController
 */
@WebServlet("/chatBController.do")
public class ChatBController extends HttpServlet {

	public static final String CHAT = "chat";
	public static final String RESPOSTA_NAO_ENCONTRADA = "Desculpe, mas não tenho a resposta para sua pergunta! Você pode reformular a sua pergunta?";
	public static final String ATT_PERG = "pergunta";
	public ChatService chatService = new ChatService();
	ChatBDao chatJ = new ChatBDao();

	private static final long serialVersionUID = 1L;
	int sim = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ChatB chat = (ChatB) session.getAttribute(CHAT);
		String pergunta = request.getParameter(ATT_PERG);
		String pAcao = request.getParameter("acao");

		String respostaA = chatJ.TirarEspeciais(pergunta);
        Resposta resposta = chatService.buscaResposta(respostaA.toLowerCase());
		

		if (pAcao.equals("Enviar")) {

			// Adicionando ao Banco a Conversa
			if (resposta == null) {

				chat.addConversa(pergunta, RESPOSTA_NAO_ENCONTRADA);
			} else {
				chat.addConversa(pergunta, resposta.getValor());

			}

			// veicular o atendimento com a resposta
			Atend_ConversaService ate = new Atend_ConversaService();
			ate.Select();
		} else if (pAcao.equals("Sim")) {

			ChatBDao dao = new ChatBDao();
			resposta = chatService.SimBotaoo(dao.Ultima());

			chat.addConversa(dao.Ultima(), resposta.getValor());

			// veicular o atendimento com a resposta
			Atend_ConversaService ate = new Atend_ConversaService();
			ate.Select();

		} else if (pAcao.equals("Sim")) {
			
		}
		session.setAttribute(CHAT, chat);

		RequestDispatcher view = request.getRequestDispatcher("chat.jsp");
		view.forward(request, response);

	}

	String username, tempName;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}

}
