package com.travix.medusa.busyflights.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrazyAirMapperTest {

	@Test
	public void toCrazyAirRequestTest(){		
		BusyFlightsRequest request = 
				new BusyFlightsRequest("JED", "HBE", "2017-01-01","2017-01-10", 2);
		
		CrazyAirRequest expectedCrazyAirRequest = 
				new CrazyAirRequest("JED", "HBE", "2017-01-01","2017-01-10", 2);
		
		CrazyAirRequest crazyAirRequest = 
				CrazyAirMapper.toCrazyAirRequest(request);
		
		Assert.isTrue(crazyAirRequest.equals(expectedCrazyAirRequest), "toCrazyAirRequestTest failed");
	}
	
	@Test
	public void toBusyFlightsResponseTest(){
		
	}
}
