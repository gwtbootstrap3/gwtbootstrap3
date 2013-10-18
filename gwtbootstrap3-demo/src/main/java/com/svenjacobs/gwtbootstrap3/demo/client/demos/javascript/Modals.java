package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Modals extends Composite {
    interface ModalsUiBinder extends UiBinder<Row, Modals> {
    }

    private static ModalsUiBinder ourUiBinder = GWT.create(ModalsUiBinder.class);

    public Modals() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}