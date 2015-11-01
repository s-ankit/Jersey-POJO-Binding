package com.ankit.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
@Path("/service")
public class LoginService {

  @Path("/login")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response testHeader(UserBean userdata){
	return Response.status(200)
			.entity("Login is called \nUsername: "+userdata.getUserName()+"\nPassword: "+userdata.getPassword())
			.cookie(new NewCookie("cookieTest", "Success"))//this line is to return a cookie to browser
			.build();
	  
  }

} 