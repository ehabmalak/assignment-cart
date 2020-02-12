package com.example.cartservice.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class CartLineItem {

    private final String itemNo;
    private final int qty;
    private final int price;
}
