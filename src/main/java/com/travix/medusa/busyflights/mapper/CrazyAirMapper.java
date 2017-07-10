package com.travix.medusa.busyflights.mapper;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

public class CrazyAirMapper {

	public static CrazyAirRequest toCrazyAirRequest(BusyFlightsRequest busyFlightsRequest){
		CrazyAirRequest crazyAirRequest = 
				new CrazyAirRequest(
						busyFlightsRequest.getOrigin(), 
						busyFlightsRequest.getDestination(),
						busyFlightsRequest.getDepartureDate(),
						busyFlightsRequest.getReturnDate(),
						busyFlightsRequest.getNumberOfPassengers());
		return crazyAirRequest;
	}
	
	public static BusyFlightsResponse toBusyFlightsResponse(CrazyAirResponse crazyAirResponse){
		BusyFlightsResponse busyFlightsResponse = 
				new BusyFlightsResponse(
						crazyAirResponse.getAirline(), 
						"CrazyAir", 
						crazyAirResponse.getPrice(), 
						crazyAirResponse.getDepartureAirportCode(), 
						crazyAirResponse.getDestinationAirportCode(),
						crazyAirResponse.getDepartureDate(), 
						crazyAirResponse.getArrivalDate());
		return busyFlightsResponse;
	}
}
