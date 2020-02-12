package com.example.cartservice.service;

import com.example.cartservice.adapter.repository.ItemRepository;
import com.example.cartservice.model.Item;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    private final ItemRepository itemRepository;

    public ProductsService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item){
        itemRepository.saveItem(item);
    }

    public Optional<Item> loadItem(String itemNo){
        return itemRepository.loadItemByNo(itemNo);
    }
 }
