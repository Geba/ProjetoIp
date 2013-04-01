package classesBase;
import dados.*;

public class Professor extends Empregado {
	private String login;
	private String senha;
	private RepositorioTurma turmas;
	private RepositorioArrayDisciplina disciplinas;
	public Professor(String cpf, String nome, String dataNasc, String identidade, String sexo,
			Endereco endereco, String funcao, String login) {
		super(cpf, nome, dataNasc, identidade, sexo, endereco, funcao);
		this.login=login;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public RepositorioTurma getTurmas() {
		return turmas;
	}
	public void setTurmas(RepositorioTurma turmas) {
		this.turmas = turmas;
	}
	public RepositorioArrayDisciplina getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(RepositorioArrayDisciplina disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}
