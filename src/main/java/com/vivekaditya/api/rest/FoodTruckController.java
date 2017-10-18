package com.vivekaditya.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vivekaditya.DataLoader;
import com.vivekaditya.domain.FoodTruck;
import com.vivekaditya.domain.Locations;
import com.vivekaditya.service.FoodTruckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * 
 */

@RestController
@RequestMapping(value = "/mygateapi/v1/foodTruck")
@Api(value = "foodTruck", description = "FoodTruck API")
public class FoodTruckController extends AbstractRestHandler {

	@Autowired
	private FoodTruckService foodTruckService;

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Creates a foodTruck", notes = "Returns the URL of the new resource in the Location header.")
	public void createFoodTruck(@RequestBody FoodTruck foodTruck, HttpServletRequest request, HttpServletResponse response) {
		FoodTruck createdFoodTruck = this.foodTruckService.createFoodTruck(foodTruck);
		response.setHeader("Location", request.getRequestURL().append("/").append(createdFoodTruck.getId()).toString());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get a single FoodTruck.", notes = "You have to provide a valid foodTruck ID.")
	public @ResponseBody FoodTruck getFoodTruck(@ApiParam(value = "The ID of the existing foodTruck resource.", required = true) @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		return this.foodTruckService.getFoodTruck(Long.parseLong(id));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get a paginated list of all FoodTrucks.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
	public @ResponseBody Page<FoodTruck> getAllFoodTruck(@ApiParam(value = "The page number (zero-based)", required = false) @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUM) Integer page, @ApiParam(value = "The page size", required = false) @RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer size, HttpServletRequest request, HttpServletResponse response) {
		return this.foodTruckService.getAllFoodTrucks(page, size);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get the FoodTruck closest to a given location/locations.", notes = "")
	public @ResponseBody FoodTruck getClosestFoodTruck(@RequestBody Locations locations, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.foodTruckService.getClosestFoodTruck(locations);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get a paginated list of FoodTrucks matching the search criteria.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
	public @ResponseBody Page<FoodTruck> getFoodTruck(@ApiParam(value = "The page number (zero-based)", required = false) @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUM) Integer page, @ApiParam(value = "The page size", required = false) @RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer size, @ApiParam(value = "The name of the foodTruck.", required = false) @RequestParam(value = "name", required = false) String name, @ApiParam(value = "The name of the foodTruck.", required = false) @RequestParam(value = "streetName", required = false) String streetName, @ApiParam(value = "Date in yyyy-MM-dd format", required = false) @RequestParam(value = "date", required = false) String date, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.foodTruckService.getFoodTruck(name, streetName, date, page, size);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete a foodTruck resource.", notes = "You have to provide a valid foodTruck ID in the URL. Once deleted the resource cannot be recovered.")
	public void deleteFoodTruck(@ApiParam(value = "The ID of the existing foodTruck resource.", required = true) @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
		checkResourceFound(this.foodTruckService.getFoodTruck(Long.parseLong(id)));
		this.foodTruckService.deleteFoodTruck(Long.parseLong(id));
	}

	@RequestMapping(value = "/loader", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Load foodTrucks file into DB.", notes = "Donot run this API more than once")
	public void loader(HttpServletRequest request, HttpServletResponse response) {
		try {
			DataLoader.create(foodTruckService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
