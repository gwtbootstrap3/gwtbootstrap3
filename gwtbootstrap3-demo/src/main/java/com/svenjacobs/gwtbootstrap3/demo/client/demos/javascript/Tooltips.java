package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.Button;
import com.svenjacobs.gwtbootstrap3.client.ui.Tooltip;

/**
 * @author Joshua Godi
 */
public class Tooltips extends Composite {
    interface TooltipsUiBinder extends UiBinder<Widget, Tooltips> {
    }

    private static final TooltipsUiBinder ourUiBinder = GWT.create(TooltipsUiBinder.class);

    @UiField
    Tooltip forceTooltip;
    @UiField
    Button forceHideButton;
    @UiField
    Button forceShowButton;

    public Tooltips() {
        initWidget(ourUiBinder.createAndBindUi(this));

        forceHideButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                forceTooltip.hide();
            }
        });

        forceShowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                forceTooltip.show();
            }
        });
    }
}