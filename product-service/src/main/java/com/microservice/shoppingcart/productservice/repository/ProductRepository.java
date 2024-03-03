package com.microservice.shoppingcart.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.shoppingcart.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
