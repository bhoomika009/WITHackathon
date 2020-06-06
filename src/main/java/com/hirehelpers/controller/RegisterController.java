package com.hirehelpers.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirehelpers.model.entity.Agent;
import com.hirehelpers.model.entity.User;
import com.hirehelpers.model.response.AuthenticationBean;
import com.hirehelpers.model.response.RegisterResponeBean;
import com.hirehelpers.repository.AgentRepository;
import com.hirehelpers.repository.UserRepository;

@RestController
public class RegisterController{

	@Autowired
	AgentRepository agentRepository;

	@Autowired
	UserRepository userRepository;


	@PostMapping("/register/agent")
	public ResponseEntity<RegisterResponeBean> registerAgent(@Valid @RequestBody Agent agent)
	{   
		String message="";
		boolean getAgent = createOrUpdateAgent(agent);
		if(!getAgent)
			message="Agent Registration Successful";
		else
			message="Agent already exists";
		RegisterResponeBean response = new RegisterResponeBean(getAgent,message);
		return new ResponseEntity<RegisterResponeBean>(response, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/register/agent")
	public ResponseEntity<List<Agent>> getAllAgents() {
		List<Agent> agentList = fetchAllAgents();

		return new ResponseEntity<List<Agent>>(agentList, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/register/user")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = fetchAllUsers();

		return new ResponseEntity<List<User>>(userList, new HttpHeaders(), HttpStatus.OK);
	}


	@PostMapping("/register/user")
	public ResponseEntity<RegisterResponeBean> resgiterUser(@Valid @RequestBody User user)
	{   
		String message="";
		boolean getUser = createOrUpdateUser(user);
		if(!getUser)
			message="User Registration Successful";
		else
			message="User already exists";
		RegisterResponeBean response = new RegisterResponeBean(getUser,message);
		return new ResponseEntity<RegisterResponeBean>(response, new HttpHeaders(), HttpStatus.OK);

	}


	public List<User> fetchAllUsers()
	{
		List<User> userList = userRepository.findAll();

		if(userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<User>();
		}
	}

	public List<Agent> fetchAllAgents()
	{
		List<Agent> agentList = agentRepository.findAll();

		if(agentList.size() > 0) {
			return agentList;
		} else {
			return new ArrayList<Agent>();
		}
	}

	public boolean createOrUpdateUser(User entity)
	{
		List<User> user= userRepository.findByUserId(entity.getUserId());	
		System.out.println("User Id: "+ entity.getUserId());

		if(user.size()>0) 
		{
			//			User updateUser = user.get();
			//			updateUser.setFname(entity.getFname());
			//			updateUser.setLname(entity.getLname());
			//			updateUser.setAddress(entity.getAddress());			
			//			updateUser.setContactNumber(entity.getContactNumber());	 
			//			updateUser = userRepository.save(updateUser);
			System.out.println("Existing User");
			return true;
		} else {
			System.out.println("Added new user");
			entity = userRepository.save(entity);

			return false;
		}
	}

	public boolean createOrUpdateAgent(Agent entity)
	{
		System.out.println("Agent Id:"+ entity.getAgentId());
		List<Agent> agent= agentRepository.findByAgentId(entity.getAgentId());


		if(agent.size()>0) 
		{
			//			Agent updateAgent = agent.get();
			//			updateAgent.setAddress(entity.getAddress());
			//			updateAgent.setName(entity.getName());
			//			updateAgent.setContactNumber(entity.getContactNumber());	 
			//			updateAgent = agentRepository.save(updateAgent);
			System.out.println("Existing Agent");
			return true;

		} else {
			System.out.println("Added new Agency");
			entity = agentRepository.save(entity);

			return false;
		}
	} 
}