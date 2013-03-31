package dados;
import excecoes.ElementoNaoEncontradoException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import classesBase.Disciplina;


public class RepositorioArrayDisciplina extends RepositorioArray<Disciplina> {

	

	public RepositorioArrayDisciplina(int n) {//Aqui a gente inicia o array de Disciplinas; o n define o tamanho
		super();
		Disciplina [] array = new Disciplina[n];
		for (int a = 0; a < array.length; a++) {
			array[a] = null;
		}
		super.setArray(array);
	}
	
	public RepositorioArrayDisciplina() {//Tamanho defalt = 500000
		super();
		Disciplina [] array = new Disciplina[500000];
		for (int a = 0; a < array.length; a++) {
			array[a] = null;
		}
		super.setArray(array);
	}

	public void inserir(Disciplina item) {
		Disciplina []array = super.getArray();
		array[super.getCont()] = item;
		super.setArray(array);
		super.setCont(super.getCont() + 1);
	}

	public Disciplina procurar(String procura)
			throws ElementoNaoEncontradoException {
		Disciplina p = null;
		boolean achou = false;
		Iterator<Disciplina> it = iterator();
		while (it.hasNext() && !achou) {
			try {
				p = it.next();
			} catch (NoSuchElementException e) {
				throw new ElementoNaoEncontradoException();
			}
			if (p != null && p.getNome().equals(procura)) {
				achou = true;
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		return p;
	}

	public int procurarIndice(String nome) throws ElementoNaoEncontradoException {
		Disciplina p = null;
		int i = -1;
		boolean achou = false;
		Iterator<Disciplina> it = iterator();
		
		while (it.hasNext() && !achou) {
			try {
				p = it.next();
				i++;
			} catch (NoSuchElementException e) {
				throw new ElementoNaoEncontradoException();
			}
			if (p != null && p.getNome().equals(nome)) {
				achou = true;
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		return i;
	}

	public void atualizar(Disciplina item) throws ElementoNaoEncontradoException {
		int i = 0;
		try {
			i = procurarIndice(item.getNome());
		} catch (NoSuchElementException e) {
			throw new ElementoNaoEncontradoException();
		}
		Disciplina[] disciplinas = super.getArray();
		disciplinas[i] = item;
		super.setArray(disciplinas);
	}

	public void remover(String nome) throws ElementoNaoEncontradoException {
		int i=0;
		try {
			i = procurarIndice(nome);
		} catch (ElementoNaoEncontradoException e) {
			throw new ElementoNaoEncontradoException();
		}
		System.out.println(i);//esseéumTeste
		Disciplina[] disciplinas = super.getArray();
		if (i == super.getCont()){
			disciplinas[i]=null;
		}else{
			for (int n=i; n < super.getCont(); n++) {
				disciplinas[n] = disciplinas[n+1];
			}	
		}
		
		
		disciplinas[disciplinas.length - 1] = null;
		super.setArray(disciplinas);
		super.setCont(super.getCont() - 1);
	}

	public String imprimir() {
		String retorno = "";
		Disciplina[] disciplinas = super.getArray();
		for (int i = 0; i <= super.getCont(); i++) {
			
			if (disciplinas[i] != null) {
				retorno += disciplinas[i].getNome() + " / "
						+ disciplinas[i].getEmenta();
				retorno += "\n";
			}
		}
		return retorno;

	}
	
	public Iterator<Disciplina> iterator() {// Ele já pecorre o array da classe pai.vv
		IteratorArray<Disciplina> it = new IteratorArray<Disciplina>(super.getArray());// Tem de Definir o tipoDoIterator, aqui eu fiz de array:)
		return it;
	}

}
