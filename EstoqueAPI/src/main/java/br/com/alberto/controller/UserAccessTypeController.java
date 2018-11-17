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
import br.com.alberto.interfaces.api.servicers.IUserAccessTypeService;
import br.com.alberto.models.UserAccessType;

@Path("/user-access-type-controller")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserAccessTypeController extends Controller {

	@Inject
	private IUserAccessTypeService service;
	
	@GET
	@Path("/{userAccessTypeId}")
	public Response getUserAccessTypeById(@PathParam("userAccessTypeId") Long userAccessTypeId) {
		try {
			return sendResponseBody(service.findById(userAccessTypeId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{userAccessTypeId}")
	public Response deleteUserAccessTypeById(@PathParam("userAccessTypeId") Long userAccessTypeId) {
		try {
			service.deleteById(userAccessTypeId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveUserAccessType(UserAccessType userAccessType) {
		try {
			return sendResponseBody(this.service.save(userAccessType));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateUserAccessType(UserAccessType userAccessType) {
		try {
			return sendResponseBody(this.service.update(userAccessType));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
