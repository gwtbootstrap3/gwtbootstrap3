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

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.shared.event.TabShowEvent;
import org.gwtbootstrap3.client.shared.event.TabShowHandler;
import org.gwtbootstrap3.client.shared.event.TabShownEvent;
import org.gwtbootstrap3.client.shared.event.TabShownHandler;
import org.gwtbootstrap3.client.shared.js.JQuery;
import org.gwtbootstrap3.client.ui.base.HasDataTarget;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import java.util.List;

/**
 * List item for the nav tabs, needs special toggle and JS to make it work properly
 * <p/>
 * <a href="http://getbootstrap.com/javascript/#tabs">Bootstrap Documentation</a>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:NavTabs>
 *    <b:TabListItem/>
 *    <b:TabListItem/>
 * </b:NavTabs>
 * }
 * </pre>
 *
 * @author Joshua Godi
 * @author Drew Spencer
 * @see org.gwtbootstrap3.client.ui.NavTabs
 */
public class TabListItem extends AnchorListItem implements HasDataTarget {

    /**
     * Creates the default widget with no text
     */
    public TabListItem() {
        this("");
    }

    /**
     * Creates the default widget with the desired text
     *
     * @param text text for the list item
     */
    public TabListItem(final String text) {
        super(text);
        setDataToggle(Toggle.TAB);
    }

    public TabListItem(final String text, final IconType iconType) {
        this(text);
        setIcon(iconType);
    }

    public TabListItem(final String text, final IconType iconType, final IconSize iconSize) {
        this(text, iconType);
        setIconSize(iconSize);
    }

    public TabListItem(final String text, final String badgeText) {
        this(text);
        setBadgeText(badgeText);
    }

    /**
     * Forces the tab pane associated with this list item to be shown and default fires the events
     */
    public void showTab() {
        showTab(true);
    }

    /**
     * Forces the tab pane associated with this list item to be shown
     *
     * @param fireEvents true=fire show/hide events, false=don't fire show/hide events
     */
    public void showTab(final boolean fireEvents) {
        showTab(anchor.getElement());

        if (fireEvents) {
            fireEvent(new TabShowEvent(this, null));
        }
    }

    /**
     * Add a show handler for the tab
     *
     * @param showHandler show handler
     * @return HandlerRegistration to manage handles
     */
    public HandlerRegistration addShowHandler(final TabShowHandler showHandler) {
        return addHandler(showHandler, TabShowEvent.getType());
    }

    /**
     * Add a shown handler for the tab
     *
     * @param shownHandler show handler
     * @return HandlerRegistration to manage handles
     */
    public HandlerRegistration addShownHandler(final TabShownHandler shownHandler) {
        return addHandler(shownHandler, TabShownEvent.getType());
    }

    /**
     * We override set href here because we want to ensure that projects with gwt places and gwtp
     * don't try to execute a place change event with it being clicked
     */
    @Override
    public void setHref(final String href) {
        setDataTarget(href);
    }

    /** {@inheritDoc} */
    @Override
    public String getHref() {
        return getDataTarget();
    }

    /** {@inheritDoc} */
    @Override
    public void setDataTargetWidgets(final List<Widget> widgets) {
        anchor.setDataTargetWidgets(widgets);
    }

    /** {@inheritDoc} */
    @Override
    public void setDataTargetWidget(final Widget widget) {
        anchor.setDataTargetWidget(widget);
    }

    /** {@inheritDoc} */
    @Override
    public void setDataTarget(final String dataTarget) {
        anchor.setDataTarget(dataTarget);
    }

    /** {@inheritDoc} */
    @Override
    public String getDataTarget() {
        return anchor.getDataTarget();
    }

    /** {@inheritDoc} */
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);

        // On enable/disable we need to add/remove the data toggle for it to work properly
        if (enabled) {
            setDataToggle(Toggle.TAB);
        } else {
            setDataToggle(null);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind JS Events
        bindJavaScriptEvents(anchor.getElement());
    }

    /** {@inheritDoc} */
    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind JS events
        unbindJavaScriptEvents(anchor.getElement());
    }

    public String getHTML() {
        return anchor.getHTML();
    }

    public void setHTML(final String html) {
        anchor.setHTML(html);
    }

    /**
     * Can be override by subclasses to handle Tabs's "show" event however
     * it's recommended to add an event handler to the tab.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        fireEvent(new TabShowEvent(this, evt));
    }

    /**
     * Can be override by subclasses to handle Tabs's "shown" event however
     * it's recommended to add an event handler to the tab.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.ShownEvent
     */
    protected void onShown(final Event evt) {
        fireEvent(new TabShownEvent(this, evt));
    }

    private void showTab(Element e) {
        JQuery.jQuery(e).tab("show");
    }

    // @formatter:off
    private void bindJavaScriptEvents(final Element e) {
        JQuery tab = JQuery.jQuery(e);

        tab.on("show.bs.tab", (evt) -> {
            onShow(evt);
        });

        tab.on("shown.bs.tab", (evt) -> {
            onShown(evt);
        });
    }

    private void unbindJavaScriptEvents(final Element e) {
        JQuery.jQuery(e).off("show.bs.tab");
        JQuery.jQuery(e).off("shown.bs.tab");
    }
    
}
