package com.travix.medusa.busyflights.mapper;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class ToughJetMapper {
	public static ToughJetRequest toToughJetRequest(BusyFlightsRequest busyFlightsRequest){
		ToughJetRequest toughJetRequest = 
				new ToughJetRequest(
						busyFlightsRequest.getOrigin(), 
						busyFlightsRequest.getDestination(),
						busyFlightsRequest.getDepartureDate(),
						busyFlightsRequest.getReturnDate(),
						busyFlightsRequest.getNumberOfPassengers());
		return toughJetRequest;
	}
	
	public static BusyFlightsResponse toBusyFlightsResponse(ToughJetResponse toughJetResponse){
		BusyFlightsResponse busyFlightsResponse = 
				new BusyFlightsResponse(
						toughJetResponse.getCarrier(),
						"ToughJet", 
						toughJetResponse.getTotalPrice(),
						toughJetResponse.getDepartureAirportName(), 
						toughJetResponse.getArrivalAirportName(),
						toughJetResponse.getOutboundDateTime(),
						toughJetResponse.getInboundDateTime());
		return busyFlightsResponse;
	}

}
