package com.travix.medusa.busyflights.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

// Mock outs of remote services

@Controller
public class SupplierServiceMockController {

	@RequestMapping(value = "/mock/CrazyAir/search", method = RequestMethod.POST)
    public @ResponseBody List<CrazyAirResponse> search(@RequestBody CrazyAirRequest request) {
		 List<CrazyAirResponse> flightList = new ArrayList();
		 flightList.add(new CrazyAirResponse("Egypt Air", 1000, "E", "HBE", "JED", 
				 "2017-12-10T10:00:00", "2017-12-10T12:00:00"));
		 flightList.add(new CrazyAirResponse("Emirates", 2000, "B", "HBE", "JED", 
				 "2017-12-10T03:00:00", "2017-12-10T05:00:00"));
		 return flightList;
    }
	
	@RequestMapping(value = "/mock/ToughJet/search", method = RequestMethod.POST)
    public @ResponseBody List<ToughJetResponse> search(@RequestBody ToughJetRequest request) {
		 List<ToughJetResponse> flightList = new ArrayList();
		 flightList.add(new ToughJetResponse("Air Cairo", 1000, 110, 0.25, "HBE", "JED", 
				 "2017-12-10T05:00:00z", "2017-12-10T07:00:00z"));
		 return flightList;
    }
}
