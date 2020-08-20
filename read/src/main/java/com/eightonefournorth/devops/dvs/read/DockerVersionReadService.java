package com.eightonefournorth.devops.dvs.read;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/")
public class DockerVersionReadService{

	// curl example:
	// curl -d "comp=eureka&plat=qa" -X POST http://localhost:8080/dvsread/fetch
	@POST
	@Path("/fetch")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response lookupResource(@FormParam("comp") String component, @FormParam("plat") String platform){
	    try {	
	    	System.out.println("@@@@@@@@@@@@@@@@@@@@@");
	    	System.out.println("COMPONENT: " + component);
	    	System.out.println("PLATFORM: " + platform);
//	    	return Response.status(200).build();
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    	return Response.status(Response.Status.PRECONDITION_FAILED).build();
	    }
	    return Response.status(200).entity("EUREKA=2.1").build();
	}	
	
//	curl http://localhost:8080/dvsread/verify
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		System.out.println("Verfied DockerVersionReadService online ...");
//		String result = "";
// return HTTP response 200 in case of success
		return Response.status(200).entity("Success").entity("Verfied DockerVersionReadService online ...").build();
	}

}

