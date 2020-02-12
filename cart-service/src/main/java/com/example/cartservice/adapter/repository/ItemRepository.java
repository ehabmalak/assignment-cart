package com.example.cartservice.adapter.repository;

import com.example.cartservice.model.Item;

import java.util.Optional;

public interface ItemRepository {

    public void saveItem(Item item);

    public Optional<Item> loadItemByNo(String itemNo);


}
