package org.josle.guice.propertyinjector;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class PropertyInjectorModule extends AbstractModule {

	InjectPropertyMapper mapper;
	
	public PropertyInjectorModule(InjectPropertyMapper mapper) {
		this.mapper = mapper;
	}
	
	
	@Override
	protected void configure() {
		bindListener(Matchers.any(), new InjectPropertyListener(mapper));
	}

}
