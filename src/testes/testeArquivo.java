package testes;

import classesBase.Aluno;
import classesBase.Endereco;
import classesBase.Pessoa;
import classesBase.Professor;
import classesBase.Turma;
import dados.RepositorioPessoaArquivoXls;
import excecoes.RepositorioException;

public class testeArquivo {

	public static void main(String[] args) {

		RepositorioPessoaArquivoXls pessoas = new RepositorioPessoaArquivoXls();

		Endereco end = new Endereco("sddsad", "sdasd", "Sadasd", "sdsad",
				"asd", "", "asdasd");
		Turma turma = new Turma("tumrma1");

		Pessoa bruna = new Aluno("43536787656", "Bruna", "7727724", "F", end,
				"Luiz", "Nancy", turma);
		// Pessoa harry = new Aluno("25365576866", "Harry", "7727724", "F", end,
		// "Luiz", "Nancy", turma);
		Pessoa laryssa = new Professor("47623456456", "Laryssa", "7727724",
				"F", end, "ser legal", "alasdsas");
		Pessoa geba = new Aluno("83830480504", "Geovane", "7727724", "F", end,
				"Luiz", "Nancy", turma);

		Pessoa novo = new Aluno("000000", "Fulano", "7727724", "F", end,
				"Luiz", "Nancy", turma);

		Pessoa prof = new Professor("47623456456", "Prof", "7727724", "F", end,
				"ser legal", "alasds");

		// Pessoa novo2 = new Aluno("000000", "Fulano2", "7727724", "F", end,
		// "Luiz", "Nancy", turma);

		try {
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
			pessoas.inserir(prof);
			pessoas.inserir(geba);
			pessoas.inserir(bruna);
			pessoas.inserir(novo);
			pessoas.inserir(laryssa);
		} catch (RepositorioException e) {
			System.out.println("n deu certo");
		}
		
		/**try {
			pessoas.remover("000000");
		} catch (ElementoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			pessoas.inserir(geba);
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("imprimindo: ");
		//System.out.println(pessoas.getPessoas().imprimir());
	}

}
