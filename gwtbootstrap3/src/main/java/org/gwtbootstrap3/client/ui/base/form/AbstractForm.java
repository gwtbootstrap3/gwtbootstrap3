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
    
    /**
     * Used with {@link #setEncoding(String)} to specify that the form will be
     * submitted using MIME encoding (necessary for file upload to work
     * properly).
     */
    public static final String ENCODING_MULTIPART = "multipart/form-data";

    /**
     * Used with {@link #setEncoding(String)} to specify that the form will be
     * submitted using traditional URL encoding.
     */
    public static final String ENCODING_URLENCODED = "application/x-www-form-urlencoded";

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
     * Gets the encoding used for submitting this form. This should be either
     * {@link #ENCODING_MULTIPART} or {@link #ENCODING_URLENCODED}.
     *
     * @return the form's encoding
     */
    public String getEncoding() {
        return getEncoding(getFormElement());
    }
    
    /**
     * Sets the encoding used for submitting this form. This should be either
     * {@link #ENCODING_MULTIPART} or {@link #ENCODING_URLENCODED}.
     *
     * @param encodingType the form's encoding
     */
    public void setEncoding(String encodingType) {
        setEncoding(getFormElement(), encodingType);
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
    
    private native String getEncoding(Element form) /*-{
        // We can always get 'enctype', no matter which browser, because we set
        // both 'encoding' and 'enctype' in setEncoding().
        return form.enctype;
    }-*/;
    
    private native void setEncoding(Element form, String encoding) /*-{
        // To be safe, setting both.
        form.enctype = encoding;
        form.encoding = encoding;
    }-*/;
}
