package com.jspiders.weje3springboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.weje3springboot.pojo.ProductPojo;
import com.jspiders.weje3springboot.response.ProductResponse;
import com.jspiders.weje3springboot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/add")
	public ResponseEntity<ProductResponse>  addProduct(@RequestBody ProductPojo product){
		ProductPojo pojo=service.saveProduct(product);
		if(pojo!=null) {
			//success response
			return new ResponseEntity<ProductResponse>
			(new ProductResponse("Ok", "Product added successfully..!!", pojo, null),HttpStatus.ACCEPTED);
		}
		//failure response
		return new ResponseEntity<ProductResponse>
		(new ProductResponse("FAIL","Product not added..!!", null, null),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable int id){
		ProductPojo pojo=service.findProduct(id);
		if(pojo!=null) {
			//success response
			return new ResponseEntity<ProductResponse>
			(new ProductResponse("OK", "Product found successfully..!!", pojo, null),HttpStatus.ACCEPTED);
		}
		//failure response
		return new ResponseEntity<ProductResponse>
		(new ProductResponse("Fail", "Product not found..!!", null, null),HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProductResponse> updatePro(@RequestBody ProductPojo product){
		ProductPojo pojo=service.updateProduct(product);
		if(pojo!=null) {
			//success response
			return new ResponseEntity<ProductResponse>
			(new ProductResponse("Ok", "Product data updated successfully..!!", pojo, null),HttpStatus.ACCEPTED);
		}
		//failure response
		return new ResponseEntity<ProductResponse>
		(new ProductResponse("Fail", "Product data not updated..!!", null, null),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<ProductResponse> findAllProduct(){
		List<ProductPojo> pojos=service.findAll();
		if(pojos!=null) {
			//success response
			return new ResponseEntity<ProductResponse>
			(new ProductResponse("OK", "All product found successfully..!!", null, pojos),HttpStatus.ACCEPTED);
		}
		//failure response
		return new ResponseEntity<ProductResponse>
		(new ProductResponse("Fail", "product not found..!!", null, null),HttpStatus.BAD_REQUEST);
		
	}
}

