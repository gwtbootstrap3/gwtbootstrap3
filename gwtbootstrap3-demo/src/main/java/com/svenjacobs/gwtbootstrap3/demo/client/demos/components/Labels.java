package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Labels extends Composite {
    interface LabelsUiBinder extends UiBinder<Row, Labels> {
    }

    private static LabelsUiBinder ourUiBinder = GWT.create(LabelsUiBinder.class);

    public Labels() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}