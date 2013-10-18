package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class MediaObjects extends Composite {
    interface MediaObjectsUiBinder extends UiBinder<Row, MediaObjects> {
    }

    private static MediaObjectsUiBinder ourUiBinder = GWT.create(MediaObjectsUiBinder.class);

    public MediaObjects() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}