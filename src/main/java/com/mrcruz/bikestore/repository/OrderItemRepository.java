package com.mrcruz.bikestore.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.OrderItemId;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
	
	@Modifying
	@Query(value = "insert into order_items(order_id,discount,list_price,quantity,product_id) values(:order,:discount,:price,:quantity,:product)", nativeQuery = true)
	void saveOrderItem(
			@Param("order")Long orderId,
			@Param("discount")BigDecimal discount, 
			@Param("price")BigDecimal listPrice, 
			@Param("quantity")int quantity, 
			@Param("product")Long productId);

}
