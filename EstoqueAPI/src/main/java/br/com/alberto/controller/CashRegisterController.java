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
import br.com.alberto.interfaces.api.servicers.ICashRegisterService;
import br.com.alberto.models.CashRegister;

@Path("/cash-register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CashRegisterController extends Controller {

	@Inject
	private ICashRegisterService service;
	
	@GET
	@Path("/{cashRegisterId}")
	public Response getCashRegisterById(@PathParam("cashRegisterId") Long cashRegisterId) {
		try {
			return sendResponseBody(service.findById(cashRegisterId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{cashRegisterId}")
	public Response deleteCashRegisterById(@PathParam("cashRegisterId") Long cashRegisterId) {
		try {
			service.deleteById(cashRegisterId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveCashRegister(CashRegister cashRegister) {
		try {
			return sendResponseBody(this.service.save(cashRegister));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateCashRegister(CashRegister cashRegister) {
		try {
			return sendResponseBody(this.service.update(cashRegister));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
