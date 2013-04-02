package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import classesBase.*;
import excecoes.ElementoNaoEncontradoException;
import excecoes.RepositorioException;

public class RepositorioTurmaArquivoXls implements Repositorio<Turma> {

	private RepositorioArrayTurma turmas;
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	int cont = 0;
	FileOutputStream stream;
	FileInputStream file;
	boolean abrir = false;

	// boolean primeiravez = true;

	public RepositorioTurmaArquivoXls() {

		try {
			file = new FileInputStream(new File("planilha.xls"));
			this.wb = new HSSFWorkbook(file);
			sheet1 = wb.getSheet("Turmas");
			stream = new FileOutputStream("planilha.xls");
			stream.flush();
			stream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("n achou");
			wb = new HSSFWorkbook();
			this.sheet1 = wb.createSheet("Pessoas");
			try {
				stream = new FileOutputStream("planilha.xls");
				wb.write(stream);
				stream.flush();
				stream.close();
			} catch (FileNotFoundException e) {
				System.out.println("erro dentro");
			} catch (IOException e) {
				System.out.println("erro dentro");
			}
			abrir = true;
		} catch (IOException e) {
			System.out.println("n achou");
			wb = new HSSFWorkbook();
			this.sheet1 = wb.createSheet("Turmas");
			try {
				stream = new FileOutputStream("planilha.xls");
				wb.write(stream);
				stream.flush();
				stream.close();
			} catch (FileNotFoundException g) {
				System.out.println("erro dentro");
			} catch (IOException f) {
				System.out.println("erro dentro");
			}
			abrir = true;
		}

		turmas = new RepositorioArrayTurma();
		this.lerPlanilha();

	}

	public void lerPlanilha() {

		Turma turma = null;

		String nome;
		RepositorioArrayPessoa alunos;
		RepositorioArrayDisciplina disciplinas;
		int i = 0;
		boolean acabou = false;
		String str="";

		while (!acabou) {
			HSSFRow row = this.sheet1.getRow(i);
			HSSFCell cell = null;
			boolean pulou = false;
			try {
				cell = row.getCell((short) 0);
			} catch (NullPointerException e) {
				acabou = true;
				// System.out.println("acabou");
			}
			if (cell != null) {

				try {
					nome = lerCelula(i, 0);
				} catch (NumberFormatException e) {
					HSSFCell cell1 = row.getCell((short) 0);
					try {
						nome = "" + cell1.getNumericCellValue();
					} catch (NumberFormatException e1) {
						// System.out.print("achou um vazio");
						pulou = true;
					}
				}

				if (!pulou) {

					nome = lerCelula(i, 0);
					turma = new Turma(nome);
					this.turmas.inserir(turma);
					i++;
					cont++;
				} else {
					acabou = true;
				}
			} else {
				acabou = true;
			}
		}

	}

	@SuppressWarnings("deprecation")
	public String lerCelula(int linha, int coluna) {
		HSSFRow row = this.sheet1.getRow(linha);
		HSSFCell cell = row.getCell((short) coluna);
		return cell.getStringCellValue();
	}

	@SuppressWarnings("deprecation")
	public void gravarTurma(Turma turma) {

		try {
			file = new FileInputStream(new File("planilha.xls"));
		} catch (FileNotFoundException e1) {
			// System.out.println("erro1");
		}

		try {
			this.wb = new HSSFWorkbook(file);
		} catch (IOException e1) {
			// System.out.println("erro2");
			// System.out.println(e1.getMessage());
		}

		try {
			stream = new FileOutputStream("planilha.xls");
		} catch (FileNotFoundException e1) {
			// System.out.println("erro3");
		}

		sheet1 = wb.getSheet("Turmas");

		// System.out.println("entrou no gravar pessoa");

		HSSFRow row = sheet1.createRow(cont);
		row.createCell((short) 0).setCellValue(turma.getNome());

		try {
			wb.write(stream);
		} catch (IOException e) {
			System.out.println("erro no stream");
		}
		try {
			stream.flush();
		} catch (IOException e) {
			System.out.println("erro flush");
		}
		try {
			stream.close();
		} catch (IOException e) {
			System.out.println("erro close");
		}
	}

	public void inserir(Turma item) throws RepositorioException {
		// TODO Auto-generated method stub

	}

	@Override
	public Turma procurar(String procura) throws ElementoNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Turma item) throws ElementoNaoEncontradoException,
			RepositorioException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(String remover) throws ElementoNaoEncontradoException,
			RepositorioException {
		// TODO Auto-generated method stub

	}

}
