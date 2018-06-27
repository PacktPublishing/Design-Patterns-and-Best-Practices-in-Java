package com.employee.service;

import java.util.Calendar;
import java.util.Date;

import com.employee.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTService {

	String secret = "SomeSecretKey";
	
	/**
	 * This method takes a user object and returns a token. 
	 * @param user
	 * @return
	 */
	public String createAccessJwtToken(User user) {
		
		Date date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		Date expiration = c.getTime();

		Claims claims = Jwts.claims().setSubject(user.getName())
				.setId(user.getId())
				.setIssuedAt(date)
				.setExpiration(expiration);
		claims.put("ROLE",user.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	

	/**
	 * This method takes a token and returns User Object.
	 * @param token
	 * @return
	 */
    public User parseJwtToken(String token) {
    	Jws<Claims> jwsClaims ;
			jwsClaims = Jwts.parser()
			         .setSigningKey(secret)
			         .parseClaimsJws(token);
		String role = 	jwsClaims.getBody().get("ROLE", String.class);
		
		User user = new User();
		user.setId(jwsClaims.getBody().getId());
		user.setName(jwsClaims.getBody().getSubject());
		user.setRole(role);
		return user;
    }
}
