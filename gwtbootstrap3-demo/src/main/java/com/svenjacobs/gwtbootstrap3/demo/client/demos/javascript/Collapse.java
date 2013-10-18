package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Collapse extends Composite {
    interface CollapseUiBinder extends UiBinder<Row, Collapse> {
    }

    private static CollapseUiBinder ourUiBinder = GWT.create(CollapseUiBinder.class);

    public Collapse() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}