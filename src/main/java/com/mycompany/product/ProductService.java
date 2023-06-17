package com.mycompany.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }

    public Product getProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ProductNotFoundException("Could not find product with ID: " + id);
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public void deleteProduct(Integer id) throws ProductNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Could not find product with ID: " + id);
        }
    }
}
