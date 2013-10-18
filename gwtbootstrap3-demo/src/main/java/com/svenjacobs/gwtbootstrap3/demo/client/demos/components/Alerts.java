package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Alerts extends Composite {
    interface AlertsUiBinder extends UiBinder<Row, Alerts> {
    }

    private static AlertsUiBinder ourUiBinder = GWT.create(AlertsUiBinder.class);

    public Alerts() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}