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

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Focusable;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.FocusableMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ToggleMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * @author Joshua Godi
 */
public class ThumbnailLink extends ComplexWidget implements HasClickHandlers, HasDoubleClickHandlers, HasHref,
        HasToggle, HasTargetHistoryToken, HasTabIndex, Focusable, HasResponsiveness {

    private final ToggleMixin<ThumbnailLink> toggleMixin = new ToggleMixin<ThumbnailLink>(this);
    private final FocusableMixin focusableMixin;
    private String targetHistoryToken;

    public ThumbnailLink(final String href) {
        setElement(DOM.createAnchor());
        setHref(href);
        focusableMixin = new FocusableMixin(AnchorElement.as(getElement()));
    }

    public ThumbnailLink(final String text, final String href) {
        this(href);
    }

    public ThumbnailLink() {
        this("#");
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
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }
}