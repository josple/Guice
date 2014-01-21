package org.josle.guice.propertyinjector;

import java.lang.reflect.Field;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.MoreTypes;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;


public class InjectPropertyListener implements TypeListener {

	private final InjectPropertyMapper mapper;
	
	@Inject
	public InjectPropertyListener(InjectPropertyMapper mapper) {
		this.mapper = mapper;
	}
	
	
	@Override
	public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
		for (Field field : typeLiteral.getRawType().getDeclaredFields()) {
	        if (field.isAnnotationPresent(InjectProperty.class)) {
	            typeEncounter.register(new PropertyInjector<T>(field, MoreTypes.typeToString(typeLiteral.getType()), mapper));
	        }
	    }
	}
}