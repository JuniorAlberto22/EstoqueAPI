package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.ITransactionTypeService;
import br.com.alberto.models.TransactionType;

@Stateless
public class TransactionTypeService extends Service<TransactionType, Long> implements ITransactionTypeService {

}
