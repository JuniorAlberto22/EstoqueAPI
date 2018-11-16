package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.IProductService;
import br.com.alberto.models.Product;

@Stateless
public class ProductService extends Service<Product, Long> implements IProductService {

}
