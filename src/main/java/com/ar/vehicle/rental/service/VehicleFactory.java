package com.ar.vehicle.rental.service;

import com.ar.vehicle.rental.domain.Bus;
import com.ar.vehicle.rental.domain.Car;
import com.ar.vehicle.rental.domain.Suv;
import com.ar.vehicle.rental.domain.Van;
import com.ar.vehicle.rental.domain.Vehicle;

public class VehicleFactory {
	
	    public static Vehicle buildVehicleType(String type)
	    {
	        Vehicle vehicle = null;
	        if(type == null) return null;
	        if(type.equalsIgnoreCase("Car")){
				vehicle = new Car();
				vehicle.setType("Car");
				vehicle.setMaxLimit(5);
			}
			if(type.equalsIgnoreCase("Bus")){
				vehicle = new Bus();
				vehicle.setType("Bus");
				vehicle.setMaxLimit(45);
			}
			if(type.equalsIgnoreCase("Van")){
				vehicle = new Van();
				vehicle.setType("Van");
				vehicle.setMaxLimit(20);
			}
			if(type.equalsIgnoreCase("Suv")){
				vehicle = new Suv();
				vehicle.setType("Suv");
				vehicle.setMaxLimit(8);
			}
			return vehicle;
	    }
	}
