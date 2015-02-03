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

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.shared.event.*;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * @author Grant Slender
 */
public class Collapse extends Div {
    private static final String TOGGLE = "toggle";
    private static final String SHOW = "show";
    private static final String HIDE = "hide";

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
        if(toggle) {
            addStyleName("in");
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
     * Causes the collapse to show or hide
     */
    public void toggle() {
        fireMethod(getElement(), TOGGLE);
    }

    /**
     * Causes the collapse to show
     */
    public void show() {
        fireMethod(getElement(), SHOW);
    }

    /**
     * Causes the collapse to hide
     */
    public void hide() {
        fireMethod(getElement(), HIDE);
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

    private native void bindJavaScriptEvents(final com.google.gwt.dom.client.Element e) /*-{
        var target = this;
        var $collapse = $wnd.jQuery(e);

        $collapse.on('show.bs.collapse', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Collapse::onShow(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $collapse.on('shown.bs.collapse', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Collapse::onShown(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $collapse.on('hide.bs.collapse', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Collapse::onHide(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $collapse.on('hidden.bs.collapse', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Collapse::onHidden(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;

    private native void unbindJavaScriptEvents(final com.google.gwt.dom.client.Element e) /*-{
        $wnd.jQuery(e).off('show.bs.collapse');
        $wnd.jQuery(e).off('shown.bs.collapse');
        $wnd.jQuery(e).off('hide.bs.collapse');
        $wnd.jQuery(e).off('hidden.bs.collapse');
    }-*/;

    private native void collapse(final com.google.gwt.dom.client.Element e, final boolean toggle) /*-{
        $wnd.jQuery(e).collapse({
            toggle: toggle
        });
    }-*/;

    private native void fireMethod(final com.google.gwt.dom.client.Element e, String method) /*-{
        $wnd.jQuery(e).collapse(method);
    }-*/;

    private native void fireMethod(final com.google.gwt.dom.client.Element e, int slideNumber) /*-{
        $wnd.jQuery(e).collapse(slideNumber);
    }-*/;
}
