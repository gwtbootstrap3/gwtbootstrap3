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
import com.svenjacobs.gwtbootstrap3.client.ui.HasSpy;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Attributes;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Spy;

/**
 * @author Sven Jacobs
 */
public class SpyMixin<T extends UIObject & HasSpy> extends AbstractMixin implements HasSpy {

    public SpyMixin(final T uiObject) {
        super(uiObject);
    }

    @Override
    public void setSpy(final Spy spy) {
        if (spy != null) {
            uiObject.getElement().setAttribute(Attributes.DATA_SPY, spy.getSpy());
        } else {
            uiObject.getElement().removeAttribute(Attributes.DATA_SPY);
        }
    }

    @Override
    public Spy getSpy() {
        final String spy = uiObject.getElement().getAttribute(Attributes.DATA_SPY);
        return spy != null ? Spy.valueOf(spy) : null;
    }
}
