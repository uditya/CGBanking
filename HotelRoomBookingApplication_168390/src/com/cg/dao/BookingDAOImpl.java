package com.cg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.dto.BookingDetail;
import com.cg.dto.HotelDetail;
@Repository("hotelDao")
@Transactional
public class BookingDAOImpl implements IBookingDAO{
	@PersistenceContext
	EntityManager entityManager=null;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public ArrayList<HotelDetail> getAllHotelDetails() {
		String qry="SELECT hdetail FROM HotelDetail hdetail" ;
		TypedQuery tq=entityManager.createQuery(qry,HotelDetail.class);
		ArrayList<HotelDetail> hotelList=(ArrayList)tq.getResultList();
		return hotelList;
	}
	@Override
	public BookingDetail addBookingDetail(BookingDetail bookingDetails) {
		entityManager.persist(bookingDetails);
		entityManager.flush();
		BookingDetail bd=entityManager.find(BookingDetail.class, bookingDetails.getId());
		return bd;
	}

}
