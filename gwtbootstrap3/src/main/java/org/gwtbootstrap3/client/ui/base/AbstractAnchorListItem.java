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
import org.gwtbootstrap3.client.ui.HasDataToggle;
import org.gwtbootstrap3.client.ui.HasHref;
import org.gwtbootstrap3.client.ui.HasTargetHistoryToken;
import org.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Base class for list items that contain an {@link org.gwtbootstrap3.client.ui.Anchor} link.
 *
 * @author Sven Jacobs
 */
public abstract class AbstractAnchorListItem extends AbstractListItem
        implements HasHref, HasTargetHistoryToken, HasClickHandlers, Focusable, HasDataToggle {

    protected final Anchor anchor;

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
        return anchor.addClickHandler(handler);
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
}
