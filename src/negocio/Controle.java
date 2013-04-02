package negocio;

import classesBase.Turma;

public class Controle {

	public Controle() {

	}

	public static boolean inserirAluno(String cpf, String nome,
			String dataNasc, String rg, String sexo, String telefone,
			String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String nomeDoPai,
			String nomeDaMae, Turma turma) {
		boolean pode = true;
		if (cpf == null || cpf == "") {
			pode = false;
		} else if (nome == null || nome == "") {
			pode = false;
		} else if (rg == null || rg == "") {
			pode = false;
		} else if (cpf.length() < 11) {
			pode = false;
		} else if (rg.length() < 4) {
			pode = false;
		} else if (nome.length() < 5) {
			pode = false;
		} else if (dataNasc.length() != 10) {
			pode = false;
		} else if (dataNasc.charAt(2) != '/' || dataNasc.charAt(5) != '/') {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(0, 2))) > 31) {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(3, 5))) > 12) {
			pode = false;
		} else if (telefone.length() < 8) {
			pode = false;
		}

		return pode;
	}

	public static boolean inserirProfessor(String cpf, String nome,
			String dataNasc, String rg, String sexo, String telefone,
			String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String funcao) {

		boolean pode = true;
		if (cpf == null || cpf == "") {
			pode = false;
		} else if (nome == null || nome == "") {
			pode = false;
		} else if (rg == null || rg == "") {
			pode = false;
		} else if (cpf.length() < 11) {
			pode = false;
		} else if (rg.length() < 4) {
			pode = false;
		} else if (nome.length() < 5) {
			pode = false;
		}

		else if (dataNasc.length() != 10) {
			pode = false;
		} else if (dataNasc.charAt(2) != '/' || dataNasc.charAt(5) != '/') {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(0, 2))) > 31) {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(3, 5))) > 12) {
			pode = false;
		} else if (telefone.length() < 8) {
			pode = false;
		}
		return pode;
	}

	public static boolean inserirAdministrador(String cpf, String nome,
			String dataNasc, String rg, String sexo, String telefone,
			String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String funcao) {

		boolean pode = true;
		if (cpf == null || cpf == "") {
			pode = false;
		} else if (nome == null || nome == "") {
			pode = false;
		} else if (rg == null || rg == "") {
			pode = false;
		} else if (cpf.length() < 11) {
			pode = false;
		} else if (rg.length() < 4) {
			pode = false;
		} else if (nome.length() < 5) {
			pode = false;
		} else if (dataNasc.length() != 10) {
			pode = false;
		} else if (dataNasc.charAt(2) != '/' || dataNasc.charAt(5) != '/') {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(0, 2))) > 31) {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(3, 5))) > 12) {
			pode = false;
		} else if (telefone.length() < 8) {
			pode = false;
		}
		return pode;
	}

	public static boolean inserirFuncionario(String cpf, String nome,
			String dataNasc, String rg, String sexo, String telefone,
			String rua, String numero, String bairro, String cep,
			String cidade, String estado, String pais, String funcao) {
		boolean pode = true;
		if (cpf == null || cpf == "") {
			pode = false;
		} else if (nome == null || nome == "") {
			pode = false;
		} else if (rg == null || rg == "") {
			pode = false;
		} else if (cpf.length() < 11) {
			pode = false;
		} else if (rg.length() < 4) {
			pode = false;
		} else if (nome.length() < 5) {
			pode = false;
		} else if (telefone.length() < 8) {
			pode = false;
		}

		else if (dataNasc.length() != 10) {
			pode = false;
		} else if (dataNasc.charAt(2) != '/' || dataNasc.charAt(5) != '/') {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(0, 2))) > 31) {
			pode = false;
		} else if ((Integer.parseInt(dataNasc.substring(3, 5))) > 12) {
			pode = false;
		}
		return pode;
	}

	public static boolean cpfValido(String cpf) {
		boolean pode = true;
		double cpf2;

		try {
			cpf2 = Double.parseDouble(cpf);
		} catch (NumberFormatException e) {
			pode = false;
			cpf2 = 0.0;
		}

		if (cpf.length() < 11) {
			pode = false;
		}
		if (cpf2 == 0.0) {
			pode = false;
		}

		return pode;
	}

	public static boolean nomeValido(String nome) {
		boolean pode = true;
		if (nome.length() < 3 || nome == null) {
			pode = false;
		}
		return pode;

	}

}
