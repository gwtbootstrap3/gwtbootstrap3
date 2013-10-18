package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Pagination extends Composite {
    interface PaginationUiBinder extends UiBinder<Row, Pagination> {
    }

    private static PaginationUiBinder ourUiBinder = GWT.create(PaginationUiBinder.class);

    public Pagination() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}