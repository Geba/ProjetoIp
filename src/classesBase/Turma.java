package classesBase;

import dados.RepositorioArrayDisciplina;
import dados.RepositorioArrayPessoa;


public class Turma {

	private String nome;
	private RepositorioArrayPessoa alunos;
	private RepositorioArrayDisciplina disciplinas;

	public Turma(String nome) {
		this.nome = nome;
		this.alunos = new RepositorioArrayPessoa();
		disciplinas = new RepositorioArrayDisciplina();
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

	public RepositorioArrayPessoa getAlunos() {
		return alunos;
	}

	public void setAlunos(RepositorioArrayPessoa alunos) {
		this.alunos = alunos;
	}

	public RepositorioArrayDisciplina getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(RepositorioArrayDisciplina disciplinas) {
		this.disciplinas = disciplinas;
	}

	public int qtdDeDisciplinas() {
		return disciplinas.getCont();
	}

}
