package org.gwtbootstrap3.client.ui.base.mixin;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2016 GwtBootstrap3
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

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.HasText;

import org.gwtbootstrap3.client.ui.Badge;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.HasBadge;
import org.gwtbootstrap3.client.ui.base.HasIcon;
import org.gwtbootstrap3.client.ui.base.HasIconPosition;
import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.html.Text;

/**
 * Mixin for Widgets that have text, an optional icon, and an optional badge
 *
 * @author Sven Jacobs
 * @author Drew Spencer
 */
public class IconTextMixin<T extends ComplexWidget & HasText & HasIcon & HasIconPosition & HasBadge> implements
        HasText, HasIcon, HasIconPosition, HasBadge {

    private final T widget;
    private final Text text = new Text();
    private final Text separator = new Text(" ");
    private final Text badgeSeparator = new Text(" ");
    private Icon icon;
    private IconType iconType;
    private IconPosition iconPosition = IconPosition.LEFT;
    private IconSize iconSize = IconSize.NONE;
    private IconFlip iconFlip = IconFlip.NONE;
    private IconRotate iconRotate = IconRotate.NONE;
    private boolean iconInverse = false;
    private boolean iconSpin = false;
    private boolean iconPulse = false;
    private boolean iconBordered = false;
    private boolean iconFixedWidth = false;
    private Badge badge = new Badge();
    private BadgePosition badgePosition = BadgePosition.RIGHT;
    private String iconColor;

    public IconTextMixin(final T widget) {
        this.widget = widget;
    }

    public void addTextWidgetToParent() {
        widget.add(text);
    }

    @Override
    public void setText(final String text) {
        this.text.setText(text);
        render();
    }

    @Override
    public String getText() {
        return text.getText();
    }

    @Override
    public void setIcon(final IconType iconType) {
        this.iconType = iconType;
        render();
    }

    @Override
    public IconType getIcon() {
        return icon == null ? null : icon.getType();
    }

    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        this.iconPosition = iconPosition;
        render();
    }

    @Override
    public IconPosition getIconPosition() {
        return iconPosition;
    }

    @Override
    public void setIconSize(final IconSize iconSize) {
        this.iconSize = iconSize;
        render();
    }

    @Override
    public IconSize getIconSize() {
        return iconSize;
    }

    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        this.iconFlip = iconFlip;
        render();
    }

    @Override
    public IconFlip getIconFlip() {
        return iconFlip;
    }

    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        this.iconRotate = iconRotate;
        render();
    }

    @Override
    public IconRotate getIconRotate() {
        return iconRotate;
    }

    @Override
    public void setIconBordered(final boolean iconBordered) {
        this.iconBordered = iconBordered;
        render();
    }

    @Override
    public boolean isIconBordered() {
        return iconBordered;
    }

    @Override
    public void setIconInverse(final boolean iconInverse) {
        this.iconInverse = iconInverse;
        render();
    }

    @Override
    public boolean isIconInverse() {
        return iconInverse;
    }

    @Override
    public void setIconSpin(final boolean iconSpin) {
        this.iconSpin = iconSpin;
        render();
    }

    @Override
    public boolean isIconSpin() {
        return iconSpin;
    }

    @Override
    public void setIconPulse(boolean iconPulse) {
        this.iconPulse = iconPulse;
        render();
    }

    @Override
    public boolean isIconPulse() {
        return iconPulse;
    }

    @Override
    public void setIconFixedWidth(final boolean iconFixedWidth) {
        this.iconFixedWidth = iconFixedWidth;
        render();
    }

    @Override
    public boolean isIconFixedWidth() {
        return iconFixedWidth;
    }

    @Override
    public void setBadgeText(String badgeText) {
        badge.setText(badgeText);
        render();
    }

    @Override
    public String getBadgeText() {
        return badge.getText();
    }

    @Override
    public void setBadgePosition(final BadgePosition badgePosition) {
        this.badgePosition = badgePosition;
        render();
    }

    @Override
    public BadgePosition getBadgePosition() {
        return badgePosition;
    }

    private void render() {
        // We defer to make sure the elements are available to manipulate their positions
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {

                if (text.isAttached()) {
                    text.removeFromParent();
                }

                if (separator.isAttached()) {
                    separator.removeFromParent();
                }

                if (badgeSeparator.isAttached()) {
                    badgeSeparator.removeFromParent();
                }

                if (badge.isAttached()) {
                    badge.removeFromParent();
                }

                if (icon != null) {
                    icon.removeFromParent();
                    icon = null;
                }

                if (iconType != null) {
                    icon = new Icon();
                    icon.setType(iconType);
                    icon.setSize(iconSize);
                    icon.setFlip(iconFlip);
                    icon.setRotate(iconRotate);
                    icon.setSpin(iconSpin);
                    icon.setPulse(iconPulse);
                    icon.setBorder(iconBordered);
                    icon.setFixedWidth(iconFixedWidth);
                    icon.setInverse(iconInverse);
                    icon.setColor(iconColor);
                }

                // Since we are dealing with Icon/Text, we can insert them at the right position
                // Helps on widgets like ButtonDropDown, where it has a caret added
                int position = 0;

                if (badge.getText() != null && badge.getText().length() > 0 && badgePosition == BadgePosition.LEFT) {
                    widget.insert(badge, position++);
                    widget.insert(badgeSeparator, position++);
                }

                if (icon != null && iconPosition == IconPosition.LEFT) {
                    widget.insert(icon, position++);
                    widget.insert(separator, position++);
                }

                if (text.getText() != null && text.getText().length() > 0) {
                    widget.insert(text, position++);
                }

                if (icon != null && iconPosition == IconPosition.RIGHT) {
                    widget.insert(separator, position++);
                    widget.insert(icon, position++);
                }

                if (badge.getText() != null && badge.getText().length() > 0 && badgePosition == BadgePosition.RIGHT) {
                    widget.insert(badgeSeparator, position++);
                    widget.insert(badge, position++);
                }

                // hack to remove css spacing in Pills
                badge.setMarginLeft(0);
                badge.setMarginRight(0);

            }
        });
    }

	@Override
	public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
        render();
	}
}
