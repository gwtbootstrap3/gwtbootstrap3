package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Dropdowns extends Composite {
    interface DropdownsUiBinder extends UiBinder<Row, Dropdowns> {
    }

    private static DropdownsUiBinder ourUiBinder = GWT.create(DropdownsUiBinder.class);

    public Dropdowns() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}