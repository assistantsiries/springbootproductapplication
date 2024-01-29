package com.jspiders.weje3springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jspiders.weje3springboot.pojo.ProductPojo;
import com.jspiders.weje3springboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ProductPojo saveProduct(ProductPojo product) {
		ProductPojo pojo=repository.save(product);
		return pojo;
	}
	
	public ProductPojo findProduct(int id) {
		ProductPojo pojo=repository.findById(id).orElse(null);
		return pojo;
	}
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product data deleted successfully..!!";
	}
	
	public ProductPojo updateProduct(ProductPojo product) {
	ProductPojo existingProduct=repository.findById(product.getId()).orElse(null);
	existingProduct.setName(product.getName());
	existingProduct.setPrice(product.getPrice());
	repository.save(existingProduct);
		return existingProduct;
	}

	public List<ProductPojo> findAll() {
		List<ProductPojo> pojos=repository.findAll();
		return pojos;
	}

	

	

	
	



	

	

}
