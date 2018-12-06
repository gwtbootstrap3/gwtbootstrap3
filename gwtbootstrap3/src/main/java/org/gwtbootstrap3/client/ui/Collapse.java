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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;

import org.gwtbootstrap3.client.shared.event.HiddenEvent;
import org.gwtbootstrap3.client.shared.event.HiddenHandler;
import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.shared.event.ShownEvent;
import org.gwtbootstrap3.client.shared.event.ShownHandler;
import org.gwtbootstrap3.client.shared.js.JQuery;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.CollapseParam;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * @author Grant Slender
 */
public class Collapse extends Div {

    // Default shown
    private boolean toggle = true;

    public Collapse() {
        // Set the default styles
        setStyleName(Styles.COLLAPSE);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind jquery events
        bindJavaScriptEvents(getElement());

        // Configure the collapse
        if (toggle) {
            addStyleName(Styles.IN);
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind the events
        unbindJavaScriptEvents(getElement());
    }

    /**
     * Sets the default state to show or hide. Show is true.
     *
     * @param toggle toggle the collapse
     */
    public void setToggle(final boolean toggle) {
        this.toggle = toggle;
    }

    /**
     * Causes the collapse to show or hide without animation and events
     *
     * @param in show or hide the collapse
     */
    public void setIn(final boolean in) {
        if (in) {
            addStyleName(Styles.IN);
        } else {
            removeStyleName(Styles.IN);
        }
    }

    /**
     * Causes the collapse to show or hide
     */
    public void toggle() {
        fireMethod(getElement(), CollapseParam.TOGGLE);
    }

    /**
     * Causes the collapse to show
     */
    public void show() {
        fireMethod(getElement(), CollapseParam.SHOW);
    }

    /**
     * Causes the collapse to hide
     */
    public void hide() {
        fireMethod(getElement(), CollapseParam.HIDE);
    }

    public boolean isShown() {
        return StyleHelper.containsStyle(getStyleName(), Styles.IN);
    }

    public boolean isHidden() {
        return !isShown();
    }

    public boolean isCollapsing() {
        return StyleHelper.containsStyle(getStyleName(), Styles.COLLAPSING);
    }

    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return addHandler(shownHandler, ShownEvent.getType());
    }

    public HandlerRegistration addHideHandler(final HideHandler hideHandler) {
        return addHandler(hideHandler, HideEvent.getType());
    }

    public HandlerRegistration addHiddenHandler(final HiddenHandler hiddenHandler) {
        return addHandler(hiddenHandler, HiddenEvent.getType());
    }

    /**
     * Fired when the collapse is starting to show
     */
    private void onShow(final Event evt) {
        fireEvent(new ShowEvent(evt));
    }

    /**
     * Fired when the collapse has shown
     */
    private void onShown(final Event evt) {
        fireEvent(new ShownEvent(evt));
    }

    /**
     * Fired when the collapse is starting to hide
     */
    private void onHide(final Event evt) {
        fireEvent(new HideEvent(evt));
    }

    /**
     * Fired when the collapse has hidden
     */
    private void onHidden(final Event evt) {
        fireEvent(new HiddenEvent(evt));
    }

    private void bindJavaScriptEvents(final com.google.gwt.dom.client.Element e) {
        JQuery collapse = JQuery.jQuery(e);

        collapse.on("show.bs.collapse", (evt) -> {
            onShow(evt);
        });

        collapse.on("shown.bs.collapse", (evt) -> {
            onShown(evt);
        });

        collapse.on("hide.bs.collapse", (evt) -> {
            onHide(evt);
        });

        collapse.on("hidden.bs.collapse", (evt) -> {
            onHidden(evt);
        });
    }

    private void unbindJavaScriptEvents(final Element e) {
        JQuery.jQuery(e).off("show.bs.collapse");
        JQuery.jQuery(e).off("shown.bs.collapse");
        JQuery.jQuery(e).off("hide.bs.collapse");
        JQuery.jQuery(e).off("hidden.bs.collapse");
    }

    private void fireMethod(final Element e, String method) {
        JQuery.jQuery(e).collapse(method);
    }
}
