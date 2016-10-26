package com.ar.vehicle.rental.service;

import java.math.BigDecimal;

public interface RentalService {
	BigDecimal getTotalExpense(String type, String name, String fuelType, String acOrNot, String tripDestinations, int numberOfPassengers);
}