package com.example.demo.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductInterface;

@Service
public class ProductServiceImpl {
	ProductInterface productRepository;
	

	public ProductServiceImpl(ProductInterface productRepository) {
		super();
		this.productRepository = productRepository;
	}


	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	public Product getProductById(Integer pid) {
		// TODO Auto-generated method stub
		Optional<Product > product=productRepository.findById(pid);
		return product.orElse(null);
	}


	public Product postProduct(Product product) {
		// TODO Auto-generated method stub
		Product p=productRepository.save(product);
		return p;
	}


	public String deleteProductById(Integer pid) {
		// TODO Auto-generated method stub
		productRepository.deleteById(pid);
		return "Delete Success";
		
		
	}


	public String updateProductById(Integer pid, Product updatingProduct) {
		// TODO Auto-generated method stub
		Optional<Product>existingProduct=productRepository.findById(pid);
		if(existingProduct.isPresent()) {
			
			Product product=existingProduct.get();
			product.setPname(updatingProduct.getPname());
			productRepository.save(product);
			return "Update is Successs";
		}
		else {
			return "Record not found";
		}
		
	}


	public Product getProductByName(String pname) {
		// TODO Auto-generated method stub
		Product product=productRepository.findByName(pname);
		return product;
	}


}
