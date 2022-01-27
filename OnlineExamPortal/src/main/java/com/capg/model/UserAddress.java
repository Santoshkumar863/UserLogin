package com.capg.model;

import javax.persistence.Embeddable;

@Embeddable
public class UserAddress {
	
	private String country;
	private String state;
	private String city;
	private long zip;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "UserAddress [country=" + country + ", state=" + state + ", city=" + city + ", zip=" + zip + "]";
	}
	


}
