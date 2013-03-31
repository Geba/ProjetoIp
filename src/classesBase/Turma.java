package classesBase;

import dados.RepositorioArrayDisciplina;


public class Turma {

	private String nome;
	private Aluno[] alunos;
	private RepositorioArrayDisciplina disciplinas;

	public Turma(String nome) {
		this.nome = nome;
		this.alunos = new Aluno[60];
		disciplinas = new RepositorioArrayDisciplina();
	}

	public void inserirDisciplina(String nome, String ementa) {
		Disciplina d = new Disciplina(nome, ementa);
		disciplinas.inserir(d);
	}

	public void inserirDisciplina(Disciplina d) {
		disciplinas.inserir(d);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aluno[] getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno[] alunos) {
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
