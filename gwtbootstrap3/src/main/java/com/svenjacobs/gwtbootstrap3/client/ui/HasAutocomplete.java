package com.svenjacobs.gwtbootstrap3.client.ui;

public interface HasAutocomplete {
	
	String AUTOCOMPLETE = "autocomplete";
	String ON = "on";
	String OFF = "off";
	
	void setAutocomplete(boolean autocomplete);
	String getAutocomplete();
}
