package com.microservice.shoppingcart.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.shoppingcart.productservice.dto.ProductDto;
import com.microservice.shoppingcart.productservice.model.Product;
import com.microservice.shoppingcart.productservice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDto> getAllProducts() {
		
		List<Product> productList = productRepository.findAll();
		return productList.stream().map(product -> mapToProductResponse(product)).toList();
		
	}

	private ProductDto mapToProductResponse(Product product) {
		
		 return ProductDto.builder()
	                .id(product.getId())
	                .name(product.getName())
	                .description(product.getDescription())
	                .price(product.getPrice())
	                .build();
		
	}

	public void saveProduct(ProductDto productDto) {
		
		Product product = Product.builder()
					.name(productDto.getName())
					.description(productDto.getDescription())
					.price(productDto.getPrice())
					.build();
		
		productRepository.save(product);
		log.info("product {} is saved" ,  product.getId());
	}

	public ProductDto getProductById(Integer id) {
		
		Product product = productRepository.findById(id).get();
		return ProductDto.builder()
					.id(product.getId())
					.name(product.getName())
					.description(product.getDescription())
					.price(product.getPrice())
					.build();
		
	}

	public void deleteProductById(Integer id) {
		
		productRepository.deleteById(id);
		
	}

	public void updateProduct(ProductDto productDto) {
		
		Product product = Product.builder()
					.id(productDto.getId())
					.name(productDto.getName())
					.description(productDto.getDescription())
					.price(productDto.getPrice())
					.build();
		productRepository.save(product);
		
	}

}
