package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Alignment;

/**
 * Container with the h(1-6) tag so that you can do layouts like:
 * <p/>
 * <HeadingPanel>
 * <Icon/>
 * <Text/>
 * </HeadingPanel>
 * <p/>
 * Please note, this doesn't enforce any requirements on the children. It is up to
 * you to make sure you produce valid HTML code.
 *
 * @author Joshua Godi
 */
public class HeadingPanel extends ComplexWidget implements HasResponsiveness, HasAlignment {

    @UiConstructor
    public HeadingPanel(final int size) {
        setElement(DOM.createElement("h" + size));
        assert size > 0 && size < 7 : "Wrong heading size (must be between 1 and 6)";
    }

    @Override
    public void setAlignment(final Alignment alignment) {
        StyleHelper.addUniqueEnumStyleName(this, Alignment.class, alignment);
    }

    @Override
    public Alignment getAlignment() {
        return Alignment.fromStyleName(getStyleName());
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
