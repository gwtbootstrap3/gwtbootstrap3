package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Jumbotron extends Composite {
    interface JumbotronUiBinder extends UiBinder<Row, Jumbotron> {
    }

    private static JumbotronUiBinder ourUiBinder = GWT.create(JumbotronUiBinder.class);

    public Jumbotron() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}