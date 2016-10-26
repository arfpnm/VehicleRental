package com.vehicle.rental;

import com.ar.vehicle.rental.domain.Vehicle;
import com.ar.vehicle.rental.repository.DistanceRepository;
import com.ar.vehicle.rental.service.RentalService;
import com.ar.vehicle.rental.service.RentalServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	public static void main(String[] args){
		
		//"Swift, Diesel, NON AC, Pune-Mumbai-Bangalore-Pune, 3 Passengers";
		RentalService<Vehicle> rentalService = new RentalServiceImpl();
		System.out.println(rentalService.getTotalExpense("Car", "Benz", "Petrol", "AC", "Mumbai-Chennai-Bangalore-Pune", 5));
	}

}
