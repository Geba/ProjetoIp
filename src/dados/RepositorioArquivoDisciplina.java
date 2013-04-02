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

public class RepositorioArquivoDisciplina implements Repositorio<Disciplina> {
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	int cont = 0;
	FileOutputStream stream;
	FileInputStream file;
	boolean abrir = false;

	public int getCont() {
		return this.cont;
	}

	public RepositorioArquivoDisciplina() {
		try {
			file = new FileInputStream(new File("planilha.xls"));
			this.wb = new HSSFWorkbook(file);
			sheet1 = wb.getSheet("Disciplinas");
			stream = new FileOutputStream("planilha.xls");
			stream.flush();
			stream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("n achou");
			wb = new HSSFWorkbook();
			this.sheet1 = wb.createSheet("Disciplinas");
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
			this.sheet1 = wb.createSheet("Disciplinas");
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

		this.lerPlanilha();
	}

	public void lerPlanilha() {
		Disciplina d = null;
		String nome, ementa;
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

				ementa = lerCelula(i, 1);

				if (!pulou) {

					nome = lerCelula(i, 0);
					d = new Disciplina(nome, ementa);
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
	public void gravarDisciplina(Disciplina d) {

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

		sheet1 = wb.getSheet("Disciplinas");

		// System.out.println("entrou no gravar pessoa");

		HSSFRow row = sheet1.createRow(cont);
		row.createCell((short) 0).setCellValue(d.getNome());
		row.createCell((short) 1).setCellValue(d.getEmenta());

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

	public void inserir(Disciplina item) throws RepositorioException {
		gravarDisciplina(item);
		++cont;

	}

	@SuppressWarnings("deprecation")
	public Disciplina procurar(String nome)
			throws ElementoNaoEncontradoException {
		Disciplina d = null;
		boolean achou = false;
		int i = 0;

		while (!achou && i < cont) {
			HSSFRow row = sheet1.createRow(i);
			HSSFCell cell = row.getCell((short) 0);
			if (cell.getStringCellValue().equalsIgnoreCase(nome)) {
				achou = true;
				HSSFCell cell2 = row.getCell((short) 1);
				d = new Disciplina(nome, cell2.getStringCellValue());
			} else {
				i++;
			}
		}
		if (!achou) {
			throw new ElementoNaoEncontradoException();
		}

		return d;
	}

	@Override
	public void atualizar(Disciplina item)
			throws ElementoNaoEncontradoException, RepositorioException {
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

		sheet1 = wb.getSheet("Disciplinas");
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
		for (int k = 0; k < 2; k++) {
			row2.getCell((short) k).setCellValue("");
		}

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
