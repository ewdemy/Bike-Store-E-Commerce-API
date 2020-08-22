package com.mrcruz.bikestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrcruz.bikestore.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
