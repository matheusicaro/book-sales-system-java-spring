package matheusicaro.com.github.store.controller;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import matheusicaro.com.github.store.daos.UserDAO;
import matheusicaro.com.github.store.models.Role;
import matheusicaro.com.github.store.models.UserAuth;

@Controller
@RequestMapping("/register")
public class RegisterController {

	
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView register() {
		
        UserAuth user = new UserAuth(); 
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("user", user);
		
	return modelAndView;
	}
	
    @Transactional
    @ResponseBody
	@RequestMapping(method = RequestMethod.POST)
    public ModelAndView createRegister(UserAuth user, RedirectAttributes redirectAttributes) {
       
    	user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));

        userDAO.save(user);

	    redirectAttributes.addFlashAttribute("success", "Usuario registrado com sucesso! Seu login é: (" + user.getEmail() + ")");

	    return new ModelAndView("redirect:/login");
    }

}
