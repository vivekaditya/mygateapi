package com.vivekaditya;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.vivekaditya.domain.FoodTruck;
import com.vivekaditya.service.FoodTruckService;

import au.com.bytecode.opencsv.CSVReader;

public class DataLoader {

	public static void create(FoodTruckService foodTruckService) throws Exception {
		String fileName = "data/Mobile_Food_Facility_Permit.csv";
		CSVReader reader = new CSVReader(new FileReader(fileName), ',');
		String[] record = null;
		boolean ignoreHeader = true;
		if (ignoreHeader) {
			record = reader.readNext();
		}
		while ((record = reader.readNext()) != null) {
			if (record.length > 0) {
				System.out.println(record[0]);
				FoodTruck newFoodTruck = new FoodTruck();
				newFoodTruck.setLocationid(record[0]);
				newFoodTruck.setApplicant(record[1]);
				newFoodTruck.setFacilityType(record[2]);
				newFoodTruck.setCnn(record[3]);
				newFoodTruck.setLocationDescription(record[4]);
				newFoodTruck.setAddress(record[5]);
				newFoodTruck.setBlocklot(record[6]);
				newFoodTruck.setBlock(record[7]);
				newFoodTruck.setLot(record[8]);
				newFoodTruck.setPermit(record[9]);
				newFoodTruck.setStatus(record[10]);
				newFoodTruck.setFoodItems(record[11]);
				if (!record[12].isEmpty())
					newFoodTruck.setX(Double.parseDouble(record[12]));
				if (!record[13].isEmpty())
					newFoodTruck.setY(Double.parseDouble(record[13]));
				if (!record[14].isEmpty())
					newFoodTruck.setLatitude(Double.parseDouble(record[14]));
				if (!record[15].isEmpty())
					newFoodTruck.setLongitude(Double.parseDouble(record[15]));
				newFoodTruck.setSchedule(record[16]);
				newFoodTruck.setDayshours(record[17]);
				DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aa");
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if (!record[18].isEmpty())
						newFoodTruck.setNOISent(df1.parse(record[18]));
					if (!record[19].isEmpty())
						newFoodTruck.setApproved(df1.parse(record[19]));
					if (!record[22].isEmpty())
						newFoodTruck.setExpirationDate(df1.parse(record[22]));
					if (!record[20].isEmpty())
						newFoodTruck.setReceived(df2.parse(record[20]));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				newFoodTruck.setPriorPermit(record[21]);
				newFoodTruck.setLocation(record[23]);
				foodTruckService.createFoodTruck(newFoodTruck);
			}
		}
		reader.close();
	}
}
