package matheusicaro.com.github.store.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import matheusicaro.com.github.store.models.PaymantData;
import matheusicaro.com.github.store.models.ShoppingCart;

@RequestMapping("/payment")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PaymentController {

	@Autowired
	ShoppingCart cart;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/finalize", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizeBuyItem(RedirectAttributes model) {	// CALLABLE is an implementation of spring in which it enables
																				// work asynchronously without crashing the server. For each user
																				// entering this method, the payment, a thread is opened for the
																				// user to wait for payment while others can browse the server.
		return () -> {  //Lambda necessary for implemention this CALLABLE
			String uri = "http://book-payment.herokuapp.com/payment";

			try {
				String response = restTemplate.postForObject(uri, new PaymantData(cart.getTotal()),
						String.class);
				model.addFlashAttribute("success", "** " + response + " **");
				System.out.println(response);
				return new ModelAndView("redirect:/products");
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				model.addFlashAttribute("fail", "** Valor maior que o permitido ** -  (Máximo R$ 500,00 pro transação)**");
				return new ModelAndView("redirect:/products");
			}
		};
	}

}
