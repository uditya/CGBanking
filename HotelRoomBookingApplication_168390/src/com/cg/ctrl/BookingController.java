package com.cg.ctrl;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.dto.BookingDetail;
import com.cg.dto.HotelDetail;
import com.cg.service.IBookingService;

@Controller
public class BookingController {
	@Autowired
	IBookingService bookingService=null;

	public IBookingService getBookingService() {
		return bookingService;
	}

	public void setBookingService(IBookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	
	/**************************************Hotel Details*******************************************/
	
	@RequestMapping(value="/hotelDetailController", method=RequestMethod.GET)
	public String listAllTrainee(
														@ModelAttribute(value="hdetail")
														@Valid
														HotelDetail hd, BindingResult result, 
														Model model) {
			
			ArrayList<HotelDetail> hotelList=bookingService.getAllHotelDetails();
			model.addAttribute("hotelListObj", hotelList);
			return "HotelDetailsPage";
			}
	
	/********************************Booking Page***************************************/
	@RequestMapping(value="/bookingController1", method=RequestMethod.GET)
	public String bookingHotel1(Model model) {
			BookingDetail bookingDetail=new BookingDetail();
			model.addAttribute("hd",bookingDetail);
			return "HotelBooking";
		}
	
	/**************************************Store Booking Details**********************************/
	@RequestMapping(value="/bookingDetails", method=RequestMethod.POST)
	public String addBookingDetails(
														@ModelAttribute(value="hd")
														@Valid
														BookingDetail bd, BindingResult result) {
			bookingService.addBookingDetail(bd);
		//	model.addAttribute("hotel1","your Rooms are booked at Us");
			return "BookingConfirmation";
	}
	

}
