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
 * Basic implementation for the Bootstrap Popover
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#popovers">Bootstrap Documentation</a>
 * <p/>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * 
 * <pre>
 * {@code
 * <b:Popover text="...">
 *    ...
 * </b:Popover>
 * }
 * </pre>
 * <p/>
 *
 * @author Steven Jardine
 */
public class Popover extends AbstractTooltip {

    private static final String TEMPLATE = "<div class=\"popover\" role=\"tooltip\"><div class=\"arrow\"></div><h3 class=\"popover-title\"></h3><div class=\"popover-content\"></div></div>";

    private String content = null;

    /**
     * Creates the empty Popover
     */
    public Popover() {
        super("bs.popover");
        setAlternateTemplate(TEMPLATE);
    }

    /**
     * Creates the popover with given title. Remember to set the content and widget as well.
     *
     * @param title title for the popover
     */
    public Popover(final String title) {
        this();
        setTitle(title);
    }

    /**
     * Creates the popover with given title and content. Remember to set the widget as well.
     *
     * @param title title for the popover
     */
    public Popover(final String title, String content) {
        this();
        setTitle(title);
        setContent(content);
    }

    /**
     * Creates the popover around this widget
     *
     * @param w widget for the popover
     */
    public Popover(final Widget w) {
        this();
        setWidget(w);
    }

    /**
     * Creates the popover around this widget with given title and content.
     *
     * @param w widget for the popover
     * @param title title for the popover
     * @param content content for the popover
     */
    public Popover(final Widget w, final String title, String content) {
        this();
        setWidget(w);
        setTitle(title);
        setContent(content);
    }

    /**
     * Call the native popover method with the given argument.
     *
     * @param e the {@link Element}.
     * @param arg the arg
     */
    private void call(final Element e, final String arg) {
        JQuery.jQuery(e).popover(arg);
    }

    /** {@inheritDoc} */
    @Override
    protected void call(String arg) {
        call(getWidget().getElement(), arg);
    }

    /**
     * @return the content of the popover.
     */
    public String getContent() {
        return content == null ? "" : content;
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        Element element = getWidget().getElement();
        createOptions(element, isAnimated(), isHtml(), getSelector(),
                getTrigger().getCssName(), getShowDelayMs(), getHideDelayMs(), getContainer(), prepareTemplate(), 
                getViewportSelector(), getViewportPadding());
        popover(element, getContent());
        bindJavaScriptEvents(element);
        setInitialized(true);
    }

    /**
     * Create the popover.
     */
    private void popover(Element e, String content) {
        e.setAttribute("data-content", content);
        JQuery.jQuery(e).popover();
    }

    /**
     * @param content the content of the popover to set
     */
    public void setContent(String content) {
        this.content = content;
        if (initialized) {
            updateString(widget.getElement(), "content", content);
        }
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
     * @param e the popover {@link Element}.
     */
    private void updateTitleWhenShowing(Element e) {
        JQuery.jQuery(e).popover("fixTitle").popover("show");
    };

}
