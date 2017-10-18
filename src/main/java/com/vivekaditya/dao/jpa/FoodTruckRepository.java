package com.vivekaditya.dao.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vivekaditya.domain.FoodTruck;

/**
 * 
 */
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
	Page<FoodTruck> findAll(Pageable pageable);

	Page<FoodTruck> findAllByApplicantContaining(String name, Pageable pageable);

	Page<FoodTruck> findAllByAddressContaining(String streetName, Pageable pageable);

	Page<FoodTruck> findAllByExpirationDateBefore(Date date, Pageable pageable);

	List<FoodTruck> findAllByStatusAndExpirationDateBefore(String status, Date today);
}
