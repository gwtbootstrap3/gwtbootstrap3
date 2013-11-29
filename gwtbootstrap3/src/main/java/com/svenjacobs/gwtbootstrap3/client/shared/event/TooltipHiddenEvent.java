package com.svenjacobs.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.ui.Tooltip;

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
 * #Limport com.google.gwt.event.shared.GwtEvent;
 import com.google.gwt.user.client.Event;
 import com.svenjacobs.gwtbootstrap3.client.ui.Tooltip;
 oltip;

 /**
 * @author Pontus Enmark
 */
public class TooltipHiddenEvent extends GwtEvent<TooltipHiddenHandler> implements TooltipEvent {

	private static final Type<TooltipHiddenHandler> TYPE = new Type<TooltipHiddenHandler>();

	private final Tooltip tooltip;
	private final Event nativeEvent;

	public static Type<TooltipHiddenHandler> getType() {
		return TYPE;
	}

	public TooltipHiddenEvent(final Tooltip tooltip, final Event nativeEvent) {
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
	public Type<TooltipHiddenHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final TooltipHiddenHandler handler) {
		handler.onHidden(this);
	}
}
