package com.svenjacobs.gwtbootstrap3.client.ui.base.mixin;

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

import com.google.gwt.user.client.ui.UIObject;
import com.svenjacobs.gwtbootstrap3.client.ui.HasToggle;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * @author Sven Jacobs
 */
public class ToggleMixin<T extends UIObject & HasToggle> extends AbstractMixin implements HasToggle {

    public ToggleMixin(final T uiObject) {
        super(uiObject);
    }

    @Override
    public void setToggle(final Toggle toggle) {
        if (toggle != null) {
            uiObject.getElement().setAttribute(Attributes.DATA_TOGGLE, toggle.getToggle());
        } else {
            uiObject.getElement().removeAttribute(Attributes.DATA_TOGGLE);
        }
    }

    @Override
    public Toggle getToggle() {
        final String toggle = uiObject.getElement().getAttribute(Attributes.DATA_TOGGLE);
        return toggle != null ? Toggle.valueOf(toggle) : null;
    }
}
