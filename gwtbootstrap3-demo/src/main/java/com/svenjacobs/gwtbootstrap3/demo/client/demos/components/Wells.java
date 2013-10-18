package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Wells extends Composite {
    interface WellsUiBinder extends UiBinder<Row, Wells> {
    }

    private static WellsUiBinder ourUiBinder = GWT.create(WellsUiBinder.class);

    public Wells() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}