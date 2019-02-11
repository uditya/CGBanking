package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IBookingDAO;
import com.cg.dto.BookingDetail;
import com.cg.dto.HotelDetail;

@Service("bookingService")
public class BookingServiceImpl implements IBookingService{
	@Autowired
	IBookingDAO bookingDao=null;
	
	public IBookingDAO getBookingDao() {
		return bookingDao;
	}
	public void setBookingDao(IBookingDAO bookingDao) {
		this.bookingDao = bookingDao;
	}

	@Override
	public ArrayList<HotelDetail> getAllHotelDetails() {
		return bookingDao.getAllHotelDetails();
	}
	@Override
	public BookingDetail addBookingDetail(BookingDetail bookingDetails) {
		return bookingDao.addBookingDetail(bookingDetails);
	}

}
