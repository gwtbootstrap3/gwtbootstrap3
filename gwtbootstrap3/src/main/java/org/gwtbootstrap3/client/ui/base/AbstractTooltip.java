package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.gwtbootstrap3.client.shared.event.HiddenEvent;
import org.gwtbootstrap3.client.shared.event.HiddenHandler;
import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.InsertedEvent;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.shared.event.ShownEvent;
import org.gwtbootstrap3.client.shared.event.ShownHandler;
import org.gwtbootstrap3.client.shared.js.JQuery;
import org.gwtbootstrap3.client.ui.constants.Placement;
import org.gwtbootstrap3.client.ui.constants.Trigger;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.HandlerRegistration;

import jsinterop.annotations.JsMethod;

/**
 * Common implementation for the Bootstrap tooltip and popover.
 *
 * @author Joshua Godi
 * @author Pontus Enmark
 * @author Steven Jardine
 */
public abstract class AbstractTooltip implements IsWidget, HasWidgets, HasOneWidget, HasId, HasHover {
    
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
    private String selector = null;
    private String viewportSelector = "body";
    private int viewportPadding = 0;

    private String tooltipClassNames = "tooltip";
    private String tooltipArrowClassNames = "tooltip-arrow";
    private String tooltipInnerClassNames = "tooltip-inner";

    private final static String DEFAULT_TEMPLATE = "<div class=\"{0}\"><div class=\"{1}\"></div><div class=\"{2}\"></div></div>";
    private String alternateTemplate = null;

    protected Widget widget;
    private String id;
    private final String dataTarget;
    protected boolean initialized = false;
    private boolean showing = false;

    /**
     * Creates the empty Tooltip
     */
    public AbstractTooltip(String dataTarget) {
        this.dataTarget = dataTarget;
    }

    /**
     * Creates the tooltip with given title. Remember to set the widget as well
     *
     * @param title title for the tooltip
     */
    public AbstractTooltip(String dataTarget, final String title) {
        this(dataTarget);
        setTitle(title);
    }

    /**
     * Creates the tooltip around this widget
     *
     * @param w widget for the tooltip
     */
    public AbstractTooltip(String dataTarget, final Widget w) {
        this(dataTarget);
        setWidget(w);
    }

    /**
     * Creates the tooltip around this widget with given title
     *
     * @param w widget for the tooltip
     * @param title title for the tooltip
     */
    public AbstractTooltip(String dataTarget, final Widget w, final String title) {
        this(dataTarget);
        setWidget(w);
        setTitle(title);
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
     * Adds a hidden handler to the Tooltip that will be fired when the Tooltip's hidden event is fired
     *
     * @param hiddenHandler HiddenHandler to handle the hidden event
     * @return HandlerRegistration of the handler
     */
    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return widget.addHandler(hiddenHandler, HiddenEvent.getType());
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
     * Add a tooltip arrow div class name
     *
     * @param tooltipArrowClassName a tooltip arrow div class name
     */
    public void addTooltipArrowClassName(String tooltipArrowClassName) {
        this.tooltipArrowClassNames += " " + tooltipArrowClassName;
    }

    /**
     * Add a tooltip div class name
     *
     * @param tooltipClassName a tooltip div class name
     */
    public void addTooltipClassName(String tooltipClassName) {
        this.tooltipClassNames += " " + tooltipClassName;
    }

    /**
     * Add a tooltip inner div class name
     *
     * @param tooltipInnerClassName a tooltip inner div class name
     */
    public void addTooltipInnerClassName(String tooltipInnerClassName) {
        this.tooltipInnerClassNames += " " + tooltipInnerClassName;
    }

    /** {@inheritDoc} */
    @Override
    public Widget asWidget() {
        return widget;
    }

    // @formatter:off
    protected void bindJavaScriptEvents(final Element e) {
        JQuery tooltip = JQuery.jQuery(e);
        tooltip.on("show." + dataTarget, (evt) -> {
            onShow(evt);
        });
        tooltip.on("shown." + dataTarget, (evt) -> {
            onShown(evt);
        });
        tooltip.on("hide." + dataTarget, (evt) -> {
            onHide(evt);
        });
        tooltip.on("hidden." + dataTarget, (evt) -> {
            onHidden(evt);
        });
        tooltip.on("inserted." + dataTarget, (evt) -> {
            onInserted(evt);
        });
    }
    
    protected abstract void call(final String arg);

    /** {@inheritDoc} */
    @Override
    public void clear() {
        widget = null;
    }

    /**
     * Create the options for the tooltip.
     */
    protected void createOptions(Element e, boolean animation, boolean html, String selector,
            String trigger, int showDelay, int hideDelay, String container, String template, String viewportSelector,
            int viewportPadding) {
        e.setAttribute("data-animation", Boolean.toString(animation));
        e.setAttribute("data-delay", "{ \"show\": " + Integer.toString(showDelay) + ", \"hide\": " + Integer.toString(hideDelay) + " }");
        e.setAttribute("data-html", Boolean.toString(html));
        e.setAttribute("data-placement", getPlacementCssName());
        e.setAttribute("data-template", template);
        e.setAttribute("data-title", getTitle());
        e.setAttribute("data-trigger", trigger);
        e.setAttribute("data-viewport", "{ \"selector\": \"" + viewportSelector + "\", \"padding\": " + viewportPadding + " }");
        if (selector != null) {
            e.setAttribute("data-selector", selector);
        }
        if (container != null) {
            e.setAttribute("data-container", container);
        }
    }
    
    /**
     * Force the Tooltip to be destroyed
     */
    public void destroy() {
        call(DESTROY);
        setInitialized(false);
    }

    /**
     * Get the alternate template used to render the tooltip. If null,
     * the default template will be used.
     *
     * @return String the alternate template used to render the tooltip
     */
    public String getAlternateTemplate() {
        return alternateTemplate;
    }

    /** {@inheritDoc} */
    @Override
    public String getContainer() {
        return container;
    }

    /** {@inheritDoc} */
    @Override
    public int getHideDelayMs() {
        return hideDelayMs;
    }

    /** {@inheritDoc} */
    @Override
    public String getId() {
        return (widget == null) ? id : widget.getElement().getId();
    }

    /** {@inheritDoc} */
    @Override
    public Placement getPlacement() {
        return placement;
    }

    /**
     * Gets the placement css name.
     *
     * @return the placement css name
     */
    private String getPlacementCssName() {
        return placement == null ? Placement.TOP.getCssName() : placement.getCssName();
    }

    /**
     * Get the tooltip's selector
     *
     * @return String the tooltip's selector
     */
    public String getSelector() {
        return selector;
    }

    /** {@inheritDoc} */
    @Override
    public int getShowDelayMs() {
        return showDelayMs;
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
     * Get the tooltip arrow div class names
     *
     * @return String Get the tooltip arrow div class names
     */
    public String getTooltipArrowClassNames() {
        return tooltipArrowClassNames;
    }

    /**
     * Get the tooltip div class names
     *
     * @return String the tooltip div class names
     */
    public String getTooltipClassNames() {
        return tooltipClassNames;
    }

    /**
     * Get the tooltip inner div class names
     *
     * @return String the tooltip inner div class names
     */
    public String getTooltipInnerClassNames() {
        return tooltipInnerClassNames;
    }

    /** {@inheritDoc} */
    @Override
    public Trigger getTrigger() {
        return trigger;
    }

    /**
     * @return the viewportPadding
     */
    public int getViewportPadding() {
        return viewportPadding;
    }

    /**
     * @return the viewportSelector
     */
    public String getViewportSelector() {
        return viewportSelector;
    }

    /** {@inheritDoc} */
    @Override
    public Widget getWidget() {
        return widget;
    }

    /**
     * Force hide the Tooltip
     */
    public void hide() {
        call(HIDE);
    }

    /**
     * Initializes the tooltip for use.
     */
    public abstract void init();

    /** {@inheritDoc} */
    @Override
    public boolean isAnimated() {
        return isAnimated;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isHtml() {
        return isHTML;
    }

    /**
     * @return the initialized
     */
    public boolean isInitialized() {
        return initialized;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<Widget> iterator() {
        // Simple iterator for the widget
        return new Iterator<Widget>() {

            boolean hasElement = widget != null;

            Widget returned = null;

            /** {@inheritDoc} */
            @Override
            public boolean hasNext() {
                return hasElement;
            }

            /** {@inheritDoc} */
            @Override
            public Widget next() {
                if (!hasElement || (widget == null)) {
                    throw new NoSuchElementException();
                }
                hasElement = false;
                return (returned = widget);
            }

            /** {@inheritDoc} */
            @Override
            public void remove() {
                if (returned != null) {
                    AbstractTooltip.this.remove(returned);
                }
            }
        };
    }

    /**
     * Can be override by subclasses to handle Tooltip's "hidden" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.HiddenEvent
     */
    protected void onHidden(final Event evt) {
        showing = false;
        widget.fireEvent(new HiddenEvent(evt));
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
     * Can be override by subclasses to handle Tooltip's "inserted" event however
     * it's recommended to add an event handler to the tooltip.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.InsertedEvent
     */
    protected void onInserted(final Event evt) {
        widget.fireEvent(new InsertedEvent(evt));
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
        showing = true;
        widget.fireEvent(new ShownEvent(evt));
    }

    protected String prepareTemplate() {
        String template = null;
        if (alternateTemplate == null) {
            template = DEFAULT_TEMPLATE.replace("{0}", getTooltipClassNames());
            template = template.replace("{1}", getTooltipArrowClassNames());
            template = template.replace("{2}", getTooltipInnerClassNames());
        } else {
            template = alternateTemplate;
        }
        return template;
    }

    /**
     * Reconfigures the tooltip.
     * 
     * @deprecated will be removed after the next release.
     */
    public void reconfigure() {
        // Do nothing. No longer necessary.
    }

    /**
     * Recreate the tooltip/popover with a default dealy of 300ms between the call to destroy and init.
     */
    public void recreate() {
        recreate(300);
    }

    /**
     * Recreate the tooltip/popover. The delay is necessary because the destroy of the tooltip needs to be complete
     * prior to calling init.
     *
     * @param delay the delay in ms between the call to destroy and init.
     */
    public void recreate(int delay) {
        destroy();
        new Timer() {
            @Override
            public void run() {
                init();
            }
        }.schedule(delay);
    }

    /** {@inheritDoc} */
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
     * Set the alternate template used to render the tooltip. The template should contain
     * divs with classes 'tooltip', 'tooltip-inner', and 'tooltip-arrow'. If an alternate
     * template is configured, the 'tooltipClassNames', 'tooltipArrowClassNames', and
     * 'tooltipInnerClassNames' properties are not used.
     *
     * @param alternateTemplate the alternate template used to render the tooltip
     */
    public void setAlternateTemplate(String alternateTemplate) {
        this.alternateTemplate = alternateTemplate;
        if (initialized) {
            updateString(widget.getElement(), "template", prepareTemplate());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setContainer(final String container) {
        this.container = container;
        if (initialized) {
            updateString(widget.getElement(), "container", container);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setHideDelayMs(final int hideDelayMs) {
        this.hideDelayMs = hideDelayMs;
        if (initialized) {
            updateDelay(widget.getElement(), showDelayMs, hideDelayMs);
        }
    }

    /**
     * Sets the tooltip's display string in HTML format
     *
     * @param text String display string in HTML format
     */
    public void setHtml(final SafeHtml html) {
        setIsHtml(true);
        if (html == null) {
            setTitle("");
        } else {
            setTitle(html.asString());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setId(final String id) {
        this.id = id;
        if (widget != null) {
            widget.getElement().setId(id);
        }
    }

    /**
     * @param initialized the initialized to set
     */
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    /** {@inheritDoc} */
    @Override
    public void setIsAnimated(final boolean isAnimated) {
        this.isAnimated = isAnimated;
        if (initialized) {
            updateBool(widget.getElement(), "animation", isAnimated);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setIsHtml(final boolean isHTML) {
        this.isHTML = isHTML;
        if (initialized) {
            updateBool(widget.getElement(), "html", isHTML);
        }

    }

    /** {@inheritDoc} */
    @Override
    public void setPlacement(final Placement placement) {
        this.placement = placement;
        if (initialized) {
            updateString(widget.getElement(), "placement", getPlacementCssName());
        }
    }

    /**
     * Set the tooltip's selector
     *
     * @param selector the tooltip's selector
     */
    public void setSelector(String selector) {
        this.selector = selector;
        if (initialized) {
            updateString(widget.getElement(), "selector", selector);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setShowDelayMs(final int showDelayMs) {
        this.showDelayMs = showDelayMs;
        if (initialized) {
            updateDelay(widget.getElement(), showDelayMs, hideDelayMs);
        }
    }

    /**
     * Convenience method. Sets the tooltop's display string.
     * 
     * @param text String display string.
     * @deprecated use {@link #setTitle(String)}.
     */
    public void setText(String text) {
        setTitle(text);
    }

    /**
     * Sets the tooltip's display string
     *
     * @param title String display string
     */
    public void setTitle(final String title) {
        this.title = title;
        if (initialized) {
            updateString(widget.getElement(), "title", this.title);
            if (showing) {
                updateTitleWhenShowing();
            }
        }
    }

    /**
     * Set the tooltip arrow div class names
     *
     * @param tooltipArrowClassNames the tooltip arrow div class names
     */
    public void setTooltipArrowClassNames(String tooltipArrowClassNames) {
        this.tooltipArrowClassNames = tooltipArrowClassNames;
    }

    /**
     * Set the tooltip div class names
     *
     * @param tooltipClassNames the tooltip div class names
     */
    public void setTooltipClassNames(String tooltipClassNames) {
        this.tooltipClassNames = tooltipClassNames;
    }

    /**
     * Set the tooltip inner div class names
     *
     * @param tooltipInnerClassNames the tooltip inner div class names
     */
    public void setTooltipInnerClassNames(String tooltipInnerClassNames) {
        this.tooltipInnerClassNames = tooltipInnerClassNames;
    }

    /** {@inheritDoc} */
    @Override
    public void setTrigger(final Trigger trigger) {
        this.trigger = trigger;
        if (initialized) {
            updateString(widget.getElement(), "trigger",
                    trigger == null ? Trigger.HOVER.getCssName() : trigger.getCssName());
        }
    }

    /**
     * @param viewportPadding the viewportPadding to set
     */
    public void setViewportPadding(int viewportPadding) {
        this.viewportPadding = viewportPadding;
        if (initialized) {
            updateViewport(getWidget().getElement(), this.viewportSelector, this.viewportPadding);
        }
    }

    /**
     * @param viewportSelector the viewportSelector to set
     */
    public void setViewportSelector(String viewportSelector) {
        this.viewportSelector = viewportSelector;
        if (initialized) {
            updateViewport(getWidget().getElement(), this.viewportSelector, this.viewportPadding);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setWidget(final IsWidget w) {
        setWidget(w.asWidget());
    }

    /** {@inheritDoc} */
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

        // When we attach it, configure the tooltip
        widget.addAttachHandler(new AttachEvent.Handler() {

            @Override
            public void onAttachOrDetach(final AttachEvent event) {
                init();
            }
        });
    }

    /**
     * Force show the Tooltip
     */
    public void show() {
        call(SHOW);
    }

    /**
     * Toggle the Tooltip to either show/hide
     */
    public void toggle() {
        call(TOGGLE);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return asWidget().toString();
    }

    private void updateBool(Element e, String option, boolean value) {
        updateBool(dataTarget, e, option, value);
    }

    @JsMethod
    private static native void updateBool(String dataTarget, Element e, String option, boolean value);

    private void updateDelay(Element e, int showDelay, int hideDelay) {
        updateDelay(dataTarget, e, showDelay, hideDelay);
    }

    @JsMethod
    private static native void updateDelay(String dataTarget, Element e, int showDelay, int hideDelay);

    protected void updateString(Element e, String option, String value) {
        updateString(dataTarget, e, option, value);
    }

    @JsMethod
    private static native void updateString(String dataTarget, Element e, String option, String value);

    /**
     * Update the title. This should only be called when the title is already showing. It causes a small flicker but
     * updates the title immediately.
     */
    protected abstract void updateTitleWhenShowing();

    private void updateViewport(Element e, String selector, int padding) {
        updateViewport(dataTarget, e, selector, padding);
    }

    @JsMethod
    private static native void updateViewport(String dataTarget, Element e, String selector, int padding);

}
