package org.gwtbootstrap3.client.ui.base.mixin;

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
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Text;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.constants.*;

/**
 * Mixin for Widgets that have text and an optional icon.
 *
 * @author Sven Jacobs
 */
public class IconTextMixin<T extends ComplexWidget & HasText & HasIcon & HasIconPosition> implements
        HasText, HasIcon, HasIconPosition {

    private final T widget;
    private final Text text = new Text();
    private final Text separator = new Text(" ");
    private Icon icon;
    private IconPosition iconPosition = IconPosition.LEFT;
    private IconSize iconSize = IconSize.NONE;
    private IconFlip iconFlip = IconFlip.NONE;
    private IconRotate iconRotate = IconRotate.NONE;
    private boolean iconMuted = false;
    private boolean iconSpin = false;
    private boolean iconBordered = false;
    private boolean iconLight = false;

    public IconTextMixin(final T widget) {
        this.widget = widget;
    }

    public void addTextWidgetToParent() {
        widget.add(text);
    }

    @Override
    public void setText(final String text) {
        this.text.setText(text);
    }

    @Override
    public String getText() {
        return text.getText();
    }

    @Override
    public void setIcon(final IconType iconType) {
        render(new Icon(iconType));
    }

    @Override
    public IconType getIcon() {
        return icon == null ? null : icon.getType();
    }

    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        this.iconPosition = iconPosition;
        render(icon);
    }

    @Override
    public IconPosition getIconPosition() {
        return iconPosition;
    }

    @Override
    public void setIconSize(final IconSize iconSize) {
        this.iconSize = iconSize;
        render(icon);
    }

    @Override
    public IconSize getIconSize() {
        return iconSize;
    }

    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        this.iconFlip = iconFlip;
        render(icon);
    }

    @Override
    public IconFlip getIconFlip() {
        return iconFlip;
    }

    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        this.iconRotate = iconRotate;
        render(icon);
    }

    @Override
    public IconRotate getIconRotate() {
        return iconRotate;
    }

    @Override
    public void setIconBordered(final boolean iconBordered) {
        this.iconBordered = iconBordered;
        render(icon);
    }

    @Override
    public boolean isIconBordered() {
        return iconBordered;
    }

    @Override
    public void setIconMuted(final boolean iconMuted) {
        this.iconMuted = iconMuted;
        render(icon);
    }

    @Override
    public boolean isIconMuted() {
        return iconMuted;
    }

    @Override
    public void setIconLight(final boolean iconLight) {
        this.iconLight = iconLight;
        render(icon);
    }

    @Override
    public boolean isIconLight() {
        return iconLight;
    }

    @Override
    public void setIconSpin(final boolean iconSpin) {
        this.iconSpin = iconSpin;
        render(icon);
    }

    @Override
    public boolean isIconSpin() {
        return iconSpin;
    }

    private void render(final Icon newIcon) {
        text.removeFromParent();
        separator.removeFromParent();

        if (icon != null) {
            icon.removeFromParent();
        }

        icon = newIcon;
        icon.setSize(iconSize);
        icon.setFlip(iconFlip);
        icon.setRotate(iconRotate);
        icon.setMuted(iconMuted);
        icon.setSpin(iconSpin);
        icon.setBorder(iconBordered);
        icon.setLight(iconLight);

        if (iconPosition == IconPosition.LEFT) {
            widget.add(icon);
            widget.add(separator);
        }

        widget.add(text);

        if (iconPosition == IconPosition.RIGHT) {
            widget.add(separator);
            widget.add(icon);
        }
    }
}
