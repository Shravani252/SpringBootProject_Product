package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;

import com.example.demo.serviceimple.ProductServiceImpl;

@RestController
public class ProductController {
	ProductServiceImpl productService;

	public ProductController(ProductServiceImpl productService) {
		super();
		this.productService = productService;
	}
	@GetMapping(value="/get")
	public List<Product> getProduct(){
		return productService.getProduct();
	}
	@GetMapping(value="/getid/{pid}")
	public Product getProductById(@PathVariable Integer pid) {
		return productService.getProductById(pid);
	}
	@GetMapping(value="/getname/{pname}")
	public Product getProductByName(@PathVariable String pname) {
		return productService.getProductByName(pname);
	}
	//insert a product into db
	@PostMapping(value="/post")
	public Product postProduct(@RequestBody Product product) {
		return productService.postProduct(product);
	}
	//delete product by id
	@DeleteMapping(value="/delete/{pid}")
	public String deleteProductById(@PathVariable Integer pid) {
		return productService.deleteProductById(pid);
	}
	//update product by_id
	@PutMapping(value="/put/{pid}")
	public String updateProductById(@PathVariable Integer pid,@RequestBody Product product) {
		return productService.updateProductById(pid,product);
	}
}
