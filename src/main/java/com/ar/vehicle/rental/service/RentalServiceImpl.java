package com.ar.vehicle.rental.service;

import java.math.BigDecimal;

import com.ar.vehicle.rental.domain.Vehicle;
import com.ar.vehicle.rental.repository.DistanceRepository;

public class RentalServiceImpl implements RentalService{

	private final static DistanceRepository distanceRepository = new DistanceRepository();
	private final static String vBus = "Bus"; 
	private final static String vPetrol = "Petrol";
	private final static String AC="AC";

	/**
	 * @param type
	 * @param name
	 * @param fuelType
	 * @param acOrNot
	 * @param tripDestinations
	 * @param numberOfPassengers
	 * @return BigDecmal (Total Expense)
	 * This public method expects the input in following format (eg: "Car", "Swift", "Petrol", "NON AC", "Mumbai-Chennai-Pune", 5) and returns the
	 * total expense calculation
	 */
	@Override
	public BigDecimal getTotalExpense(String type, String name, String fuelType, String acOrNot, String tripDestinations, int numberOfPassengers) {
		Vehicle vehicle = VehicleFactory.buildVehicleType(type);
		if(vehicle == null) return BigDecimal.ZERO;
		vehicle.setName(name);
		vehicle.setFuelType(fuelType);
		vehicle.setAc( (acOrNot != null && !acOrNot.isEmpty()) && acOrNot.equalsIgnoreCase(AC) ? true : false);
		return calculateTotalExpenses(vehicle, calculateDistanceBetweenDestinations(tripDestinations), numberOfPassengers);
	}

	private BigDecimal calculateTotalExpenses(Vehicle vehicle, Double totalDistance, int numberOfPassengers){
		
		if(vehicle == null) return null;
		BigDecimal totalExpense = BigDecimal.valueOf(0);

		BigDecimal standardRate = calculateStandardRate(vehicle);
		
		totalExpense=totalExpense.add(standardRate.multiply(BigDecimal.valueOf(totalDistance)));
		
		totalExpense=totalExpense.add(vehicle.getFuelType() != null && 
						vehicle.getFuelType().equalsIgnoreCase(vPetrol) && vehicle.isAc() ? 
								BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(totalDistance)) : BigDecimal.ZERO);
		
		totalExpense=totalExpense.add(numberOfPassengers > vehicle.getMaxLimit() ? 
				BigDecimal.valueOf(1).multiply(BigDecimal.valueOf(totalDistance)).
				multiply(BigDecimal.valueOf(numberOfPassengers - vehicle.getMaxLimit())) : BigDecimal.ZERO); 
		return totalExpense;
	}

	/**
	 * @param tripDestinations
	 * @return Double (distance)
	 * This method takes an input of String, with destinations and it expects the '-' delimiter (eg: Pune-Mumbai-Bangalore).
	 * The distance will be calculated based on the 'from' and 'to' destinations or multiple destinations.
	 */
	private Double calculateDistanceBetweenDestinations(String tripDestinations){
		if(tripDestinations == null ||tripDestinations.isEmpty()) return 0D;
		String strArr[] = tripDestinations.split("-");
		Double distance = 0D;
		for(int i =0; i< strArr.length-1;i++){
			distance += distanceRepository.getDistanceInKm(strArr[i], strArr[i + 1]);
		}
		return distance;
	}
	
	/**
	 * @param vehicle
	 * @param standardRate
	 * @return BigDecimal (Recalculated Standard Rate)
	 * 
	 * The standard rate will be set to its default value.
	 * The standard rate will be re-calculated if the Vehicle is bus. 
	 * 1 Rupee will be reduced from the standard rate if the fuel type is 'Diesel'
	 *  
	 */
	private BigDecimal calculateStandardRate(Vehicle vehicle){
		BigDecimal standardRate = BigDecimal.valueOf(15.00);
		standardRate = standardRate.subtract(vehicle.getType().equalsIgnoreCase(vBus) ? calculateStandardRateForBus(standardRate) : BigDecimal.ZERO);
		standardRate = vehicle.getFuelType() != null && !vehicle.getFuelType().equalsIgnoreCase(vPetrol) ? standardRate.subtract(BigDecimal.valueOf(1)) : standardRate;
		return standardRate;
	}
	
	/**
	 * @param standardRate
	 * @return BigDecimal
	 * This method calculates the standard rate for bus
	 */
	private BigDecimal calculateStandardRateForBus(BigDecimal standardRate){
		return  standardRate.multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
	}
}
