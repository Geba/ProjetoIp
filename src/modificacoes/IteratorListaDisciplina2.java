package modificacoes;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorListaDisciplina2 implements Iterator<RepositorioListaDisciplina2> {

	private RepositorioListaDisciplina2 repositorio;

	public IteratorListaDisciplina2(RepositorioListaDisciplina2 repositorio) {//Recebe como argumento o primeiro item da lista
		this.repositorio = new RepositorioListaDisciplina2();
		this.repositorio.setProx(repositorio);//Cria a mesma estrutura presente no repositorio, em q o primeiro item da lista é vazio.
	}

	public boolean hasNext() {
		boolean resposta = true;
		if (this.repositorio.getProx() == null) {
			resposta = false;
		}
		return resposta;
	}
	
	
	
	public RepositorioListaDisciplina2 next() throws NoSuchElementException{
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

	public RepositorioListaDisciplina2 getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioListaDisciplina2 repositorio) {
		this.repositorio = repositorio;
	}

}
