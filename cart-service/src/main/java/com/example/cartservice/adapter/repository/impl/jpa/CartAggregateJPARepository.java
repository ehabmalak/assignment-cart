package com.example.cartservice.adapter.repository.impl.jpa;

import com.example.cartservice.adapter.repository.entity.CartAggregateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartAggregateJPARepository extends JpaRepository<CartAggregateEntity,String> {
}
