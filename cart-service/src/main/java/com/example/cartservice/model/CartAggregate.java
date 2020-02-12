package com.example.cartservice.model;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartAggregate {

    private  String userId;
    private  String cartId;
    private final Map<String,CartLineItem> items =
            new ConcurrentHashMap<>();

    public CartAggregate(String userId, String cartId) {
        this.userId = userId;
        this.cartId = cartId;
    }
    public CartAggregate(){

    }

    public String getUserId() {
        return userId;
    }

    public String getCartId() {
        return cartId;
    }

    public Map<String, CartLineItem> getItems() {
        return items;
    }

    public void removeItem(String itemNo){
        items.remove(itemNo);
    }

    public void addItem(String itemNo,int qty, int price){
        //if the item is in the aggregate it  will get it if not it will add it to the aggregate with qty = 0
            CartLineItem cartLineItem=items.getOrDefault(itemNo
            , new CartLineItem(itemNo,0,price));
        //add qty by 1
        CartLineItem newLineItem = cartLineItem.toBuilder()
                .qty(cartLineItem.getQty() + qty)
                .build();

        items.put(newLineItem.getItemNo(),newLineItem);
    }

    public int calculatePrice(){
        return items.values().stream()
                .mapToInt(item-> item.getQty()*item.getPrice())
                .sum();
    }

    @Override
    public String toString() {
        return "CartAggregate{" +
                "userId='" + userId + '\'' +
                ", cartId='" + cartId + '\'' +
                ", items=" + items +
                '}';
    }
}
