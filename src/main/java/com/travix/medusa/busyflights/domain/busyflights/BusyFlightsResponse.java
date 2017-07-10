package com.travix.medusa.busyflights.domain.busyflights;

public class BusyFlightsResponse implements Comparable<BusyFlightsResponse>{
	
	private String airline;
	private String supplier;
	
	private double fare;

    @Override
	public String toString() {
		return "BusyFlightsResponse [airline=" + airline + ", supplier="
				+ supplier + ", fare=" + fare + ", departureAirportCode="
				+ departureAirportCode + ", destinationAirportCode="
				+ destinationAirportCode + ", departureDate=" + departureDate
				+ ", arrivalDate=" + arrivalDate + "]";
	}

	private String departureAirportCode;
    private String destinationAirportCode;

    private String departureDate;
    private String arrivalDate;
    
    public BusyFlightsResponse(){
    	
    }
    
    public BusyFlightsResponse(String airline, String supplier, double fare, 
    		String departureAirportCode, String destinationAirportCode,
    		String departureDate, String arrivalDate){
    	this.setAirline(airline);
    	this.setSupplier(supplier);
    	
    	this.setFare(fare);

    	this.setDepartureAirportCode(departureAirportCode);
    	this.setDestinationAirportCode(destinationAirportCode);

    	this.setDepartureDate(departureDate);
    	this.setArrivalDate(arrivalDate);
    }
    
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public int compareTo(BusyFlightsResponse other) {
        return Double.compare(this.fare, other.fare);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
		result = prime * result
				+ ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime
				* result
				+ ((departureAirportCode == null) ? 0 : departureAirportCode
						.hashCode());
		result = prime * result
				+ ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime
				* result
				+ ((destinationAirportCode == null) ? 0
						: destinationAirportCode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(fare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusyFlightsResponse other = (BusyFlightsResponse) obj;
		if (airline == null) {
			if (other.airline != null)
				return false;
		} else if (!airline.equals(other.airline))
			return false;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (departureAirportCode == null) {
			if (other.departureAirportCode != null)
				return false;
		} else if (!departureAirportCode.equals(other.departureAirportCode))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (destinationAirportCode == null) {
			if (other.destinationAirportCode != null)
				return false;
		} else if (!destinationAirportCode.equals(other.destinationAirportCode))
			return false;
		if (Double.doubleToLongBits(fare) != Double
				.doubleToLongBits(other.fare))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}
}
