package matheusicaro.com.github.store.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import matheusicaro.com.github.store.models.Product;

@Repository
@Transactional
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager mananger;
	
	public void toSave (Product product) {
		mananger.persist(product);
	}

}
