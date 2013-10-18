package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Buttons extends Composite {
    interface ButtonsUiBinder extends UiBinder<Row, Buttons> {
    }

    private static ButtonsUiBinder ourUiBinder = GWT.create(ButtonsUiBinder.class);

    public Buttons() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}