package dados;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class IteratorListaTurma implements Iterator<RepositorioListaTurma> {

	private RepositorioListaTurma repositorio;

	public IteratorListaTurma(RepositorioListaTurma repositorio) {//Recebe como argumento o primeiro item da lista
		this.repositorio = new RepositorioListaTurma();
		this.repositorio.setProx(repositorio);//Cria a mesma estrutura presente no repositorio, em q o primeiro item da lista é vazio.
	}

	public boolean hasNext() {
		boolean resposta = true;
		if (this.repositorio.getProx() == null) {
			resposta = false;
		}
		return resposta;
	}
	
	
	
	public RepositorioListaTurma next() throws NoSuchElementException{
		if (hasNext()) {
			this.repositorio = this.repositorio.getProx();
			return this.repositorio;
		} else {
			throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException(
				"Esta operacao nao é suportada.");
	}

	public RepositorioListaTurma getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioListaTurma repositorio) {
		this.repositorio = repositorio;
	}

}
