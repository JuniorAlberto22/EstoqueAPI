package br.com.alberto.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.alberto.controller.ProdutoController;

@ApplicationPath("/api/v1")
public class App extends Application{

	Set<Class<?>> classes = new HashSet<>();
	
	private Set<Class<?>> getResourcersClasses() {
		classes.add(ProdutoController.class);
		return this.classes;
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return getResourcersClasses();
	}
}
