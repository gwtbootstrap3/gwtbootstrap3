package com.svenjacobs.gwtbootstrap3.client.ui;

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

import java.util.Iterator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.shared.event.TooltipHiddenEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.TooltipHideEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.TooltipShowEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.TooltipShownEvent;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Placement;

public class Tooltip implements IsWidget, HasWidgets, HasPlacement, HasOneWidget, HasId {

	// Defaults from http://getbootstrap.com/javascript/#tooltips
	private final boolean animation = true;
	private final boolean html = false;
	private Placement placement = Placement.TOP;
	private String title = "";
	private final int hideDelay = 0;
	private final int showDelay = 0;

	Widget widget;
	private String id;

	// private EnumSet<Trigger> trigger = EnumSet.of(Trigger.HOVER,
	// Trigger.FOCUS);
	// Unused in gwt?
	// private String selector = string|false
	// private String container = string|false

	public Tooltip() {
	}

	public Tooltip(final Widget w) {
		setWidget(w);
	}

	@Override
	public void setWidget(final Widget w) {
		// Validate
		if (w == widget) {
			return;
		}
		// Detach new child
		if (w != null) {
			w.removeFromParent();
		}
		// Remove old child
		if (widget != null) {
			remove(widget);
		}
		// Logical attach, but don't physical attach; done by jquery.
		widget = w;
		if (widget == null) {
			return;
		}
		// Bind jquery events
		bindJsEvents(widget.getElement());
	}

	@Override
	public void add(final Widget child) {
		if (getWidget() != null) {
			throw new IllegalStateException("Can only contain one child widget");
		}
		setWidget(child);
	}

	@Override
	public void setWidget(final IsWidget w) {
		widget = (w == null) ? null : w.asWidget();
	}

	@Override
	public Widget getWidget() {
		return widget;
	}

	@Override
	public void setId(final String id) {
		this.id = id;
		if (widget != null) {
			widget.getElement().setId(id);
		}
	}

	@Override
	public String getId() {
		return (widget == null) ? id : widget.getElement().getId();
	}

	@Override
	public void setPlacement(final Placement placement) {
		this.placement = placement;
	}

	@Override
	public Placement getPlacement() {
		return placement;
	}

	public String getTitle() {
		return title;
	}

	public void setText(final String text) {
		setTitle(text);
	}

	public void setTitle(final String text) {
		title = text;
	}

	public void reconfigure() {
		// FIXME
		tooltip(widget.getElement(), placement.toString(), title);
	}

	public void toggle() {
		call(widget.getElement(), "toggle");
	}

	public void show() {
		call(widget.getElement(), "show");
	}

	public void hide() {
		call(widget.getElement(), "hide");
	}

	public void destroy() {
		call(widget.getElement(), "destroy");
	}

	/**
	 * Can be override by subclasses to handle Tooltip's "show" event however
	 * it's recommended to add an event handler to the tooltip.
	 * 
	 * @param evt Event
	 * @see TooltipShowEvent
	 */
	protected void onShow(final Event evt) {
		widget.fireEvent(new TooltipShowEvent(this, evt));
	}

	/**
	 * Can be override by subclasses to handle Tooltip's "shown" event however
	 * it's recommended to add an event handler to the tooltip.
	 * 
	 * @param evt Event
	 * @see TooltipShownEvent
	 */
	protected void onShown(final Event evt) {
		widget.fireEvent(new TooltipShownEvent(this, evt));
	}

	/**
	 * Can be override by subclasses to handle Tooltip's "hide" event however
	 * it's recommended to add an event handler to the tooltip.
	 * 
	 * @param evt Event
	 * @see TooltipHideEvent
	 */
	protected void onHide(final Event evt) {
		widget.fireEvent(new TooltipHideEvent(this, evt));
	}

	/**
	 * Can be override by subclasses to handle Tooltip's "hidden" event however
	 * it's recommended to add an event handler to the tooltip.
	 * 
	 * @param evt Event
	 * @see TooltipHiddenEvent
	 */
	protected void onHidden(final Event evt) {
		widget.fireEvent(new TooltipHiddenEvent(this, evt));
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Widget> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(final Widget w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	// @formatter:off
	private native void bindJsEvents(final Element e) /*-{
		var target = this;
		var $tooltip = $wnd.jQuery(e);
		
		$tooltip.on('show.bs.tooltip', function (evt) {
			target.@com.svenjacobs.gwtbootstrap3.client.ui.Tooltip::onShow(Lcom/google/gwt/user/client/Event;)(evt);
		});
		
		$tooltip.on('shown.bs.tooltip', function (evt) {
			target.@com.svenjacobs.gwtbootstrap3.client.ui.Tooltip::onShown(Lcom/google/gwt/user/client/Event;)(evt);
		});
		
		$tooltip.on('hide.bs.tooltip', function (evt) {
			target.@com.svenjacobs.gwtbootstrap3.client.ui.Tooltip::onHide(Lcom/google/gwt/user/client/Event;)(evt);
		});
		
		$tooltip.on('hidden.bs.tooltip', function (evt) {
			target.@com.svenjacobs.gwtbootstrap3.client.ui.Tooltip::onHidden(Lcom/google/gwt/user/client/Event;)(evt);
		});
	}-*/;

	private native void call(final Element e, final String arg) /*-{
		$wnd.jQuery(e).tooltip(arg);
	}-*/;
	
	private native void tooltip(final Element e, final String placement, final String title) /*-{
		$wnd.jQuery(e).tooltip({
			placement: placement,
			title: title
		});
	}-*/;
	
	private native void tooltip(Element e, boolean animation, boolean html, String placement, String selector,
			String title, String trigger, int showDelay, int hideDelay, String container) /*-{
		$wnd.jQuery(e).tooltip({
			animation: animation,
			html: html,
			placement: placement,
			selector: selector,
			title: title,
			trigger: trigger,
			delay: {
				show: showDelay,
				hide: hideDelay
			},
			container: container
		});
	}-*/;
}
