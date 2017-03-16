package rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import dto.User;
import dto.UserPass;
import jwt.JWTHandler;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("login")
public class LoginService {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	
	@POST
	public void getLogin(UserPass userPass){
		if (validate(userPass)) {
			response.addHeader("Authorization", "Bearer " + JWTHandler.generateJwtToken(getUser(userPass.getuserName())));
		} else {
			throw new WebApplicationException(Status.FORBIDDEN);
		}
	}
	
	

	private User getUser(String userName) {
		return new User(-1L, userName, "");
	}



	private boolean validate(UserPass userPass) {
		return "test".equals(userPass.getPassword()) && "test".equals(userPass.getPassword());
	}

}
