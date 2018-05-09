package pacote;

/**
 * Created by daniel on 14/04/18.
 */
public class Conversa {
	
	public int id_conversa;
	
    public String pergunta;

    public String resposta;

    public Conversa() {
    }

    public Conversa(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

	public int getId_conversa() {
		return id_conversa;
	}

	public void setId_conversa(int id_conversa) {
		this.id_conversa = id_conversa;
	}
}