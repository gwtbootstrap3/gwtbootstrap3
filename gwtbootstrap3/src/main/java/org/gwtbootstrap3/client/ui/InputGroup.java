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
import org.gwtbootstrap3.client.ui.constants.InputGroupSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

/**
 * Input group parent element of {@link InputGroupAddon}.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 * @see InputGroupAddon
 */
public class InputGroup extends FlowPanel implements HasSize<InputGroupSize> {

    public InputGroup() {
        setStyleName(Styles.INPUT_GROUP);
    }

    @Override
    public void setSize(InputGroupSize size) {
        StyleHelper.addUniqueEnumStyleName(this, InputGroupSize.class, size);
    }

    @Override
    public InputGroupSize getSize() {
        return InputGroupSize.fromStyleName(getStyleName());
    }

}
