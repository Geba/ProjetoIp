package dados;
import excecoes.ElementoNaoEncontradoException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import classesBase.Pessoa;


public class RepositorioArrayPessoa extends RepositorioArray<Pessoa> {

	
	public RepositorioArrayPessoa(int n) {//Aqui a gente inicia o array de Pessoas; o n define o tamanho
		super();
		Pessoa [] array = new Pessoa[n];
		for (int a = 0; a < array.length; a++) {
			array[a] = null;
		}
		super.setArray(array);
	}
	
	public RepositorioArrayPessoa() {//Tamanho default = 500000
		super();
		Pessoa [] array = new Pessoa[50000];
		for (int a = 0; a < array.length; a++) {
			array[a] = null;
		}
		super.setArray(array);
	}

	public void inserir(Pessoa item) {
		Pessoa []array = super.getArray();
		array[super.getCont()] = item;
		super.setArray(array);
		super.setCont(super.getCont() + 1);
	}

	public Pessoa procurar(String cpf)
			throws ElementoNaoEncontradoException {
		Pessoa p = null;
		boolean achou = false;
		Iterator<Pessoa> it = iterator();
		while (it.hasNext() && !achou) {
			try {
				p = it.next();
			} catch (NoSuchElementException e) {
				throw new ElementoNaoEncontradoException();
			}
			if (p != null && p.getCpf().equals(cpf)) {
				achou = true;
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		return p;
	}

	public int procurarIndice(String cpf) throws ElementoNaoEncontradoException {
		Pessoa p = null;
		int i = -1;
		boolean achou = false;
		Iterator<Pessoa> it = iterator();
		
		while (it.hasNext() && !achou) {
			try {
				p = it.next();
				i++;
			} catch (NoSuchElementException e) {
				throw new ElementoNaoEncontradoException();
			}
			if (p != null && p.getCpf().equals(cpf)) {
				achou = true;
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		return i;
	}

	public void atualizar(Pessoa item) throws ElementoNaoEncontradoException {
		int i = 0;
		try {
			i = procurarIndice(item.getCpf());
		} catch (NoSuchElementException e) {
			throw new ElementoNaoEncontradoException();
		}
		Pessoa[] pessoas = super.getArray();
		pessoas[i] = item;
		super.setArray(pessoas);
	}

	public void remover(String cpf) throws ElementoNaoEncontradoException {
		int i=0;
		try {
			i = procurarIndice(cpf);
		} catch (ElementoNaoEncontradoException e) {
			throw new ElementoNaoEncontradoException();
		}
		//System.out.println(i);//esseéumTeste
		Pessoa[] pessoas = super.getArray();
		if (i == super.getCont()){
			pessoas[i]=null;
		}else{
			for (int n=i; n < super.getCont(); n++) {
				pessoas[n] = pessoas[n+1];
			}	
		}
		
		
		pessoas[pessoas.length - 1] = null;
		super.setArray(pessoas);
		super.setCont(super.getCont() - 1);
	}

	public String imprimir() {
		String retorno = "";
		Pessoa[] pessoas = super.getArray();
		for (int i = 0; i <= super.getCont(); i++) {
			
			if (pessoas[i] != null) {
				retorno += pessoas[i].getNome() + " / "
						+ pessoas[i].getCpf() + " / "
						+ pessoas[i].getIdentidade();
				retorno += "\n";
			}
		}
		return retorno;

	}
	
	public Iterator<Pessoa> iterator() {// Ele já pecorre o array da classe pai.vv
		IteratorArray<Pessoa> it = new IteratorArray<Pessoa>(super.getArray());// Tem de Definir o tipoDoIterator, aqui eu fiz de array:)
		return it;
	}

}
