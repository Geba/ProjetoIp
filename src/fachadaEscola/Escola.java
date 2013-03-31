package fachadaEscola;

import classesBase.*;
import dados.*;
import excecoes.*;

public class Escola {

	Repositorio<Pessoa> pessoas;
	Repositorio<Turma> turmas; // AINDA TEM QUE TRATAR OS ERROS NO CATCH
	Repositorio<Disciplina> disciplinas; // INSERIR, PROCURAR, REMOVER E ATUALIZAR
										// DONE

	public Escola(String repositorio) {

		if (repositorio.equalsIgnoreCase("array")) {
			pessoas = new RepositorioArrayPessoa();
			turmas = new RepositorioArrayTurma();
			disciplinas = new RepositorioArrayDisciplina();
		} else if (repositorio.equalsIgnoreCase("lista")) {

		} else if (repositorio.equalsIgnoreCase("arquivo")) {

		} else {

		}
	}

	public void inserirAluno(String cpf, String nome, String rg, String sexo,
			String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String nomeDoPai,
			String nomeDaMae, Turma turma) throws RepositorioException {
		Endereco end = new Endereco(rua, numero, bairro, cep, cidade, estado,
				pais);
		Pessoa aluno = new Aluno(cpf, nome, rg, sexo, end, nomeDoPai,
				nomeDaMae, turma);
		try {
			pessoas.inserir(aluno);
		} catch (RepositorioException e) {

		}
	}

	public void inserirProfessor(String cpf, String nome, String rg,
			String sexo, String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String funcao,
			String login) throws RepositorioException {
		Endereco end = new Endereco(rua, numero, bairro, cep, cidade, estado,
				pais);
		Pessoa prof = new Professor(cpf, nome, rg, sexo, end, funcao, login);
		try {
			pessoas.inserir(prof);
		} catch (RepositorioException e) {

		}
	}

	public void inserirAdministrador(String cpf, String nome, String rg,
			String sexo, String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String funcao,
			String login) throws RepositorioException {
		Endereco end = new Endereco(rua, numero, bairro, cep, cidade, estado,
				pais);
		Pessoa adm = new Administrador(cpf, nome, rg, sexo, end, funcao, login);
		try {
			pessoas.inserir(adm);
		} catch (RepositorioException e) {
			// ainda tem que tratar
		}
	}

	public void inserirFuncionario(String cpf, String nome, String rg,
			String sexo, String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String funcao)
			throws RepositorioException {
		Endereco end = new Endereco(rua, numero, bairro, cep, cidade, estado,
				pais);
		Pessoa func = new Funcionario(cpf, nome, rg, sexo, end, funcao);
		try {
			pessoas.inserir(func);
		} catch (RepositorioException e) {

		}
	}

	public void inserirTurma(String nome) {
		Turma t = new Turma(nome);
		try {
			turmas.inserir(t);
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inserirDisciplina(String nome, String ementa) {
		Disciplina d = new Disciplina(nome, ementa);
		try {
			disciplinas.inserir(d);
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pessoa procurarPessoa(String cpf)
			throws ElementoNaoEncontradoException {
		Pessoa p = null;
		try {
			p = pessoas.procurar(cpf);
		} catch (ElementoNaoEncontradoException e) {
			// TRATAR
		}
		return p;
	}

	public Disciplina procurarDisciplina(String nome)
			throws ElementoNaoEncontradoException {
		Disciplina d = null;
		try {
			d = disciplinas.procurar(nome);
		} catch (ElementoNaoEncontradoException e) {

		}
		return d;
	}

	public Turma procurarTurma(String nome)
			throws ElementoNaoEncontradoException {
		Turma t = null;
		try {
			t = turmas.procurar(nome);
		} catch (ElementoNaoEncontradoException e) {

		}
		return t;
	}

	public void removerPessoa(String cpf) throws RepositorioException {
		try {
			pessoas.remover(cpf);

		} catch (RepositorioException f) {

		} catch (ElementoNaoEncontradoException e) {

		}
	}

	public void removerDisciplina(String nome) throws RepositorioException {
		try {
			disciplinas.remover(nome);
		} catch (ElementoNaoEncontradoException e) {

		}
	}

	public void removerTurma(String nome) throws RepositorioException {
		try {
			turmas.remover(nome);
		} catch (ElementoNaoEncontradoException e) {

		}
	}

	public void atualizarPessoa(Pessoa pessoa)
			throws ElementoNaoEncontradoException, RepositorioException {
		try {
			pessoas.atualizar(pessoa);
		} catch (ElementoNaoEncontradoException e) {

		} catch (RepositorioException f) {

		}
	}

	public void atualizarDisciplina(Disciplina disc)
			throws ElementoNaoEncontradoException {
		try {
			try {
				disciplinas.atualizar(disc);
			} catch (RepositorioException e) {
				
				e.printStackTrace();
			}
		} catch (ElementoNaoEncontradoException e) {

		}
	}

	public void atualizarTurma(Turma turma)
			throws ElementoNaoEncontradoException {
		try {
			try {
				turmas.atualizar(turma);
			} catch (RepositorioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ElementoNaoEncontradoException e) {

		}
	}

}
