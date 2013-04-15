package testes;

import java.util.Iterator;

import fachadaEscola.Escola;
import classesBase.*;
import dados.*;

public class TESTEFACHADA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Escola fachada = new Escola();

		System.out.println("Pegando os alunoss: \n");
		
		Iterator<Pessoa> it1 = fachada.getAlunos().getIterator();
		while(it1.hasNext()){
			System.out.println(it1.next().resumo());
		}
	}

}
