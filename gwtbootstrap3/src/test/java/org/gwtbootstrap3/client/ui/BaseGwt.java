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

import org.gwtbootstrap3.client.ui.base.HasActive;
import org.gwtbootstrap3.client.ui.base.HasFormValue;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.UIObject;

public abstract class BaseGwt extends GWTTestCase {

    /**
     * Specifies a module to use when running this test case. The returned
     * module must include the source for this class.
     *
     * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
     */
    @Override
    public String getModuleName() {
        return "org.gwtbootstrap3.GwtBootstrap3";
    }

    public <T extends UIObject & HasActive> void checkActive(T button) {
        final Element label = button.getElement();
        assertFalse(label.hasClassName(Styles.ACTIVE));
        button.setActive(true);
        assertTrue(label.hasClassName(Styles.ACTIVE));
        button.setActive(false);
        assertFalse(label.hasClassName(Styles.ACTIVE));
    }

    public <T extends UIObject & HasName> void checkName(T button) {
        final String name = "name";
        button.setName(name);
        assertEquals(name, button.getName());
    }

    public <T extends UIObject & HasFormValue> void checkFormValue(T button) {
        final String formValue = "formValue";
        button.setFormValue(formValue);
        assertEquals(formValue, button.getFormValue());
    }

    public <T extends UIObject & HasValue<Boolean>> void checkValue(T button) {
        button.setValue(true);
        assertTrue(button.getValue());
        button.setValue(false);
        assertFalse(button.getValue());
    }

    public <T extends UIObject & HasEnabled> void checkEnabled(T button) {
        final Element label = button.getElement();
        assertFalse(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
        button.setEnabled(false);
        assertTrue(label.hasClassName(Styles.DISABLED));
        assertTrue(label.hasAttribute(Styles.DISABLED));
        button.setEnabled(true);
        assertFalse(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
    }

}