package org.gwtbootstrap3.client.ui;

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
import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Sven Jacobs
 */
public class FormLabel extends AbstractTextWidget {

    public FormLabel() {
        super(DOM.createLabel());
        setStyleName(Styles.CONTROL_LABEL);
    }

    public void setFor(final String f) {
        if (f != null) {
            getElement().setAttribute(Attributes.FOR, f);
        } else {
            getElement().removeAttribute(Attributes.FOR);
        }
    }
}
