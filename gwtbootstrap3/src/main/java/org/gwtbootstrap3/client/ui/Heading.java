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

import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HasText;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Alignment;
import org.gwtbootstrap3.client.ui.constants.Emphasis;

/**
 * Represents a Heading tag, has an optional subtext.
 * <p/>
 * <h3>Bootstrap's Documentation</h3>
 * <a href="http://getbootstrap.com/css/#type">Typography</a>
 * <p/>
 * <h3>Usage in UiBinder</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Heading size="1">Heading Text</b:Heading>
 * <b:Heading size="1" subtext="Subtext Text">Heading Text</b:Heading>
 * }
 * </pre>
 * <p/>
 * <h3>Usage in Java</h3>
 * <p/>
 * <pre>
 * Heading h1 = new Heading(1, "Heading Text");
 * h1.setSubtext("Subtext Text); // optional
 * </pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 */
public class Heading extends ComplexWidget implements HasEmphasis, HasText, HasAlignment {
    private String text;
    private String subtext;

    /**
     * Creates a Heading with the passed in size.
     *
     * @param size size of the heading
     */
    @UiConstructor
    public Heading(final int size) {
        setElement(Document.get().createElement("h" + size));
        assert size > 0 && size < 7 : "Wrong heading size (must be between 1 and 6)";
    }

    /**
     * Creates a Heading with the passed in size and text.
     *
     * @param size size of the heading
     * @param text text for the heading
     */
    public Heading(final int size, final String text) {
        this(size);
        setText(text);
    }

    /**
     * Sets the subtext for the heading (wrapped in a Small tag).
     *
     * @param subtext the subtext of the heading
     */
    public void setSubtext(final String subtext) {
        this.subtext = subtext;

        // Render the inner html of the element
        render();
    }

    /**
     * Returns the subtext of the heading.
     *
     * @return subtext of the heading
     */
    public String getSubtext() {
        return subtext;
    }

    /**
     * Returns the text of the heading.
     *
     * @return text of the heading
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * Sets the text for the heading
     *
     * @param text the text of the heading
     */
    @Override
    public void setText(final String text) {
        this.text = text;

        // Render the inner html of the element
        render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEmphasis(final Emphasis emphasis) {
        StyleHelper.addUniqueEnumStyleName(this, Emphasis.class, emphasis);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Emphasis getEmphasis() {
        return Emphasis.fromStyleName(getStyleName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAlignment(final Alignment alignment) {
        StyleHelper.addUniqueEnumStyleName(this, Alignment.class, alignment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Alignment getAlignment() {
        return Alignment.fromStyleName(getStyleName());
    }

    /**
     * Renders the element's inner html depending on what is set. This ensures that we don't have the small
     * tag always there if the user doesn't want to use it.
     */
    private void render() {
        StringBuilder builder = new StringBuilder();

        // If the text isn't null, add it to the builder
        if (text != null) {
            builder = builder.append(text);
        }

        // If the subtext isn't null, add a space and it to the builder (wrapped inside a small tag)
        if (subtext != null) {
            builder = builder.append(" ")
                    .append("<small>")
                    .append(subtext)
                    .append("</small>");
        }

        // Set the inner html of the element to the builder
        getElement().setInnerHTML(builder.toString());
    }
}
