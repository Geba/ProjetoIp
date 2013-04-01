package classesBase;

public class Administrador extends Empregado {
	private String login;
	private String senha;

	public Administrador(String cpf, String nome, String dataNasc, String identidade,
			String sexo, Endereco endereco, String funcao,
			String login) {
		super(cpf, nome, dataNasc, identidade, sexo, endereco, funcao);
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
