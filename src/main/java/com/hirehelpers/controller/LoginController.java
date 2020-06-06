package com.hirehelpers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hirehelpers.model.entity.Agent;
import com.hirehelpers.model.entity.LoginRequestBean;
import com.hirehelpers.model.entity.User;
import com.hirehelpers.model.response.LoginResponse;
import com.hirehelpers.repository.AgentRepository;
import com.hirehelpers.repository.UserRepository;


@Controller
@RequestMapping("/login")
public class LoginController{


	@Autowired
	UserRepository userRepository;

	@Autowired
	AgentRepository agentRepository;

	@PostMapping("/user")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequestBean loginUser){
		try{
			String userId = loginUser.getLoginId();
			String userPwd =loginUser.getLoginPwd();

			System.out.println("User ID : "+ userId);
			System.out.println("User Pwd : "+ userPwd);
			List<User> user =userRepository.findByUserIdPwd(userId,userPwd);

			if(user.size()>0){
				System.out.println("User found : "+ userId);
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setId(user.get(0).getId());
				loginResponse.setStatus("Success");
				return new ResponseEntity<LoginResponse>(loginResponse, new HttpHeaders(), HttpStatus.OK);
			}
			else{ 
				System.out.println("User not found :"+ userId);
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setId(user.get(0).getId());
				loginResponse.setStatus("Fail");
				return new ResponseEntity<LoginResponse>(loginResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
			}
			//	return new ResponseEntity<List<User>>(user, new HttpHeaders(), HttpStatus.OK);	
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<LoginResponse>(new LoginResponse(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/agent")
	public ResponseEntity<LoginResponse> loginAgent(@Valid @RequestBody LoginRequestBean loginAgent) {
		try{
			String agentId = loginAgent.getLoginId();
			String agentPwd =loginAgent.getLoginPwd();

			System.out.println("Agent ID : "+ agentId);
			System.out.println("Agent Pwd : "+ agentPwd);
			List<Agent> agent =agentRepository.findByAgentIdPwd(agentId, agentPwd);	

			if(agent.size()>0){
				System.out.println("User found : "+ agentId);
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setId(agent.get(0).getId());
				loginResponse.setStatus("Success");
				return new ResponseEntity<LoginResponse>(loginResponse, new HttpHeaders(), HttpStatus.OK);
			}
			else{ 
				System.out.println("User not found :"+ agentId);
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setId(agent.get(0).getId());
				loginResponse.setStatus("Fail");
				return new ResponseEntity<LoginResponse>(loginResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<LoginResponse>(new LoginResponse(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		//		return new ResponseEntity<List<Agent>>(agent, new HttpHeaders(), HttpStatus.OK);		
	}


}
