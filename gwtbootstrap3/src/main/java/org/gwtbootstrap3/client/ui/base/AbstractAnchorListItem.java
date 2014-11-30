package org.gwtbootstrap3.client.ui.base;

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

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Focusable;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.constants.*;

/**
 * Base class for list items that contain an {@link org.gwtbootstrap3.client.ui.Anchor} link.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractAnchorListItem extends AbstractListItem
        implements HasHref, HasTargetHistoryToken, HasClickHandlers, Focusable, HasDataToggle, HasIcon, HasIconPosition {

    protected final Anchor anchor;
    
    private HandlerRegistration handlerRegistration;

    protected AbstractAnchorListItem() {
        anchor = new Anchor();
        add(anchor, (Element) getElement());
    }

    @Override
    public void setHref(final String href) {
        anchor.setHref(href);
    }

    @Override
    public String getHref() {
        return anchor.getHref();
    }

    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        anchor.setTargetHistoryToken(targetHistoryToken);
    }

    @Override
    public String getTargetHistoryToken() {
        return anchor.getTargetHistoryToken();
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
    	
        return handlerRegistration = anchor.addClickHandler(handler);
    }

    @Override
    public int getTabIndex() {
        return anchor.getTabIndex();
    }

    @Override
    public void setAccessKey(final char key) {
        anchor.setAccessKey(key);
    }

    @Override
    public void setFocus(final boolean focused) {
        anchor.setFocus(focused);
    }

    @Override
    public void setTabIndex(final int index) {
        anchor.setTabIndex(index);
    }

    @Override
    public void setDataToggle(final Toggle toggle) {
        anchor.setDataToggle(toggle);
    }

    @Override
    public Toggle getDataToggle() {
        return anchor.getDataToggle();
    }


    @Override
    public void setIcon(final IconType iconType) {
        anchor.setIcon(iconType);
    }

    @Override
    public IconType getIcon() {
        return anchor.getIcon();
    }

    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        anchor.setIconPosition(iconPosition);
    }

    @Override
    public IconPosition getIconPosition() {
        return anchor.getIconPosition();
    }

    @Override
    public void setIconSize(final IconSize iconSize) {
        anchor.setIconSize(iconSize);
    }

    @Override
    public IconSize getIconSize() {
        return anchor.getIconSize();
    }

    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        anchor.setIconFlip(iconFlip);
    }

    @Override
    public IconFlip getIconFlip() {
        return anchor.getIconFlip();
    }

    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        anchor.setIconRotate(iconRotate);
    }

    @Override
    public IconRotate getIconRotate() {
        return anchor.getIconRotate();
    }

    @Override
    public void setIconBordered(final boolean iconBordered) {
        anchor.setIconBordered(iconBordered);
    }

    @Override
    public boolean isIconBordered() {
        return anchor.isIconBordered();
    }

    @Override
    public void setIconMuted(final boolean iconMuted) {
        anchor.setIconMuted(iconMuted);
    }

    @Override
    public boolean isIconMuted() {
        return anchor.isIconMuted();
    }

    @Override
    public void setIconLight(final boolean iconLight) {
        anchor.setIconLight(iconLight);
    }

    @Override
    public boolean isIconLight() {
        return anchor.isIconLight();
    }

    @Override
    public void setIconSpin(final boolean iconSpin) {
        anchor.setIconSpin(iconSpin);
    }

    @Override
    public boolean isIconSpin() {
        return anchor.isIconSpin();
    }

    @Override
    public void setIconFixedWidth(final boolean iconFixedWidth) {
        anchor.setIconFixedWidth(iconFixedWidth);
    }

    @Override
    public boolean isIconFixedWidth() {
        return anchor.isIconFixedWidth();
    }
    @Override
    public void setEnabled(boolean enabled){
    	super.setEnabled(enabled);
    	anchor.setEnabled(enabled);
    }
}
