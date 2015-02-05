package org.gwtbootstrap3.client.ui.base.button;

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

import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * Button that represents a close ("x") icon, usually used within an {@link org.gwtbootstrap3.client.ui.Alert}.
 *
 * @author Sven Jacobs
 * @see org.gwtbootstrap3.client.ui.Alert
 */
public class CloseButton extends AbstractButton {

    public CloseButton() {
        setStyleName(Styles.CLOSE);
        getElement().setInnerHTML("&times;");
    }

    @Override
    protected Element createElement() {
        return Document.get().createPushButtonElement().cast();
    }
}
