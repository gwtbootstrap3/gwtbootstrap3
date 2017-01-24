package org.gwtbootstrap3.client.ui.base;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Focusable;

/**
 * Base class for list items that contain an {@link org.gwtbootstrap3.client.ui.Anchor} link.
 *
 * @author Sven Jacobs
 * @author Drew Spencer
 * @author Steven Jardine
 */
public abstract class AbstractAnchorListItem extends AbstractListItem
        implements HasHref, HasTargetHistoryToken, HasClickHandlers, Focusable, HasDataToggle, HasIcon, HasIconPosition, HasBadge {

    protected final Anchor anchor;

    /**
     * Constructor.
     */
    protected AbstractAnchorListItem() {
        anchor = new Anchor();
        anchor.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                delegateEvent(AbstractAnchorListItem.this, event);
            }
        });
        add(anchor, (Element) getElement());
    }

    /** {@inheritDoc} */
    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return anchor.addHandler(handler, ClickEvent.getType());
    }

    /** {@inheritDoc} */
    @Override
    public BadgePosition getBadgePosition() {
        return anchor.getBadgePosition();
    }

    /** {@inheritDoc} */
    @Override
    public String getBadgeText() {
        return anchor.getBadgeText();
    }

    /** {@inheritDoc} */
    @Override
    public Toggle getDataToggle() {
        return anchor.getDataToggle();
    }

    /** {@inheritDoc} */
    @Override
    public String getHref() {
        return anchor.getHref();
    }

    /** {@inheritDoc} */
    @Override
    public IconType getIcon() {
        return anchor.getIcon();
    }

    /** {@inheritDoc} */
    @Override
    public IconFlip getIconFlip() {
        return anchor.getIconFlip();
    }

    /** {@inheritDoc} */
    @Override
    public IconPosition getIconPosition() {
        return anchor.getIconPosition();
    }

    /** {@inheritDoc} */
    @Override
    public IconRotate getIconRotate() {
        return anchor.getIconRotate();
    }

    /** {@inheritDoc} */
    @Override
    public IconSize getIconSize() {
        return anchor.getIconSize();
    }

    /** {@inheritDoc} */
    @Override
    public int getTabIndex() {
        return anchor.getTabIndex();
    }

    /** {@inheritDoc} */
    @Override
    public String getTargetHistoryToken() {
        return anchor.getTargetHistoryToken();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIconBordered() {
        return anchor.isIconBordered();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIconFixedWidth() {
        return anchor.isIconFixedWidth();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIconInverse() {
        return anchor.isIconInverse();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIconPulse() {
        return anchor.isIconPulse();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIconSpin() {
        return anchor.isIconSpin();
    }

    /** {@inheritDoc} */
    @Override
    public void setAccessKey(final char key) {
        anchor.setAccessKey(key);
    }

    /** {@inheritDoc} */
    @Override
    public void setBadgePosition(BadgePosition badgePosition) {
        anchor.setBadgePosition(badgePosition);
    }

    /** {@inheritDoc} */
    @Override
    public void setBadgeText(String badgeText) {
        anchor.setBadgeText(badgeText);
    }

    /** {@inheritDoc} */
    @Override
    public void setDataToggle(final Toggle toggle) {
        anchor.setDataToggle(toggle);
    }

    /** {@inheritDoc} */
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        anchor.setEnabled(enabled);
    }

    /** {@inheritDoc} */
    @Override
    public void setFocus(final boolean focused) {
        anchor.setFocus(focused);
    }

    /** {@inheritDoc} */
    @Override
    public void setHref(final String href) {
        anchor.setHref(href);
    }

    /** {@inheritDoc} */
    @Override
    public void setIcon(final IconType iconType) {
        anchor.setIcon(iconType);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconBordered(final boolean iconBordered) {
        anchor.setIconBordered(iconBordered);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconFixedWidth(final boolean iconFixedWidth) {
        anchor.setIconFixedWidth(iconFixedWidth);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        anchor.setIconFlip(iconFlip);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconInverse(final boolean iconInverse) {
        anchor.setIconInverse(iconInverse);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        anchor.setIconPosition(iconPosition);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconPulse(boolean iconPulse) {
        anchor.setIconPulse(iconPulse);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        anchor.setIconRotate(iconRotate);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconSize(final IconSize iconSize) {
        anchor.setIconSize(iconSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setIconSpin(final boolean iconSpin) {
        anchor.setIconSpin(iconSpin);
    }

    /** {@inheritDoc} */
    @Override
    public void setTabIndex(final int index) {
        anchor.setTabIndex(index);
    }

    /** {@inheritDoc} */
    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        anchor.setTargetHistoryToken(targetHistoryToken);
    }
    
    /** {@inheritDoc} */
    @Override
    public void setIconColor(String iconColor) {
    	anchor.setIconColor(iconColor);
    }

}
