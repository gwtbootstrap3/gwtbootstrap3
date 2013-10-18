package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Breadcrumbs extends Composite {
    interface BreadcrumbsUiBinder extends UiBinder<Row, Breadcrumbs> {
    }

    private static BreadcrumbsUiBinder ourUiBinder = GWT.create(BreadcrumbsUiBinder.class);

    public Breadcrumbs() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}