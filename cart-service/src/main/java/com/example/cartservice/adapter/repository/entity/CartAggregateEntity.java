package com.example.cartservice.adapter.repository.entity;

import com.example.cartservice.model.CartLineItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartAggregateEntity {

    @Id
    private String cartId;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private Map<String,CartLineItemEntity> items;

}
