package org.josle.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Injector injector = Guice.createInjector(new GuiceModule());
    	
    	Properties properties = injector.getInstance(Properties.class);
    	System.out.println(properties.getP1());
    	System.out.println(properties.getP2());
    	System.out.println(properties.getP3());
    }
}
