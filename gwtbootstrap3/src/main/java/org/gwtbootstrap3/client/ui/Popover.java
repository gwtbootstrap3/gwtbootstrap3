package org.gwtbootstrap3.client.ui;

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

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;
import org.gwtbootstrap3.client.shared.event.*;
import org.gwtbootstrap3.client.ui.constants.Placement;
import org.gwtbootstrap3.client.ui.constants.Trigger;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Joshua Godi
 */
public class Popover implements IsWidget, HasWidgets, HasOneWidget, HasId, HasHover {
    private static final String TOGGLE = "toggle";
    private static final String SHOW = "show";
    private static final String HIDE = "hide";
    private static final String DESTROY = "destroy";

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
    private final String selector = null;

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
        bindJavaScriptEvents(widget.getElement());

        // When we attach it, configure the tooltip
        widget.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(final AttachEvent event) {
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
    public void setIsAnimated(final boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    @Override
    public boolean isAnimated() {
        return isAnimated;
    }

    @Override
    public void setIsHtml(final boolean isHTML) {
        this.isHTML = isHTML;
    }

    @Override
    public boolean isHtml() {
        return isHTML;
    }

    @Override
    public void setPlacement(final Placement placement) {
        this.placement = placement;
    }

    @Override
    public Placement getPlacement() {
        return placement;
    }

    @Override
    public void setTrigger(final Trigger trigger) {
        this.trigger = trigger;
    }

    @Override
    public Trigger getTrigger() {
        return trigger;
    }

    @Override
    public void setShowDelayMs(final int showDelayMs) {
        this.showDelayMs = showDelayMs;
    }

    @Override
    public int getShowDelayMs() {
        return showDelayMs;
    }

    @Override
    public void setHideDelayMs(final int hideDelayMs) {
        this.hideDelayMs = hideDelayMs;
    }

    @Override
    public int getHideDelayMs() {
        return hideDelayMs;
    }

    @Override
    public void setContainer(final String container) {
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
        call(widget.getElement(), TOGGLE);
    }

    public void show() {
        call(widget.getElement(), SHOW);
    }

    public void hide() {
        call(widget.getElement(), HIDE);
    }

    public void destroy() {
        call(widget.getElement(), DESTROY);
    }

    /**
     * Can be override by subclasses to handle Tooltip's "show" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        widget.fireEvent(new ShowEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tooltip's "shown" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.ShownEvent
     */
    protected void onShown(final Event evt) {
        widget.fireEvent(new ShownEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tooltip's "hide" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.HideEvent
     */
    protected void onHide(final Event evt) {
        widget.fireEvent(new HideEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tooltip's "hidden" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.HiddenEvent
     */
    protected void onHidden(final Event evt) {
        widget.fireEvent(new HiddenEvent(evt));
    }

    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return widget.addHandler(showHandler, ShowEvent.getType());
    }

    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return widget.addHandler(shownHandler, ShownEvent.getType());
    }

    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return widget.addHandler(hideHandler, HideEvent.getType());
    }

    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return widget.addHandler(hiddenHandler, HiddenEvent.getType());
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
    private native void bindJavaScriptEvents(final Element e) /*-{
        var target = this;
        var $popover = $wnd.jQuery(e);

        $popover.on('show.bs.popover', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Popover::onShow(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $popover.on('shown.bs.popover', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Popover::onShown(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $popover.on('hide.bs.popover', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Popover::onHide(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $popover.on('hidden.bs.popover', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Popover::onHidden(Lcom/google/gwt/user/client/Event;)(evt);
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
