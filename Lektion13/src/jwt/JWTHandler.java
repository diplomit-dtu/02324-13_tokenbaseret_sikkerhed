package jwt;


import java.security.Key;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JWTHandler {
		static Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);
		
	public static String generateJwtToken(){
		return Jwts.builder()
				.setIssuer("DiplomIt")
				.claim("user", new User(1L,"test","testPass"))
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
	}
	
	public static Jws<Claims> validateToken(String tokenString) {
		 Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(tokenString).getBody();
		 ObjectMapper mapper = new ObjectMapper();
		 User user = mapper.convertValue((claims.get("user")), User.class);
		 System.out.println(user);
		 return Jwts.parser().setSigningKey(key).parseClaimsJws(tokenString);
			

	}
	

}
