package org.gwtbootstrap3.client.shared.event;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * @author Sven Jacobs
 */
public class ModalHiddenEvent extends GwtEvent<ModalHiddenHandler> implements ModalEvent {

    private static final Type<ModalHiddenHandler> TYPE = new Type<ModalHiddenHandler>();

    private final Modal modal;
    private final Event nativeEvent;

    public static Type<ModalHiddenHandler> getType() {
        return TYPE;
    }

    public ModalHiddenEvent(final Modal modal, final Event nativeEvent) {
        this.modal = modal;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public Modal getModal() {
        return modal;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<ModalHiddenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ModalHiddenHandler handler) {
        handler.onHidden(this);
    }
}
