package com.example.cartservice.adapter.repository;

import com.example.cartservice.model.CartAggregate;

import java.util.Optional;

public interface CartAggregateRepository {

    public void saveCartAggregate(String cartId,CartAggregate cartAggregate);

    public Optional<CartAggregate> loadCartAggregate(String cartId);


}
