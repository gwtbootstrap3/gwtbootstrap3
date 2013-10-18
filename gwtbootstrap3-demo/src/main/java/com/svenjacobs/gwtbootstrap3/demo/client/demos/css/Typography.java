package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Typography extends Composite {
    interface TypographyUiBinder extends UiBinder<Row, Typography> {
    }

    private static TypographyUiBinder ourUiBinder = GWT.create(TypographyUiBinder.class);

    public Typography() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}