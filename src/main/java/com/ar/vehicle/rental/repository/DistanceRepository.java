package com.ar.vehicle.rental.repository;

import java.util.ArrayList;
import java.util.List;

import com.ar.vehicle.rental.domain.Distance;

public class DistanceRepository {

	/**
	 * @param from
	 * @param to
	 * @return Double (Distance in KM)
	 */
	public Double getDistanceInKm(String from, String to){
		if(from == null || to == null) return null;
		List<Distance> distanceList = initDistances();
		Distance1 distance = distanceList.stream().filter(d -> d.getFrom().equalsIgnoreCase(from) && 
				d.getTo().equalsIgnoreCase(to)).findAny().orElse(null);
		return distance == null ? 0.0D : distance.getDistance();
	}

	/**
	 * @return List<Distance>
	 * TODO: The distance values should be pulled from database. It has been hard coded at the moment
	 * 'from' and 'to' destination should be properly added. Logic doesn't cover vis versa routes
	 */
	private List<Distance> initDistances(){
		List<Distance> distanceList = new ArrayList<Distance>();
		Distance distancePuneToMumbai = new Distance();
		distancePuneToMumbai.setFrom("Pune");
		distancePuneToMumbai.setTo("Mumbai");
		distancePuneToMumbai.setDistance(200.00D);
		
		Distance distanceMumbaiToPune = new Distance();
		distanceMumbaiToPune.setFrom("Mumbai");
		distanceMumbaiToPune.setTo("Pune");
		distanceMumbaiToPune.setDistance(200.00D);

		Distance distancePuneToBangalore = new Distance();
		distancePuneToBangalore.setFrom("Pune");
		distancePuneToBangalore.setTo("Bangalore");
		distancePuneToBangalore.setDistance(1000.00D);
		
		Distance distanceBangaloreToPune = new Distance();
		distanceBangaloreToPune.setFrom("Bangalore");
		distanceBangaloreToPune.setTo("Pune");
		distanceBangaloreToPune.setDistance(1000.00D);

		Distance distanceMumbaiToDelhi = new Distance();
		distanceMumbaiToDelhi.setFrom("Mumbai");
		distanceMumbaiToDelhi.setTo("Delhi");
		distanceMumbaiToDelhi.setDistance(2050.00D);
		
		Distance distanceDelhiToMumbai = new Distance();
		distanceDelhiToMumbai.setFrom("Delhi");
		distanceDelhiToMumbai.setTo("Mumbai");
		distanceDelhiToMumbai.setDistance(2050.00D);

		Distance distanceMumbaiToChennai = new Distance();
		distanceMumbaiToChennai.setFrom("Mumbai");
		distanceMumbaiToChennai.setTo("Chennai");
		distanceMumbaiToChennai.setDistance(1234.5D);
		
		Distance distanceChennaiToMumbai = new Distance();
		distanceChennaiToMumbai.setFrom("Chennai");
		distanceChennaiToMumbai.setTo("Mumbai");
		distanceChennaiToMumbai.setDistance(1234.5D);

		Distance distanceMumbaiToBangalore = new Distance();
		distanceMumbaiToBangalore.setFrom("Mumbai");
		distanceMumbaiToBangalore.setTo("Bangalore");
		distanceMumbaiToBangalore.setDistance(800.00D);
		
		Distance distanceBangaloreToMumbai = new Distance();
		distanceBangaloreToMumbai.setFrom("Bangalore");
		distanceBangaloreToMumbai.setTo("Mumbai");
		distanceBangaloreToMumbai.setDistance(800.00D);

		Distance distanceBangaloreToDelhi = new Distance();
		distanceBangaloreToDelhi.setFrom("Bangalore");
		distanceBangaloreToDelhi.setTo("Delhi");
		distanceBangaloreToDelhi.setDistance(3000.00D);
		
		Distance distanceDelhiToBangalore = new Distance();
		distanceDelhiToBangalore.setFrom("Delhi");
		distanceDelhiToBangalore.setTo("Bangalore");
		distanceDelhiToBangalore.setDistance(3000.00D);

		distanceList.add(distancePuneToMumbai);
		distanceList.add(distanceMumbaiToPune);
		distanceList.add(distancePuneToBangalore);
		distanceList.add(distanceBangaloreToPune);
		distanceList.add(distanceMumbaiToDelhi);
		distanceList.add(distanceDelhiToMumbai);
		distanceList.add(distanceMumbaiToChennai);
		distanceList.add(distanceChennaiToMumbai);
		distanceList.add(distanceMumbaiToBangalore);
		distanceList.add(distanceBangaloreToMumbai);
		distanceList.add(distanceBangaloreToDelhi);
		distanceList.add(distanceDelhiToBangalore);

		return distanceList;
	}

}
