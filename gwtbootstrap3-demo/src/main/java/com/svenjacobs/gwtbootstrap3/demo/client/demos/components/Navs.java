package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Navs extends Composite {
    interface NavsUiBinder extends UiBinder<Row, Navs> {
    }

    private static NavsUiBinder ourUiBinder = GWT.create(NavsUiBinder.class);

    public Navs() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}