package service;

import pacote.PalavraChave;
import pacote.Resposta;

import java.util.ArrayList;

import dao.RespostaDao;

public class PerguntaService {
	
	RespostaDao dao = new RespostaDao();
	
	
 	public Resposta obterPalavraChave(PalavraChave palavraChave1) {
 		String [] pl;
 		pl = palavraChave1.getPalavra().split(" ");
 		ArrayList<PalavraChave> palavraChav = new ArrayList<PalavraChave>();
 		
 		for(int i = 0; i<pl.length; i++) {
 			palavraChav.add(palavraChave1);
 		}

 		
 		return RespostaService.buscaRespostaApropriada(palavraChav);
 	}



	public ArrayList<String> quebraResposta(String pergunta) {
		String [] vet;
		vet= pergunta.split(" ");
		ArrayList<String> listPergunta = new ArrayList<String>();
		
		for(int i = 0; i<vet.length; i++) {
			listPergunta.add(vet[i]);
		}

		
		return listPergunta;
	}

}

/*
 * ChatBDao dao = new ChatBDao();
 * 
 * 
 * public PalavraChave obterPalavraChave(PalavraChave palavraChave1) {
 * 
 * // pl = palavraChave1.getPalavra().split(" "); //// ArrayList<PalavraChave>
 * palavraChave = new ArrayList<PalavraChave>(); //// ArrayList
 * <RespostaService> respostasPossiveis =
 * RespostaService.obterRespostasPossiveis (palavraChave); ////
 * while(palavraChave1.split(" ") != null) //// palavraChave.add(palavraChave1);
 * // // return dao.chamarPalavra(palavraChave1); return null; }
 * 
 * }
 */

