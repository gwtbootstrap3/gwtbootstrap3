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

import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Element;

/**
 * @author Joshua Godi
 */
public class Input extends ComplexWidget implements HasInputType, HasPlaceholder, HasFormValue {

    public Input() {
        setElement(Document.get().createElement("input"));
        addStyleName(Styles.FORM_CONTROL);
    }

    @UiConstructor
    public Input(final InputType type) {
        this();
        setType(type);
    }

    public void setMin(final String min) {
        getElement().setAttribute("min", min);
    }

    public void setMax(final String max) {
        getElement().setAttribute("max", max);
    }

    @Override
    public void setType(final InputType inputType) {
        getElement().setAttribute(TYPE, inputType.getType());
    }

    @Override
    public InputType getType() {
        if (getElement().getAttribute(TYPE) == null || getElement().getAttribute(TYPE).isEmpty()) {
            return null;
        }
        return InputType.valueOf(getElement().getAttribute(TYPE));
    }

    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

	private final native String getJSNIValue(Element elem) /*-{
		return elem.value;
	}-*/;

	@Override
	public String getFormValue() {
		return getJSNIValue(getElement());
	}

	private final native void setJSNIValue(Element elem, String value) /*-{
		elem.value = value;
	}-*/;

	@Override
	public void setFormValue(String value) {
		setJSNIValue(getElement(),value);
	}
}
