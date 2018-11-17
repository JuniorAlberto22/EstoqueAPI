package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.ICashRegisterService;
import br.com.alberto.models.CashRegister;

@Stateless
public class CashRegisterService extends Service<CashRegister, Long> implements ICashRegisterService {
	
}
