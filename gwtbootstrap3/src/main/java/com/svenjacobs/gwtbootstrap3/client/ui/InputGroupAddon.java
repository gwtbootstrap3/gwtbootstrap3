package com.svenjacobs.gwtbootstrap3.client.ui;

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

import com.google.gwt.user.client.ui.HasText;
import com.svenjacobs.gwtbootstrap3.client.ui.base.AbstractInputGroupAddon;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.IconType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Prepends or appends texts to input fields.
 * <p/>
 * For prepending/appending {@link Button} see {@link InputGroupButton}.
 * Needs to be encapsulated in an {@link InputGroup}.
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:InputGroup>
 *         <b:InputGroupAddon>Prepend something</b:InputGroupAddon>
 *         <b:TextBox/>
 *         <b:InputGroupAddon>Append something</b:InputGroupAddon>
 *     </b:InputGroup>
 * }</pre>
 * <p/>
 * Also see Bootstrap <a href="http://getbootstrap.com/components/#input-groups">documentation</a>.
 *
 * @author Sven Jacobs
 * @see InputGroup
 * @see InputGroupButton
 */
public class InputGroupAddon extends AbstractInputGroupAddon implements HasText, HasIcon {

    private Icon icon;
    
    public InputGroupAddon() {
        super(Styles.INPUT_GROUP_ADDON);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }

    @Override
    public void setText(final String text) {
        getElement().setInnerText(text);
    }
    
    @Override
    public IconType getIcon() {
        return icon == null ? null : icon.getType();
    }
    
    @Override
    public void setIcon(final IconType iconType) {
        this.add(icon = new Icon(iconType), this.getElement());
    }
}
