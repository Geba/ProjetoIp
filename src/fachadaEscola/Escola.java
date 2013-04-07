package fachadaEscola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import negocio.Controle;
import classesBase.Administrador;
import classesBase.Aluno;
import classesBase.Disciplina;
import classesBase.Endereco;
import classesBase.Funcionario;
import classesBase.Pessoa;
import classesBase.Professor;
import classesBase.Turma;
import dados.*;
import excecoes.ElementoJaCadastradoException;
import excecoes.ElementoNaoEncontradoException;
import excecoes.EntradaInvalidaException;
import excecoes.RepositorioException;

public class Escola {

	Repositorio<Pessoa> pessoas;
	Repositorio<Turma> turmas; // AINDA TEM QUE TRATAR OS ERROS NO CATCH
	Repositorio<Disciplina> disciplinas; // INSERIR, PROCURAR, REMOVER E
											// ATUALIZAR
											// DONE

	public Escola() {

		FileReader arq;
		String repositorio = "";
		try {
			arq = new FileReader("config.txt");
			@SuppressWarnings("resource")
			BufferedReader lerArq = new BufferedReader(arq);
			repositorio = lerArq.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("erro1");
		} catch (IOException e) {
			System.out.println("erro2");
		}

		if (repositorio.equalsIgnoreCase("array")) {
			pessoas = new RepositorioArrayPessoa();
			turmas = new RepositorioArrayTurma();
			disciplinas = new RepositorioArrayDisciplina();
		} else if (repositorio.equalsIgnoreCase("lista")) {
			pessoas = new RepositorioListaPessoa();
			turmas = new RepositorioListaTurma();
			disciplinas = new RepositorioListaDisciplina();
		} else if (repositorio.equalsIgnoreCase("arquivo")) {
			pessoas = new RepositorioArquivoPessoa();
			turmas = new RepositorioArquivoTurma();
			disciplinas = new RepositorioArquivoDisciplina();
		} else {

		}
	}

	public Repositorio<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Repositorio<Pessoa> pessoas) {
		this.pessoas = pessoas;
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

	public void inserirAluno(String cpf, String nome, String dataNasc,
			String rg, String sexo, String telefone, String rua, String numero,
			String bairro, String cep, String cidade, String estado,
			String pais, String pai, String mae, Turma turma)
			throws EntradaInvalidaException, ElementoJaCadastradoException {
		try {
			Pessoa p = pessoas.procurar(cpf);
			throw new ElementoJaCadastradoException();
		} catch (ElementoNaoEncontradoException e1) {

			if (Controle.inserirAluno(cpf, nome, dataNasc, rg, sexo, telefone,
					rua, numero, bairro, cep, cidade, estado, pais, pai, mae,
					turma)) {
				Endereco end = new Endereco(rua, numero, bairro, cep, cidade,
						estado, pais);
				Pessoa aluno = new Aluno(cpf, nome, dataNasc, rg, sexo,
						telefone, end, pai, mae, turma);
				try {
					pessoas.inserir(aluno);
				} catch (RepositorioException e) {

				}
			} else {
				throw new EntradaInvalidaException();
			}
		}
	}

	public void inserirProfessor(String cpf, String nome, String dataNasc,
			String rg, String sexo, String telefone, String rua, String numero,
			String bairro, String cep, String cidade, String estado,
			String pais, String funcao) throws RepositorioException,
			EntradaInvalidaException, ElementoJaCadastradoException {
		try {
			Pessoa p = pessoas.procurar(cpf);
			throw new ElementoJaCadastradoException();
		} catch (ElementoNaoEncontradoException e1) {
			if (Controle.inserirProfessor(cpf, nome, dataNasc, rg, sexo,
					telefone, rua, numero, bairro, cep, cidade, estado, pais,
					funcao)) {
				Endereco end = new Endereco(rua, numero, bairro, cep, cidade,
						estado, pais);
				Pessoa prof = new Professor(cpf, nome, dataNasc, rg, sexo,
						telefone, end, funcao);
				try {
					pessoas.inserir(prof);
				} catch (RepositorioException e) {

				}
			} else {
				throw new EntradaInvalidaException();
			}
		}
	}

	public void inserirAdministrador(String cpf, String nome, String dataNasc,
			String rg, String sexo, String telefone, String rua, String numero,
			String bairro, String cep, String cidade, String estado,
			String pais, String funcao) throws RepositorioException,
			EntradaInvalidaException, ElementoJaCadastradoException {

		try {
			Pessoa p = pessoas.procurar(cpf);
			throw new ElementoJaCadastradoException();
		} catch (ElementoNaoEncontradoException e1) {
			if (Controle.inserirAdministrador(cpf, nome, dataNasc, rg, sexo,
					telefone, rua, numero, bairro, cep, cidade, estado, pais,
					funcao)) {
				Endereco end = new Endereco(rua, numero, bairro, cep, cidade,
						estado, pais);
				Pessoa adm = new Administrador(cpf, nome, dataNasc, rg, sexo,
						telefone, end, funcao);
				try {
					pessoas.inserir(adm);
				} catch (RepositorioException e) {
					// ainda tem que tratar
				}
			} else {
				throw new EntradaInvalidaException();
			}
		}

	}

	public void inserirFuncionario(String cpf, String nome, String dataNasc,
			String rg, String sexo, String telefone, String rua, String numero,
			String bairro, String cep, String cidade, String estado,
			String pais, String funcao) throws RepositorioException,
			EntradaInvalidaException, ElementoJaCadastradoException {
		try {
			Pessoa p = pessoas.procurar(cpf);
			throw new ElementoJaCadastradoException();
		} catch (ElementoNaoEncontradoException e1) {
			if (Controle.inserirFuncionario(cpf, nome, dataNasc, rg, sexo,
					telefone, rua, numero, bairro, cep, cidade, estado, pais,
					funcao)) {
				Endereco end = new Endereco(rua, numero, bairro, cep, cidade,
						estado, pais);
				Pessoa func = new Funcionario(cpf, nome, dataNasc, rg, sexo,
						telefone, end, funcao);
				try {
					pessoas.inserir(func);
				} catch (RepositorioException e) {

				}
			} else {
				throw new EntradaInvalidaException();
			}
		}
	}

	public void inserirTurma(String nome) throws EntradaInvalidaException,
			ElementoJaCadastradoException {
		try {
			Turma t = turmas.procurar(nome);
			throw new ElementoJaCadastradoException();
		} catch (ElementoNaoEncontradoException e1) {
			if (Controle.nomeValido(nome)) {

				Turma t = new Turma(nome);
				try {
					turmas.inserir(t);
				} catch (RepositorioException e) {
					// TODO Auto-generated catch block

				}
			} else {
				throw new EntradaInvalidaException();
			}
		}
	}

	public void inserirDisciplina(String nome, String ementa)
			throws EntradaInvalidaException, ElementoJaCadastradoException {
		try {
			Disciplina d = disciplinas.procurar(nome);
			throw new ElementoJaCadastradoException();
		} catch (ElementoNaoEncontradoException e1) {

			if (Controle.nomeValido(nome)) {
				Disciplina d = new Disciplina(nome, ementa);
				try {
					disciplinas.inserir(d);
				} catch (RepositorioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				throw new EntradaInvalidaException();
			}
		}
	}

	public Pessoa procurarPessoa(String cpf)
			throws ElementoNaoEncontradoException, EntradaInvalidaException {
		Pessoa p = null;
		if (Controle.cpfValido(cpf)) {
			try {
				p = pessoas.procurar(cpf);
			} catch (ElementoNaoEncontradoException e) {
				// TRATAR
			}
		} else {
			throw new EntradaInvalidaException();
		}
		return p;
	}

	public Disciplina procurarDisciplina(String nome)
			throws ElementoNaoEncontradoException, EntradaInvalidaException {
		Disciplina d = null;

		if (Controle.nomeValido(nome)) {
			try {

				d = disciplinas.procurar(nome);
			} catch (ElementoNaoEncontradoException e) {

			}
		} else {
			throw new EntradaInvalidaException();
		}
		return d;
	}

	public Turma procurarTurma(String nome)
			throws ElementoNaoEncontradoException, EntradaInvalidaException {
		Turma t = null;

		if (Controle.nomeValido(nome)) {
			try {
				t = turmas.procurar(nome);
			} catch (ElementoNaoEncontradoException e) {

			}
		} else {
			throw new EntradaInvalidaException();
		}
		return t;
	}

	public void removerPessoa(String cpf) throws RepositorioException,
			EntradaInvalidaException {

		if (Controle.cpfValido(cpf)) {
			try {
				pessoas.remover(cpf);

			} catch (RepositorioException f) {

			} catch (ElementoNaoEncontradoException e) {

			}
		} else {
			throw new EntradaInvalidaException();
		}
	}

	public void removerDisciplina(String nome) throws RepositorioException,
			EntradaInvalidaException {
		if (Controle.nomeValido(nome)) {
			try {
				disciplinas.remover(nome);
			} catch (ElementoNaoEncontradoException e) {

			}
		} else {
			throw new EntradaInvalidaException();
		}
	}

	public void removerTurma(String nome) throws RepositorioException,
			EntradaInvalidaException {
		if (Controle.nomeValido(nome)) {
			try {
				turmas.remover(nome);
			} catch (ElementoNaoEncontradoException e) {

			}
		} else {
			throw new EntradaInvalidaException();
		}
	}

	public void atualizarPessoa(Pessoa pessoaOriginal, Pessoa pessoaAtualizada)
			throws ElementoNaoEncontradoException, RepositorioException {
		try {
			pessoas.atualizar(pessoaAtualizada);
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

	public void atualizarTurma(Turma turmaOriginal, Turma turmaAtualizada)
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

	public String relatorioAlunos(){  //tem que fazer os metodos relatorio
		String retorno="";
		IteratorListaPessoa it = new IteratorListaPessoa((RepositorioListaPessoa) pessoas);
		return retorno;
		}
	

	public void atualizarAluno(Aluno alunoOriginal, Aluno AlunoAtualizado) {
		// TODO Auto-generated method stub
		
	}
	
	




}
