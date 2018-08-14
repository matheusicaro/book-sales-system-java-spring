package matheusicaro.com.github.store.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import matheusicaro.com.github.store.models.User;

@Repository
public class UserDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public User loadUserByUsername(String email) {
		System.out.println();

		List <User> users = 
				manager.createQuery("select u from User u where email = :email", User.class)
				.setParameter("email", email).getResultList();
		
		if(users.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + "não foi encontrado no sistema");
		}
		System.out.println();
		return users.get(0);
	}
	
	public void save(User user) {
	    manager.persist(user);
	}
	
}	