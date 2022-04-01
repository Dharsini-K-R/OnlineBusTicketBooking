package com.online.busticketbookingsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.busticketbookingsystem.Models.UserDetails;
import com.online.busticketbookingsystem.UserRepository.HomeRepo;

@Controller
public class User_Controller {
	@Autowired
	HomeRepo repo;

	@RequestMapping("/home")

	public String homePage() {
		return "home.jsp";
	}

	/*@RequestMapping("/log")
	public String add(@RequestParam String name, @RequestParam String dob, @RequestParam String address,
			@RequestParam String phone, @RequestParam String email, @RequestParam String password) {
		System.out.println(email);
		repo.save(new UserDetails(name, dob, address, phone, email, password));
		return "Welcome.jsp";
	}*/
	@RequestMapping("/register")
	public String registerPage(UserDetails ud)
	{
		repo.save(ud);
		return "signup.jsp";
		
	}
	@RequestMapping("/log")
	public String loginPage()
	{
		return "login.jsp";
		
	}
	@GetMapping("/user")
	public ModelAndView user(UserDetails ud)
	{
		ModelAndView m = new ModelAndView();
		m.addObject("obj",ud);
		m.setViewName("Welcome.jsp");
		repo.save(ud);
		return m;
	}
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("home.jsp");
		mv.addObject("user login",new UserDetails());
		return mv;
	}
	@GetMapping("/validate")
	public String addValidate(String email,String password)
	{
		UserDetails ud =repo.findByEmail(email);
		if(ud!=null)
		{
			if(ud.getPassword().equals(password)) {
				return "Welcome.jsp";
			}
			return"Exsistinglogin.jsp";
		}
		return "home.jsp";
		
	}
	
}

