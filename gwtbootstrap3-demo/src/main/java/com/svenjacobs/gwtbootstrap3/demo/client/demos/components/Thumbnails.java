package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Thumbnails extends Composite {
    interface ThumbnailsUiBinder extends UiBinder<Row, Thumbnails> {
    }

    private static ThumbnailsUiBinder ourUiBinder = GWT.create(ThumbnailsUiBinder.class);

    public Thumbnails() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}