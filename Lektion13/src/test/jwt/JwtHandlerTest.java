package test.jwt;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import jwt.JWTHandler;

public class JwtHandlerTest {

	@Test
	public void testGenerateJwtToken() {
		String token = JWTHandler.generateJwtToken();
		System.out.println(token);
		JWTHandler.validateToken(token);
		
		
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
