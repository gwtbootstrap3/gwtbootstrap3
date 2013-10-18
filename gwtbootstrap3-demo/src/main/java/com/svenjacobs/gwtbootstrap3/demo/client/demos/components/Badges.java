package com.svenjacobs.gwtbootstrap3.demo.client.demos.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Badges extends Composite {
    interface BadgesUiBinder extends UiBinder<Row, Badges> {
    }

    private static BadgesUiBinder ourUiBinder = GWT.create(BadgesUiBinder.class);

    public Badges() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}