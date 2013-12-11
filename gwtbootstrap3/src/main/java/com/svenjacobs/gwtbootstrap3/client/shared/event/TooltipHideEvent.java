package com.svenjacobs.gwtbootstrap3.client.shared.event;

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

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Tooltip;

/**
 * @author Pontus Enmark
 */
public class TooltipHideEvent extends GwtEvent<TooltipHideHandler> implements TooltipEvent {

    private static final Type<TooltipHideHandler> TYPE = new Type<TooltipHideHandler>();

    private final Tooltip tooltip;
    private final Event nativeEvent;

    public static Type<TooltipHideHandler> getType() {
        return TYPE;
    }

    public TooltipHideEvent(final Tooltip tooltip, final Event nativeEvent) {
        this.tooltip = tooltip;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public Tooltip getTooltip() {
        return tooltip;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<TooltipHideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final TooltipHideHandler handler) {
        handler.onHide(this);
    }
}
