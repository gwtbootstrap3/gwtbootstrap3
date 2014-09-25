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

public class CheckBoxButtonGwt extends InputToggleButtonGwt {

    public void testCheckBoxButton() {
        checkLayout(new CheckBoxButton());
        checkActive(new CheckBoxButton());
        checkName(new CheckBoxButton());
        checkFormValue(new CheckBoxButton());
        checkValue(new CheckBoxButton());
        checkEnabled(new CheckBoxButton());
        checkIsEditor(new CheckBoxButton());
    }

    public void testCheckBoxButtonLabel() {
        final String label = "label";
        final CheckBoxButton button = new CheckBoxButton(label);
        assertEquals(label, button.getText());
    }

}
