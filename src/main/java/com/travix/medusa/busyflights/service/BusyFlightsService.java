package com.travix.medusa.busyflights.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.BusyFlightsApplication;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.mapper.CrazyAirMapper;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.mapper.ToughJetMapper;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BusyFlightsService implements IBusyFlightsService{
	
	private static final Logger logger = LoggerFactory.getLogger(BusyFlightsService.class);

	@Value("${crazyAir.search}")
	private String crazyAirUrl;
	
	@Value("${toughJet.search}")
	private String toughJetUrl;
	    	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request){
    	// todo validations
    	if(logger.isDebugEnabled())
    		logger.debug(request.toString());
    	
    	ToughJetRequest toughJetRequest = ToughJetMapper.toToughJetRequest(request);
    	CrazyAirRequest crazyAirRequest = CrazyAirMapper.toCrazyAirRequest(request);
    	   	
    	CrazyAirResponse[] crazyAirFlights = 
    			getFlightsFromSupplier(crazyAirUrl, crazyAirRequest, CrazyAirResponse[].class);
    	
    	ToughJetResponse[] toughJetFlights = 
    			getFlightsFromSupplier(toughJetUrl, toughJetRequest, ToughJetResponse[].class);    	
    	
    	List<BusyFlightsResponse> response = Arrays.stream(crazyAirFlights)
                .map(CrazyAirMapper::toBusyFlightsResponse)
                .collect(Collectors.toList());
    	
    	response.addAll(Arrays.stream(toughJetFlights)
                .map(ToughJetMapper::toBusyFlightsResponse)
                .collect(Collectors.toList()));
    	
    	Collections.sort(response);
    	
    	if(logger.isDebugEnabled())
    		response.forEach(System.out::print);
    	
		return response;
    }
    
    private <T> T getFlightsFromSupplier(String url, Object request, Class<T> responseType){
    	T response = restTemplate.postForObject(url, request, responseType);
        return response;
    }
}
