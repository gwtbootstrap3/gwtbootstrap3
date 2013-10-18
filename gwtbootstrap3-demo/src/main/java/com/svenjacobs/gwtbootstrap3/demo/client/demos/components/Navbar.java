package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Navbar extends Composite {
    interface NavbarUiBinder extends UiBinder<Row, Navbar> {
    }

    private static NavbarUiBinder ourUiBinder = GWT.create(NavbarUiBinder.class);

    public Navbar() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}