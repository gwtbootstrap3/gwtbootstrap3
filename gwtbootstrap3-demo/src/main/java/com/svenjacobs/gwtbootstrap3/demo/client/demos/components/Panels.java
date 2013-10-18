package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Panels extends Composite {
    interface PanelsUiBinder extends UiBinder<Row, Panels> {
    }

    private static PanelsUiBinder ourUiBinder = GWT.create(PanelsUiBinder.class);

    public Panels() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}