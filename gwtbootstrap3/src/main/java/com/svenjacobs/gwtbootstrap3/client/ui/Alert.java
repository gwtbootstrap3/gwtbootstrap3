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

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.svenjacobs.gwtbootstrap3.client.shared.event.AlertCloseEvent;
import com.svenjacobs.gwtbootstrap3.client.shared.event.AlertClosedEvent;
import com.svenjacobs.gwtbootstrap3.client.ui.base.button.CloseButton;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.AlertType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonDismiss;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Alert block.
 * <p/>
 * Use {@link #setDismissable(boolean)} to add a close ("x") button.
 *
 * @author Sven Jacobs
 * @see AlertCloseEvent
 * @see AlertClosedEvent
 */
public class Alert extends HTMLPanel implements HasType<AlertType> {

    private final CloseButton closeButton = new CloseButton();

    public Alert(final String html) {
        super(html);

        setStyleName(Styles.ALERT);
        setType(AlertType.WARNING);

        closeButton.setDismiss(ButtonDismiss.ALERT);

        bindJavaScriptEvents(getElement());
    }

    public Alert(final String html,
                 final AlertType type) {

        this(html);
        setType(type);
    }

    public Alert(final SafeHtml safeHtml) {
        this(safeHtml.asString());
    }

    public Alert(final SafeHtml safeHtml,
                 final AlertType type) {

        this(safeHtml.asString(), type);
    }

    /**
     * Sets alert type.
     *
     * @param type Alert type
     * @see AlertType
     */
    @Override
    public void setType(final AlertType type) {
        StyleHelper.addUniqueEnumStyleName(this, AlertType.class, type);
    }

    @Override
    public AlertType getType() {
        return AlertType.fromStyleName(getStyleName());
    }

    /**
     * Adds a close button to the alert
     *
     * @param dismissable Adds close button when {@code true}
     */
    public void setDismissable(final boolean dismissable) {
        if (dismissable) {
            insert(closeButton, getElement(), 0, true);
            addStyleName(Styles.ALERT_DISMISSABLE);
        } else {
            closeButton.removeFromParent();
            removeStyleName(Styles.ALERT_DISMISSABLE);
        }
    }

    public boolean isDismissable() {
        return closeButton.getParent() != null;
    }

    /**
     * Closes alert.
     */
    public void close() {
        alert(getElement(), "close");
    }

    protected void onClose(final Event evt) {
        fireEvent(new AlertCloseEvent(evt));
    }

    protected void onClosed(final Event evt) {
        fireEvent(new AlertClosedEvent(evt));
    }

    private native void alert(final Element e,
                              final String arg) /*-{
        $wnd.jQuery(e).alert(arg);
    }-*/;

    private native void bindJavaScriptEvents(final Element e) /*-{
        var target = this;
        var $modal = $wnd.jQuery(e);

        $modal.on('close.bs.alert', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Alert::onClose(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $modal.on('closed.bs.alert', function (evt) {
            target.@com.svenjacobs.gwtbootstrap3.client.ui.Alert::onClosed(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;
}
