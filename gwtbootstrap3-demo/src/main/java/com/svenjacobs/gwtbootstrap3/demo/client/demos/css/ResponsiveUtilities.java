package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class ResponsiveUtilities extends Composite {
    interface ResponsiveUtilitiesUiBinder extends UiBinder<Row, ResponsiveUtilities> {
    }

    private static ResponsiveUtilitiesUiBinder ourUiBinder = GWT.create(ResponsiveUtilitiesUiBinder.class);

    public ResponsiveUtilities() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}