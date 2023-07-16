package springblog.web.controllers;

import javax.servlet.http.HttpServletRequest;
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

import springblog.bl.dto.HouseDTO;
import springblog.bl.services.house.HouseService;
import springblog.web.form.HouseForm;



@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/owner/house")
	public ModelAndView houseHome() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	@RequestMapping("/house/create")
	public ModelAndView houseCreate() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("houseCreate", new HouseForm());
		return mv;
	}
	
	@RequestMapping(value = "/house/create/save", method = RequestMethod.POST)
	public ModelAndView houseCreateSave(@ModelAttribute("houseCreate") @Valid HouseForm houseForm,BindingResult result,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("redirect:/house/create");
			return mv;
		}
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
		System.out.println(houseForm.getNumberOfMasterRoom());
		System.out.println(houseForm.getAddress());
		houseService.saveHoust(houseForm,username);
		mv.setViewName("redirect:/owner/home");
		return mv;
	}
	
	@RequestMapping("/house/delete")
	public ModelAndView deletePost(@RequestParam int deleteId) {
		ModelAndView mv = new ModelAndView();
		houseService.deletePost(deleteId);
		mv.setViewName("redirect:/owner/home");
		return mv;
	}
	
	@RequestMapping("/house/edit")
	public ModelAndView editUser(@RequestParam int editId) {
		ModelAndView mv = new ModelAndView();
		HouseDTO houseDto = houseService.findById(editId);
		mv.addObject("editHouse", new HouseForm(houseDto));
		return mv;
	}

	@RequestMapping(value = "/house/edit/save", method = RequestMethod.POST)
	public ModelAndView saveEditUser(@ModelAttribute("editHouse") @Valid HouseForm houseForm,
									 BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("redirect:/house/edit");
			return mv;
		}
		System.out.println(houseForm.getAddress());
		System.out.println(houseForm.getId());
		houseService.editUser(houseForm);
		mv.setViewName("redirect:/owner/home");
		return mv;
	}
	
	
	
	
	
}
