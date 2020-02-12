package com.example.cartservice.adapter.messages.inbound;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ItemInputChannel {

    String ITEM_ADDED_INPUT_CHANNEL="item-added-events";

    @Input(ITEM_ADDED_INPUT_CHANNEL)
    SubscribableChannel input();
}
