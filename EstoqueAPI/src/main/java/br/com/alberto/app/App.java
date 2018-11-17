package br.com.alberto.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.reflections.Reflections;

@ApplicationPath("/api/v1")
public class App extends Application{

	Set<Class<?>> classes = new HashSet<>();
	
	private Set<Class<?>> getResourcersClasses() {
		Reflections reflections = new Reflections("br.com.alberto.controller");
		return reflections.getSubTypesOf(Object.class);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return getResourcersClasses();
	}
}
