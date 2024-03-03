package com.microservice.shoppingcart.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.shoppingcart.productservice.dto.ProductDto;
import com.microservice.shoppingcart.productservice.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}
	@PostMapping("/products")
	public void saveProduct(@RequestBody ProductDto productDto) {
		productService.saveProduct(productDto);
	}
	@GetMapping("/products/{id}")
	public ProductDto getProductById(@PathVariable("id") Integer id) {
		return productService.getProductById(id);
	}
	@DeleteMapping("/products/{id}")
	public void deleteProductById(@PathVariable("id") Integer id) {
		productService.deleteProductById(id);
	}
	@PutMapping("/products")
	public void updateProduct(@RequestBody ProductDto productDto) {
		productService.updateProduct(productDto); 
	}
	
}
