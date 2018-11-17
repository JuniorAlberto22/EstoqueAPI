package br.com.alberto.servircers;

import javax.ejb.Stateless;

import br.com.alberto.interfaces.api.servicers.IUserService;
import br.com.alberto.models.User;

@Stateless
public class UserService extends Service<User, Long> implements IUserService {

}
