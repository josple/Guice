package org.josle.guice;

import org.josle.guice.propertyinjector.InjectProperty;

public class Properties {

	@InjectProperty
	private String p1;
	
	@InjectProperty
	private int p2;
	
	@InjectProperty
	private String p3;

	
	public String getP1() {
		return p1;
	}

	
	public int getP2() {
		return p2;
	}

	
	public String getP3() {
		return p3;
	}	
}
