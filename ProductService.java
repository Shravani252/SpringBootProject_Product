package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;


@Service
public interface ProductService {
	public List<Product> getStudent();
	public Product getProductById(Integer pid);
	public Product getProductByName(String name);
	public Product postProduct(Product product);
	public Product deleteProductById(Integer pid);
	public String updateProductById(Integer pid,Product updatingProduct);

}
