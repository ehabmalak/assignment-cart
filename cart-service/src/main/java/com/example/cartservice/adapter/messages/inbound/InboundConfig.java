package com.example.cartservice.adapter.messages.inbound;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(ItemInputChannel.class)
public class InboundConfig {
}
