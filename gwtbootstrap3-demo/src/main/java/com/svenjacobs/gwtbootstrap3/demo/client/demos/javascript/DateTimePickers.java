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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.shared.event.HideEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.HideHandler;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ShowEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.ShowHandler;
import com.svenjacobs.gwtbootstrap3.client.ui.Button;
import com.svenjacobs.gwtbootstrap3.client.ui.Paragraph;
import com.svenjacobs.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimeBox;

import java.util.Date;

/**
 * @author Joshua Godi
 */
public class DateTimePickers extends Composite {
    interface DateTimePickersUiBinder extends UiBinder<Widget, DateTimePickers> {
    }

    private static final DateTimePickersUiBinder ourUiBinder = GWT.create(DateTimePickersUiBinder.class);

    @UiField
    Button clearLogButton;
    @UiField
    FlowPanel logRow;
    @UiField
    DateTimeBox eventDateTimeBox;
    @UiField
    Button getDateValue;
    @UiField
    DateTimeBox justDateBox;
    @UiField
    DateTimeBox justTimeBox;
    @UiField
    Button getTimeValue;
    @UiField
    DateTimeBox methodsBox;
    @UiField
    Button setValue;
    @UiField
    Button getValue;
    @UiField
    Button enable;
    @UiField
    Button disable;
    @UiField
    Button hide;
    @UiField
    Button show;
    @UiField
    Button setEndDate;
    @UiField
    Button setStartDate;

    @UiHandler("setStartDate")
    public void handleSetStartDate(final ClickEvent event) {
        methodsBox.setStartDate(new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 10)));
    }

    @UiHandler("setEndDate")
    public void handleSetEndDate(final ClickEvent event) {
        methodsBox.setEndDate(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 10)));
    }

    @UiHandler("show")
    public void handleShow(final ClickEvent event) {
        methodsBox.show();
    }

    @UiHandler("hide")
    public void handleHide(final ClickEvent event) {
        methodsBox.hide();
    }

    @UiHandler("disable")
    public void handleDisable(final ClickEvent event) {
        methodsBox.setEnabled(false);
    }

    @UiHandler("enable")
    public void handleEnable(final ClickEvent event) {
        methodsBox.setEnabled(true);
    }

    @UiHandler("setValue")
    public void handleSetValue(final ClickEvent event) {
        methodsBox.setValue(new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 3)));
    }

    @UiHandler("getValue")
    public void handleGetValue(final ClickEvent event) {
        Window.alert(methodsBox.getValue().toString());
    }

    @UiHandler("clearLogButton")
    public void handleClearLog(final ClickEvent event) {
        logRow.clear();
    }

    @UiHandler("getDateValue")
    public void handleGetDateValue(final ClickEvent event) {
        Window.alert(justDateBox.getValue().toString());
    }

    @UiHandler("getTimeValue")
    public void handleGetTimeValue(final ClickEvent event) {
        Window.alert(justTimeBox.getValue().toString());
    }

    public DateTimePickers() {
        initWidget(ourUiBinder.createAndBindUi(this));

        eventDateTimeBox.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(final ValueChangeEvent<Date> event) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Value Changed Event Fired! (" + event.getValue().toString() + ")");
                logRow.add(logEntry);
            }
        });

        eventDateTimeBox.addShowHandler(new ShowHandler() {
            @Override
            public void onShow(final ShowEvent showEvent) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Show Event Fired");
                logRow.add(logEntry);
            }
        });

        eventDateTimeBox.addHideHandler(new HideHandler() {
            @Override
            public void onHide(final HideEvent hideEvent) {
                final Paragraph logEntry = new Paragraph();
                logEntry.setText("Hide Event Fired");
                logRow.add(logEntry);
            }
        });
    }
}