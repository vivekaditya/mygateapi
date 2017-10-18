package com.vivekaditya.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.vivekaditya.dao.jpa.FoodTruckRepository;
import com.vivekaditya.domain.FoodTruck;
import com.vivekaditya.domain.Locations;
import com.vivekaditya.util.Util;

/*
 * 
 */
@Service
public class FoodTruckService {

	// private static final Logger log = LoggerFactory.getLogger(FoodTruckService.class);

	@Autowired
	private FoodTruckRepository foodTruckRepository;

	@Autowired
	CounterService counterService;

	@Autowired
	GaugeService gaugeService;

	SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

	public FoodTruckService() {
	}

	public FoodTruck createFoodTruck(FoodTruck foodTruck) {
		return foodTruckRepository.save(foodTruck);
	}

	public FoodTruck getFoodTruck(Long id) {
		return foodTruckRepository.findOne(id);
	}

	public FoodTruck getClosestFoodTruck(Locations locations) {
		FoodTruck closestFoodTruck = new FoodTruck();
		double minDistance = Double.MAX_VALUE;
		for (FoodTruck currentFoodTruck : foodTruckRepository.findAll()) {
			double distance = Util.totalDistance(currentFoodTruck, locations);
			if (distance < minDistance) {
				minDistance = distance;
				closestFoodTruck = currentFoodTruck;
			}
		}
		return closestFoodTruck;
	}

	public Page<FoodTruck> getFoodTruck(String name, String streetName, String date, Integer page, Integer size) {
		PageRequest pageRequest = new PageRequest(page, size);
		Page<FoodTruck> pages = new PageImpl<FoodTruck>(new ArrayList<FoodTruck>(), pageRequest, 0);
		if (name != null && !name.isEmpty()) {
			pages = foodTruckRepository.findAllByApplicantContaining(name, pageRequest);
		}
		if (streetName != null && !streetName.isEmpty()) {
			pages = foodTruckRepository.findAllByAddressContaining(streetName, pageRequest);
		}
		if (date != null) {
			try {
				pages = foodTruckRepository.findAllByExpirationDateBefore(parser.parse(date), pageRequest);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return pages;
	}

	public void updateFoodTruck(FoodTruck foodTruck) {
		foodTruckRepository.save(foodTruck);
	}

	public void deleteFoodTruck(Long id) {
		foodTruckRepository.delete(id);
	}

	public Page<FoodTruck> getAllFoodTrucks(Integer page, Integer size) {
		Page<FoodTruck> pageOfFoodTrucks = foodTruckRepository.findAll(new PageRequest(page, size));
		return pageOfFoodTrucks;
	}
}
