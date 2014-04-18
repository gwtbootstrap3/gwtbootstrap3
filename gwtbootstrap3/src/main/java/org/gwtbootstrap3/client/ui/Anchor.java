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

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasHTML;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.mixin.*;
import org.gwtbootstrap3.client.ui.constants.*;

/**
 * Anchor {@code <a>} element with text and optional icon.
 * 
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Grant Slender
 */
public class Anchor extends ComplexWidget implements HasClickHandlers, HasDoubleClickHandlers, HasHref, HasToggle, HasParent,
        HasTargetHistoryToken, HasHTML, HasIcon, HasIconPosition, Focusable, HasTarget {

    private final ToggleMixin<Anchor> toggleMixin = new ToggleMixin<Anchor>(this);
    private final ParentMixin<Anchor> parentMixin = new ParentMixin<Anchor>(this);
    private final IconTextMixin<Anchor> iconTextMixin = new IconTextMixin<Anchor>(this);
    private final TargetMixin<Anchor> targetMixin = new TargetMixin<Anchor>(this);
    private final FocusableMixin<Anchor> focusableMixin;
    private String targetHistoryToken;

    public Anchor(final String href) {
        setElement(Document.get().createAnchorElement());
        setHref(href);
        focusableMixin = new FocusableMixin<Anchor>(this);
        iconTextMixin.addTextWidgetToParent();
    }

    public Anchor(final String text, final String href) {
        this(href);
        setText(text);
    }

    public Anchor() {
        this(EMPTY_HREF);
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    @Override
    public HandlerRegistration addDoubleClickHandler(final DoubleClickHandler handler) {
        return addDomHandler(handler, DoubleClickEvent.getType());
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

    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        iconTextMixin.setIconFlip(iconFlip);
    }

    @Override
    public IconFlip getIconFlip() {
        return iconTextMixin.getIconFlip();
    }

    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        iconTextMixin.setIconRotate(iconRotate);
    }

    @Override
    public IconRotate getIconRotate() {
        return iconTextMixin.getIconRotate();
    }

    @Override
    public void setIconBordered(final boolean iconBordered) {
        iconTextMixin.setIconBordered(iconBordered);
    }

    @Override
    public boolean isIconBordered() {
        return iconTextMixin.isIconBordered();
    }

    @Override
    public void setIconMuted(final boolean iconMuted) {
        iconTextMixin.setIconMuted(iconMuted);
    }

    @Override
    public boolean isIconMuted() {
        return iconTextMixin.isIconMuted();
    }

    @Override
    public void setIconLight(final boolean iconLight) {
        iconTextMixin.setIconLight(iconLight);
    }

    @Override
    public boolean isIconLight() {
        return iconTextMixin.isIconLight();
    }

    @Override
    public void setIconSpin(final boolean iconSpin) {
        iconTextMixin.setIconSpin(iconSpin);
    }

    @Override
    public boolean isIconSpin() {
        return iconTextMixin.isIconSpin();
    }

    @Override
    public void setHref(final String href) {
        AnchorElement.as(getElement()).setHref(href);
    }

    @Override
    public String getHref() {
        return AnchorElement.as(getElement()).getHref();
    }

    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        this.targetHistoryToken = targetHistoryToken;
        final String hash = History.encodeHistoryToken(targetHistoryToken);
        setHref("#" + hash);
    }

    @Override
    public String getTargetHistoryToken() {
        return targetHistoryToken;
    }

    @Override
    public void setDataParent(final String href) {
        parentMixin.setDataParent(href);
    }

    @Override
    public String getDataParent() {
        return parentMixin.getDataParent();
    }

    @Override
    public void setToggle(final Toggle toggle) {
        toggleMixin.setToggle(toggle);
    }

    @Override
    public Toggle getToggle() {
        return toggleMixin.getToggle();
    }

    @Override
    public int getTabIndex() {
        return focusableMixin.getTabIndex();
    }

    @Override
    public void setTabIndex(final int index) {
        focusableMixin.setTabIndex(index);
    }

    @Override
    public void setAccessKey(final char key) {
        focusableMixin.setAccessKey(key);
    }

    @Override
    public void setFocus(final boolean focused) {
        focusableMixin.setFocus(focused);
    }

	@Override
	public String getHTML() {
		return getElement().getInnerHTML();
	}

	@Override
    public void setHTML(final String html) {
        getElement().setInnerHTML(html);
	}

    @Override
    public void setTarget(final String target) {
        targetMixin.setTarget(target);
    }

    @Override
    public String getTarget() {
        return targetMixin.getTarget();
    }
}
