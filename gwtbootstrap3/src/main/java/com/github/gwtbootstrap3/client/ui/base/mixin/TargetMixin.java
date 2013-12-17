package com.github.gwtbootstrap3.client.ui.base.mixin;

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

import com.github.gwtbootstrap3.client.ui.HasTarget;
import com.github.gwtbootstrap3.client.ui.constants.Attributes;
import com.google.gwt.user.client.ui.UIObject;

/**
 * @author Sven Jacobs
 */
public class TargetMixin<T extends UIObject & HasTarget> extends AbstractMixin implements HasTarget {

    public TargetMixin(final T uiObject) {
        super(uiObject);
    }

    @Override
    public void setTarget(final String target) {
        if (target != null) {
            uiObject.getElement().setAttribute(Attributes.DATA_TARGET, target);
        } else {
            uiObject.getElement().removeAttribute(Attributes.DATA_TARGET);
        }
    }

    @Override
    public String getTarget() {
        return uiObject.getElement().getAttribute(Attributes.DATA_TARGET);
    }
}
