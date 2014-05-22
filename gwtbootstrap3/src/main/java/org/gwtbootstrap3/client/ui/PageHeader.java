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

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HasText;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * Page header with optional subtext
 *
 * <h3>UiBinder example</h3>
 *
 * <pre>
 * {@code
 *     <b:PageHeader subText="Some subtext">Page header title</b:PageHeader>
 * }
 * </pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class PageHeader extends Div implements HasText {

    private String heading;
    private String subText;

    public PageHeader() {
        setStyleName(Styles.PAGE_HEADER);
    }

    public void setSubText(final String subText) {
        this.subText = subText;
        render();
    }

    @Override
    public void setText(final String text) {
        heading = text;
        render();
    }

    @Override
    public String getText() {
        return heading;
    }

    private void render() {
        final SafeHtmlBuilder builder = new SafeHtmlBuilder();

        builder.appendHtmlConstant("<h1>");
        builder.appendEscaped(heading == null ? "" : heading);

        if (subText != null && !subText.isEmpty()) {
            builder.appendEscaped(" ");
            builder.appendHtmlConstant("<small>");
            builder.appendEscaped(subText);
            builder.appendHtmlConstant("</small>");
        }

        builder.appendHtmlConstant("</h1>");

        getElement().setInnerSafeHtml(builder.toSafeHtml());
    }
}
