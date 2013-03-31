package modificacoes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import classesBase.Turma;

public class IteratorArrayTurma2 implements Iterator<Turma> {
	Turma[] array;
	int indiceAtual;
	long contador = 0;

	public IteratorArrayTurma2(Turma[] array) {
		this.array = array;
		this.indiceAtual = 0;
		for (int i = 0; this.array[i] != null; i++) {
			this.contador = i;
		}

	}

	public boolean hasNext() {
		return this.indiceAtual < this.contador;
	}

	public Turma next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return array[indiceAtual++];

	}

	public void remove() {
		throw new UnsupportedOperationException(
				"Esta operacao nao � suportada.");
	}

	public int getIndice() {
		return indiceAtual;
	}
}
