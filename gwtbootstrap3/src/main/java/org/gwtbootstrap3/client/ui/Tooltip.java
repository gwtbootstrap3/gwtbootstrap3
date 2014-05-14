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
import org.gwtbootstrap3.client.shared.event.HiddenEvent;
import org.gwtbootstrap3.client.shared.event.HiddenHandler;
import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.shared.event.ShownEvent;
import org.gwtbootstrap3.client.shared.event.ShownHandler;
import org.gwtbootstrap3.client.ui.base.HasHover;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.constants.Placement;
import org.gwtbootstrap3.client.ui.constants.Trigger;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Basic implementation for the Bootstrap tooltip
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#tooltips">Bootstrap Documentation</a>
 * <p/>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Tooltip text="...">
 *    ...
 * </b:Tooltip>
 * }
 * </pre>
 * <p/>
 * ** Must call reconfigure() after altering any/all Tooltips!
 *
 * @author Joshua Godi
 * @author Pontus Enmark
 */
public class Tooltip implements IsWidget, HasWidgets, HasOneWidget, HasId, HasHover {
    private static final String TOGGLE = "toggle";
    private static final String SHOW = "show";
    private static final String HIDE = "hide";
    private static final String DESTROY = "destroy";

    // Defaults from http://getbootstrap.com/javascript/#tooltips
    private boolean isAnimated = true;
    private boolean isHTML = false;
    private Placement placement = Placement.TOP;
    private Trigger trigger = Trigger.HOVER;
    private String title = "";
    private int hideDelayMs = 0;
    private int showDelayMs = 0;
    private String container = null;
    private final String selector = null;

    private Widget widget;
    private String id;

    /**
     * Creates the empty Tooltip
     */
    public Tooltip() {
    }

    /**
     * Creates the tooltip around this widget
     *
     * @param w widget for the tooltip
     */
    public Tooltip(final Widget w) {
        setWidget(w);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Widget child) {
        if (getWidget() != null) {
            throw new IllegalStateException("Can only contain one child widget");
        }
        setWidget(child);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidget(final IsWidget w) {
        widget = (w == null) ? null : w.asWidget();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget getWidget() {
        return widget;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final String id) {
        this.id = id;
        if (widget != null) {
            widget.getElement().setId(id);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return (widget == null) ? id : widget.getElement().getId();
    }

    @Override
    public void setIsAnimated(final boolean isAnimated) {
        this.isAnimated = isAnimated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIsHtml(final boolean isHTML) {
        this.isHTML = isHTML;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isHtml() {
        return isHTML;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPlacement(final Placement placement) {
        this.placement = placement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Placement getPlacement() {
        return placement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTrigger(final Trigger trigger) {
        this.trigger = trigger;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Trigger getTrigger() {
        return trigger;
    }

    @Override
    public void setShowDelayMs(final int showDelayMs) {
        this.showDelayMs = showDelayMs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getShowDelayMs() {
        return showDelayMs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHideDelayMs(final int hideDelayMs) {
        this.hideDelayMs = hideDelayMs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHideDelayMs() {
        return hideDelayMs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContainer(final String container) {
        this.container = container;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getContainer() {
        return container;
    }

    /**
     * Gets the tooltip's display string
     *
     * @return String tooltip display string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the tooltip's display string
     *
     * @param text String display string
     */
    public void setText(final String text) {
        setTitle(text);
    }

    /**
     * Sets the tooltip's display string
     *
     * @param title String display string
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Reconfigures the tooltip, must be called when altering any tooltip after it has already been shown
     */
    public void reconfigure() {
        // First destroy the old tooltip
        destroy();

        // Setup the new tooltip
        if (container != null && selector != null) {
            tooltip(widget.getElement(), isAnimated, isHTML, placement.getCssName(), selector, title,
                    trigger.getCssName(), showDelayMs, hideDelayMs, container);
        } else if (container != null) {
            tooltip(widget.getElement(), isAnimated, isHTML, placement.getCssName(), title,
                    trigger.getCssName(), showDelayMs, hideDelayMs, container);
        } else if (selector != null) {
            tooltip(widget.getElement(), isAnimated, isHTML, placement.getCssName(), selector, title,
                    trigger.getCssName(), showDelayMs, hideDelayMs);
        } else {
            tooltip(widget.getElement(), isAnimated, isHTML, placement.getCssName(), title,
                    trigger.getCssName(), showDelayMs, hideDelayMs);
        }
    }

    /**
     * Toggle the Tooltip to either show/hide
     */
    public void toggle() {
        call(widget.getElement(), TOGGLE);
    }

    /**
     * Force show the Tooltip
     */
    public void show() {
        call(widget.getElement(), SHOW);
    }

    /**
     * Force hide the Tooltip
     */
    public void hide() {
        call(widget.getElement(), HIDE);
    }

    /**
     * Force the Tooltip to be destroyed
     */
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
     * @see ShownEvent
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

    /**
     * Adds a show handler to the Tooltip that will be fired when the Tooltip's show event is fired
     *
     * @param showHandler ShowHandler to handle the show event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return widget.addHandler(showHandler, ShowEvent.getType());
    }

    /**
     * Adds a shown handler to the Tooltip that will be fired when the Tooltip's shown event is fired
     *
     * @param shownHandler ShownHandler to handle the shown event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return widget.addHandler(shownHandler, ShownEvent.getType());
    }

    /**
     * Adds a hide handler to the Tooltip that will be fired when the Tooltip's hide event is fired
     *
     * @param hideHandler HideHandler to handle the hide event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return widget.addHandler(hideHandler, HideEvent.getType());
    }

    /**
     * Adds a hidden handler to the Tooltip that will be fired when the Tooltip's hidden event is fired
     *
     * @param hiddenHandler HiddenHandler to handle the hidden event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return widget.addHandler(hiddenHandler, HiddenEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        widget = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Widget> iterator() {
        // Simple iterator for the widget
        return new Iterator<Widget>() {
            boolean hasElement = widget != null;
            Widget returned = null;

            @Override
            public boolean hasNext() {
                return hasElement;
            }

            @Override
            public Widget next() {
                if (!hasElement || (widget == null)) {
                    throw new NoSuchElementException();
                }
                hasElement = false;
                return (returned = widget);
            }

            @Override
            public void remove() {
                if (returned != null) {
                    Tooltip.this.remove(returned);
                }
            }
        };
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget asWidget() {
        return widget;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return asWidget().toString();
    }

    // @formatter:off
    private native void bindJavaScriptEvents(final Element e) /*-{
        var target = this;
        var $tooltip = $wnd.jQuery(e);

        $tooltip.on('show.bs.tooltip', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Tooltip::onShow(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $tooltip.on('shown.bs.tooltip', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Tooltip::onShown(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $tooltip.on('hide.bs.tooltip', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Tooltip::onHide(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $tooltip.on('hidden.bs.tooltip', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Tooltip::onHidden(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;

    private native void call(final Element e, final String arg) /*-{
        $wnd.jQuery(e).tooltip(arg);
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

    private native void tooltip(Element e, boolean animation, boolean html, String placement,
                                String title, String trigger, int showDelay, int hideDelay, String container) /*-{
        $wnd.jQuery(e).tooltip({
            animation: animation,
            html: html,
            placement: placement,
            title: title,
            trigger: trigger,
            delay: {
                show: showDelay,
                hide: hideDelay
            },
            container: container
        });
    }-*/;

    private native void tooltip(Element e, boolean animation, boolean html, String placement, String selector,
                                String title, String trigger, int showDelay, int hideDelay) /*-{
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
            }
        });
    }-*/;

    private native void tooltip(Element e, boolean animation, boolean html, String placement,
                                String title, String trigger, int showDelay, int hideDelay) /*-{
        $wnd.jQuery(e).tooltip({
            animation: animation,
            html: html,
            placement: placement,
            title: title,
            trigger: trigger,
            delay: {
                show: showDelay,
                hide: hideDelay
            }
        });
    }-*/;
}
