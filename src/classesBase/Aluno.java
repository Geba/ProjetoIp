package classesBase;



public class Aluno extends Pessoa {
	private String pai;
	private String mae;
	private String numeroMatricula;

	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	private Boolean[][] presenca;
	private Turma turma;
	private Boletim boletim;

	public Aluno(String cpf, String nome, String identidade, String sexo,
			Endereco endereco, String pai, String mae, Turma turma) {
		super(cpf, nome, identidade, sexo, endereco);
		this.pai = pai;
		this.mae = mae;
		presenca = new Boolean[12][31];
		this.turma = turma;

		// gerando um numero aleatorio pro numeroMatricula pra nao precisar
		// pegar do usuario esse valor
		String x = (cpf.substring(0, 4));
		x += (identidade.substring(0, 3));
		this.numeroMatricula = x;

		boletim = new Boletim(turma.getDisciplinas()); // desse jeito passa pro
														// boletim do cara as
														// disciplinas que estao
														// definidas na turma

	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Boolean[][] getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean[][] presenca) {
		this.presenca = presenca;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String imprimirBoletim() {
		return boletim.imprimir();
	}

}
