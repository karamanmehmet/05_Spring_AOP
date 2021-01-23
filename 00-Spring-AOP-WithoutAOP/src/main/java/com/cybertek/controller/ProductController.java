package com.cybertek.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybertek.model.Product;
import com.cybertek.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@DeleteMapping("/{id}")
	public List<Product> delete(@PathVariable("id") Long id) {
		
		logger.info("Before  -> Controller : {} - Method : {} - Input Parameter : {}","ProductController","delete",id);
		
		List<Product> list = productService.delete(id);
		
		logger.info("After  -> Controller : {} - Method : {} - Output Parameter : {}","ProductController","delete",list);
		
		return list;
	}

	@PutMapping("/{id}")
	public List<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		
		logger.info("Before  -> Controller : {} - Method : {} - Input Parameter : {}","ProductController","updateProduct",id+product.toString());

		List<Product> list = productService.updateProduct(id, product);
		
		logger.info("After  -> Controller : {} - Method : {} - Output Parameter : {}","ProductController","updateProduct",list);
		
		return list;
		

	}

	@PostMapping
	public List<Product> createProduct(@RequestBody Product product) {
		
		logger.info("Before  -> Controller : {} - Method : {} - Input Parameter : {}","ProductController","createProduct",product.toString());

		
		List<Product> list = productService.createProduct(product);
		
		logger.info("After  -> Controller : {} - Method : {} - Output Parameter : {}","ProductController","createProduct",list);

		
		return list;
	}

	@GetMapping
	public List<Product> getProducts() {
		
		logger.info("Before  -> Controller : {} - Method : {} - Input Parameter : {}","ProductController","getProducts");

		
		List<Product> list = productService.getProducts();
		
		logger.info("After  -> Controller : {} - Method : {} - Output Parameter : {}","ProductController","getProducts",list);

		
		return list;
	}

	@GetMapping(value = "/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		logger.info("Before  -> Controller : {} - Method : {} - Input Parameter : {}","ProductController","getProduct",id);

		Product product= productService.getProduct(id);
		
		logger.info("After  -> Controller : {} - Method : {} - Output Parameter : {}","ProductController","getProduct",product.toString());

		
		return product;
	}

}
