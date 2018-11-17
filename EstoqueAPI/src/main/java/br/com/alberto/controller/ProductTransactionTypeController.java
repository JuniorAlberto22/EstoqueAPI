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
import br.com.alberto.interfaces.api.servicers.IProductTransactionTypeService;
import br.com.alberto.models.ProductTransactionType;

@Path("/product-transaction-type")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductTransactionTypeController extends Controller {

	@Inject
	private IProductTransactionTypeService service;
	
	@GET
	@Path("/{productTransactionTypeId}")
	public Response getProductTransactionTypeById(@PathParam("productTransactionTypeId") Long productTransactionTypeId) {
		try {
			return sendResponseBody(service.findById(productTransactionTypeId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{productTransactionTypeId}")
	public Response deleteProductTransactionTypeById(@PathParam("productTransactionTypeId") Long productTransactionTypeId) {
		try {
			service.deleteById(productTransactionTypeId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveProductTransactionType(ProductTransactionType productTransactionType) {
		try {
			return sendResponseBody(this.service.save(productTransactionType));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateProductTransactionType(ProductTransactionType productTransactionType) {
		try {
			return sendResponseBody(this.service.update(productTransactionType));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
