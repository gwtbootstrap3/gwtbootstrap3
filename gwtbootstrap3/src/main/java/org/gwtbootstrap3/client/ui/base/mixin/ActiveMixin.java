package org.gwtbootstrap3.client.ui.base.mixin;

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

import org.gwtbootstrap3.client.ui.base.HasActive;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Sven Jacobs
 */
public class ActiveMixin<T extends UIObject & HasActive> extends AbstractMixin implements HasActive {

    public ActiveMixin(final T uiObject) {
        super(uiObject);
    }

    @Override
    public void setActive(final boolean active) {
        if (active) {
            uiObject.addStyleName(Styles.ACTIVE);
        } else {
            uiObject.removeStyleName(Styles.ACTIVE);
        }
    }

    @Override
    public boolean isActive() {
        return StyleHelper.containsStyle(uiObject.getStyleName(), Styles.ACTIVE);
    }
}
