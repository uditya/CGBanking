package com.cg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.dto.Login;
import com.cg.dto.Trainee;

@Repository("loginDao")
@Transactional
public class TraineeDaoImpl implements TraineeDao{

	@PersistenceContext
	EntityManager entityManager=null;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean isUserExist(String usn) 
	{
		Login usr=entityManager.find(Login.class, usn);
		if(usr!=null)
		{
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public Login validateUser(Login login) {
		Login usr=entityManager.find(Login.class, login.getUsername());
		return usr;
	}

	@Override
	public Trainee addTrainee(Trainee traineeDetails) {
		entityManager.persist(traineeDetails);
		entityManager.flush();
		Trainee rd=entityManager.find(Trainee.class, traineeDetails.getTraineeId());
		return rd;
	}

	@Override
	public ArrayList<Trainee> getAllUserDetails() {
		String qry="SELECT reg FROM Trainee reg" ;
		TypedQuery tq=entityManager.createQuery(qry,Trainee.class);
		ArrayList<Trainee> uList=(ArrayList)tq.getResultList();
		return uList;
	}

	@Override
	public Trainee deleteTrainee(int traineeId) {
		Trainee redDto=entityManager.find(Trainee.class, traineeId);
	
		entityManager.remove(redDto);
		entityManager.flush();
		return redDto;
	}

	@Override
	public Trainee searchTrainee(int traineeId) {
		Trainee search=entityManager.find(Trainee.class, traineeId);
		return search;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		entityManager.find(Trainee.class, trainee.getTraineeId());
		Trainee upd=entityManager.merge(trainee);
		entityManager.flush();
		return upd;
	}

}
