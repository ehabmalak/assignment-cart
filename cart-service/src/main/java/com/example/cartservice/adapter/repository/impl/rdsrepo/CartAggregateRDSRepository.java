package com.example.cartservice.adapter.repository.impl.rdsrepo;

import com.example.cartservice.adapter.repository.CartAggregateRepository;
import com.example.cartservice.adapter.repository.entity.CartAggregateEntity;
import com.example.cartservice.adapter.repository.impl.jpa.CartAggregateJPARepository;
import com.example.cartservice.model.CartAggregate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartAggregateRDSRepository implements CartAggregateRepository {
    private  final CartAggregateJPARepository cartAggregateJPARepository;
    private final ModelMapper modelMapper;

    public CartAggregateRDSRepository(CartAggregateJPARepository cartAggregateJPARepository, ModelMapper modelMapper) {
        this.cartAggregateJPARepository = cartAggregateJPARepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveCartAggregate(String cartId, CartAggregate cartAggregate) {
                cartAggregateJPARepository.save(mapToCartAggregateEntity(cartAggregate));
    }

    @Override
    public Optional<CartAggregate> loadCartAggregate(String cartId) {
        return cartAggregateJPARepository.findById(cartId).map(this::mapToCartAggregate);
    }

    private CartAggregateEntity mapToCartAggregateEntity(CartAggregate cartAggregate){
        return modelMapper.map(cartAggregate,CartAggregateEntity.class);

    }
    private CartAggregate mapToCartAggregate(CartAggregateEntity cartAggregateEntity){
        return modelMapper.map(cartAggregateEntity,CartAggregate.class);
    }

//    private List<CartLineItemEntity> ConvertMapToList(Map<String,CartLineItem> cartLineItemMap){
//                List<CartLineItemEntity> cartLineItemEntities= new ArrayList<>();
//                    cartLineItemMap.values().stream().map(cartLineItem -> cartLineItemEntities.add())
//
//    }
}
