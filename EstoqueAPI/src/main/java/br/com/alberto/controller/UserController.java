package br.com.alberto.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.alberto.interfaces.api.servicers.IUserService;
import br.com.alberto.models.User;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController extends Controller {

	@Inject
	private IUserService service;
	
	@GET
	@Path("/{userId}")
	public Response getUserById(@PathParam("userId") Long userId) {
		try {
			return sendResponseBody(service.findById(userId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{userId}")
	public Response deleteUserById(@PathParam("userId") Long userId) {
		try {
			service.deleteById(userId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveUser(User user) {
		try {
			return sendResponseBody(this.service.save(user));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateUser(User user) {
		try {
			return sendResponseBody(this.service.update(user));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
