package com.peri.ecomweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peri.ecomweb.model.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
    
    List<CartItem> findBySharedCartId(String sharedCartId);
}
