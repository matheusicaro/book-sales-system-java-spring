package matheusicaro.com.github.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import matheusicaro.com.github.store.controller.HomeController;
import matheusicaro.com.github.store.daos.ProductDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses = {
		HomeController.class,
		ProductDAO.class	
		})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver InternalResourceView() {

	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}

}
