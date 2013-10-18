package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Dropdown extends Composite {
    interface DropdownUiBinder extends UiBinder<Row, Dropdown> {
    }

    private static DropdownUiBinder ourUiBinder = GWT.create(DropdownUiBinder.class);

    public Dropdown() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}