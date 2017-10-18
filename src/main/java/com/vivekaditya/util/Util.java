package com.vivekaditya.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.vivekaditya.domain.FoodTruck;
import com.vivekaditya.domain.Location;
import com.vivekaditya.domain.Locations;

public class Util {

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {
		final int R = 6371; // Radius of the earth
		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters
		double height = el1 - el2;
		distance = Math.pow(distance, 2) + Math.pow(height, 2);
		return Math.sqrt(distance);
	}

	public static double totalDistance(FoodTruck currentFoodTruck, Locations locations) {
		double distance = 0;
		for (Location location : locations.locations) {
			distance = distance + distance(location.latitude, currentFoodTruck.getLatitude(), location.longitude, currentFoodTruck.getLongitude(), 0, 0);
		}
		return distance;
	}
}
