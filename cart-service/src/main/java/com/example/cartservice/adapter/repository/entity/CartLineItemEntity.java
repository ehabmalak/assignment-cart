package com.example.cartservice.adapter.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartLineItemEntity {

    @Id
    private  String itemNo;
    private  int qty;
    private  int price;

}
