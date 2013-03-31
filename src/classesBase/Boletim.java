package classesBase;

import dados.RepositorioArrayDisciplina;

public class Boletim {
	private RepositorioArrayDisciplina disciplinas;
	private double[][] notas;

	public Boletim(RepositorioArrayDisciplina d) { // quantidade de disciplinas
		disciplinas = d;
		notas = new double[d.getCont()][4];
	}

	public RepositorioArrayDisciplina getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(RepositorioArrayDisciplina disciplinas) {
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
			for (int j = 0; j < 4; j++) {
				retorno += " " + notas[i][j] + " ";
				sum += notas[i][j];
			}
			retorno += "Media = " + (sum / 4) + "\n";
		}
		return retorno;
	}

}
