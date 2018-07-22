package matheusicaro.com.github.gerenciador;

public class User {

	private String email;
	private String password;

	public User (String email, String senha) {
		this.email = email;
		this.password = senha;
	}

	public String getSenha() {
		return password;
	}

	public String getEmail() {
		return email;
	}

}
