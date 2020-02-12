package com.example.cartservice.service;

import com.example.cartservice.adapter.repository.CartAggregateRepository;
import com.example.cartservice.adapter.repository.ItemRepository;
import com.example.cartservice.model.CartAggregate;
import com.example.cartservice.model.Item;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {

        private final CartAggregateRepository cartAggregateRepository;
        private final ItemRepository itemRepository;

    public CartService(CartAggregateRepository cartAggregateRepository, ItemRepository itemRepository) {
        this.cartAggregateRepository = cartAggregateRepository;
        this.itemRepository = itemRepository;
    }

    public String createCart(String userId){

        String cartId = UUID.randomUUID().toString();
        //create Aggregate
        CartAggregate cartAggregate= new CartAggregate(userId,cartId);

        //save the Aggregate
        cartAggregateRepository.saveCartAggregate(cartId,cartAggregate);
        return cartId;
    }

    public void removeItem(String cartId,String itemNo){
            //TODO Load cart aggregate then remove item then save aggregate again
        //print the cart aggregate

    }
    //return the total price
    public int addItemToCart (String cartId,String itemNo , int qty){
        //TODO Load item from repo if not found throw runtime Exception
        Item item = itemRepository.loadItemByNo(itemNo)
                .orElseThrow(() -> new RuntimeException("Item not found "));
        //TODO load cart aggregate if not found throw exception
        CartAggregate cartAggregate = cartAggregateRepository.loadCartAggregate(cartId).get();

        // if both was found add item cartaggregate.additem
        cartAggregate.addItem(item.getItemNo(),qty,item.getPrice());
        //TODO save aggregate
        cartAggregateRepository.saveCartAggregate(cartId,cartAggregate);
        //return price;
        return cartAggregate.calculatePrice();
    }

    public void loadCart(String cartId) {

    }
}
