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

import com.github.gwtbootstrap3.client.ui.base.AbstractButtonGroup;
import com.github.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Vertical button group
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 *     <b:VerticalButtonGroup>
 *         <b:Button>Button 1</b:Button>
 *         <b:Button>Button 2</b:Button>
 *         <b:Button>Button 3</b:Button>
 *     </b:VerticalButtonGroup>
 * }
 * </pre>
 *
 * @author Sven Jacobs
 * @see Button
 * @see ButtonGroup
 */
public class VerticalButtonGroup extends AbstractButtonGroup {

    public VerticalButtonGroup() {
        super(Styles.BTN_GROUP_VERTICAL);
    }
}
