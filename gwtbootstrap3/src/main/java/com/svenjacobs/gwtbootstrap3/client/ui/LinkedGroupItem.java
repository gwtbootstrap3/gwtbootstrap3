package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class LinkedGroupItem extends ComplexWidget implements HasClickHandlers, HasDoubleClickHandlers, HasHref,
        HasTargetHistoryToken, HasResponsiveness, HasActive {

    private final ActiveMixin<LinkedGroupItem> activeMixin = new ActiveMixin<LinkedGroupItem>(this);

    private Span span = new Span();

    private String targetHistoryToken;

    public LinkedGroupItem(final String href) {
        setElement(DOM.createAnchor());
        setStyleName(Styles.LIST_GROUP_ITEM);
        setHref(href);
        add(span);
    }

    public LinkedGroupItem(final String text,
                           final String href) {
        this(href);
        setText(text);
    }

    public LinkedGroupItem() {
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

    public void setText(final String text) {
        span.setText(text);
    }

    public String getText() {
        return span.getText();
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
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    @Override
    public void setActive(boolean active) {
        activeMixin.setActive(active);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }
}
