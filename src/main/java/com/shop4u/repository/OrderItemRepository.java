package com.shop4u.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop4u.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
