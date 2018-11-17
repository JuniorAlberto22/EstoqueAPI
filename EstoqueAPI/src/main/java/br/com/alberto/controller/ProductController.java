package br.com.alberto.controller;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.p;
import static j2html.TagCreator.title;

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
import br.com.alberto.interfaces.api.servicers.IProductService;
import br.com.alberto.models.Product;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController extends Controller {
	
	@Inject
	private IProductService service;
	
	@GET
	@Path("/{productId}")
	public Response getProductById(@PathParam("productId") Long productId) {
		try {
			return sendResponseBody(service.findById(productId));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@DELETE
	@Path("/{productId}")
	public Response deleteProductById(@PathParam("productId") Long productId) {
		try {
			service.deleteById(productId);
			return sendResponseSuccessful();
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@POST
	public Response saveProduct(Product product) {
		try {
			return sendResponseBody(this.service.save(product));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
	
	@PUT
	public Response updateProduct(Product product) {
		try {
			return sendResponseBody(this.service.update(product));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
