package matheusicaro.com.github.store.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import matheusicaro.com.github.store.controller.HomeController;
import matheusicaro.com.github.store.daos.ProductDAO;
import matheusicaro.com.github.store.infra.FileSaver;
import matheusicaro.com.github.store.models.ShoppingCart;

@EnableWebMvc
@ComponentScan(basePackageClasses = {
		HomeController.class,
		ProductDAO.class,
		FileSaver.class,
		ShoppingCart.class
		})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver InternalResourceView() {

	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    
	    resolver.setExposedContextBeanNames("shoppingCart");	// Bean available for viewing in the view.
	    
	    return resolver;
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource =
	        new ReloadableResourceBundleMessageSource();

	    messageSource.setBasename("/WEB-INF/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(1);

	    return messageSource;
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
	    DefaultFormattingConversionService conversionService = 
	        new DefaultFormattingConversionService();
	    DateFormatterRegistrar registrar = new DateFormatterRegistrar();
	    registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
	    registrar.registerFormatters(conversionService);

	    return conversionService;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}
	
	// handle static configuration, performance, and tomcat resources.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}
}
