package com.svenjacobs.gwtbootstrap3.demo.client.demos.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Images extends Composite {
    interface ImagesUiBinder extends UiBinder<Row, Images> {
    }

    private static ImagesUiBinder ourUiBinder = GWT.create(ImagesUiBinder.class);

    public Images() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}