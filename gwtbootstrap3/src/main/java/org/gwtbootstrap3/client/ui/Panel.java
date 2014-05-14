package org.gwtbootstrap3.client.ui;

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

import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.PanelType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * @author Joshua Godi
 */
public class Panel extends Div implements HasType<PanelType> {

    public Panel() {
        this(PanelType.DEFAULT);
    }

    public Panel(final PanelType type) {
        setStyleName(Styles.PANEL);
        setType(type);
    }

    @Override
    public void setType(final PanelType type) {
        StyleHelper.addUniqueEnumStyleName(this, PanelType.class, type);
    }

    @Override
    public PanelType getType() {
        return PanelType.fromStyleName(getStyleName());
    }
}
