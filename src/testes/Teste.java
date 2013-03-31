package testes;

import classesBase.Aluno;
import classesBase.Endereco;
import classesBase.Pessoa;
import classesBase.Turma;
import dados.RepositorioArrayPessoa;
import excecoes.ElementoNaoEncontradoException;

public class Teste {

	public static void main(String[] args) {

		// FUNCIONOU TUDO DO ARRAY DE PESSOA!

		RepositorioArrayPessoa pessoas = new RepositorioArrayPessoa();
		Endereco end = new Endereco("sddsad", "sdasd", "Sadasd", "sdsad",
				"asd", "", "asdasd");
		Turma turma = new Turma("tumrma1");
		Pessoa p = new Aluno("12345678983", "Ana", "7727724", "F",
				end, "Luiz", "Nancy", turma);
		Pessoa a = new Aluno("43536787656", "Bruna", "7727724", "F",
				end, "Luiz", "Nancy", turma);
		Pessoa alana = new Aluno("47623456456", "Laryssa", "7727724", "F", end,
				"Luiz", "Nancy", turma);
		Pessoa geba = new Aluno("97087543324", "Geovane", "7727724", "F",
				end, "Luiz", "Nancy", turma);

		Pessoa novo = new Aluno("47623456456", "Fulano", "7727724", "F", end,
				"Luiz", "Nancy", turma);

		pessoas.inserir(geba);
		pessoas.inserir(alana);
		pessoas.inserir(a);
		pessoas.inserir(p);
		
		
System.out.println("\nImprima:\n");
		
			
	System.out.println(pessoas.imprimir());
	
	try {
		pessoas.atualizar(novo);
	} catch (ElementoNaoEncontradoException e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println(pessoas.imprimir());
	
	try {
		pessoas.remover(a.getCpf());
	} catch (ElementoNaoEncontradoException e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println(pessoas.imprimir());

	}

}
