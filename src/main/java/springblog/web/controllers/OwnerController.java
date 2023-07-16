package springblog.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springblog.bl.services.house.HouseService;
import springblog.bl.services.owner.OwnerService;
import springblog.persistence.entity.House;
import springblog.persistence.entity.Owner;
import springblog.web.form.HouseForm;
import springblog.web.form.OwnerForm;

@Controller
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/owner/home")
	public ModelAndView ownerHome() {
		ModelAndView mv = new ModelAndView("ownerHome");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        int ownerInt = ownerService.findOwnerByEmail(username);
		List<House> houseList = houseService.getAllHouses(ownerInt);
		mv.addObject("houses", houseList);
		return mv;
	}
	
	@RequestMapping("/owner/create")
	public ModelAndView ownerCreate() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ownerCreate",new OwnerForm());
		return mv;
	}
	
	@RequestMapping(value = "/owner/create/save", method = RequestMethod.POST)
	public ModelAndView saveOwner(@ModelAttribute("ownerCreate") @Valid OwnerForm ownerForm,
									 BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("redirect:/owner/create");
			return mv;
		}
		ownerService.saveOwner(ownerForm);
		mv.setViewName("redirect:/owner/home");
		return mv;
	}
	
	@RequestMapping("/owner/search")
	public ModelAndView searchUser(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView("ownerSearch");
		List<House> houseList = houseService.searchHouse(keyword);
		mv.addObject("houses", houseList);
		return mv;
	}
	
	

}
