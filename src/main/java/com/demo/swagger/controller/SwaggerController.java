package com.demo.swagger.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.swagger.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Swagger Demo")
@RestController
public class SwaggerController {

	@ApiOperation(value = "addUser", notes = "user registration", response = User.class, tags = { "addUser" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = User.class, message = "Successfully user has been added"),
			@ApiResponse(code = 400, message = "Bad Request, Input params are invalid"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
		user.setUserId(12345L);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "getUser", notes = "get user details by userid", response = User.class, tags = { "getUser" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = User.class, message = "Successfully user has been added"),
			@ApiResponse(code = 400, message = "Bad Request, Input params are invalid"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUser(
			@ApiParam(name = "userId", allowEmptyValue = false, allowMultiple = false, required = true, type = "Long", hidden = false, example = "12345") @RequestParam("userId") @NotNull Long userId) {
		User user = new User();
		user.setFirstName("Suresh");
		user.setLastName("E");
		user.setPhoneNumber("8125743669");
		user.setUserId(12345L);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "update User", notes = "update user details", response = User.class, tags = { "updateUser" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = User.class, message = "Successfully user has been updated"),
			@ApiResponse(code = 400, message = "Bad Request, Input params are invalid"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "delete User", notes = "delete user detailby userid", response = User.class, tags = {
			"deleteUser" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = User.class, message = "Successfully user has been deleted"),
			@ApiResponse(code = 400, message = "Bad Request, Input params are invalid"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping("/deleteUser")
	public ResponseEntity<User> deleteUser(
			@ApiParam(name = "userId", allowEmptyValue = false, allowMultiple = false, required = true, type = "Long", hidden = false, example = "12345") @RequestParam("userId") @NotNull Long userId) {
		System.out.println("userId:" + userId);
		User user = new User();
		user.setFirstName("Suresh");
		user.setLastName("E");
		user.setPhoneNumber("8125743669");
		user.setUserId(12345L);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
