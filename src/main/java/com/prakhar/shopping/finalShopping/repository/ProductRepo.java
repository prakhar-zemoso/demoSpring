package com.prakhar.shopping.finalShopping.repository;


import com.prakhar.shopping.finalShopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {


}
