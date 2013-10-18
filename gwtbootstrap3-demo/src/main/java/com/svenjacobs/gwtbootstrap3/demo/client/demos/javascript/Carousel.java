package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.svenjacobs.gwtbootstrap3.client.ui.Row;

/**
 * @author Joshua Godi
 */
public class Carousel extends Composite {
    interface CarouselUiBinder extends UiBinder<Row, Carousel> {
    }

    private static CarouselUiBinder ourUiBinder = GWT.create(CarouselUiBinder.class);

    public Carousel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}