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
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasValue;
import org.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * An {@link InputButton} that can have a "checked" state.
 * Usually makes only sense for input types "checkbox" and "radio".
 *
 * @author Sven Jacobs
 */
public class CheckableInputButton extends InputButton implements HasValue<Boolean> {

    public CheckableInputButton(final TypeAttrType type) {
        super(type);
        bindJavaScriptEvents(getElement());
    }

    @Override
    public Boolean getValue() {
        return InputElement.as(getElement()).isChecked();
    }

    @Override
    public void setValue(final Boolean value) {
        setValue(value, false);
    }

    @Override
    public void setValue(final Boolean value, final boolean fireEvents) {
        InputElement.as(getElement()).setChecked(value);
        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    private void onChange(final Event evt) {
        ValueChangeEvent.fire(this, getValue());
    }

    private native void bindJavaScriptEvents(final Element e) /*-{
        var target = this;
        var $e = $wnd.jQuery(e);

        $e.on('change', function (evt) {
            target.@org.gwtbootstrap3.client.ui.CheckableInputButton::onChange(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;
}
