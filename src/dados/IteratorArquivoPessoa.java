package dados;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import classesBase.*;

public class IteratorArquivoPessoa extends IteratorArquivo<Pessoa> implements
		Iterator<Pessoa> {

	public IteratorArquivoPessoa(String aba) {
		super(aba);
		// fechar();
	}

	public Pessoa next() {
		// super.abrir();

		Pessoa pessoa = null;
		if (hasNext()) {

			String telefone = "", nomeTurma, cpf, nome, rg, sexo, pai, mae, rua, numero, bairro, cep, cidade, estado, pais, numeroMatricula, funcao;
			double salario = 0.0;
			double tipoPessoa = 0.0;
			HSSFRow row = null;

			int i = super.indiceAtual;
			try {
				row = this.sheet1.getRow(i);
			} catch (IndexOutOfBoundsException e) {
				i++;
				row = this.sheet1.getRow(i);
			}
			try {
				tipoPessoa = Integer.parseInt(lerCelula(i, 0));
			} catch (NumberFormatException e) {
				HSSFCell cell1 = row.getCell((short) 0);
				try {
					tipoPessoa = cell1.getNumericCellValue();
				} catch (NumberFormatException e1) {
					System.out.print("pulouIteratorArqPessoa");
				}
			}

			try {
				cpf = lerCelula(i, 1);
			} catch (NumberFormatException e) {
				HSSFCell cell2 = row.getCell((short) 1);
				cpf = "" + (int) cell2.getNumericCellValue();
			}

			nome = lerCelula(i, 2);
			String dataNasc = lerCelula(i, 3);
			try {
				rg = lerCelula(i, 4);
			} catch (NumberFormatException e) {
				HSSFCell cell4 = row.getCell((short) 4);
				rg = "" + (int) cell4.getNumericCellValue();
			}
			sexo = lerCelula(i, 5);
			rua = lerCelula(i, 6);
			numero = lerCelula(i, 7);
			bairro = lerCelula(i, 8);
			try {
				cep = lerCelula(i, 9);
			} catch (NumberFormatException e) {
				HSSFCell cell5 = row.getCell((short) 9);
				cep = "" + (int) cell5.getNumericCellValue();
			}
			cidade = lerCelula(i, 10);
			estado = lerCelula(i, 11);
			pais = lerCelula(i, 12);
			pai = lerCelula(i, 13);
			mae = lerCelula(i, 14);
			numeroMatricula = lerCelula(i, 15);
			nomeTurma = lerCelula(i, 16);
			funcao = lerCelula(i, 17);
			try {
				String sal = lerCelula(i, 18);
				if (!sal.equals("")) {
					salario = Double.parseDouble(lerCelula(i, 18));
				} else {
					salario = 0.0;
				}
			} catch (NumberFormatException e) {
				HSSFCell cell7 = row.getCell((short) 18);
				salario = cell7.getNumericCellValue();
			}
			try {
				String tel = lerCelula(i, 19);
				if (!tel.equals("")) {
					telefone = lerCelula(i, 19);
				}
			} catch (NumberFormatException e) {
				HSSFCell cell7 = row.getCell((short) 19);
				telefone = "" + cell7.getNumericCellValue();
			}

			i--;

			Endereco end = new Endereco(rua, numero, bairro, cep, cidade,
					estado, pais);
			Turma turma = new Turma(nomeTurma);

			switch ((int) tipoPessoa) {
			case 1:
				pessoa = new Aluno(cpf, nome, dataNasc, rg, sexo, telefone,
						end, pai, mae, turma);
				((Aluno) pessoa).setNumeroMatricula(numeroMatricula);
				// System.out.println("criou um aluno");
				break;
			case 2:
				pessoa = new Administrador(cpf, nome, dataNasc, rg, sexo,
						telefone, end, funcao);
				((Administrador) pessoa).setSalario(salario);

				// System.out.println("criou um adm");
				break;
			case 3:
				pessoa = new Professor(cpf, nome, dataNasc, rg, sexo, telefone,
						end, funcao);
				((Professor) pessoa).setSalario(salario);
				// System.out.println("criou um prof");
				break;
			case 4:
				pessoa = new Funcionario(cpf, nome, dataNasc, rg, sexo,
						telefone, end, funcao);
				((Funcionario) pessoa).setSalario(salario);
			}
			// pessoas.inserir(pessoa);
		}
		// super.fechar();
		return pessoa;
	}

	@SuppressWarnings("deprecation")
	public String lerCelula(int linha, int coluna) {
		HSSFRow row = this.sheet1.getRow(linha);
		HSSFCell cell = row.getCell((short) coluna);
		return cell.getStringCellValue();

	}

}
