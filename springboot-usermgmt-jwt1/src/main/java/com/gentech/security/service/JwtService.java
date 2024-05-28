package com.gentech.security.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.gentech.security.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private final String SECRET_KEY="31be14527033f11d2679eba110a4df0b77933db8b257ef0081e1a029782da0fb";

	
	public <T> T extractClaim(String token, Function<Claims, T> resolver)
	{
		Claims claims=extractAllClaims(token);
		return resolver.apply(claims);
	}
	
	public String extractUsername(String token)
	{
		return extractClaim(token, Claims::getSubject);
	}
	
	public boolean isValid(String token,UserDetails user)
	{
		String username=extractUsername(token);
		return username.equals(user.getUsername()) && !isExpired(token);
	}
	
	
	private boolean isExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	

	private Date extractExpiration(String token) {
		
		return extractClaim(token, Claims::getExpiration);
	}

	public Claims extractAllClaims(String token)
	{
		return Jwts
				.parser()
				.verifyWith(getSigninKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public String generateToken(User user)
	{
		String token=Jwts
				.builder()
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+30 * 60 * 1000))
				.signWith(getSigninKey())
				.compact();
		
		return token;
	}
	
	private SecretKey getSigninKey()
	{
		byte[] bytekeys=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(bytekeys);
	}
}
