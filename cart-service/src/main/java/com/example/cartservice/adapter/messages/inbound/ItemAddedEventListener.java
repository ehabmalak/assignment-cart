package com.example.cartservice.adapter.messages.inbound;

import com.example.cartservice.adapter.repository.ItemRepository;
import com.example.cartservice.model.Item;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class ItemAddedEventListener {
    private final ItemRepository itemRepository;

    public ItemAddedEventListener(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @StreamListener(ItemInputChannel.ITEM_ADDED_INPUT_CHANNEL)
    public void itemAdded(Item item){
        System.out.println("item = " + item);
        itemRepository.saveItem(item);

        itemRepository.loadItemByNo(item.getItemNo())
                .ifPresent(it-> System.out.println("Item Saved: "+it));
    }
}
