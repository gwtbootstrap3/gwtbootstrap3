package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class ProgressBars extends Composite {
    interface ProgressBarsUiBinder extends UiBinder<Row, ProgressBars> {
    }

    private static ProgressBarsUiBinder ourUiBinder = GWT.create(ProgressBarsUiBinder.class);

    public ProgressBars() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}