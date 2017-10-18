package com.vivekaditya;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vivekaditya.dao.jpa.FoodTruckRepository;
import com.vivekaditya.domain.FoodTruck;

@Component
public class LicenseScheduler {

	@Autowired
	private FoodTruckRepository foodTruckRepository;

	/*	 
	 * SELECT COUNT( * ) AS cnt,  `expiration_date` FROM  `food_trucks` GROUP BY  `expiration_date` ORDER BY cnt DESC
	 * SELECT COUNT( * ) AS cnt,  `status` FROM  `food_trucks` GROUP BY  `status` ORDER BY cnt DESC 
	 */
	@Scheduled(cron = "0 12 * * * *")
	public void expireLicenses() {
		Date today = new Date(); 
		for (FoodTruck foodTruck : foodTruckRepository.findAllByStatusAndExpirationDateBefore("APPROVED", today)) {
			foodTruck.setStatus("EXPIRED");
			foodTruckRepository.save(foodTruck);
		}
	}
}