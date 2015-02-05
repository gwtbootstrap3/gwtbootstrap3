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

import org.gwtbootstrap3.client.ui.Tooltip;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;

/**
 * @author Pontus Enmark
 */
public class TooltipShownEvent extends GwtEvent<TooltipShownHandler> implements TooltipEvent {

    private static final Type<TooltipShownHandler> TYPE = new Type<TooltipShownHandler>();

    private final Tooltip tooltip;
    private final Event nativeEvent;

    public static Type<TooltipShownHandler> getType() {
        return TYPE;
    }

    public TooltipShownEvent(final Tooltip tooltip, final Event nativeEvent) {
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
    public Type<TooltipShownHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final TooltipShownHandler handler) {
        handler.onShown(this);
    }
}
