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
	
	
//	public static void main(String[] args){
//		
//		//String input = "Swift, Diesel, NON AC, Pune-Mumbai-Bangalore-Pune, 3 Passengers";
//		RentalService<Vehicle> rentalService = new RentalServiceImpl();
//		//System.out.println(rentalService.getTotalExpense("Car", "Swift", "Diesel", "NON AC", "Pune-Mumbai-Bangalore-Pune", 3));
//		System.out.println(rentalService.getTotalExpense("Bus", "Benz", "Petrol", "NON AC", "Mumbai-Chennai-Bangalore-Pune", 47));
//	}
	
    public static void main( String[] args )
    {
    	
    	/*Vehicle vehicle = new Bus();
    	vehicle.setName("Swift");
    	vehicle.setFuelType("Petrol");
    	System.out.println(vehicle.getMaxLimit());
    	
        System.out.println( "Hello World! casdsgsdgsdfvsd" );*/
    	DistanceRepository distanceRepository = new DistanceRepository();
    	
    	String str = "Mumbai-Chennai-Pune";
    	
    	String strArr[] = str.split("-");
    	Double distance = 0D;
    	for(int i =0; i< strArr.length-1;i++){
    		distance +=distanceRepository.getDistanceInKm(strArr[i], strArr[i + 1]);
    	}
    	System.out.println(distance);
    	
    	//BigDecimal bd = new BigDecimal(15);
    	//System.out.println(bd.subtract(BigDecimal.valueOf(1)));
    	//System.out.println(bd.subtract(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP)));
    	
    }
    public static void getStr(String str1, String str2){
    	System.out.println(str1);
    	System.out.println(str2);
    	System.out.println();
    }
}
