package com.training.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.userservice.dao.User;
import com.training.userservice.dto.OrderDto;
import com.training.userservice.dto.UserDto;
import com.training.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${orders.service.url}")
	private String orderserviceurl;
	

	public UserController() {
	}
	
	@GetMapping(value = "/greet/{msg}")
	public String greet(@PathVariable String msg) {
		return restTemplate.postForObject(orderserviceurl+"/hello",msg,String.class);
	}
	
	@GetMapping("/orders/{uid}")
	public UserDto getOrders(@PathVariable Integer uid) {
		User user = service.getUserById(uid);
		List<OrderDto> orders = restTemplate.getForObject(orderserviceurl+"/orders/user/"+uid, List.class);
		UserDto usrdto = new UserDto(user.getUid(),user.getName(), user.getContact(), orders);
		return usrdto;
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("msg", "Hello There!!!");
		httpHeaders.add("total_users",service.getAllUsers().size()+"");
		return new ResponseEntity<List<User>>(service.getAllUsers(),httpHeaders,HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public User getUserByName(@PathVariable String name) {
		return service.getUserbyName(name);
	}
	
	@GetMapping("/page/{pageSize}/{pageNumber}")
	public List<User> getUserByPage(@PathVariable Integer pageSize,@PathVariable Integer pageNumber){
		return service.getUserByPage(pageSize, pageNumber);
	}
	
	@GetMapping("/sort/{sortcol}/{sorttype}")
	public List<User> getUserBySort(@PathVariable String sortcol,@PathVariable String sorttype){
		return service.getUsersBySort(sortcol,sorttype);
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable Integer uid) {
		//return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("msg", "Hello There!!!");
		return ResponseEntity.ok().headers(httpHeaders).body(service.getUserById(uid));
		
	}
	
	@GetMapping("/req")
	public ResponseEntity<User> getUserByIdReq(@RequestParam Integer uid) {
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		return new ResponseEntity<User>(service.saveUser(u),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable Integer uid,@RequestBody User u) {
		return new ResponseEntity<User>(service.updateUser(uid, u),HttpStatus.CREATED);
	}
	
	@PatchMapping("/semiupdate/{uid}")
	public ResponseEntity<User> updateUserproperty(@PathVariable Integer uid,@RequestBody User u) {
		return new ResponseEntity<User>(service.updateUser(uid, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		return new ResponseEntity<String>(service.deleteUser(id),HttpStatus.ACCEPTED);
	}
	
	
}
