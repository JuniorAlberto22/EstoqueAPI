package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.IUserAccessTypeService;
import br.com.alberto.models.UserAccessType;

@Stateless
public class UserAccessTypeService extends Service<UserAccessType, Long> implements IUserAccessTypeService {
	
}
