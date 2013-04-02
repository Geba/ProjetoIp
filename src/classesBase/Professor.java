package classesBase;

import dados.*;
import excecoes.ElementoNaoEncontradoException;
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
			this.disciplinas.inserir(d);
		} catch (RepositorioException e) {
			System.out.println("erro no inserir disciplinas");
		}
	}
	
	public void removerDisciplina(Disciplina d) throws RepositorioException, ElementoNaoEncontradoException{
		try{
			this.disciplinas.remover(d.getNome());
		}catch(ElementoNaoEncontradoException e){
			throw e;			
		}catch(RepositorioException a){
			throw a;
		}
		
	}
	
	public void inserirTurma(Turma t){
		try {
			this.turmas.inserir(t);
		} catch (RepositorioException e) {
			System.out.println("erro no inserir turmas");
		}
	}
	
	public void removerTurma(Turma t) throws RepositorioException, ElementoNaoEncontradoException{
		try{
			this.turmas.remover(t.getNome());
		}catch(ElementoNaoEncontradoException e){
			throw e;			
		}catch(RepositorioException a){
			throw a;
		}
		
	}



}
