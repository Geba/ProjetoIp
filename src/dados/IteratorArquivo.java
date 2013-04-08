package dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class IteratorArquivo<T> implements Iterator<T> {
	int indiceAtual;
	
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	int cont = 0;
	FileOutputStream stream;
	FileInputStream file;

	public IteratorArquivo(String arq, String aba) {
		
		try {
			file = new FileInputStream(new File(arq));
			this.wb = new HSSFWorkbook(file);
			sheet1 = wb.getSheet(aba);
			stream = new FileOutputStream(arq);
			stream.flush();
			stream.close();
		} catch (FileNotFoundException e1) {
			//System.out.println("n achou");
			wb = new HSSFWorkbook();
			this.sheet1 = wb.createSheet(aba);
			try {
				stream = new FileOutputStream(arq);
				wb.write(stream);
				stream.flush();
				stream.close();
			} catch (FileNotFoundException e) {
				//System.out.println("erro dentro");
			} catch (IOException e) {
				//System.out.println("erro dentro");
			}
			//abrir = true;
		} catch (IOException e) {
			//System.out.println("n achou");
			wb = new HSSFWorkbook();
			this.sheet1 = wb.createSheet(aba);
			try {
				stream = new FileOutputStream(arq);
				wb.write(stream);
				stream.flush();
				stream.close();
			} catch (FileNotFoundException g) {
				//System.out.println("erro dentro");
			} catch (IOException f) {
				//System.out.println("erro dentro");
			}
			//abrir = true;
		}
		
	}

	public boolean hasNext() {
		boolean retorno=false;
		
		//return indiceAtual < array.length;
		return retorno;
	}

	public T next() {
		
return null;

	}

	public void remove() {
		throw new UnsupportedOperationException(
				"Esta operacao nao é suportada.");
	}

	public int getIndice() {
		return indiceAtual;
	}
}
