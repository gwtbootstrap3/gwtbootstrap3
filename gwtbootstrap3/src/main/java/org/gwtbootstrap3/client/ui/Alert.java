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

import org.gwtbootstrap3.client.shared.event.AlertCloseEvent;
import org.gwtbootstrap3.client.shared.event.AlertCloseHandler;
import org.gwtbootstrap3.client.shared.event.AlertClosedEvent;
import org.gwtbootstrap3.client.shared.event.AlertClosedHandler;
import org.gwtbootstrap3.client.shared.js.JQuery;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.button.CloseButton;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.gwtbootstrap3.client.ui.constants.ButtonDismiss;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.HandlerRegistration;

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
public class Alert extends Div implements HasWidgets, HasText, HasType<AlertType>, HasResponsiveness {
    private static final String CLOSE = "close";

    private final Text text = new Text();
    private final CloseButton closeButton = new CloseButton();

    private final HandlerRegistration closedHandlerReg;

    /**
     * Builds a default alert
     */
    public Alert() {
        setStyleName(Styles.ALERT);
        setType(AlertType.WARNING);
        closeButton.setDataDismiss(ButtonDismiss.ALERT);
        closedHandlerReg = addCloseHandler(new AlertCloseHandler() {
            @Override
            public void onClose(AlertCloseEvent evt) {
                // Do logical detach
                removeFromParent();
                closedHandlerReg.removeHandler();
            }
        });
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
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return text.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
     * Sets whether the Alert should fade out before it is removed
     *
     * @param fade The alert will fade on close before it is removed when {@code true}
     */
    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.FADE);
            addStyleName(Styles.IN);
        } else {
            removeStyleName(Styles.FADE);
            removeStyleName(Styles.IN);
        }
    }

    /**
     * Returns if the alert will fade out before it is removed
     *
     * @return true = alert will fade out, false = alert won't fade out
     */
    public boolean isFade() {
        return StyleHelper.containsStyle(getStyleName(), Styles.FADE);
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
     * Event fired when the alert is fully closed (will wait for CSS transitions)
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
    private void alert(final Element e, final String arg) {
        JQuery.jQuery(e).alert(arg);
    }

    private void bindJavaScriptEvents(final Element e) {
        JQuery alert = JQuery.jQuery(e);

        alert.on("close.bs.alert", (evt) -> {
            onClose(evt);
        });

        alert.on("closed.bs.alert", (evt) -> {
            onClosed(evt);
        });
    }

    private void unbindJavaScriptEvents(final Element e) {
        JQuery.jQuery(e).off("close.bs.alert");
        JQuery.jQuery(e).off("closed.bs.alert");
    }
}
