package com.alten.vts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.vts.datamodel.Customer;

@Repository
public interface CustomerVSRepository extends JpaRepository<Customer, Long> {

}
