package org.josle.guice.propertyinjector;

/**
 * Interface that the {@link PropertyInjector} will use to obtain the
 * property value for the fields annotated with {@link InjectProperty}.
 * 
 * @author joseph
 */
public interface InjectPropertyMapper {

	/**
	 * Returns the property value to which the specified property key is mapped,
	 * or null if this property mapper contains no mapping for the key.
	 * The key is expected to be in the format: package.className.fieldName.
	 * 
	 * @param propertyKey the property key to get the value for.
	 * @return the value corresponding to the propertyKey.
	 */
	public String getPropertyValue(String propertyKey);
}
