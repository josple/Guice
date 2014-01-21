package org.josle.guice;

import org.josle.guice.propertyinjector.PropertyInjectorModule;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {		
		install(new PropertyInjectorModule(new InjectPropertyMapperImpl()));
	}
}
