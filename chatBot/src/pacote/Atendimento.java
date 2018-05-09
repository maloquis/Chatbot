package pacote;

public class Atendimento {

	private int id_atendimento;
	private String status= "Aberto";
	private int id_cliente;
	private int id_atendente;
	
	public Atendimento(int id_atendimento, String status, int id_cliente, int id_atendente) {
		super();
		this.id_atendimento = id_atendimento;
		this.status = status;
		this.id_cliente = id_cliente;
		this.id_atendente = id_atendente;
	}

	public Atendimento() {
	
	}

	public int getId_atendimento() {
		return id_atendimento;
	}

	public void setId_atendimento(int id_atendimento) {
		this.id_atendimento = id_atendimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_atendente() {
		return id_atendente;
	}

	public void setId_atendente(int id_atendente) {
		this.id_atendente = id_atendente;
	}

	@Override
	public String toString() {
		return "Atendimento [id_atendimento=" + id_atendimento + ", status=" + status + ", id_cliente=" + id_cliente
				+ ", id_atendente=" + id_atendente + "]";
	}
	
	
}
