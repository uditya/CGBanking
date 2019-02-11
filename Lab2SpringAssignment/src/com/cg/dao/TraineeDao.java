package com.cg.dao;

import java.util.ArrayList;

import com.cg.dto.Login;
import com.cg.dto.Trainee;

public interface TraineeDao {
	public boolean isUserExist(String usn);
	public Login validateUser(Login login);
	public Trainee addTrainee(Trainee traineeDetails);
	public Trainee deleteTrainee(int traineeId);
	public ArrayList<Trainee> getAllUserDetails();
	public Trainee searchTrainee(int traineeId);
	public Trainee updateTrainee(Trainee trainee);
}
