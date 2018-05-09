package pacote;

public class Atend_Conversa {

	private int id_atendimento;

	private int id_conversa;
	
	public Atend_Conversa(int id_atendimento, int id_conversa) {
		super();
		this.id_atendimento = id_atendimento;
		this.id_conversa = id_conversa;
	}

	public Atend_Conversa() {
		
	}

	public int getId_atendimento() {
		return id_atendimento;
	}

	public void setId_atendimento(int id_atendimento) {
		this.id_atendimento = id_atendimento;
	}

	public int getId_conversa() {
		return id_conversa;
	}

	public void setId_conversa(int id_conversa) {
		this.id_conversa = id_conversa;
	}

	@Override
	public String toString() {
		return "Atend_Conversa [id_atendimento=" + id_atendimento + ", id_conversa=" + id_conversa + "]";
	}
	
}
