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
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Text;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.UIObject;

public class InputToggleButtonGwt extends BaseGwt {

    public void checkLayout(UIObject button) {
        final Element label = button.getElement();
        assertTrue(LabelElement.is(label));
        assertEquals(2, label.getChildCount());
        final Element input = label.getFirstChildElement();
        assertTrue(InputElement.is(input));
        final Node text = label.getLastChild();
        assertTrue(text instanceof Text);
    }

    public <T extends UIObject & IsEditor<LeafValueEditor<Boolean>>> void checkIsEditor(T object) {
        assertNotNull(object.asEditor());
    }

    @Override
    public <T extends UIObject & HasName> void checkName(T button) {
        final String name = "name";
        final Element label = button.getElement();
        final InputElement input = InputElement.as(label.getFirstChildElement());
        button.setName(name);
        assertEquals(name, button.getName());
        assertEquals(name, input.getName());
    }

    @Override
    public <T extends UIObject & HasFormValue> void checkFormValue(T button) {
        final String formValue = "formValue";
        final Element label = button.getElement();
        final InputElement input = InputElement.as(label.getFirstChildElement());
        button.setFormValue(formValue);
        assertEquals(formValue, button.getFormValue());
        assertEquals(formValue, input.getValue());
    }

    @Override
    public <T extends UIObject & HasValue<Boolean>> void checkValue(T button) {
        final Element label = button.getElement();
        final InputElement input = InputElement.as(label.getFirstChildElement());
        button.setValue(true);
        assertTrue(button.getValue());
        assertTrue(input.isChecked());
        button.setValue(false);
        assertFalse(button.getValue());
        assertFalse(input.isChecked());
    }

    @Override
    public <T extends UIObject & HasEnabled> void checkEnabled(T button) {
        final Element label = button.getElement();
        final InputElement input = InputElement.as(label.getFirstChildElement());
        assertFalse(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
        assertFalse(input.isDisabled());
        button.setEnabled(false);
        assertTrue(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
        assertTrue(input.isDisabled());
        button.setEnabled(true);
        assertFalse(label.hasClassName(Styles.DISABLED));
        assertFalse(label.hasAttribute(Styles.DISABLED));
        assertFalse(input.isDisabled());
    }

}
