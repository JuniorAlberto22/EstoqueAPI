package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.IProductTransactionTypeService;
import br.com.alberto.models.ProductTransactionType;

@Stateless
public class ProductTransactionTypeService extends Service<ProductTransactionType, Long> implements IProductTransactionTypeService {

}
