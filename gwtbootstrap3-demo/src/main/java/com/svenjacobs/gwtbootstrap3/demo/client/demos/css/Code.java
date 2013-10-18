package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Code extends Composite {
    interface CodeUiBinder extends UiBinder<Row, Code> {
    }

    private static CodeUiBinder ourUiBinder = GWT.create(CodeUiBinder.class);

    public Code() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}