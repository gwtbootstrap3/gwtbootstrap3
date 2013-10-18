package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class InputGroups extends Composite {
    interface InputGroupsUiBinder extends UiBinder<Row, InputGroups> {
    }

    private static InputGroupsUiBinder ourUiBinder = GWT.create(InputGroupsUiBinder.class);

    public InputGroups() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}