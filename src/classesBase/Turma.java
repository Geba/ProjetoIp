package classesBase;

import modificacoes.RepositorioArrayDisciplina2;
import modificacoes.RepositorioArrayPessoa2;


public class Turma {

	private String nome;
	private RepositorioArrayPessoa2 alunos;
	private RepositorioArrayDisciplina2 disciplinas;

	public Turma(String nome) {
		this.nome = nome;
		this.alunos = new RepositorioArrayPessoa2();
		disciplinas = new RepositorioArrayDisciplina2();
	}

	public void inserirDisciplina(String nome, String ementa) {
		Disciplina d = new Disciplina(nome, ementa);
		disciplinas.inserir(d);
	}

	public void inserirDisciplina(Disciplina d) {
		disciplinas.inserir(d);
	}

	public void inserirAluno(Pessoa p){
		alunos.inserir(p);
	}
	
public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RepositorioArrayPessoa2 getAlunos() {
		return alunos;
	}

	public void setAlunos(RepositorioArrayPessoa2 alunos) {
		this.alunos = alunos;
	}

	public RepositorioArrayDisciplina2 getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(RepositorioArrayDisciplina2 disciplinas) {
		this.disciplinas = disciplinas;
	}

	public int qtdDeDisciplinas() {
		return disciplinas.getCont();
	}

}
