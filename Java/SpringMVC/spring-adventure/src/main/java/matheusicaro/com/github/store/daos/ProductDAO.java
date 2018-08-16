package matheusicaro.com.github.store.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import matheusicaro.com.github.store.models.EnumTypePrice;
import matheusicaro.com.github.store.models.Product;

@Repository
@Transactional
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void toSave (Product product) {
		manager.persist(product);
	}
	
	public List<Product> getProductsList (){
		return manager.createQuery("select p from Product p", Product.class).getResultList();
	}
	
	public Product find(Integer id) {
	    return manager.createQuery("select distinct(p) from Product p join fetch p.prices prices where p.id = :id", Product.class).setParameter("id", id).getSingleResult();
	}
	
	public BigDecimal sumPriceType (EnumTypePrice typePrice) {
		TypedQuery<BigDecimal> query = manager.createQuery("select sum(price.value) from Product p "
				+ " join p.prices price where price.tipo = :typePrice", BigDecimal.class);
		
		return query.getSingleResult();
	}

	public void cleanProducts() {
		manager.createNativeQuery("truncate product * cascade").executeUpdate();
	}
}
