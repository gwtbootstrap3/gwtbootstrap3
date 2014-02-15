package org.gwtbootstrap3.client.ui.base.mixin;

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

import com.google.gwt.user.client.ui.UIObject;
import org.gwtbootstrap3.client.ui.HasEnabled;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class EnabledMixin<T extends UIObject & HasEnabled> extends AbstractMixin implements HasEnabled {

    public EnabledMixin(final T uiObject) {
        super(uiObject);
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (enabled) {
            uiObject.removeStyleName(Styles.DISABLED);
            uiObject.getElement().removeAttribute(DISABLED);
        } else {
            uiObject.addStyleName(Styles.DISABLED);
            uiObject.getElement().setAttribute(DISABLED, "");
        }
    }

    @Override
    public boolean isEnabled() {
        return !uiObject.getElement().hasAttribute(DISABLED);
    }
}
