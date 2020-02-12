package com.example.cartservice.adapter.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ItemEntity {
    @Id
    private String itemNo;

    private String name;

    private int price;
}
