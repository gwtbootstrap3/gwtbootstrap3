package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.base.HasFormValue;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Pull;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A simple radio button widget, with no label.
 */
public class SimpleRadioButton extends com.google.gwt.user.client.ui.SimpleRadioButton implements HasResponsiveness,
        HasId, HasPull, HasFormValue {

    private Boolean oldValue;

    /**
     * Creates a SimpleRadioButton widget that wraps an existing &lt;input
     * type='radio'&gt; element.
     * 
     * This element must already be attached to the document. If the element is
     * removed from the document, you must call
     * {@link RootPanel#detachNow(Widget)}.
     * 
     * @param element
     *            the element to be wrapped
     */
    public static SimpleRadioButton wrap(Element element) {
        // Assert that the element is attached.
        assert Document.get().getBody().isOrHasChild(element);

        SimpleRadioButton radioButton = new SimpleRadioButton(InputElement.as(element));

        // Mark it attached and remember it for cleanup.
        radioButton.onAttach();
        RootPanel.detachOnWindowClose(radioButton);

        return radioButton;
    }

    private final IdMixin<SimpleRadioButton> idMixin = new IdMixin<SimpleRadioButton>(this);
    private final PullMixin<SimpleRadioButton> pullMixin = new PullMixin<SimpleRadioButton>(this);
    private final EnabledMixin<SimpleRadioButton> enabledMixin = new EnabledMixin<SimpleRadioButton>(this);

    /**
     * Creates a new radio associated with a particular group name. All radio
     * buttons associated with the same group name belong to a
     * mutually-exclusive set.
     * 
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     * 
     * @param name
     *            the group name with which to associate the radio button
     */
    @UiConstructor
    public SimpleRadioButton(String name) {
        this(Document.get().createRadioInputElement(name));
    }

    /**
     * This constructor may be used by subclasses to explicitly use an existing
     * element. This element must be an &lt;input&gt; element whose type is
     * 'radio'.
     * 
     * @param element
     *            the element to be used
     */
    protected SimpleRadioButton(InputElement element) {
        super(element);

        sinkEvents(Event.ONCLICK);
        sinkEvents(Event.ONMOUSEUP);
        sinkEvents(Event.ONBLUR);
        sinkEvents(Event.ONKEYDOWN);
    }

    @Override
    public void setEnabled(boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return idMixin.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

    /**
     * Overridden to send ValueChangeEvents only when appropriate.
     */
    @Override
    public void onBrowserEvent(Event event) {
        switch (DOM.eventGetType(event)) {
        case Event.ONMOUSEUP:
        case Event.ONBLUR:
        case Event.ONKEYDOWN:
            // Note the old value for onValueChange purposes (in ONCLICK case)
            oldValue = getValue();
            break;

        case Event.ONCLICK:
            // Let our handlers hear about the click...
            super.onBrowserEvent(event);
            // ...and now maybe tell them about the change
            ValueChangeEvent.fireIfNotEqual(SimpleRadioButton.this, oldValue, getValue());
            return;
        }

        super.onBrowserEvent(event);
    }

    /**
     * No-op. CheckBox's click handler is no good for radio button, so don't use
     * it. Our event handling is all done in {@link #onBrowserEvent}
     */
    @Override
    protected void ensureDomEventHandlers() {
    }

}
