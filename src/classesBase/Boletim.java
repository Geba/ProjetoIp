package classesBase;

import modificacoes.RepositorioArrayDisciplina2;

public class Boletim {
	private RepositorioArrayDisciplina2 disciplinas;
	private double[][] notas;

	public Boletim(RepositorioArrayDisciplina2 repositorioArrayDisciplina2) { // quantidade
																				// de
																				// disciplinas
		disciplinas = repositorioArrayDisciplina2;
		notas = new double[15][4];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 4; j++) {
				notas[i][j] = 0.0;
			}
		}
	}

	public RepositorioArrayDisciplina2 getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(RepositorioArrayDisciplina2 disciplinas) {
		this.disciplinas = disciplinas;
	}

	public double[][] getNotas() {
		return notas;
	}

	public void setNotas(double[][] notas) {
		this.notas = notas;
	}

	public String imprimir() {
		String retorno = "";
		double sum = 0;
		for (int i = 0; i < this.disciplinas.getCont(); i++) {
			retorno+=this.disciplinas.getArray()[i].getNome();
			for (int j = 0; j < 4; j++) {
				retorno += " " + notas[i][j] + " ";
				sum += notas[i][j];
			}
			retorno += "Media = " + (sum / 4) + "\n";
		}
		return retorno;
	}

}
