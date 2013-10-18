package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Affix extends Composite {
    interface AffixUiBinder extends UiBinder<Row, Affix> {
    }

    private static AffixUiBinder ourUiBinder = GWT.create(AffixUiBinder.class);

    public Affix() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}