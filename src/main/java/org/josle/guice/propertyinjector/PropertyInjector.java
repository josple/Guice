package org.josle.guice.propertyinjector;

import java.lang.reflect.Field;

import com.google.inject.MembersInjector;

public class PropertyInjector<T> implements MembersInjector<T> {

	private final Field field;
	private final String clazz;
	private final InjectPropertyMapper mapper;
    

    PropertyInjector(Field field, String clazz, InjectPropertyMapper mapper) {
      this.field = field;
      this.clazz = clazz;
      this.mapper = mapper;
      field.setAccessible(true);
    }
    
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void injectMembers(T t) {
		try {
			if (field.getType() == String.class) {
				field.set(t, mapper.getPropertyValue(clazz + "." + field.getName()));
			} else if (field.getType() instanceof Class && ((Class<?>)field.getType()).isEnum()) {
				field.set(t, Enum.valueOf((Class<Enum>) field.getType(), (String)mapper.getPropertyValue(clazz + "." + field.getName())));
			} else if (field.getType() == int.class) {
				field.set(t, Integer.valueOf((String)mapper.getPropertyValue(clazz + "." + field.getName())));
			} else {
				throw new IllegalStateException("Unable to inject property into class type: " + field.getType());
			}
	      } catch (IllegalAccessException e) {
	        throw new RuntimeException(e);
	      }
	}
}
