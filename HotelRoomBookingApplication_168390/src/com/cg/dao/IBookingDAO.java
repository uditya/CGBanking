package com.cg.dao;

import java.util.ArrayList;

import com.cg.dto.BookingDetail;
import com.cg.dto.HotelDetail;

public interface IBookingDAO {
	public ArrayList<HotelDetail> getAllHotelDetails();
	public BookingDetail addBookingDetail(BookingDetail bookingDetails);
}
