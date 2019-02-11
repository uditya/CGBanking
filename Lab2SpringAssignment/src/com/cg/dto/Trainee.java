package com.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cg_trainee")
public class Trainee {
	@Id
	@Column(name="trainee_id",length=20)
	private int traineeId;
	
	@Column(name="trainee_name",length=40)
	private String traineeName;
	
	@Column(name="trainee_domain",length=30)
	private String traineeDomain;
	
	@Column(name="trainee_location",length=30)
	private String	traineeLocation;
	
	@NotNull(message="ID should be there")
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	
	

}
