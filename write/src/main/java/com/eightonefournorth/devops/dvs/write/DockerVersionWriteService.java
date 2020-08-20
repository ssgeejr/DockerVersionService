package com.eightonefournorth.devops.dvs.write;

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
public class DockerVersionWriteService{

	// curl example:
	// curl -d "comp=eureka" -X POST http://localhost:8080/dvswrite/promote
	@POST
	@Path("/promote")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response lookupResource(@FormParam("comp") String component, @FormParam("plat") String platform, @FormParam("ver") String version){
	    try {	
	    	System.out.println("@@@@@@@@@@@@@@@@@@@@@");
	    	System.out.println("COMPONENT: " + component);
	    	System.out.println("PLATFORM: " + platform);
	    	System.out.println("VERSION: " + version);
	    	return Response.status(200).build();
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    	return Response.status(Response.Status.PRECONDITION_FAILED).build();
	    }
	}	
	
//	curl http://localhost:8080/dvswrite/verify
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		System.out.println("Verfied DockerVersionWriteService online ...");
//		String result = "";
// return HTTP response 200 in case of success
		return Response.status(200).entity("Success").entity("Verfied DockerVersionWriteService online ...").build();
	}

}
