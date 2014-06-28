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
import org.gwtbootstrap3.client.ui.base.*;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.DataToggleMixin;
import org.gwtbootstrap3.client.ui.base.mixin.FocusableMixin;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Widget representing the Bootstrap Thumbnail as a clickable image
 * <p/>
 * <a href="http://getbootstrap.com/components/#thumbnails">Bootstrap Documentation</a>
 * <p/>
 * <h3>UiBinder example</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:ThumbnailLink>
 *    Image
 * </b:ThumbnailLink>
 * }
 * </pre>
 *
 * @author Joshua Godi
 */
public class ThumbnailLink extends ComplexWidget implements HasClickHandlers, HasDoubleClickHandlers, HasHref,
        HasDataToggle, HasTargetHistoryToken, Focusable, HasTarget {

    private final DataToggleMixin<ThumbnailLink> toggleMixin = new DataToggleMixin<ThumbnailLink>(this);
    private final AttributeMixin<ThumbnailLink> attributeMixin = new AttributeMixin<ThumbnailLink>(this);
    private final FocusableMixin<ThumbnailLink> focusableMixin;
    private String targetHistoryToken;

    /**
     * Creates the default ThumbnailLink with the specified HREF
     *
     * @param href String href to use
     */
    public ThumbnailLink(final String href) {
        setElement(Document.get().createAnchorElement());
        setHref(href);
        focusableMixin = new FocusableMixin<ThumbnailLink>(this);
    }

    /**
     * Creates the default ThumbnailLink with a default HREF
     */
    public ThumbnailLink() {
        this(EMPTY_HREF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addDoubleClickHandler(final DoubleClickHandler handler) {
        return addDomHandler(handler, DoubleClickEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHref(final String href) {
        AnchorElement.as(getElement()).setHref(href);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHref() {
        return AnchorElement.as(getElement()).getHref();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        this.targetHistoryToken = targetHistoryToken;
        final String hash = History.encodeHistoryToken(targetHistoryToken);
        setHref("#" + hash);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTargetHistoryToken() {
        return targetHistoryToken;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDataToggle(final Toggle toggle) {
        toggleMixin.setDataToggle(toggle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Toggle getDataToggle() {
        return toggleMixin.getDataToggle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTabIndex() {
        return focusableMixin.getTabIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTabIndex(final int index) {
        focusableMixin.setTabIndex(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccessKey(final char key) {
        focusableMixin.setAccessKey(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFocus(final boolean focused) {
        focusableMixin.setFocus(focused);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTarget(final String target) {
        attributeMixin.setAttribute(Attributes.TARGET, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTarget() {
        return attributeMixin.getAttribute(Attributes.TARGET);
    }
}
