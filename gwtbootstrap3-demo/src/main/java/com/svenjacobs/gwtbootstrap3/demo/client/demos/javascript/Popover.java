package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Popover extends Composite {
    interface PopoverUiBinder extends UiBinder<Row, Popover> {
    }

    private static PopoverUiBinder ourUiBinder = GWT.create(PopoverUiBinder.class);

    public Popover() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}