package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Supplier;
import com.example.demo.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	//create a method handler
	@GetMapping("/supplier")
	public String viewHomePage(Model model) {
		model.addAttribute("listSupplier", supplierService.getAllSuppliers());
		return "supplier_index";
	}
	
	@GetMapping("/newSupplierForm")
	public String ShowAddProductForm(Model model) {
		Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		
		return "new_supplier";
	}
	@PostMapping("/saveSupplier")
	public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
		supplierService.saveSupplier(supplier);

		return "redirect:/supplier";
		
	}
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model) {
//		Product product = productService.getProductById(id);
//		model.addAttribute("product", product);
//		return "update_product";
//	}
//	
//	@GetMapping("/deleteProduct/{id}")
//	public String deleteProduct(@PathVariable (value = "id") Long id) {
//		this.productService.deleteProductById(id);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/showBySupplier/{id}")
//	public String showBySupplier(@PathVariable (value = "id") Long id, Model model) {
//		Product product = productService.getProductById(id);
////		model.addAttribute("listProducts", productService.getAllProducts());
//		model.addAttribute("product", product);
////		return Product;
//		return "show_by_supplier";
//	}
}
