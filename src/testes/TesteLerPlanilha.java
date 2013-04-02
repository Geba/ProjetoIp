package testes;

import java.io.*;

public class TesteLerPlanilha {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		FileReader arq;
		String linha="";
		try {
			arq = new FileReader("config.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			linha = lerArq.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("erro1");
		} catch (IOException e) {
			System.out.println("erro2");
		}
		System.out.println(linha);

	}
}
