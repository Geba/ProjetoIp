package modificacoes;

import java.util.Iterator;
import excecoes.ElementoNaoEncontradoException;
import classesBase.*;

public class RepositorioListaPessoa2 {

	private Pessoa pessoa;
	private RepositorioListaPessoa2 prox;

	public RepositorioListaPessoa2() {
		this.pessoa = null;
		this.prox = null;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public RepositorioListaPessoa2 getProx() {
		return this.prox;
	}

	public void setProx(RepositorioListaPessoa2 prox) {
		this.prox = prox;
	}

	public void inserir(Pessoa pessoa) {

		if (this.prox == null) {
			RepositorioListaPessoa2 novoRepositorio = new RepositorioListaPessoa2();
			novoRepositorio.setPessoa(pessoa);
			setProx(novoRepositorio);
		} else {
			getProx().inserir(pessoa);
		}
	}

	public String imprimir() {
		RepositorioListaPessoa2 repositorioAtual= this.prox;
		String resposta = "";
		while (repositorioAtual!= null) {
			resposta = resposta + repositorioAtual.getPessoa().getNome()+"\n";
			repositorioAtual=repositorioAtual.getProx();
		}
		return resposta;
	}

	public Pessoa procurar(String cpf) throws ElementoNaoEncontradoException {
		Pessoa p = null;
		boolean achou = false;
		// Iterator<RepositorioLista<Pessoa>> it = iterator();
		RepositorioListaPessoa2 repositorioAtual = this.prox;
		while (repositorioAtual != null && achou == false) {
			p = repositorioAtual.getPessoa();
			if (p.getCpf().equals(cpf)) {
				achou = true;
			}
			repositorioAtual = repositorioAtual.getProx();
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		return p;
		/**
		 * while (it.hasNext() && !achou) { try { p = it.next().getPessoa(); }
		 * catch (NoSuchElementException e) { throw new
		 * ElementoNaoEncontradoException(); } if (p != null &&
		 * p.getCpf().equals(cpf)) { achou = true; } } if (achou == false) {
		 * throw new ElementoNaoEncontradoException(); } return p;
		 */
	}

	public RepositorioArrayPessoa2 procurarNome(String nome)
			throws ElementoNaoEncontradoException {
		Pessoa p = null;
		boolean achou = false;
		RepositorioArrayPessoa2 resultado = new RepositorioArrayPessoa2();
		RepositorioListaPessoa2 repositorioAtual = this.prox;
		while (repositorioAtual != null) {
			p = repositorioAtual.getPessoa();
			if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
				achou = true;
				resultado.inserir(p);
			}
			repositorioAtual = repositorioAtual.getProx();
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		return resultado;
	}

	public void atualizar(Pessoa pessoa) throws ElementoNaoEncontradoException {

		boolean achou = false;
		Pessoa p = null;
		RepositorioListaPessoa2 repositorioAtual = this.prox;
		while ((repositorioAtual != null) && (achou == false)) {
			p = repositorioAtual.getPessoa();
			if (p.getCpf().equals(pessoa.getCpf())) {
				repositorioAtual.setPessoa(pessoa);
				achou = true;
			} else {
				repositorioAtual = repositorioAtual.getProx();
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		/**
		 * boolean achou = false; Iterator<RepositorioLista<Pessoa>> it =
		 * iterator(); Pessoa p = null; RepositorioLista<Pessoa> repositorio =
		 * null; while (it.hasNext() && !achou) { try { repositorio = it.next();
		 * p = repositorio.getPessoa(); } catch (NoSuchElementException e) {
		 * throw new ElementoNaoEncontradoException(); } if (p != null &&
		 * p.getCpf().equals(pessoa.getCpf())) { achou = true;
		 * repositorio.setPessoa(pessoa); // substitui a pessoa atual pelo //
		 * parametro passado. } } if (achou == false) { throw new
		 * ElementoNaoEncontradoException(); }
		 */
	}

	public void remover(String cpf) throws ElementoNaoEncontradoException {
		boolean achou = false;
		RepositorioListaPessoa2 repositorioAtual = null;
		RepositorioListaPessoa2 repositorioProximo = this.prox;
		if (this.prox.getPessoa().getCpf().equals(cpf)) {// Verifica se o
															// primeiro da lista
															// é aquele que eu
															// quero remover.
			this.prox = this.prox.getProx();
			achou = true;
		} else {
			repositorioAtual = this.prox;
			repositorioProximo = repositorioAtual.getProx();
			while (achou != true && repositorioProximo != null) {
				if (repositorioProximo.getPessoa().getCpf().equals(cpf)) {
					repositorioAtual.setProx(repositorioProximo.getProx());
					;
					achou = true;
				} else {
					repositorioAtual = repositorioProximo;
					repositorioProximo = repositorioProximo.getProx();
				}
			}
		}
		if (achou == false) {
			throw new ElementoNaoEncontradoException();
		}
		/**
		 * Pessoa p = null; boolean achou = false;
		 * Iterator<RepositorioLista<Pessoa>> it = iterator();
		 * RepositorioLista<Pessoa> repositorioAtual = null;
		 * RepositorioLista<Pessoa> repositorioProximo = null; if
		 * (getProx().getPessoa().getCpf().equals(cpf)) { p =
		 * getProx().getPessoa(); setProx(getProx().getProx()); achou = true; }
		 * else { while (it.hasNext() && !achou) { try { repositorioAtual =
		 * ((IteratorLista<Pessoa>) it) .getRepositorio(); repositorioProximo =
		 * it.next(); p = repositorioProximo.getPessoa(); } catch
		 * (NoSuchElementException e) { throw new
		 * ElementoNaoEncontradoException(); } if (p != null &&
		 * p.getCpf().equals(cpf)) { achou = true; System.out.println("achei " +
		 * p.getNome() + "\n\n");
		 * repositorioAtual.setProx(repositorioProximo.getProx()); } }
		 */

		/**
		 * if (achou == false) { throw new ElementoNaoEncontradoException(); }
		 */
	}

	public Iterator<RepositorioListaPessoa2> iterator() {
		IteratorListaPessoa2 it = new IteratorListaPessoa2(this.prox);//Passa como argumento o primeiro item da lista.
		return it;

	}

}
