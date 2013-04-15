package dados;

import java.util.Iterator;
import java.util.NoSuchElementException;
import classesBase.Disciplina;


public class IteratorArrayDisciplina implements Iterator<Disciplina> {
	Disciplina[] array;
	int indiceAtual;
	long contador = 0;

	public IteratorArrayDisciplina(Disciplina[] array) {
		this.array = array;
		this.indiceAtual = -1;
		for (int i = 0; this.array[i] != null; i++) {
			this.contador = i;
		}

	}

	public boolean hasNext() {
		return this.indiceAtual < this.contador-1;
	}

	public Disciplina next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return array[++indiceAtual];

	}

	public void remove() {
		throw new UnsupportedOperationException(
				"Esta operacao nao é suportada.");
	}

	public int getIndice() {
		return indiceAtual;
	}
}
