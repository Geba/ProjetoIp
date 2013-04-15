package testes;

import java.util.Iterator;

import excecoes.ElementoJaCadastradoException;
import excecoes.ElementoNaoEncontradoException;
import excecoes.EntradaInvalidaException;
import excecoes.RepositorioException;
import fachadaEscola.Escola;
import classesBase.*;
import dados.*;

public class TESTEFACHADA {

	/**
	 * @param args
	 * @throws RepositorioException 
	 * @throws ElementoJaCadastradoException 
	 * @throws EntradaInvalidaException 
	 * @throws ElementoNaoEncontradoException 
	 */
	public static void main(String[] args) throws EntradaInvalidaException, ElementoJaCadastradoException, RepositorioException, ElementoNaoEncontradoException {
		Escola fachada = new Escola();

		System.out.println("Pegando os alunoss: \n");

		Iterator<Pessoa> it1 = fachada.getAlunos().getIterator();
		fachada.inserirTurma("Turma1");
		
		fachada.inserirAluno("000000000000134342", "heey", "01/01/1111", "8349638", "M",
				"34626209", "rua", "1234", "bairro", "51030630", "cidade",
				"estado", "pais", "pai", "mae",
				fachada.getTurmas().procurar("Turma1"));
		while (it1.hasNext()) {
			System.out.println(it1.next().resumo());
		}
	}
}
