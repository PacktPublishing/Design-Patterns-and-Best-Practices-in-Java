package com.employee.main;
import com.employee.model.User;
import com.employee.service.JWTService;

/**
 * Class to test our JWT implementation.
 *
 */
public class JWTMain {

	public static void main(String s[]) {
		User user = new User();
		user.setId("1");
		user.setName("Dave");
		user.setRole("Manager");
		
		JWTService jwtService=new JWTService();
		String token = jwtService.createAccessJwtToken(user);
		
		System.out.println(token);
		
		User newuser = jwtService.parseJwtToken(token);
		System.out.println(newuser.getName());
		System.out.println(newuser.getId());
		System.out.println(newuser.getRole());
	}
}
