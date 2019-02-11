package com.cg.ctrl;


import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.dto.Login;
import com.cg.dto.Trainee;
import com.cg.service.TraineeServices;

@Controller
public class EmployeeController {
	
	@Autowired
	TraineeServices traineeServ=null;

	public TraineeServices getTraineeServ() {
		return traineeServ;
	}

	public void setTraineeServ(TraineeServices traineeServ) {
		this.traineeServ = traineeServ;
	}
	
	/*********************Login Page*************************/
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public String displayLoginpage(Model model) {
		Login lg=new Login();
		lg.setUsername("enter your user name");
		model.addAttribute("log", lg);
		model.addAttribute("compNameObj", "Capgemini");
		return "Login";
	}
	
/***********************Validate Admin********************/
	
	@RequestMapping(value="/ValidateUser", method=RequestMethod.POST)
	public String validateUserDetails(
															@ModelAttribute (value="log")
															@Valid Login lg, BindingResult result,
															Model model)
	{
		if(result.hasErrors()) 
			return "Login";
		else {
				if(traineeServ.isUserExist(lg.getUsername())) {
				Login user=traineeServ.validateUser(lg);
				if(user!=null) {
					return "Success";
				}
				else 
						return "Failure";
				}
				else
			return "redirect:/Login.obj";
		}
	}
		
	
	/*********************************ShowAddTraineePage***************************/
	
	@RequestMapping(value="/AddTraineePage", method=RequestMethod.GET)
		public String dispAddTraineePage(Model model) {
		
		Trainee rd=new Trainee();
		model.addAttribute("reg",rd);
		return "AddTraineePage";
	}
	
	
	/**********************************************************Store Trainee Details***********************************/
	
	@RequestMapping(value="/addTrainee", method=RequestMethod.POST)
	public String addTraineeDetails(
														@ModelAttribute(value="reg")
														@Valid
														Trainee rd, BindingResult result) {
			if(result.hasErrors()) {
				return "AddTraineePage";
			}
			else {
			traineeServ.addTrainee(rd);
			return "Success";
			}
	}
	
	
	/*******************************************listall trainee***************************************************/
	
	@RequestMapping(value="/ListAllTraineePage", method=RequestMethod.GET)
	public String listAllTrainee(
														@ModelAttribute(value="reg")
														@Valid
														Trainee rd, BindingResult result, 
														Model model) {
			
			ArrayList<Trainee> userList=traineeServ.getAllUserDetails();
			model.addAttribute("userListObj", userList);
			return "ListAllTraineePage";
			}
	
	/****************************delete************************************************/
	@RequestMapping(value="/deleteTraineePage", method=RequestMethod.GET)
	public String deleteTraineePage(Model model) {
			model.addAttribute("tr",new Trainee());
			return "DeleteTrainee";
		}
	

	@RequestMapping(value="/deleteTrainee", method=RequestMethod.POST)
	public String deleteTrainee(@ModelAttribute @Value(value="tr") Trainee trainee ,Model model) {
		traineeServ.deleteTrainee(trainee.getTraineeId());
		model.addAttribute("msg", "Trainee Deleted");
		return "Success";
	}
	
	/**********************************search single trainee*******************************************/
	@RequestMapping(value="/searchTraineePage",method=RequestMethod.GET)
	public String searchTraineePage(Model model) {
		model.addAttribute("trainee",new Trainee());
		return "ListTrainee";
	}
	
	@RequestMapping(value="/listTrainee",method=RequestMethod.POST)
	public String searchTrainee(@ModelAttribute @Value(value="trainee") Trainee trainee ,Model model) {
		 trainee=traineeServ.searchTrainee(trainee.getTraineeId());
	        if((trainee)!= null) {
	            model.addAttribute("trainee", trainee);
	            model.addAttribute("htmlCode", "<table border=\"3\" style=\"width:30%\"><tr><th>Name</th><th>ID</th><th>Domain</th><th>Location</th></tr><td>"
	            +trainee.getTraineeName()+"</td><td>"+ trainee.getTraineeId()+"</td><td>"
	            +trainee.getTraineeDomain()+"</td><td>"+trainee.getTraineeLocation()
	            +"</td></tr></table>");
	            return "ListTrainee";
	        }
	        return null;
	}
	
	/**************************************Update Trainee****************************************************/
	@RequestMapping(value="/updateTraineePage",method=RequestMethod.GET)
	public String updateTraineePage(Model model) {
		model.addAttribute("trainee",new Trainee());
		return "UpdateTraineePage";
	}
		
		@RequestMapping(value="/updateTrainee",method=RequestMethod.POST)
		public String updateTrainee(@ModelAttribute @Value(value="trainee") Trainee trainee ,Model model) {
			Trainee trr=traineeServ.updateTrainee(trainee);
			model.addAttribute("msg","trainee updated");
			return "Success";
		}	
}

	

	

