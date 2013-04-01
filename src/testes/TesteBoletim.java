package testes;

import modificacoes.RepositorioArrayDisciplina2;
import classesBase.*;

public class TesteBoletim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RepositorioArrayDisciplina2 disc = new RepositorioArrayDisciplina2(3);
		Disciplina portugues = new Disciplina("portgues", "oi");
		Disciplina mat = new Disciplina("matematica", "oi");
		Disciplina geo = new Disciplina("geografia", "oi");
		
		disc.inserir(portugues);
		disc.inserir(mat);
		disc.inserir(geo);
		
		Boletim boletim = new Boletim(disc);
		System.out.println(boletim.imprimir());
		
		

	}

}
