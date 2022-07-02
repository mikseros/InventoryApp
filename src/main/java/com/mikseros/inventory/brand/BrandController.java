package com.mikseros.inventory.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mikseros.inventory.category.Category;
import com.mikseros.inventory.category.CategoryRepository;

@Controller
public class BrandController {

	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("brands/new")
	public String showCreateNewBrandForm (Model model) {
		List<Category> listCategories = categoryRepo.findAll();
		
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("brand", new Brand());
		
		return "brand_form";
	}
	
	@PostMapping("/brands/save")
	public String saveBrand(Brand brand) {
		brandRepo.save(brand);
		
		return "redirect:/";
	}
}
