package com.svenjacobs.gwtbootstrap3.demo.client.demos.setup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Joshua Godi
 */
public class Setup extends Composite {
    interface SetupUiBinder extends UiBinder<Widget, Setup> {
    }

    private static SetupUiBinder ourUiBinder = GWT.create(SetupUiBinder.class);

    public Setup() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}