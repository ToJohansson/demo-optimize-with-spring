package com.tobiasjohansson.demooptimize.controllers;

import com.tobiasjohansson.demooptimize.models.Product;
import com.tobiasjohansson.demooptimize.repositories.ProductRepository;
import com.tobiasjohansson.demooptimize.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    public ProductController() {
    }
    //GET
    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("getwithpage")
    public ResponseEntity<Page<Product>> getAllWithPage(Pageable pageable){
        return new ResponseEntity<>(productRepository.findAll(pageable),HttpStatus.OK);
    }

    //POST
    @PostMapping("/postproduct")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

}
