package com.mrcruz.bikestore.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.Customer;
import com.mrcruz.bikestore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query(value = "select customer_id, count(customer_id) as qnt "
			+ "from orders group by customer_id  order by qnt desc limit 5;", nativeQuery = true)
	List<Number> findCustomers();
	
	List<Order> findByCustomer(Customer customer);
	List<Order> findAllByDateGreaterThanEqualAndDateLessThanEqual(OffsetDateTime startDate, OffsetDateTime endDate);
}
