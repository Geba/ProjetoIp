package classesBase;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	private String dataNasc;
	private String identidade;
	private String sexo;
	private Endereco endereco;

	public Pessoa(String cpf, String nome, String dataNasc, String identidade,
			String sexo, Endereco endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.identidade = identidade;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
