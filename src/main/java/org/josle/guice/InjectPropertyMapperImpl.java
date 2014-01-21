package org.josle.guice;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.josle.guice.propertyinjector.InjectPropertyMapper;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;

public class InjectPropertyMapperImpl implements InjectPropertyMapper {
	private static final Log log = LogFactory.getLog(InjectPropertyMapperImpl.class);

	private Properties properties;
	
	
	public InjectPropertyMapperImpl() {
		Reflections reflections = new Reflections(ClasspathHelper.forPackage("org.josle.guice"), new ResourcesScanner());
		Set<String> propertyFiles = reflections.getResources(Pattern.compile(".*\\.properties"));
		properties = new Properties();
		for (String property : propertyFiles) {					
			try {
				properties.load(this.getClass().getClassLoader().getResourceAsStream(property));
			} catch (IOException e) {
				log.error("Unable to load properties.");
			}
		}
	}
	
	
	@Override
	public String getPropertyValue(String propertyKey) {
		return properties.getProperty(propertyKey);
	}
}
