package com.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hoteldetails")
public class HotelDetail {
	@Id
	@Column(name="id")
	private int hotelId;
	@Column(name="name")
	private String hotelName;
	@Column(name="rating")
	private String hotelRating;
	@Column(name="rate")
	private String hotelRate;
	@Column(name="availableRooms")
	private int availableRooms;
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelRating() {
		return hotelRating;
	}
	public void setHotelRating(String hotelRating) {
		this.hotelRating = hotelRating;
	}
	public String getHotelRate() {
		return hotelRate;
	}
	public void setHotelRate(String hotelRate) {
		this.hotelRate = hotelRate;
	}
	public int getAvailableRooms() {
		return availableRooms;
	}
	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	
	

}
