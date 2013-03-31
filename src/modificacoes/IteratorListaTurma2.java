package modificacoes;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorListaTurma2 implements Iterator<RepositorioListaTurma2> {

	private RepositorioListaTurma2 repositorio;

	public IteratorListaTurma2(RepositorioListaTurma2 repositorio) {//Recebe como argumento o primeiro item da lista
		this.repositorio = new RepositorioListaTurma2();
		this.repositorio.setProx(repositorio);//Cria a mesma estrutura presente no repositorio, em q o primeiro item da lista é vazio.
	}

	public boolean hasNext() {
		boolean resposta = true;
		if (this.repositorio.getProx() == null) {
			resposta = false;
		}
		return resposta;
	}
	
	
	
	public RepositorioListaTurma2 next() throws NoSuchElementException{
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

	public RepositorioListaTurma2 getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioListaTurma2 repositorio) {
		this.repositorio = repositorio;
	}

}
