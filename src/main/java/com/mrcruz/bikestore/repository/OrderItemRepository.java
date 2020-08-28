package com.mrcruz.bikestore.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mrcruz.bikestore.model.OrderItem;
import com.mrcruz.bikestore.model.OrderItemId;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
	
	
	@Query(value = "select product_id, count(product_id) as qnt "
			+ "from order_items group by product_id  order by qnt desc limit 5;", nativeQuery = true)
	List<Number> findItem();
			
			

}
