package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.IProductRegisterService;
import br.com.alberto.models.ProductRegister;

@Stateless
public class ProductRegisterService extends Service<ProductRegister, Long> implements IProductRegisterService {
	
}
