package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface IBusyFlightsService {

    List<BusyFlightsResponse> searchFlights(BusyFlightsRequest request);
}
