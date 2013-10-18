package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Icons extends Composite {
    interface IconsUiBinder extends UiBinder<Row, Icons> {
    }

    private static IconsUiBinder ourUiBinder = GWT.create(IconsUiBinder.class);

    public Icons() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}