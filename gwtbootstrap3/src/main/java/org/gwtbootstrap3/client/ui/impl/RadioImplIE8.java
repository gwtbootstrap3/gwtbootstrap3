package org.gwtbootstrap3.client.ui.impl;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.Radio;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.Event;

/**
 * This implementation will work in most cases.
 *
 * This case is not supported:
 *
 * 1. Given a group of two Radios
 * 2. Select the first with a click on either input or label
 * 3. Select the second with a click on either input or label
 * 4. Select the first using the keyboard
 *
 * You will notice that 4 does not trigger a ValueChangeEvent.
 *
 */
public class RadioImplIE8 extends RadioImpl {

    private static class Handler implements ClickHandler, MouseUpHandler, BlurHandler, KeyDownHandler {

        private final Radio radio;
        private Boolean oldValue;

        public Handler(Radio radio) {
            this.radio = radio;
        }

        @Override
        public void onClick(ClickEvent event) {
            ValueChangeEvent.fireIfNotEqual(radio, oldValue, radio.getValue());
        }

        @Override
        public void onKeyDown(KeyDownEvent event) {
            oldValue = radio.getValue();
        }

        @Override
        public void onBlur(BlurEvent event) {
            oldValue = radio.getValue();
        }

        @Override
        public void onMouseUp(MouseUpEvent event) {
            oldValue = radio.getValue();
        }

    }

    @Override
    public void ensureDomEventHandlers(final Radio radio) {
        final Handler handler = new Handler(radio);
        radio.addClickHandler(handler);
        radio.addMouseUpHandler(handler);
        radio.addBlurHandler(handler);
        radio.addKeyDownHandler(handler);
    }

    @Override
    public void sinkEvents(int eventBitsToAdd, Element inputElem,
            Element labelElem) {
        Event.sinkEvents(inputElem,
                eventBitsToAdd | Event.getEventsSunk(inputElem));
        Event.sinkEvents(labelElem,
                eventBitsToAdd | Event.getEventsSunk(labelElem));
    }

}
