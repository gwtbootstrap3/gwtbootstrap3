package org.gwtbootstrap3.client.ui.base.button;

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

import com.google.gwt.user.client.ui.HasText;
import org.gwtbootstrap3.client.ui.HasIcon;
import org.gwtbootstrap3.client.ui.HasIconPosition;
import org.gwtbootstrap3.client.ui.HasIconSize;
import org.gwtbootstrap3.client.ui.base.mixin.IconTextMixin;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;

/**
 * Base class for buttons that can contain an icon.
 *
 * @author Sven Jacobs
 * @see org.gwtbootstrap3.client.ui.Icon
 */
public abstract class AbstractIconButton extends AbstractButton implements HasText, HasIcon, HasIconPosition, HasIconSize {

    IconTextMixin<AbstractIconButton> iconTextMixin = new IconTextMixin<AbstractIconButton>(this);

    protected AbstractIconButton() {
    }

    protected AbstractIconButton(final ButtonType type) {
        super(type);
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
    public void setIconPosition(final IconPosition iconPosition) {
        iconTextMixin.setIconPosition(iconPosition);
    }

    @Override
    public IconPosition getIconPosition() {
        return iconTextMixin.getIconPosition();
    }

    @Override
    public void setIconSize(final IconSize iconSize) {
        iconTextMixin.setIconSize(iconSize);
    }

    @Override
    public IconSize getIconSize() {
        return iconTextMixin.getIconSize();
    }
}
