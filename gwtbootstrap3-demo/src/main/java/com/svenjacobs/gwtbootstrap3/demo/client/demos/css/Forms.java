package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Forms extends Composite {
    interface FormsUiBinder extends UiBinder<Row, Forms> {
    }

    private static FormsUiBinder ourUiBinder = GWT.create(FormsUiBinder.class);

    public Forms() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}