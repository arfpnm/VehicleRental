package com.vehicle.rental;

import org.junit.Test;

import com.ar.vehicle.rental.domain.Vehicle;
import com.ar.vehicle.rental.repository.DistanceRepository;
import com.ar.vehicle.rental.service.RentalService;
import com.ar.vehicle.rental.service.RentalServiceImpl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

public class TotalRentalExpenseCalculationTest {
	 
	 @Test
	 public void testCalculateExpenseForPetrolAcCarFromMumbaiChennaiPuneWith5Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Car", "Swift", "Petrol", "AC", "Mumbai-Chennai-Pune", 5);
	        assertEquals( BigDecimal.valueOf(20986.50D).setScale(2) , returnValue);
	    }
	 @Test
	 public void testAtestCalculateExpenseForPetrolNonAcCarFromMumbaiChennaiPuneWith5Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Car", "Ambasaddor", "Petrol", "NON AC", "Mumbai-Chennai-Pune", 5);
	        assertEquals( BigDecimal.valueOf(18517.50).setScale(2) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseForPetrolNonAcCarFromMumbaiChennaiPuneWith7Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Car", "Audi", "Petrol", "NON AC", "Mumbai-Chennai-Pune", 7);
	        assertEquals( BigDecimal.valueOf(20986.50).setScale(2) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseForDieselAcCarFromMumbaiChennaiPuneWith5Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Car", "Audi", "Deisel", "AC", "Mumbai-Chennai-Pune", 7);
	        assertEquals( BigDecimal.valueOf(19752.00).setScale(2) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseForPetrolAcWithoutPassingVehicleType()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("", "Swift", "Petrol", "AC", null, 5);
	        assertEquals( BigDecimal.valueOf(0) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseForPetrolAcBusFromMumbaiChennaiBangalorePuneWith5Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Bus", "Swift", "Petrol", "AC", "Mumbai-Chennai-Bangalore-Pune", 5);
	        assertEquals( BigDecimal.valueOf(37316.150).setScale(3) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseForPetrolNonAcBusFromMumbaiChennaiBangalorePuneWith5Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Bus", "Benz", "Petrol", "NON AC", "Mumbai-Chennai-Bangalore-Pune", 45);
	        assertEquals( BigDecimal.valueOf(32847.150).setScale(3) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseForPetrolNonAcBusFromMumbaiChennaiBangalorePuneWith47Passengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Bus", "Benz", "Petrol", "NON AC", "Mumbai-Chennai-Bangalore-Pune", 47);
	        assertEquals( BigDecimal.valueOf(37316.150).setScale(3) , returnValue);
	    }
	 @Test
	 public void testCalculateExpenseWithoutPassingPassengers()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense("Car", "Polo", "Petrol", "AC", null, 0);
	        assertEquals( BigDecimal.valueOf(0).setScale(2) , returnValue);
	    }
	
	 @Test
	 public void testCalculateExpenseByPassingNullarguments()
	    {
		 RentalService rentalService = new RentalServiceImpl();
			BigDecimal returnValue = rentalService.getTotalExpense(null, null, null, null, null, 0);
	        assertEquals( BigDecimal.valueOf(0) , returnValue);
	    }
	 @Test
	 public void testCalculateDistanceBetweenMumbaiChennaiBangalorePune(){
		 DistanceRepository distanceRepository = new DistanceRepository();
		 Double returnValue = distanceRepository.getDistanceInKm("Mumbai", "Chennai");
		 assertEquals(Double.valueOf(1234.5D), returnValue);
	 }
	 @Test
	 public void testCalculateDistanceWithoutToDestination(){
		 DistanceRepository distanceRepository = new DistanceRepository();
		 Double returnValue = distanceRepository.getDistanceInKm("Mumbai", "");
		 assertEquals(Double.valueOf(0D), returnValue);
	 }
	 @Test
	 public void testCalculateDistanceWithoutFrom(){
		 DistanceRepository distanceRepository = new DistanceRepository();
		 Double returnValue = distanceRepository.getDistanceInKm("", "Chennai");
		 assertEquals(Double.valueOf(0D), returnValue);
	 }

}
