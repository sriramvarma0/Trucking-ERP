package com.trucking.erp.repository;

import com.trucking.erp.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    // You can add custom queries later if needed, e.g. findByRegistrationNumber
}
