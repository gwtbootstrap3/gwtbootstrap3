package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class ListGroup extends Composite {
    interface ListGroupUiBinder extends UiBinder<Row, ListGroup> {
    }

    private static ListGroupUiBinder ourUiBinder = GWT.create(ListGroupUiBinder.class);

    public ListGroup() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}