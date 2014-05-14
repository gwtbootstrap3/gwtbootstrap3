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

import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.WellSize;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * Widget representing the Bootstrap Well
 * <p/>
 * <a href="http://getbootstrap.com/components/#wells">Bootstrap Documentation</a>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Well>
 *    ...
 * </b:Well>
 * }
 * </pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class Well extends Div implements HasSize<WellSize> {

    /**
     * Creates a Well with the default Bootstrap styling
     */
    public Well() {
        setStyleName(Styles.WELL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSize(final WellSize size) {
        StyleHelper.addUniqueEnumStyleName(this, WellSize.class, size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WellSize getSize() {
        return WellSize.fromStyleName(getStyleName());
    }
}
