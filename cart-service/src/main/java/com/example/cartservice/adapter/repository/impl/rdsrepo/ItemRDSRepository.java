package com.example.cartservice.adapter.repository.impl.rdsrepo;

import com.example.cartservice.adapter.repository.ItemRepository;
import com.example.cartservice.adapter.repository.entity.ItemEntity;
import com.example.cartservice.adapter.repository.impl.jpa.ItemJPARepository;
import com.example.cartservice.model.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ItemRDSRepository implements ItemRepository {

    private final ItemJPARepository itemJPARepository;
    private final ModelMapper modelMapper;

    public ItemRDSRepository(ItemJPARepository itemJPARepository, ModelMapper modelMapper) {
        this.itemJPARepository = itemJPARepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveItem(Item item) {
        itemJPARepository.save(toEntity(item));
    }

    @Override
    public Optional<Item> loadItemByNo(String itemNo) {
        return itemJPARepository.findById(itemNo).map(this::toModel);
    }

    private Item toModel(ItemEntity itemEntity){
        return modelMapper.map(itemEntity,Item.class);
    }
    private ItemEntity toEntity(Item item){
        return modelMapper.map(item,ItemEntity.class);
    }
}
