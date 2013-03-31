package modificacoes;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorListaPessoa2 implements Iterator<RepositorioListaPessoa2> {

	private RepositorioListaPessoa2 repositorio;

	public IteratorListaPessoa2(RepositorioListaPessoa2 repositorio) {//Recebe como argumento o primeiro item da lista
		this.repositorio = new RepositorioListaPessoa2();
		this.repositorio.setProx(repositorio);//Cria a mesma estrutura presente no repositorio, em q o primeiro item da lista é vazio.
	}

	public boolean hasNext() {
		boolean resposta = true;
		if (this.repositorio.getProx() == null) {
			resposta = false;
		}
		return resposta;
	}
	
	
	
	public RepositorioListaPessoa2 next() throws NoSuchElementException{
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

	public RepositorioListaPessoa2 getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioListaPessoa2 repositorio) {
		this.repositorio = repositorio;
	}

}
