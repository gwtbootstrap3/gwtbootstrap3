package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.safehtml.client.HasSafeHtml;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasHTML;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ToggleMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Anchor {@code <a>} element.
 *
 * @author Sven Jacobs
 */
public class Anchor extends FocusWidget implements HasHTML, HasSafeHtml, HasHref, HasToggle, HasTargetHistoryToken {

    private final ToggleMixin toggleMixin = new ToggleMixin(this);
    private String targetHistoryToken;

    public Anchor() {
        this("#");
    }

    public Anchor(final String href) {
        setElement(DOM.createAnchor());
        setHref(href);
    }

    public Anchor(final String text,
                  final String href) {
        this(href);
        setText(text);
    }

    @Override
    public String getText() {
        return getElement().getInnerText();
    }

    @Override
    public void setText(final String text) {
        getElement().setInnerText(text);
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
    public void setHTML(final SafeHtml html) {
        setHTML(html.asString());
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
}
