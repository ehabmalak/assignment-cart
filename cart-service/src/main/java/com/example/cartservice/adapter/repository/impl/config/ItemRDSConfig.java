package com.example.cartservice.adapter.repository.impl.config;

import com.example.cartservice.adapter.repository.ItemRepository;
import com.example.cartservice.adapter.repository.impl.jpa.ItemJPARepository;
import com.example.cartservice.adapter.repository.impl.rdsrepo.ItemRDSRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "com.training.item.rds", name = "enabled" ,matchIfMissing = true)
public class ItemRDSConfig {
    public ItemRepository itemRepository(ItemJPARepository itemJPARepository, ModelMapper mapper){
        return new ItemRDSRepository(itemJPARepository,mapper);
    }
}
