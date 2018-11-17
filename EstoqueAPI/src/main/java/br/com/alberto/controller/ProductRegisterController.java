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
import br.com.alberto.interfaces.api.servicers.IProductRegisterService;
import br.com.alberto.models.ProductRegister;

@Path("/product-register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductRegisterController extends Controller {

	@Inject
	private IProductRegisterService service;
	
	@GET
	@Path("/{productRegisterId}")
	public Response getProductRegisterById(@PathParam("productRegisterId") Long productRegisterId) {
		try {
			return sendResponseBody(service.findById(productRegisterId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{productRegisterId}")
	public Response deleteProductRegisterById(@PathParam("productRegisterId") Long productRegisterId) {
		try {
			service.deleteById(productRegisterId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveProductRegister(ProductRegister productRegister) {
		try {
			return sendResponseBody(this.service.save(productRegister));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateProductRegister(ProductRegister productRegister) {
		try {
			return sendResponseBody(this.service.update(productRegister));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
