package com.svenjacobs.gwtbootstrap3.demo.client.demos.javascript;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

    private static TooltipsUiBinder ourUiBinder = GWT.create(TooltipsUiBinder.class);

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
            public void onClick(ClickEvent event) {
                forceTooltip.hide();
            }
        });

        forceShowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                forceTooltip.show();
            }
        });
    }
}