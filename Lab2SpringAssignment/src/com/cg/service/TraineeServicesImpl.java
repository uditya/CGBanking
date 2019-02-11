package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.TraineeDao;
import com.cg.dto.Login;
import com.cg.dto.Trainee;

@Service("traineeServ")
public class TraineeServicesImpl implements TraineeServices{
	@Autowired
	TraineeDao logDao=null;

	public TraineeDao getLogDao() {
		return logDao;
	}

	public void setLogDao(TraineeDao logDao) {
		this.logDao = logDao;
	}
	
	@Override
	public boolean isUserExist(String usn) {
		return logDao.isUserExist(usn);
	}

	@Override
	public Login validateUser(Login login) {
		Login dbUser=logDao.validateUser(login);
		if(login.getUsername().equalsIgnoreCase(dbUser.getUsername())
				&& login.getPassword().equalsIgnoreCase(dbUser.getPassword() ))
		{
			return login;
		}
		else {
			return null;
		}
	}

	@Override
	public Trainee addTrainee(Trainee traineeDetails) {
		return logDao.addTrainee(traineeDetails);
	}

	@Override
	public Trainee deleteTrainee(int traineeId) {
		return logDao.deleteTrainee(traineeId);
	}

	@Override
	public ArrayList<Trainee> getAllUserDetails() {
		return logDao.getAllUserDetails();
	}

	@Override
	public Trainee searchTrainee(int traineeId) {
		return logDao.searchTrainee(traineeId);
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		return logDao.updateTrainee(trainee);
	}

}
