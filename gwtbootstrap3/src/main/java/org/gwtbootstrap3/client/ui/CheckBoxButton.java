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

import org.gwtbootstrap3.client.ui.base.button.AbstractLabelButton;
import org.gwtbootstrap3.client.ui.constants.TypeAttrType;

/**
 * Button representing a checkbox used within a {@link ButtonGroup} that has toggle set to {@code Toogle.BUTTONS}.
 *
 * If you are looking for a classic checkbox see {@link CheckBox}.
 *
 * @author Sven Jacobs
 */
public class CheckBoxButton extends AbstractLabelButton {

    public CheckBoxButton() {
        super(TypeAttrType.CHECKBOX);
    }

    public CheckBoxButton(final String label) {
        super(TypeAttrType.CHECKBOX, label);
    }
}
