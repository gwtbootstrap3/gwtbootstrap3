package com.github.gwtbootstrap3.client.ui;

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

import com.github.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.github.gwtbootstrap3.client.ui.constants.Styles;
import com.google.gwt.dom.client.Document;

/**
 * A lightweight, flexible component to showcase key content.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class Jumbotron extends ComplexWidget implements HasResponsiveness {

    public Jumbotron() {
        setElement(Document.get().createDivElement());
        setStyleName(Styles.JUMBOTRON);
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }
}
