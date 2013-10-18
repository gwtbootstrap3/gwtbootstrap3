package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Tab extends Composite {
    interface TabUiBinder extends UiBinder<Row, Tab> {
    }

    private static TabUiBinder ourUiBinder = GWT.create(TabUiBinder.class);

    public Tab() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}