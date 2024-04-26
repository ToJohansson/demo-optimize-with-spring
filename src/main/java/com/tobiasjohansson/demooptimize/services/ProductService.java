package com.tobiasjohansson.demooptimize.services;

import com.tobiasjohansson.demooptimize.models.Product;
import com.tobiasjohansson.demooptimize.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
    }


    // GET
    @Cacheable("products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    // SAVE
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
