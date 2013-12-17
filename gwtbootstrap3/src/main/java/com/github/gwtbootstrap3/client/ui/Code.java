package com.github.gwtbootstrap3.client.ui;

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

import com.github.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasHTML;

/**
 * Simple {@code <code>} block for inline code emphasis.
 *
 * @author Sven Jacobs
 * @see Pre
 */
public class Code extends AbstractTextWidget implements HasHTML {

    public Code() {
        super(DOM.createElement("code"));
    }

    @Override
    public String getHTML() {
        return getElement().getInnerHTML();
    }

    /**
     * Sets HTML contents.
     * <p/>
     * If HTML contains "\n" it will be replaced by a {@code <br>} element
     * and "\s" will be replaced by a whitespace.
     *
     * @param html HTML contents
     */
    @Override
    public void setHTML(final String html) {
        final SafeHtmlBuilder builder = new SafeHtmlBuilder();
        final String[] splitted = html.replaceAll("\\\\s", " ").split("\\\\n\\s?");

        for (final String s : splitted) {
            builder.append(SafeHtmlUtils.fromTrustedString(SafeHtmlUtils.htmlEscapeAllowEntities(s)));
            builder.appendHtmlConstant("<br>");
        }

        getElement().setInnerHTML(builder.toSafeHtml().asString());
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        // When the widget loads, force the styling of pretty print
        prettyPrint();
    }

    private native void prettyPrint() /*-{
        $wnd.prettyPrint();
    }-*/;
}
