package org.gwtbootstrap3.client.ui;

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
import org.gwtbootstrap3.client.ui.base.AbstractInputGroupAddon;
import org.gwtbootstrap3.client.ui.base.mixin.IconTextMixin;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

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
public class InputGroupAddon extends AbstractInputGroupAddon implements HasText, HasIcon, HasIconPosition, HasIconSize {

    IconTextMixin<InputGroupAddon> iconTextMixin = new IconTextMixin<InputGroupAddon>(this);

    public InputGroupAddon() {
        super(Styles.INPUT_GROUP_ADDON);

        iconTextMixin.addTextWidgetToParent();
    }

    @Override
    public void setText(final String text) {
        iconTextMixin.setText(text);
    }

    @Override
    public String getText() {
        return iconTextMixin.getText();
    }

    @Override
    public void setIcon(final IconType iconType) {
        iconTextMixin.setIcon(iconType);
    }

    @Override
    public IconType getIcon() {
        return iconTextMixin.getIcon();
    }

    @Override
    public void setIconPosition(IconPosition iconPosition) {
        iconTextMixin.setIconPosition(iconPosition);
    }

    @Override
    public IconPosition getIconPosition() {
        return iconTextMixin.getIconPosition();
    }

    @Override
    public void setIconSize(IconSize iconSize) {
        iconTextMixin.setIconSize(iconSize);
    }

    @Override
    public IconSize getIconSize() {
        return iconTextMixin.getIconSize();
    }
}
