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

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.shared.event.*;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Placement;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Trigger;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Joshua Godi
 */
public class Popover implements IsWidget, HasWidgets, HasOneWidget, HasId, HasHover {
    // Defaults from http://getbootstrap.com/javascript/#popovers
    private boolean isAnimated = true;
    private boolean isHTML = false;
    private Placement placement = Placement.TOP;
    private Trigger trigger = Trigger.HOVER;
    private String title = "";
    private String content = "";
    private int hideDelayMs = 0;
    private int showDelayMs = 0;
    private String container = null;
    private String selector = null;

    private Widget widget;
    private String id;

    public Popover() {
    }

    public Popover(final Widget w) {
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

        // When we attach it, configure the tooltip
        widget.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent event) {
                reconfigure();
            }
        });
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
    public void setIsAnimated(boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    @Override
    public boolean isAnimated() {
        return isAnimated;
    }

    @Override
    public void setIsHtml(boolean isHTML) {
        this.isHTML = isHTML;
    }

    @Override
    public boolean isHtml() {
        return isHTML;
    }

    @Override
    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    @Override
    public Placement getPlacement() {
        return placement;
    }

    @Override
    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    @Override
    public Trigger getTrigger() {
        return trigger;
    }

    @Override
    public void setShowDelayMs(int showDelayMs) {
        this.showDelayMs = showDelayMs;
    }

    @Override
    public int getShowDelayMs() {
        return showDelayMs;
    }

    @Override
    public void setHideDelayMs(int hideDelayMs) {
        this.hideDelayMs = hideDelayMs;
    }

    @Override
    public int getHideDelayMs() {
        return hideDelayMs;
    }

    @Override
    public void setContainer(String container) {
        this.container = container;
    }

    @Override
    public String getContainer() {
        return container;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void reconfigure() {
        // First destroy the old tooltip
        destroy();

        // Setup the new tooltip
        if (container != null && selector != null) {
            popover(widget.getElement(), isAnimated, isHTML, placement.getCssName(), selector, title, content,
                    trigger.getCssName(), showDelayMs, hideDelayMs, container);
        } else if (container != null) {
            popover(widget.getElement(), isAnimated, isHTML, placement.getCssName(), title, content,
                    trigger.getCssName(), showDelayMs, hideDelayMs, container);
        } else if (selector != null) {
            popover(widget.getElement(), isAnimated, isHTML, placement.getCssName(), selector, title, content,
                    trigger.getCssName(), showDelayMs, hideDelayMs);
        } else {
            popover(widget.getElement(), isAnimated, isHTML, placement.getCssName(), title, content,
                    trigger.getCssName(), showDelayMs, hideDelayMs);
        }
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
     * @see com.svenjacobs.gwtbootstrap3.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        widget.fireEvent(new ShowEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tooltip's "shown" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see com.svenjacobs.gwtbootstrap3.client.shared.event.ShownEvent
     */
    protected void onShown(final Event evt) {
        widget.fireEvent(new ShownEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tooltip's "hide" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see com.svenjacobs.gwtbootstrap3.client.shared.event.HideEvent
     */
    protected void onHide(final Event evt) {
        widget.fireEvent(new HideEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tooltip's "hidden" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see com.svenjacobs.gwtbootstrap3.client.shared.event.HiddenEvent
     */
    protected void onHidden(final Event evt) {
        widget.fireEvent(new HiddenEvent(evt));
    }

    public void addShowHandler(ShowHandler showHandler) {
        widget.addHandler(showHandler, ShowEvent.getType());
    }

    public void addShownHandler(ShownHandler shownHandler) {
        widget.addHandler(shownHandler, ShownEvent.getType());
    }

    public void addHideHandler(HideHandler hideHandler) {
        widget.addHandler(hideHandler, HideEvent.getType());
    }

    public void addHiddenHandler(HiddenHandler hiddenHandler) {
        widget.addHandler(hiddenHandler, HiddenEvent.getType());
    }

    @Override
    public void clear() {
        widget = null;
    }

    @Override
    public Iterator<Widget> iterator() {
        // Simple iterator for the widget
        return new Iterator<Widget>() {
            boolean hasElement = widget != null;
            Widget returned = null;

            public boolean hasNext() {
                return hasElement;
            }

            public Widget next() {
                if (!hasElement || (widget == null)) {
                    throw new NoSuchElementException();
                }
                hasElement = false;
                return (returned = widget);
            }

            public void remove() {
                if (returned != null) {
                    Popover.this.remove(returned);
                }
            }
        };
    }

    @Override
    public boolean remove(final Widget w) {
        // Validate.
        if (widget != w) {
            return false;
        }

        // Logical detach.
        clear();
        return true;
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    // @formatter:off
    private native void bindJsEvents(final Element e) /*-{
        var target = this;
        var $popover = $wnd.jQuery(e);

        $popover.on('show.bs.popover', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Popover::onShow(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $popover.on('shown.bs.popover', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Popover::onShown(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $popover.on('hide.bs.popover', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Popover::onHide(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $popover.on('hidden.bs.popover', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Popover::onHidden(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;

    private native void call(final Element e, final String arg) /*-{
        $wnd.jQuery(e).popover(arg);
    }-*/;


    private native void popover(Element e, boolean animation, boolean html, String placement, String selector,
                                String title, String content, String trigger, int showDelay, int hideDelay, String container) /*-{
        $wnd.jQuery(e).popover({
            animation: animation,
            html: html,
            placement: placement,
            selector: selector,
            title: title,
            content: content,
            trigger: trigger,
            delay: {
                show: showDelay,
                hide: hideDelay
            },
            container: container
        });
    }-*/;

    private native void popover(Element e, boolean animation, boolean html, String placement,
                                String title, String content, String trigger, int showDelay, int hideDelay, String container) /*-{
        $wnd.jQuery(e).popover({
            animation: animation,
            html: html,
            placement: placement,
            title: title,
            content: content,
            trigger: trigger,
            delay: {
                show: showDelay,
                hide: hideDelay
            },
            container: container
        });
    }-*/;

    private native void popover(Element e, boolean animation, boolean html, String placement, String selector,
                                String title, String content, String trigger, int showDelay, int hideDelay) /*-{
        $wnd.jQuery(e).popover({
            animation: animation,
            html: html,
            placement: placement,
            selector: selector,
            title: title,
            content: content,
            trigger: trigger,
            delay: {
                show: showDelay,
                hide: hideDelay
            }
        });
    }-*/;

    private native void popover(Element e, boolean animation, boolean html, String placement,
                                String title, String content, String trigger, int showDelay, int hideDelay) /*-{
        $wnd.jQuery(e).popover({
            animation: animation,
            html: html,
            placement: placement,
            title: title,
            content: content,
            trigger: trigger,
            delay: {
                show: showDelay,
                hide: hideDelay
            }
        });
    }-*/;
}