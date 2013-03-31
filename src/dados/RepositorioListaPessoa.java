package dados;

import java.util.Iterator;

import excecoes.ElementoNaoEncontradoException;

import java.util.NoSuchElementException;

import classesBase.*;

public class RepositorioListaPessoa extends RepositorioLista<Pessoa> implements
		Repositorio<Pessoa>, Iterable<RepositorioLista<Pessoa>> {

	public RepositorioListaPessoa() {
		super();
	}

	public void inserir(Pessoa pessoa) {

		if (super.getProx() == null) {
			RepositorioListaPessoa novoRepositorio = new RepositorioListaPessoa();
			novoRepositorio.setItem(pessoa);
			super.setProx(novoRepositorio);
		} else {
			((RepositorioListaPessoa) super.getProx()).inserir(pessoa);
		}
	}

	public String imprimir() {
		Iterator<RepositorioLista<Pessoa>> it = iterator();
		String resposta = "";
		while (it.hasNext()) {
			resposta = resposta + it.next().getItem().getNome() + "\n";
		}
		return resposta;
	}

	public Pessoa procurar(String cpf) throws ElementoNaoEncontradoException {
		Pessoa p = null;
		boolean achou = false;
		Iterator<RepositorioLista<Pessoa>> it = iterator();
		while (it.hasNext() && !achou) {
			try {
				p = it.next().getItem();
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

	public void atualizar(Pessoa pessoa) throws ElementoNaoEncontradoException {
		boolean achou = false;
		Iterator<RepositorioLista<Pessoa>> it = iterator();
		Pessoa p = null;
		RepositorioLista<Pessoa> repositorio = null;
		while (it.hasNext() && !achou) {
			try {
				repositorio = it.next();
				p = repositorio.getItem();
			} catch (NoSuchElementException e) {
				throw new ElementoNaoEncontradoException();
			}
			if (p != null && p.getCpf().equals(pessoa.getCpf())) {
				achou = true;
				repositorio.setItem(pessoa); // substitui a pessoa atual pelo
												// parametro passado.
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
	}

	public void remover(String cpf) throws ElementoNaoEncontradoException {
		Pessoa p = null;
		boolean achou = false;
		Iterator<RepositorioLista<Pessoa>> it = iterator();
		RepositorioLista<Pessoa> repositorioAtual = null;
		RepositorioLista<Pessoa> repositorioProximo = null;
		if (super.getProx().getItem().getCpf().equals(cpf)) {
			p = super.getProx().getItem();
			super.setProx(super.getProx().getProx());
			achou = true;
			} else {
			while (it.hasNext() && !achou) {
				try {
					repositorioAtual = ((IteratorLista<Pessoa>) it)
							.getRepositorio();
					repositorioProximo = it.next();
					p = repositorioProximo.getItem();
				} catch (NoSuchElementException e) {
					throw new ElementoNaoEncontradoException();
				}
				if (p != null && p.getCpf().equals(cpf)) {
					achou = true;
					System.out.println("achei " + p.getNome() + "\n\n");
					repositorioAtual.setProx(repositorioProximo.getProx());
				}
			}
		}
		/**if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		*/
	}

	public Iterator<RepositorioLista<Pessoa>> iterator() {
		IteratorLista<Pessoa> it = new IteratorLista<Pessoa>(super.getProx());
		return it;

	}

}
