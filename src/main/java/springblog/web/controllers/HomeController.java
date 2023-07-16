package springblog.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import springblog.bl.services.house.HouseService;
import springblog.persistence.entity.House;

@Controller
public class HomeController {
	
	@Autowired
	private HouseService houseService;
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		List<House> houseList = houseService.getAllHouses();
		mv.addObject("houses", houseList);
		return mv;
	}
	
	
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
