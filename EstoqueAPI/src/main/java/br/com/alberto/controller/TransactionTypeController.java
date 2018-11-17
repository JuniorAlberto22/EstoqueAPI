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
import br.com.alberto.interfaces.api.servicers.ITransactionTypeService;
import br.com.alberto.models.TransactionType;

@Path("/transaction-type-controller")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionTypeController extends Controller {

	@Inject
	private ITransactionTypeService service;
	
	@GET
	@Path("/{transactionTypeId}")
	public Response getTransactionTypeById(@PathParam("transactionTypeId") Long transactionTypeId) {
		try {
			return sendResponseBody(service.findById(transactionTypeId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{transactionTypeId}")
	public Response deleteTransactionTypeById(@PathParam("transactionTypeId") Long transactionTypeId) {
		try {
			service.deleteById(transactionTypeId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveTransactionType(TransactionType transactionType) {
		try {
			return sendResponseBody(this.service.save(transactionType));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateTransactionType(TransactionType transactionType) {
		try {
			return sendResponseBody(this.service.update(transactionType));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
