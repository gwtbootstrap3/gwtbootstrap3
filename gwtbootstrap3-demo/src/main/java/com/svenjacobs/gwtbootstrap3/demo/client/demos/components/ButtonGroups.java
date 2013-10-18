package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class ButtonGroups extends Composite {
    interface ButtonGroupsUiBinder extends UiBinder<Row, ButtonGroups> {
    }

    private static ButtonGroupsUiBinder ourUiBinder = GWT.create(ButtonGroupsUiBinder.class);

    public ButtonGroups() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}