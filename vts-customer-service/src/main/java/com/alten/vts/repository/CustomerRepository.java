package com.alten.vts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.vts.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
