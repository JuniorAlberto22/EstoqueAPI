package br.com.alberto.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class Controller {

	protected Response sendResponseBody(Object body) {
		return Response.ok().entity(body).build();
	}
	
	protected Response sendErrorResponse(String error) {
		return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), error).build();
	}
	
	protected Response sendErrorResponse(Exception error) {
		return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), error.getCause().getMessage()).build();
	}
}
