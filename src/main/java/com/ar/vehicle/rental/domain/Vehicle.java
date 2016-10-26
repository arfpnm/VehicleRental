package com.ar.vehicle.rental.domain;

public class Vehicle {
	
	private String name;
	private String type;
	private String fuelType;
	private boolean isAc;
	private int maxLimit;
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getFuelType() {
		return fuelType;
	}
	public boolean isAc() {
		return isAc;
	}
	public int getMaxLimit() {
		return maxLimit;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

}
