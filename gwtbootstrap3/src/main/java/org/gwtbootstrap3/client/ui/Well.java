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

import com.google.gwt.safehtml.shared.SafeHtml;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.WellSize;

/**
 * Well, well Mr. Anderson...
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class Well extends HTMLPanel implements HasSize<WellSize>, HasResponsiveness {

    public Well(final String html) {
        super(html);
        setStyleName(Styles.WELL);
    }

    public Well(final SafeHtml safeHtml) {
        this(safeHtml.asString());
    }

    @Override
    public void setSize(final WellSize size) {
        StyleHelper.addUniqueEnumStyleName(this, WellSize.class, size);
    }

    @Override
    public WellSize getSize() {
        return WellSize.fromStyleName(getStyleName());
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
