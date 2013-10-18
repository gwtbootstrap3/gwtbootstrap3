package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class GridSystem extends Composite {
    interface GridSystemUiBinder extends UiBinder<Row, GridSystem> {
    }

    private static GridSystemUiBinder ourUiBinder = GWT.create(GridSystemUiBinder.class);

    public GridSystem() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}