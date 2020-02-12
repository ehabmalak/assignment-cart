package com.example.cartservice.adapter.repository.impl.jpa;

import com.example.cartservice.adapter.repository.entity.ItemEntity;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJPARepository extends JpaRepository<ItemEntity, String> {
}
