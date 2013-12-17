package com.github.gwtbootstrap3.demo.client.demos.extras;

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

import com.github.gwtbootstrap3.client.ui.Button;
import com.github.gwtbootstrap3.extras.bootbox.client.Bootbox;
import com.github.gwtbootstrap3.extras.bootbox.client.callback.AlertCallback;
import com.github.gwtbootstrap3.extras.bootbox.client.callback.ConfirmCallback;
import com.github.gwtbootstrap3.extras.bootbox.client.callback.PromptCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author lyhcode
 */
public class BootboxJS extends Composite {
    interface BootboxJSUiBinder extends UiBinder<Widget, BootboxJS> {
    }

    private static BootboxJSUiBinder ourUiBinder = GWT.create(BootboxJSUiBinder.class);

    @UiField
    Button alertButton;
    @UiField
    Button alertCallbackButton;
    @UiField
    Button confirmButton;
    @UiField
    Button promptButton;

    public BootboxJS() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("alertButton")
    public void handleAlertButton(final ClickEvent event) {
        Bootbox.alert("Hello World");
    }

    @UiHandler("alertCallbackButton")
    public void handleAlertCallbackButton(final ClickEvent event) {
        Bootbox.alert("Hello World", new AlertCallback() {
            @Override
            public void callback() {
                Window.alert("Hello World Callback");
            }
        });
    }

    @UiHandler("confirmButton")
    public void handleConfirmButton(final ClickEvent event) {
        Bootbox.confirm("Hello World", new ConfirmCallback() {
            @Override
            public void callback(final boolean result) {
                Window.alert("Return: " + result);
            }
        });
    }

    @UiHandler("promptButton")
    public void handlePromptButton(final ClickEvent event) {
        Bootbox.prompt("Hello World", new PromptCallback() {
            @Override
            public void callback(final String result) {
                Window.alert("Return: " + result);
            }
        });
    }
}