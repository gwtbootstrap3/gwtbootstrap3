package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Button extends Composite {
    interface ButtonUiBinder extends UiBinder<Row, Button> {
    }

    private static ButtonUiBinder ourUiBinder = GWT.create(ButtonUiBinder.class);

    public Button() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}