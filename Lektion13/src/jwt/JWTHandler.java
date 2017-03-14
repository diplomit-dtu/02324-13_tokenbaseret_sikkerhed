package jwt;


import java.security.Key;
import java.util.Base64;
import java.util.Map.Entry;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JWTHandler {
		static Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);
		
	public static String generateJwtToken(){
		return Jwts.builder().setIssuer("DiplomIt").signWith(SignatureAlgorithm.HS512, key).compact();
	}
	
	public static void validateToken(String tokenString){
			Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(tokenString);
			System.out.println(key);
			for (Entry<String, Object> element : parseClaimsJws.getBody().entrySet()) {
				System.out.println(element);}


	}
	
	public static void main(String[] args) {
		String token = generateJwtToken();
		System.out.println(token);
		token+=1;
		validateToken(token);
	}

}
