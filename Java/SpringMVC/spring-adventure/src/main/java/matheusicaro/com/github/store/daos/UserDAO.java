package matheusicaro.com.github.store.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import matheusicaro.com.github.store.models.UserAuth;

@Repository
public class UserDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public UserAuth loadUserByUsername(String email) {
		System.out.println();

		List <UserAuth> users = 
				manager.createQuery("select u from UserAuth u where email = :email", UserAuth.class)
				.setParameter("email", email).getResultList();
		
		if(users.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + "não foi encontrado no sistema");
		}
		System.out.println();
		return users.get(0);
	}
	
	public void save(UserAuth user) {
		manager.createNativeQuery("truncate userauth * cascade; truncate role *cascade").executeUpdate();
	    manager.persist(user);
	}
		
}	