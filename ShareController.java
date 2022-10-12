package com.gl.companyShareApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.companyShareApp.bean.CompanyShare;
import com.gl.companyShareApp.service.ShareService;

@RestController
public class ShareController {
	@Autowired
	private ShareService service;
	
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		ModelAndView mv = new ModelAndView("index");
		List<CompanyShare> companyShareList=service.findAll();
		mv.addObject("companyShareList",companyShareList);
		return mv;
	}

	@GetMapping("/company-entry")
	public ModelAndView showCourseEntryPage() {
		CompanyShare companyShare=new CompanyShare();
		ModelAndView mv=new ModelAndView("companyEntryPage");
		mv.addObject("companyRecord",companyShare);
		return mv;
	}
	
	@PostMapping("/companyShare")
	public ModelAndView saveNewCourse(@ModelAttribute("companyRecord") CompanyShare companyShare) {
		long id=service.generateCompanyId();
        companyShare.setCompanyId(id);
		service.save(companyShare);
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/delete-companyShare/{id}")
	public ModelAndView deleteACompany(@PathVariable long id) {
        service.delete(id);
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/edit-companyShare/{id}")
	public ModelAndView showCompanyEditPage(@PathVariable long id) {
        CompanyShare companyShare=service.findById(id);
		ModelAndView mv=new ModelAndView("companyEditPage");
		mv.addObject("companyRecord",companyShare);
		return mv;
	}
	@PostMapping("/edit-companyShare/company-edit")
	public ModelAndView editComapny(@ModelAttribute("companyRecord") CompanyShare companyShare) {
		service.save(companyShare);
		return new ModelAndView("redirect:/index");
	}
	

}
