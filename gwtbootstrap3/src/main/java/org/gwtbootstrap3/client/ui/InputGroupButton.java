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

import org.gwtbootstrap3.client.ui.base.AbstractInputGroupAddon;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Prepends or appends buttons to input fields.
 * <p/>
 * For prepending/appending text see {@link InputGroupAddon}.
 * Needs to be encapsulated in an {@link InputGroup}.
 * <p/>
 * <strong>Note:</strong> This is not a button itself! A {@link Button} needs to be added to this container.
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:InputGroup>
 *         <b:InputGroupButton>
 *             <b:Button>Prepend</b:Button>
 *         </b:InputGroupButton>
 *         <b:TextBox/>
 *         <b:InputGroupButton>
 *             <b:Button>Append</b:Button>
 *         </b:InputGroupButton>
 *     </b:InputGroup>
 * }</pre>
 * <p/>
 * Also see Bootstrap <a href="http://getbootstrap.com/components/#input-groups">documentation</a>.
 *
 * @author Sven Jacobs
 * @see InputGroupAddon
 */
public class InputGroupButton extends AbstractInputGroupAddon {

    public InputGroupButton() {
        super(Styles.INPUT_GROUP_BTN);
    }

    @Override
    public void add(final Widget child) {
        add(child, (Element) getElement());
    }
}
