package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import modificacoes.RepositorioArrayDisciplina2;
import modificacoes.RepositorioArrayPessoa2;
import modificacoes.RepositorioArrayTurma2;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import classesBase.*;
import excecoes.ElementoNaoEncontradoException;
import excecoes.RepositorioException;

public class RepositorioArquivoTurma implements Repositorio<Turma> {

	private RepositorioArrayTurma2 turmas;
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	int cont = 0;
	FileOutputStream stream;
	FileInputStream file;
	boolean abrir = false;

	// boolean primeiravez = true;

	public int getCont() {
		return this.cont;
	}

	public RepositorioArquivoTurma() {

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
			this.sheet1 = wb.createSheet("Turmas");
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

		turmas = new RepositorioArrayTurma2();
		this.lerPlanilha();

	}

	public void lerPlanilha() {

		Turma turma = null;

		String nome;
		RepositorioArquivoDisciplina disciplinas = new RepositorioArquivoDisciplina();
		int i = 0;
		boolean acabou = false;

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
		gravarTurma(item);
		cont++;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Turma procurar(String nome) throws ElementoNaoEncontradoException {
		Turma t = null;
		boolean achou = false;
		int i = 0;

		while (!achou && i < cont) {
			HSSFRow row = sheet1.createRow(i);
			HSSFCell cell = row.getCell((short) 0);
			if (cell.getStringCellValue().equalsIgnoreCase(nome)) {
				achou = true;
				t = new Turma(nome);
			} else {
				i++;
			}
		}
		if (!achou) {
			throw new ElementoNaoEncontradoException();
		}
		return t;
	}

	@Override
	public void atualizar(Turma item) throws ElementoNaoEncontradoException,
			RepositorioException {
		remover(item.getNome());
		inserir(item);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void remover(String nome) throws ElementoNaoEncontradoException,
			RepositorioException {

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
		boolean achou = false;
		int i = 0, aux = 0;
		while (!achou) {
			HSSFRow row = sheet1.getRow(i);
			HSSFCell cell = row.getCell((short) 0);
			if (cell.getStringCellValue().equals(nome)) {
				achou = true;
				aux = i;
			} else {
				i++;
			}
		}
		HSSFRow row2 = sheet1.getRow(aux);
		row2.getCell((short) 0).setCellValue("");

		try {
			wb.write(stream);
		} catch (IOException e1) {
			System.out.println("erro no stream");
		}
		try {
			stream.flush();
		} catch (IOException e2) {
			System.out.println("erro flush");
		}
		try {
			stream.close();
		} catch (IOException e3) {
			System.out.println("erro close");
		}

	}

}
