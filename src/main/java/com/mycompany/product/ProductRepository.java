package com.mycompany.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    // Metoda shtesë nëse ka nevojë për operacione të tjera në repository
}
