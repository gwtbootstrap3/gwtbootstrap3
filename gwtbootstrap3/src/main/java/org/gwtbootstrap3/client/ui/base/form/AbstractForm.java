package org.gwtbootstrap3.client.ui.base.form;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.FormElement;
import org.gwtbootstrap3.client.ui.constants.Attributes;

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

/**
 * @author Sven Jacobs
 */
public abstract class AbstractForm extends FormElementContainer {
    private static final String FORM = "form";

    public AbstractForm() {
        setElement(Document.get().createFormElement());
        getElement().setAttribute(Attributes.ROLE, FORM);
    }

    public String getAction() {
        return getFormElement().getAction();
    }

    public void setAction(final String action) {
        getFormElement().setAction(action);
    }

    public String getMethod() {
        return getFormElement().getMethod();
    }

    public void setMethod(final String method) {
        getFormElement().setMethod(method);
    }

    /**
     * Submits form
     */
    public void submit() {
        submit(getElement());
    }

    /**
     * Resets form
     */
    public void reset() {
        reset(getElement());
    }

    FormElement getFormElement() {
        return FormElement.as(getElement());
    }

    private native void submit(final Element e) /*-{
        e.submit();
    }-*/;

    private native void reset(final Element e) /*-{
        e.reset();
    }-*/;
}
