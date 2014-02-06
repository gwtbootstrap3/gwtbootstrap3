package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasHTML;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.shared.event.ShownEvent;
import org.gwtbootstrap3.client.shared.event.ShownHandler;
import org.gwtbootstrap3.client.ui.constants.Attributes;
import org.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * @author godi
 */
public class TabListItem extends ListItem implements HasHTML {

    public TabListItem() {
        this("");
    }

    public TabListItem(final String text) {
        super(text);
        setToggle(Toggle.TAB);
    }

    public void showTab() {
        showTab(anchor.getElement());
    }

    public HandlerRegistration addShowHandler(final ShowHandler showHandler) {
        return addHandler(showHandler, ShowEvent.getType());
    }

    public HandlerRegistration addShownHandler(final ShownHandler shownHandler) {
        return addHandler(shownHandler, ShownEvent.getType());
    }

    /**
     * We override set href here because we want to ensure that projects with gwt places and gwtp
     * don't try to execute a place change event with it being clicked
     */
    @Override
    public void setHref(String href) {
        // Ensuring that the data target has # in it
        if (!href.contains("#")) {
            href = "#" + href;
        }
        anchor.getElement().setAttribute(Attributes.DATA_TARGET, href);
    }

    @Override
    public String getHref() {
        return anchor.getElement().getAttribute(Attributes.DATA_TARGET);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // Bind JS Events
        bindJsEvents(anchor.getElement());
    }

    @Override
    public String getHTML() {
        return anchor.getHTML();
    }

    @Override
    public void setHTML(String html) {
        anchor.setHTML(html);
    }

    /**
     * Can be override by subclasses to handle Tabs's "show" event however
     * it's recommended to add an event handler to the tab.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.ShowEvent
     */
    protected void onShow(final Event evt) {
        fireEvent(new ShowEvent(evt));
    }

    /**
     * Can be override by subclasses to handle Tabs's "shown" event however
     * it's recommended to add an event handler to the tab.
     *
     * @param evt Event
     * @see org.gwtbootstrap3.client.shared.event.ShownEvent
     */
    protected void onShown(final Event evt) {
        fireEvent(new ShownEvent(evt));
    }

    private native void showTab(Element e) /*-{
        $wnd.jQuery(e).tab('show');
    }-*/;

    // @formatter:off
    private native void bindJsEvents(final Element e) /*-{
        var target = this;
        var $tab = $wnd.jQuery(e);

        $tab.on('show.bs.tab', function (evt) {
            target.@org.gwtbootstrap3.client.ui.TabListItem::onShow(Lcom/google/gwt/user/client/Event;)(evt);
        });

        $tab.on('shown.bs.tab', function (evt) {
            target.@org.gwtbootstrap3.client.ui.TabListItem::onShown(Lcom/google/gwt/user/client/Event;)(evt);
        });
    }-*/;
}
