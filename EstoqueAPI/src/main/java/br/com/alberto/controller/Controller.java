package br.com.alberto.controller;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.p;
import static j2html.TagCreator.title;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public abstract class Controller {

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_HTML)
	public Response testHelloWorld() {
		String html = html(
			head(title("My Hello World Test"),
				body(
						h1("Hello World"),
						p("This is a hello world test.")
				)
			)
		).render();
		return sendResponseBody(html);
	}
	
	protected Response sendResponseBody(Object body) {
		return Response.ok().entity(body).build();
	}
	
	protected Response sendErrorResponse(String error) {
		return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), error).build();
	}
	
	protected Response sendErrorResponse(Exception error) {
		return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), error.getCause().getMessage()).build();
	}
	
	protected Response sendResponseSuccessful() {
		return Response.ok().build();
	}
}
