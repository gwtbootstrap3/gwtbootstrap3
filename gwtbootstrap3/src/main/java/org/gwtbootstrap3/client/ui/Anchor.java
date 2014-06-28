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
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.*;
import org.gwtbootstrap3.client.ui.base.mixin.*;
import org.gwtbootstrap3.client.ui.constants.*;

import java.util.List;

/**
 * Anchor {@code <a>} element with text and optional icon.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Grant Slender
 */
public class Anchor extends ComplexWidget implements HasClickHandlers, HasDoubleClickHandlers, HasHref, HasDataToggle, HasDataParent,
        HasTargetHistoryToken, HasHTML, HasIcon, HasIconPosition, Focusable, HasDataTarget, HasTarget, HasPull {

    private final PullMixin<Anchor> pullMixin = new PullMixin<Anchor>(this);
    private final DataToggleMixin<Anchor> toggleMixin = new DataToggleMixin<Anchor>(this);
    private final DataParentMixin<Anchor> parentMixin = new DataParentMixin<Anchor>(this);
    private final IconTextMixin<Anchor> iconTextMixin = new IconTextMixin<Anchor>(this);
    private final DataTargetMixin<Anchor> targetMixin = new DataTargetMixin<Anchor>(this);
    private final AttributeMixin<Anchor> attributeMixin = new AttributeMixin<Anchor>(this);
    private final FocusableMixin<Anchor> focusableMixin;
    private String targetHistoryToken;

    /**
     * Creates an anchor widget with the desired HREF
     *
     * @param href href for the anchor
     */
    public Anchor(final String href) {
        setElement(Document.get().createAnchorElement());
        setHref(href);
        focusableMixin = new FocusableMixin<Anchor>(this);
        iconTextMixin.addTextWidgetToParent();
    }

    /**
     * Creates an achor widget with the desired HREF and text
     *
     * @param text text for the anchor
     * @param href href for the anchor
     */
    public Anchor(final String text, final String href) {
        this(href);
        setText(text);
    }

    /**
     * Creates a default anchor with a default href
     */
    public Anchor() {
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
    public void setText(final String text) {
        iconTextMixin.setText(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return iconTextMixin.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIcon(final IconType iconType) {
        iconTextMixin.setIcon(iconType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IconType getIcon() {
        return iconTextMixin.getIcon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        iconTextMixin.setIconPosition(iconPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IconPosition getIconPosition() {
        return iconTextMixin.getIconPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(final IconSize iconSize) {
        iconTextMixin.setIconSize(iconSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IconSize getIconSize() {
        return iconTextMixin.getIconSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconFlip(final IconFlip iconFlip) {
        iconTextMixin.setIconFlip(iconFlip);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IconFlip getIconFlip() {
        return iconTextMixin.getIconFlip();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconRotate(final IconRotate iconRotate) {
        iconTextMixin.setIconRotate(iconRotate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IconRotate getIconRotate() {
        return iconTextMixin.getIconRotate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconBordered(final boolean iconBordered) {
        iconTextMixin.setIconBordered(iconBordered);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconBordered() {
        return iconTextMixin.isIconBordered();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconMuted(final boolean iconMuted) {
        iconTextMixin.setIconMuted(iconMuted);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconMuted() {
        return iconTextMixin.isIconMuted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconLight(final boolean iconLight) {
        iconTextMixin.setIconLight(iconLight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconLight() {
        return iconTextMixin.isIconLight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSpin(final boolean iconSpin) {
        iconTextMixin.setIconSpin(iconSpin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconSpin() {
        return iconTextMixin.isIconSpin();
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
    public void setDataParent(final String dataParent) {
        parentMixin.setDataParent(dataParent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDataParent() {
        return parentMixin.getDataParent();
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
    public String getHTML() {
        return getElement().getInnerHTML();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHTML(final String html) {
        getElement().setInnerHTML(html);
    }

    @Override
    public void setDataTargetWidgets(final List<Widget> widgets) {
        targetMixin.setDataTargetWidgets(widgets);
    }

    @Override
    public void setDataTargetWidget(final Widget widget) {
        targetMixin.setDataTargetWidget(widget);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDataTarget(final String dataTarget) {
        targetMixin.setDataTarget(dataTarget);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDataTarget() {
        return targetMixin.getDataTarget();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAttach() {
        super.onAttach();

        // Adding styles to the heading depending on the parent
        if (getParent() != null) {
            if (getParent() instanceof Alert) {
                addStyleName(Styles.ALERT_LINK);
            }
        }
    }
}
