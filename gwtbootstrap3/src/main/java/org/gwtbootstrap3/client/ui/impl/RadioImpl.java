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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.Event;

public class RadioImpl {

    public void ensureDomEventHandlers(final Radio radio) {
        radio.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                ValueChangeEvent.fire(radio, radio.getValue());
            }

        });
    }

    public void sinkEvents(int eventBitsToAdd, Element inputElem, Element labelElem) {
        Event.sinkEvents(inputElem,
                eventBitsToAdd | Event.getEventsSunk(inputElem));
    }

}
