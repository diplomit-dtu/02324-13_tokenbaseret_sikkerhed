package test.jwt;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jwt.JWTHandler;

public class JwtHandlerTest {

	@Test
	public void testGenerateJwtToken() {
		String token = JWTHandler.generateJwtToken();
		System.out.println(token);
		Jws<Claims> claims = JWTHandler.validateToken(token);
		
		
	}

	@Test
	public void testValidateToken() {
		int i = 0;
		do {
			
			try {
				String token = JWTHandler.generateJwtToken();
				List<Character> cList = new ArrayList<Character>();
				for(char c : token.toCharArray()) {
				    cList.add(c);
				}
				Collections.shuffle(cList);
				token = "";
				for (Character character : cList) {
					token+=character;
				} 
				JWTHandler.validateToken(token);
				fail();
			} catch (Exception e) {
			
			}
			
			
		} while (i++<10000);
	}

}
