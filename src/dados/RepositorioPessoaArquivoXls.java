package dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.FileInputStream;

//import modificacoes.RepositorioArrayPessoa2;

import modificacoes.RepositorioArrayPessoa2;

import org.apache.poi.hssf.usermodel.*;

import classesBase.*;
import excecoes.ElementoNaoEncontradoException;
import excecoes.RepositorioException;

public class RepositorioPessoaArquivoXls implements Repositorio<Pessoa> {

	private RepositorioArrayPessoa2 pessoas;
	HSSFWorkbook wb;
	HSSFSheet sheet1;
	int cont = 0;
	FileOutputStream stream;
	FileInputStream file;
	boolean abrir = false;

	// boolean primeiravez = true;

	public RepositorioPessoaArquivoXls() {

		try {
			file = new FileInputStream(new File("planilha.xls"));
			this.wb = new HSSFWorkbook(file);
			sheet1 = wb.getSheet("Pessoas");
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
			this.sheet1 = wb.createSheet("Pessoas");
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

		pessoas = new RepositorioArrayPessoa2();
		this.lerPlanilha();

	}

	public void lerPlanilha() {

		Pessoa pessoa = null;
		String senha, nomeTurma, cpf, nome, rg, sexo, pai, mae, rua, numero, bairro, cep, cidade, estado, pais, numeroMatricula, funcao, login;
		double salario = 0.0;
		double tipoPessoa = 0.0;
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
				System.out.println("acabou");
			}
			if (cell != null) {

				try {
					tipoPessoa = Integer.parseInt(lerCelula(i, 0));
				} catch (NumberFormatException e) {
					HSSFCell cell1 = row.getCell((short) 0);
					try {
						tipoPessoa = cell1.getNumericCellValue();
					} catch (NumberFormatException e1) {
						System.out.print("achou um vazio");
						pulou = true;
					}
				}

				if (!pulou) {

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
					login = lerCelula(i, 18);
					try {
						senha = lerCelula(i, 19);
					} catch (NumberFormatException e) {
						HSSFCell cell7 = row.getCell((short) 19);
						senha = "" + (int) cell7.getNumericCellValue();
					}
					try {
						String sal = lerCelula(i, 20);
						if (!sal.equals("")) {
							salario = Double.parseDouble(lerCelula(i, 20));
						}
					} catch (NumberFormatException e) {
						HSSFCell cell7 = row.getCell((short) 20);
						salario = cell7.getNumericCellValue();
					}
					Endereco end = new Endereco(rua, numero, bairro, cep,
							cidade, estado, pais);
					Turma turma = new Turma(nomeTurma);

					switch ((int) tipoPessoa) {
					case 1:
						pessoa = new Aluno(cpf, nome, dataNasc, rg, sexo, end,
								pai, mae, turma);
						((Aluno) pessoa).setNumeroMatricula(numeroMatricula);
						// System.out.println("criou um aluno");
						break;
					case 2:
						pessoa = new Administrador(cpf, nome, dataNasc, rg,
								sexo, end, funcao, login);
						((Administrador) pessoa).setSalario(salario);
						((Administrador) pessoa).setSenha(senha);
						// System.out.println("criou um adm");
						break;
					case 3:
						pessoa = new Professor(cpf, nome, dataNasc, rg, sexo,
								end, funcao, login);
						((Professor) pessoa).setSalario(salario);
						((Professor) pessoa).setSenha(senha);
						// System.out.println("criou um prof");
						break;
					case 4:
						pessoa = new Funcionario(cpf, nome, dataNasc, rg, sexo,
								end, funcao);
						((Funcionario) pessoa).setSalario(salario);
						// System.out.println("criou um func");
					}
					pessoas.inserir(pessoa);
					i++;
					cont++;
				} else {
					i++;
				}
			} else {
				acabou = true;
			}
		}

	}

	public RepositorioArrayPessoa2 getPessoas() {
		return pessoas;
	}

	@SuppressWarnings("deprecation")
	public void gravarPessoa(Pessoa p) {
		/**
		 * try { file = new FileInputStream(new File("planilha.xls")); this.wb =
		 * new HSSFWorkbook(file); stream = new
		 * FileOutputStream("planilha.xls"); } catch (FileNotFoundException e1)
		 * { System.out.println("erro1"); } catch (IOException e) {
		 * System.out.println("erro2"); }
		 * 
		 * sheet1 = wb.getSheet("Pessoas");
		 */

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

		sheet1 = wb.getSheet("Pessoas");

		// System.out.println("entrou no gravar pessoa");

		if (p instanceof Aluno) {
			HSSFRow row = sheet1.createRow(cont);
			// System.out.println("entrou no gravar pessoa aluno >" + cont);

			row.createCell((short) 0).setCellValue("1");
			row.createCell((short) 1).setCellValue(p.getCpf());
			row.createCell((short) 2).setCellValue(p.getNome());
			row.createCell((short) 3).setCellValue(p.getDataNasc());
			row.createCell((short) 4).setCellValue(p.getIdentidade());
			row.createCell((short) 5).setCellValue(p.getSexo());
			row.createCell((short) 6).setCellValue(p.getEndereco().getRua());
			row.createCell((short) 7).setCellValue(p.getEndereco().getNumero());
			row.createCell((short) 8).setCellValue(p.getEndereco().getBairro());
			row.createCell((short) 9).setCellValue(p.getEndereco().getCep());
			row.createCell((short) 10)
					.setCellValue(p.getEndereco().getCidade());
			row.createCell((short) 11)
					.setCellValue(p.getEndereco().getEstado());
			row.createCell((short) 12).setCellValue(p.getEndereco().getPais());
			row.createCell((short) 13).setCellValue(((Aluno) p).getPai());
			row.createCell((short) 14).setCellValue(((Aluno) p).getMae());
			row.createCell((short) 15).setCellValue(
					((Aluno) p).getNumeroMatricula());
			row.createCell((short) 16).setCellValue(
					((Aluno) p).getTurma().getNome());
			row.createCell((short) 17).setCellValue("");
			row.createCell((short) 18).setCellValue("");
			row.createCell((short) 19).setCellValue("");
			row.createCell((short) 20).setCellValue("");
		} else if (p instanceof Administrador) {
			HSSFRow row = sheet1.createRow(cont);
			// System.out.println("entrou no gravar pessoa admo >" + cont);
			row.createCell((short) 0).setCellValue("2");
			row.createCell((short) 1).setCellValue(p.getCpf());
			row.createCell((short) 2).setCellValue(p.getNome());
			row.createCell((short) 3).setCellValue(p.getDataNasc());
			row.createCell((short) 4).setCellValue(p.getIdentidade());
			row.createCell((short) 5).setCellValue(p.getSexo());
			row.createCell((short) 6).setCellValue(p.getEndereco().getRua());
			row.createCell((short) 7).setCellValue(p.getEndereco().getNumero());
			row.createCell((short) 8).setCellValue(p.getEndereco().getBairro());
			row.createCell((short) 9).setCellValue(p.getEndereco().getCep());
			row.createCell((short) 10)
					.setCellValue(p.getEndereco().getCidade());
			row.createCell((short) 11)
					.setCellValue(p.getEndereco().getEstado());
			row.createCell((short) 12).setCellValue(p.getEndereco().getPais());
			row.createCell((short) 13).setCellValue("");
			row.createCell((short) 14).setCellValue("");
			row.createCell((short) 15).setCellValue("");
			row.createCell((short) 16).setCellValue("");
			row.createCell((short) 17).setCellValue(
					((Administrador) p).getFuncao());
			row.createCell((short) 18).setCellValue(
					((Administrador) p).getLogin());
			row.createCell((short) 19).setCellValue(
					((Administrador) p).getSenha());
			row.createCell((short) 20).setCellValue(
					((Administrador) p).getSalario());
		} else if (p instanceof Professor) {
			HSSFRow row2 = sheet1.createRow(cont);
			// System.out.println("entrou no gravar pessoa profo >" + cont);
			row2.createCell((short) 0).setCellValue("3");
			row2.createCell((short) 1).setCellValue(p.getCpf());
			row2.createCell((short) 2).setCellValue(p.getNome());
			row2.createCell((short) 3).setCellValue(p.getDataNasc());
			row2.createCell((short) 4).setCellValue(p.getIdentidade());
			row2.createCell((short) 5).setCellValue(p.getSexo());
			row2.createCell((short) 6).setCellValue(p.getEndereco().getRua());
			row2.createCell((short) 7)
					.setCellValue(p.getEndereco().getNumero());
			row2.createCell((short) 8)
					.setCellValue(p.getEndereco().getBairro());
			row2.createCell((short) 9).setCellValue(p.getEndereco().getCep());
			row2.createCell((short) 10).setCellValue(
					p.getEndereco().getCidade());
			row2.createCell((short) 11).setCellValue(
					p.getEndereco().getEstado());
			row2.createCell((short) 12).setCellValue(p.getEndereco().getPais());
			row2.createCell((short) 13).setCellValue("");
			row2.createCell((short) 14).setCellValue("");
			row2.createCell((short) 15).setCellValue("");
			row2.createCell((short) 16).setCellValue("");
			row2.createCell((short) 17).setCellValue(
					((Professor) p).getFuncao());
			row2.createCell((short) 18)
					.setCellValue(((Professor) p).getLogin());
			row2.createCell((short) 19)
					.setCellValue(((Professor) p).getSenha());
			row2.createCell((short) 20).setCellValue(
					((Professor) p).getSalario());
		} else if (p instanceof Funcionario) {
			HSSFRow row = sheet1.createRow(cont);
			// System.out.println("entrou no gravar pessoa funco >" + cont);
			row.createCell((short) 0).setCellValue("4");
			row.createCell((short) 1).setCellValue(p.getCpf());
			row.createCell((short) 2).setCellValue(p.getNome());
			row.createCell((short) 3).setCellValue(p.getDataNasc());
			row.createCell((short) 4).setCellValue(p.getIdentidade());
			row.createCell((short) 5).setCellValue(p.getSexo());
			row.createCell((short) 6).setCellValue(p.getEndereco().getRua());
			row.createCell((short) 7).setCellValue(p.getEndereco().getNumero());
			row.createCell((short) 8).setCellValue(p.getEndereco().getBairro());
			row.createCell((short) 9).setCellValue(p.getEndereco().getCep());
			row.createCell((short) 10)
					.setCellValue(p.getEndereco().getCidade());
			row.createCell((short) 11)
					.setCellValue(p.getEndereco().getEstado());
			row.createCell((short) 12).setCellValue(p.getEndereco().getPais());
			row.createCell((short) 13).setCellValue("");
			row.createCell((short) 14).setCellValue("");
			row.createCell((short) 15).setCellValue("");
			row.createCell((short) 16).setCellValue("");
			row.createCell((short) 17).setCellValue(
					((Funcionario) p).getFuncao());
			row.createCell((short) 18).setCellValue("");
			row.createCell((short) 19).setCellValue("");
			row.createCell((short) 20).setCellValue(
					((Funcionario) p).getSalario());
		}
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

	public void inserir(Pessoa item) throws RepositorioException {
		pessoas.inserir(item);
		gravarPessoa(item);
		++cont;
	}

	@SuppressWarnings("deprecation")
	public String lerCelula(int linha, int coluna) {
		HSSFRow row = this.sheet1.getRow(linha);
		HSSFCell cell = row.getCell((short) coluna);
		return cell.getStringCellValue();

	}

	public Pessoa procurar(String cpf) throws ElementoNaoEncontradoException {
		Pessoa pessoa = pessoas.procurar(cpf);
		Pessoa p = null;
		String senha, nomeTurma, cpf2, nome2 = "", rg, sexo, pai, mae, rua, numero, bairro, cep, cidade, estado, pais, numeroMatricula, funcao, login;
		double salario = 0.0;

		int i = pessoas.procurarIndice(cpf);
		HSSFRow row = this.sheet1.getRow(i);
		double tipoPessoa = 0.0;

		System.out.println("try");
		try {
			tipoPessoa = Integer.parseInt(lerCelula(i, 0));
		} catch (NumberFormatException e) {
			HSSFCell cell1 = row.getCell((short) 0);
			try {
				tipoPessoa = cell1.getNumericCellValue();
			} catch (NumberFormatException e1) {
				System.out.print("achou um vazio");
				// pulou = true;
			}
		}

		try {
			cpf2 = lerCelula(i, 1);
		} catch (NumberFormatException e) {
			HSSFCell cell2 = row.getCell((short) 1);
			cpf2 = "" + (int) cell2.getNumericCellValue();
		}

		nome2 = lerCelula(i, 2);
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
		login = lerCelula(i, 18);
		try {
			senha = lerCelula(i, 19);
		} catch (NumberFormatException e) {
			HSSFCell cell7 = row.getCell((short) 19);
			senha = "" + (int) cell7.getNumericCellValue();
		}
		try {
			salario = Double.parseDouble(lerCelula(i, 20));
		} catch (NumberFormatException e) {
			HSSFCell cell7 = row.getCell((short) 20);
			salario = cell7.getNumericCellValue();
		}

		Endereco end = new Endereco(rua, numero, bairro, cep, cidade, estado,
				pais);
		Turma turma = new Turma(nomeTurma);

		switch ((int) tipoPessoa) {
		case 1:
			pessoa = new Aluno(cpf2, nome2, dataNasc, rg, sexo, end, pai, mae,
					turma);
			((Aluno) pessoa).setNumeroMatricula(numeroMatricula);
			// System.out.println("criou um aluno");
			break;
		case 2:
			pessoa = new Administrador(cpf2, nome2, dataNasc, rg, sexo, end,
					funcao, login);
			((Administrador) pessoa).setSalario(salario);
			((Administrador) pessoa).setSenha(senha);
			// System.out.println("criou um adm");
			break;
		case 3:
			pessoa = new Professor(cpf2, nome2, dataNasc, rg, sexo, end,
					funcao, login);
			((Professor) pessoa).setSalario(salario);
			((Professor) pessoa).setSenha(senha);
			// System.out.println("criou um prof");
			break;
		case 4:
			pessoa = new Funcionario(cpf2, nome2, dataNasc, rg, sexo, end,
					funcao);
			((Funcionario) pessoa).setSalario(salario);
			// System.out.println("criou um func");
		}

		return p;
	}

	@Override
	public void atualizar(Pessoa item) throws ElementoNaoEncontradoException,
			RepositorioException {
		pessoas.atualizar(item);
		pessoas.remover(item.getCpf());
		System.out.println("att");
		inserir(item);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void remover(String cpf) throws ElementoNaoEncontradoException,
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

		sheet1 = wb.getSheet("Pessoas");

		int i = pessoas.procurarIndice(cpf);

		System.out.println(i);

		HSSFRow row = sheet1.getRow(i);
		for (int k = 0; k < 19; k++) {
			row.getCell((short) k).setCellValue("");
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

		pessoas.remover(cpf);
	}

	public String imprimir() {
		String retorno = "";

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

		sheet1 = wb.getSheet("Pessoas");

		for (int i = 0; i < cont; i++) {
			HSSFRow row = this.sheet1.getRow(i);
			String cpf, rg;
			try {
				cpf = lerCelula(i, 1);
			} catch (NumberFormatException e) {
				HSSFCell cell2 = row.getCell((short) 1);
				cpf = "" + (int) cell2.getNumericCellValue();
			}

			String nome = lerCelula(i, 2);
			String dataNasc = lerCelula(i, 3);
			try {
				rg = lerCelula(i, 4);
			} catch (NumberFormatException e) {
				HSSFCell cell4 = row.getCell((short) 4);
				rg = "" + (int) cell4.getNumericCellValue();
			}
			if (!nome.equals("")) {
				retorno += nome + " / " + cpf + " / " + rg + " / " + dataNasc
						+ "\n";
			}
		}

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
		return retorno;
	}

}
