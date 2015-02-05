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

import org.gwtbootstrap3.client.ui.base.HasHref;
import org.gwtbootstrap3.client.ui.base.HasTargetHistoryToken;
import org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap3.client.ui.constants.ButtonType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.impl.HyperlinkImpl;

/**
 * Button based on {@code <a>} element.
 *
 * @author Sven Jacobs
 * @see Button
 * @see org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton
 */
public class AnchorButton extends AbstractToggleButton implements HasHref, HasTargetHistoryToken {

    private String targetHistoryToken;

    private static HyperlinkImpl impl = GWT.create(HyperlinkImpl.class);

    public AnchorButton(final ButtonType type) {
        super(type);
        setHref(EMPTY_HREF);
        sinkEvents(Event.ONCLICK);
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        if (getTargetHistoryToken() != null) {
            // implementation is based on Hyperlink#onBrowserEvent
            if (DOM.eventGetType(event) == Event.ONCLICK && impl.handleAsClick(event)) {
                History.newItem(getTargetHistoryToken());
                event.preventDefault();
            }
        }
    }

    /**
     * Set the target history token for the widget. Note, that you should use either {@link #setTargetHistoryToken(String)}
     * or {@link #setHref(String)}, but not both as {@link #setHref(String)} resets the target history token.
     * @param targetHistoryToken String target history token of the widget
     */
    @Override
    public void setTargetHistoryToken(final String targetHistoryToken) {
        this.targetHistoryToken = targetHistoryToken;
        if (targetHistoryToken != null) {
            final String hash = History.encodeHistoryToken(targetHistoryToken);
            getAnchorElement().setHref("#" + hash);
        }
    }

    /**
     * Get the target history token for the widget. May return {@code null} if no history token has been set or if
     * it has been reset by {@link #setHref(String)}
     * @return String the widget's target history token
     */
    @Override
    public String getTargetHistoryToken() {
        return targetHistoryToken;
    }

    public AnchorButton() {
        this(ButtonType.DEFAULT);
    }

    /**
     * Set's the HREF of the widget. Note, that you should use either {@link #setTargetHistoryToken(String)}
     * or {@link #setHref(String)}, but not both as {@link #setHref(String)} resets the target history token.
     * @param href String href
     */
    @Override
    public void setHref(final String href) {
        this.targetHistoryToken = null;
        getAnchorElement().setHref(href);
    }

    @Override
    public String getHref() {
        return getAnchorElement().getHref();
    }

    @Override
    protected Element createElement() {
        return Document.get().createAnchorElement();
    }

    private AnchorElement getAnchorElement() {
        return AnchorElement.as(getElement());
    }
}
