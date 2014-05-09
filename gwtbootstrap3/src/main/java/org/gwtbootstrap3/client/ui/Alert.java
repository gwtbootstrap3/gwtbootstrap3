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
import com.google.gwt.user.client.Event;
import com.google.web.bindery.event.shared.HandlerRegistration;
import org.gwtbootstrap3.client.shared.event.AlertCloseEvent;
import org.gwtbootstrap3.client.shared.event.AlertCloseHandler;
import org.gwtbootstrap3.client.shared.event.AlertClosedEvent;
import org.gwtbootstrap3.client.shared.event.AlertClosedHandler;
import org.gwtbootstrap3.client.ui.base.button.CloseButton;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.gwtbootstrap3.client.ui.constants.ButtonDismiss;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Text;

/**
 * Alert block.
 * <p/>
 * Use {@link #setDismissable(boolean)} to add a close ("x") button.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.shared.event.AlertCloseEvent
 * @see org.gwtbootstrap3.client.shared.event.AlertClosedEvent
 */
public class Alert extends Div implements HasType<AlertType>, HasResponsiveness {
    private static final String CLOSE = "close";

    private final Text text = new Text();
    private final CloseButton closeButton = new CloseButton();

    /**
     * Builds a default alert
     */
    public Alert() {
        setStyleName(Styles.ALERT);
        setType(AlertType.WARNING);
        closeButton.setDataDismiss(ButtonDismiss.ALERT);
    }

    /**
     * Builds a default alert with the desired text
     *
     * @param text text for the alert
     */
    public Alert(final String text) {
        this();
        setText(text);
    }

    /**
     * Builds an alert with the desired text and type
     *
     * @param text text for the alert
     * @param type type for the alert
     */
    public Alert(final String text, final AlertType type) {
        this(text);
        setType(type);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind the events
        bindJavaScriptEvents(getElement());
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Unbind the events
        unbindJavaScriptEvents(getElement());
    }

    /**
     * Returns the text of the alert.
     *
     * @return text of the alert
     */
    public String getText() {
        return text.getText();
    }

    /**
     * Sets the text for the alert
     *
     * @param text the text of the alert
     */
    public void setText(final String text) {
        this.text.setText(text);
        insert(this.text, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(final AlertType type) {
        StyleHelper.addUniqueEnumStyleName(this, AlertType.class, type);
    }

    /**
     * {@inheritDoc}
     */
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
            insert(closeButton, (Element) getElement(), 0, true);
            addStyleName(Styles.ALERT_DISMISSABLE);
        } else {
            closeButton.removeFromParent();
            removeStyleName(Styles.ALERT_DISMISSABLE);
        }
    }

    /**
     * Returns if the alert can be closed or not
     *
     * @return true = alert can be closed, false = alert cannot be closed
     */
    public boolean isDismissable() {
        return closeButton.getParent() != null;
    }

    /**
     * Closes alert.
     */
    public void close() {
        alert(getElement(), CLOSE);
    }

    /**
     * Event fired when the close is initiated on the alert
     *
     * @param evt event
     */
    protected void onClose(final Event evt) {
        fireEvent(new AlertCloseEvent(evt));
    }

    /**
     * Event fired when the alert is fully closed
     *
     * @param evt event
     */
    protected void onClosed(final Event evt) {
        fireEvent(new AlertClosedEvent(evt));
    }

    /**
     * Add a handler to be used when the close event is fired
     *
     * @param handler handler for event
     * @return handler registration for the handler
     */
    public HandlerRegistration addCloseHandler(final AlertCloseHandler handler) {
        return addHandler(handler, AlertCloseEvent.getType());
    }

    /**
     * Add a handler to be used when the closed event is fired
     *
     * @param handler handler for event
     * @return handler registration for the handler
     */
    public HandlerRegistration addClosedHandler(final AlertClosedHandler handler) {
        return addHandler(handler, AlertClosedEvent.getType());
    }

    // @formatter:off
    private native void alert(final Element e, final String arg) /*-{
        $wnd.jQuery(e).alert(arg);
    }-*/;

    private native void bindJavaScriptEvents(final Element e) /*-{
        var target = this;
        var $alert = $wnd.jQuery(e);

        $alert.on('close.bs.alert', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Alert::onClose(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $alert.on('closed.bs.alert', function (evt) {
            target.@org.gwtbootstrap3.client.ui.Alert::onClosed(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;

    private native void unbindJavaScriptEvents(final Element e) /*-{
        $wnd.jQuery(e).off('close.bs.alert');
        $wnd.jQuery(e).off('closed.bs.alert');
    }-*/;
}
