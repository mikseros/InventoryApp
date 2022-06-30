package com.mikseros.inventory.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mikseros.inventory.category.Category;
import com.mikseros.inventory.category.CategoryRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listCategories = categoryRepo.findAll();
		
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
	}
}
