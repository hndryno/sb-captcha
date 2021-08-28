package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ReCaptchaValidationService;

@Controller
public class ProductController {
	
	@Autowired
	private ReCaptchaValidationService validator;
	
	@Autowired
	private ProductService productService;
	//create a method handler
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts());
		return "index";
	}
	@GetMapping("/newProductForm")
	public String ShowAddProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product, @RequestParam(name="g-recaptcha-response")
	 String captcha,Model model) {
//		productService.saveProduct(product);
//		
//		return "redirect:/";
		if(validator.validateCaptcha(captcha))
        {    
			 productService.saveProduct(product); 
//			 model.addAttribute("product", new Product());
			 model.addAttribute("message", "product added!!");  
			 return "redirect:/";
		 }else {	 
			 model.addAttribute("message", "Please Verify Captcha");

			 return "new_product";

		 }
	}
	
	@PostMapping("/updateProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "update_product";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable (value = "id") Long id) {
		this.productService.deleteProductById(id);
		return "redirect:/";
	}
	
	@GetMapping("/showBySupplier/{id}")
	public String showBySupplier(@PathVariable (value = "id") Long id, Model model) {
		Product product = productService.getProductById(id);
//		model.addAttribute("listProducts", productService.getAllProducts());
		model.addAttribute("product", product);
//		return Product;
		return "show_by_supplier";
	}
}
