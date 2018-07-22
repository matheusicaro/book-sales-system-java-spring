package matheusicaro.com.github.dao;

import java.util.HashMap;
import java.util.Map;

import matheusicaro.com.github.manager.User;

public class UserDAO {

	private final static Map<String, User> USERS = new HashMap<>();
	static {
		USERS.put("matheus@mat", new User("matheus@mat","icaro"));
		USERS.put("matheus2@mat", new User("matheus2@mat","icaro"));
	}

	public User searchForEmailPassword(String email, String password) {
		if (!USERS.containsKey(email))
			return null;

		User user = USERS.get(email);
		if (user.getSenha().equals(password))
			return user;
		
		return null;
	}

}
