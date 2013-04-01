package classesBase;

public abstract class Empregado extends Pessoa {
	private String funcao;
	private double salario;
	private boolean[][] frequencia;
	public Empregado(String cpf, String nome, String dataNasc, String identidade, String sexo,
			Endereco endereco, String funcao) {
		super(cpf, nome, dataNasc, identidade, sexo, endereco);
		this.funcao = funcao;
		this.salario = 0.0;
		frequencia = new boolean[12][31];
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean[][] getFrequencia(){
		return this.frequencia;
	}
	
}
