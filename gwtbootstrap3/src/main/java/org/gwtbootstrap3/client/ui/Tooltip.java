package org.gwtbootstrap3.client.ui;

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
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.gwtbootstrap3.client.shared.js.JQuery;
import org.gwtbootstrap3.client.ui.base.AbstractTooltip;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Basic implementation for the Bootstrap tooltip
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#tooltips">Bootstrap Documentation</a>
 * <p/>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * 
 * <pre>
 * {@code
 * <b:Tooltip text="...">
 *    ...
 * </b:Tooltip>
 * }
 * </pre>
 * <p/>
 *
 * @author Steven Jardine
 */
public class Tooltip extends AbstractTooltip {

    /**
     * Creates the empty Popover
     */
    public Tooltip() {
        super("bs.tooltip");
    }

    /**
     * Creates the tooltip with given title. Remember to set the content and widget as well.
     *
     * @param title title for the tooltip
     */
    public Tooltip(final String title) {
        this();
        setTitle(title);
    }

    /**
     * Creates the tooltip around this widget
     *
     * @param w widget for the tooltip
     */
    public Tooltip(final Widget w) {
        this();
        setWidget(w);
    }

    /**
     * Creates the tooltip around this widget with given title and content.
     *
     * @param w widget for the tooltip
     * @param title title for the tooltip
     */
    public Tooltip(final Widget w, final String title) {
        this();
        setWidget(w);
        setTitle(title);
    }

    /**
     * Call the native tooltip method with the given argument.
     *
     * @param e the {@link Element}.
     * @param arg the arg
     */
    private void call(final Element e, final String arg) {
        JQuery.jQuery(e).tooltip(arg);
    }

    /** {@inheritDoc} */
    @Override
    protected void call(String arg) {
        call(getWidget().getElement(), arg);
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        Element element = getWidget().getElement();
        createOptions(element, isAnimated(), isHtml(), getSelector(),
                getTrigger().getCssName(), getShowDelayMs(), getHideDelayMs(), getContainer(), prepareTemplate(), 
                getViewportSelector(), getViewportPadding());
        tooltip(element);
        bindJavaScriptEvents(element);
        setInitialized(true);
    }

    /**
     * Create the tooltip.
     */
    private void tooltip(Element e) {
        JQuery.jQuery(e).tooltip();
    }

    /** {@inheritDoc} */
    @Override
    protected void updateTitleWhenShowing() {
        updateTitleWhenShowing(getWidget().getElement());
    }

    /**
     * Update the title. This should only be called when the title is already showing. It causes a small flicker but
     * updates the title immediately.
     *
     * @param e the tooltip {@link Element}.
     */
    private void updateTitleWhenShowing(Element e) {
        JQuery.jQuery(e).tooltip("fixTitle").tooltip("show");
    }

}
