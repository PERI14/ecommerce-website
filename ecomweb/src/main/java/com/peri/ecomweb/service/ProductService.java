package com.peri.ecomweb.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.peri.ecomweb.model.CartItem;
import com.peri.ecomweb.model.Product;
import com.peri.ecomweb.repository.CartItemRepo;
import com.peri.ecomweb.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    // --- Product Methods ---

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }

    // --- CartItem Methods ---

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    public List<CartItem> getCartItemsBySharedCartId(String sharedCartId) {
        return cartItemRepo.findBySharedCartId(sharedCartId);
    }
}
