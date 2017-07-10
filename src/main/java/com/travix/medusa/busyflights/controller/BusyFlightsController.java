package com.travix.medusa.busyflights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;

@Controller
public class BusyFlightsController {
	@Autowired
    private BusyFlightsService service;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<BusyFlightsResponse> search(@RequestBody BusyFlightsRequest request) {
        return service.searchFlights(
                new BusyFlightsRequest(
                		request.getOrigin(), 
                		request.getDestination(), 
                		request.getDepartureDate(), 
                		request.getReturnDate(), 
                		request.getNumberOfPassengers()));
    }
}
