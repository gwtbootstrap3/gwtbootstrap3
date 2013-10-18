package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Alert extends Composite {
    interface AlertUiBinder extends UiBinder<Row, Alert> {
    }

    private static AlertUiBinder ourUiBinder = GWT.create(AlertUiBinder.class);

    public Alert() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}