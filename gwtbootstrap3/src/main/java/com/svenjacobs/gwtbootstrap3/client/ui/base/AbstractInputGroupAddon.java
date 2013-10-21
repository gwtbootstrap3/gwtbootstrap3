package com.svenjacobs.gwtbootstrap3.client.ui.base;

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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.svenjacobs.gwtbootstrap3.client.ui.HasResponsiveness;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;

/**
 * Base class for {@link com.svenjacobs.gwtbootstrap3.client.ui.InputGroupAddon} and
 * {@link com.svenjacobs.gwtbootstrap3.client.ui.InputGroupButton}
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see com.svenjacobs.gwtbootstrap3.client.ui.InputGroupAddon
 * @see com.svenjacobs.gwtbootstrap3.client.ui.InputGroupButton
 */
public abstract class AbstractInputGroupAddon extends ComplexPanel implements HasResponsiveness {

    protected AbstractInputGroupAddon(final String styleName) {
        setElement(DOM.createSpan());
        setStyleName(styleName);
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }
}
