package com.svenjacobs.gwtbootstrap3.client.ui;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Page header with optional subtext
 * <p/>
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:PageHeader subText="Some subtext">Page header title</b:PageHeader>
 * }</pre>
 *
 * @author Sven Jacobs
 */
public class PageHeader extends Widget implements HasText, HasId {

    private final IdMixin idMixin = new IdMixin(this);
    private String heading;
    private String subText;

    public PageHeader() {
        setElement(DOM.createDiv());
        setStyleName(Styles.PAGE_HEADER);
    }

    public void setSubText(final String subText) {
        this.subText = subText;
        render();
    }

    @Override
    public void setText(final String text) {
        this.heading = text;
        render();
    }

    @Override
    public String getText() {
        return heading;
    }

    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    @Override
    public String getId() {
        return idMixin.getId();
    }

    private void render() {
        final StringBuilder html = new StringBuilder();

        html.append("<h1>");
        html.append(heading == null ? "" : heading);

        if (subText != null && !subText.isEmpty()) {
            html.append(" ");
            html.append("<small>");
            html.append(subText);
            html.append("</small>");
        }

        html.append("</h1>");

        getElement().setInnerHTML(html.toString());
    }
}
