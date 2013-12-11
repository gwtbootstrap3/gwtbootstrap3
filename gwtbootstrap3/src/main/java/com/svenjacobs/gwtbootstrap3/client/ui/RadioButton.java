package com.svenjacobs.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 Sven Jacobs
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

import com.svenjacobs.gwtbootstrap3.client.ui.base.button.AbstractLabelButton;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Button representing a radio box.
 * <p/>
 * Used within a {@link com.svenjacobs.gwtbootstrap3.client.ui.ButtonGroup} that
 * has toggle set to {@code Toogle.BUTTONS}.
 * 
 * @author Sven Jacobs
 */
public class RadioButton extends AbstractLabelButton {

    public RadioButton() {
        super(TypeAttrType.RADIO);
    }

    public RadioButton(final String group, final String label) {
        this();
        setText(label);
    }

    public void setFormValue(final String value) {
        input.getElement().setAttribute("value", value);
    }

    public String getFormValue() {
        return input.getElement().getAttribute("value");
    }
}
