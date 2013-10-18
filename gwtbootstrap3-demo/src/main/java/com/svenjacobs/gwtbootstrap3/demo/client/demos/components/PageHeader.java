package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class PageHeader extends Composite {
    interface PageHeaderUiBinder extends UiBinder<Row, PageHeader> {
    }

    private static PageHeaderUiBinder ourUiBinder = GWT.create(PageHeaderUiBinder.class);

    public PageHeader() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}