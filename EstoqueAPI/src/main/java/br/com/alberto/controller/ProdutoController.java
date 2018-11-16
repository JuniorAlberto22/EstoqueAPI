package br.com.alberto.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alberto.interfaces.api.servicers.IProductService;
import br.com.alberto.models.Product;
import br.com.alberto.servircers.ProductService;

@Path("/produto")
public class ProdutoController extends Controller {

	@Inject
	private IProductService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listAll() {
		return "Hello World";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("save")
	public javax.ws.rs.core.Response saveProduct() {
		try {
			Product product = new Product();
			product.setNomeProduto("Escova");
			product.setQuantidadeProduto(12);
			product.setValorProduto(12.54);
			return sendResponseBody(this.service.save(product));
		} catch (Exception e) {
			return sendErrorResponse(e);
		}
	}
}
