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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import org.gwtbootstrap3.client.ui.base.AbstractTextWidget;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.LabelType;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Bootstrap's label, see <a href="http://getbootstrap.com/components/#labels">documentation</a>.
 * <p/>
 * Not to be confused with {@code <label>} (see {@link FormLabel}) or GWT's {@link com.google.gwt.user.client.ui.Label}
 *
 * @author Sven Jacobs
 * @see FormLabel
 */
public class Label extends AbstractTextWidget implements HasType<LabelType>, HasClickHandlers {

    public Label() {
        super(Document.get().createSpanElement());
        setStyleName(Styles.LABEL);
        setType(LabelType.DEFAULT);
    }

    public Label(final LabelType type) {
        this();
        setType(type);
    }

    public Label(final String text) {
        this(LabelType.DEFAULT, text);
    }

    public Label(final LabelType type, final String text) {
        this(type);
        setText(text);
    }

    /**
     * Sets type of label.
     *
     * @param type Type of label
     */
    @Override
    public void setType(final LabelType type) {
        StyleHelper.addUniqueEnumStyleName(this, LabelType.class, type);
    }

    @Override
    public LabelType getType() {
        return LabelType.fromStyleName(getStyleName());
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }
}
