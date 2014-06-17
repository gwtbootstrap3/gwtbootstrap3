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

import org.gwtbootstrap3.client.ui.base.HasContextualBackground;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.ContextualBackground;

import com.google.gwt.user.client.ui.UIObject;

/**
 * @author David Buhler
 */
public class ContextualBackgroundMixin<T extends UIObject & HasContextualBackground> extends AbstractMixin implements HasContextualBackground {

    public ContextualBackgroundMixin(final T uiObject) {
        super(uiObject);
    }

    @Override
    public void setContextualBackground(final ContextualBackground contextualBackground) {
        StyleHelper.addUniqueEnumStyleName(uiObject, ContextualBackground.class, contextualBackground);
    }

    @Override
    public ContextualBackground getContextualBackground() {
        return ContextualBackground.fromStyleName(uiObject.getStyleName());
    }
}
