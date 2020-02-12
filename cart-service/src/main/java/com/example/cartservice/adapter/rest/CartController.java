package com.example.cartservice.adapter.rest;

import com.example.cartservice.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public void createCart(String userId){
            cartService.createCart(userId);
    }

    @PostMapping("/add")
    public void addItemToCart(String cartId,String itemNo,int qty){
        cartService.addItemToCart(cartId,itemNo,qty);
    }

    @GetMapping
    public void loadCart(String cartId){
        cartService.loadCart(cartId);
    }
}
