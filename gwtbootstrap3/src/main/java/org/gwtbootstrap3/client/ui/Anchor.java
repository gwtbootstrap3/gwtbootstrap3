package org.gwtbootstrap3.client.ui;

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

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.HasBadge;
import org.gwtbootstrap3.client.ui.base.HasDataParent;
import org.gwtbootstrap3.client.ui.base.HasDataTarget;
import org.gwtbootstrap3.client.ui.base.HasDataToggle;
import org.gwtbootstrap3.client.ui.base.HasHref;
import org.gwtbootstrap3.client.ui.base.HasIcon;
import org.gwtbootstrap3.client.ui.base.HasIconPosition;
import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.HasTarget;
import org.gwtbootstrap3.client.ui.base.HasTargetHistoryToken;
import org.gwtbootstrap3.client.ui.base.mixin.AttributeMixin;
import org.gwtbootstrap3.client.ui.base.mixin.DataParentMixin;
import org.gwtbootstrap3.client.ui.base.mixin.DataTargetMixin;
import org.gwtbootstrap3.client.ui.base.mixin.DataToggleMixin;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.base.mixin.FocusableMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IconTextMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.BadgePosition;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.constants.Toggle;

import java.util.List;

/**
 * Anchor {@code <a>} element with text and optional icon.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Grant Slender
 * @author Drew Spencer
 */
public class Anchor extends ComplexWidget implements HasEnabled, HasClickHandlers, HasDoubleClickHandlers, HasHref, HasDataToggle, HasDataParent,
        HasTargetHistoryToken, HasHTML, HasIcon, HasIconPosition, Focusable, HasDataTarget, HasTarget, HasPull, HasBadge {

    private final PullMixin<Anchor> pullMixin = new PullMixin<Anchor>(this);
    private final DataToggleMixin<Anchor> toggleMixin = new DataToggleMixin<Anchor>(this);
    private final DataParentMixin<Anchor> parentMixin = new DataParentMixin<Anchor>(this);
    private final IconTextMixin<Anchor> iconTextMixin = new IconTextMixin<Anchor>(this);
    private final DataTargetMixin<Anchor> targetMixin = new DataTargetMixin<Anchor>(this);
    private final AttributeMixin<Anchor> attributeMixin = new AttributeMixin<Anchor>(this);
    private final FocusableMixin<Anchor> focusableMixin = new FocusableMixin<Anchor>(this);
    private final EnabledMixin<Anchor> enabledMixin = new EnabledMixin<Anchor>(this);
    private String targetHistoryToken;

    /**
     * Creates an anchor widget with the desired HREF
     *
     * @param href href for the anchor
     */
    public Anchor(final String href) {
        setElement(Document.get().createAnchorElement());
        setHref(href);
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
    public void setIconInverse(final boolean iconInverse) {
        iconTextMixin.setIconInverse(iconInverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconInverse() {
        return iconTextMixin.isIconInverse();
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
    public void setIconPulse(boolean iconPulse) {
        iconTextMixin.setIconPulse(iconPulse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconPulse() {
        return iconTextMixin.isIconPulse();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconFixedWidth(final boolean iconFixedWidth) {
        iconTextMixin.setIconFixedWidth(iconFixedWidth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIconFixedWidth() {
        return iconTextMixin.isIconFixedWidth();
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
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(final boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    @Override
    public void setBadgeText(String badgeText) {
        iconTextMixin.setBadgeText(badgeText);
    }

    @Override
    public String getBadgeText() {
        return iconTextMixin.getBadgeText();
    }

    @Override
    public void setBadgePosition(BadgePosition badgePosition) {
        iconTextMixin.setBadgePosition(badgePosition);
    }

    @Override
    public BadgePosition getBadgePosition() {
        return iconTextMixin.getBadgePosition();
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

    /**
     * We override this because the <a></a> tag doesn't support the disabled property. So on clicks and focus, if disabled then ignore
     *
     * @param event dom event
     */
    @Override
    public void onBrowserEvent(final Event event) {
        switch (DOM.eventGetType(event)) {
            case Event.ONDBLCLICK:
            case Event.ONFOCUS:
            case Event.ONCLICK:
                if (!isEnabled()) {
                    return;
                }
                break;
        }
        super.onBrowserEvent(event);
    }

	@Override
	public void setIconColor(String iconColor) {
		iconTextMixin.setIconColor(iconColor);
	}

}
