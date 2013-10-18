package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class ButtonDropdowns extends Composite {
    interface ButtonDropdownsUiBinder extends UiBinder<Row, ButtonDropdowns> {
    }

    private static ButtonDropdownsUiBinder ourUiBinder = GWT.create(ButtonDropdownsUiBinder.class);

    public ButtonDropdowns() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}