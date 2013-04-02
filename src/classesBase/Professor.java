package classesBase;

import dados.*;
import excecoes.RepositorioException;

public class Professor extends Empregado {
	private Repositorio<Turma> turmas;
	private Repositorio<Disciplina> disciplinas;

	public Professor(String cpf, String nome, String dataNasc,
			String identidade, String sexo, String telefone, Endereco endereco,
			String funcao) {
		super(cpf, nome, dataNasc, identidade, sexo, telefone, endereco, funcao);
		turmas = new RepositorioArrayTurma();
		disciplinas = new RepositorioArrayDisciplina();

	}

	public Repositorio<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Repositorio<Turma> turmas) {
		this.turmas = turmas;
	}

	public Repositorio<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Repositorio<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void inserirDisciplina(Disciplina d){
		try {
			this.getDisciplinas().inserir(d);
		} catch (RepositorioException e) {
			System.out.println("erro no inserir disciplinas");
		}
	}
	
	public void inserirTurma(Turma t){
		try {
			this.getTurmas().inserir(t);
		} catch (RepositorioException e) {
			System.out.println("erro no inserir turmas");
		}
		
	}

}
