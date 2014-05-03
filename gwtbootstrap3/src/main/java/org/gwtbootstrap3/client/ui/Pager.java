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

import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.UnorderedList;

/**
 * Support for Bootstrap pager (http://getbootstrap.com/components/#pagination-pager)
 *
 * @author Joshua Godi
 */
public class Pager extends UnorderedList implements HasResponsiveness {
    private static final String DEFAULT_PREVIOUS = "Previous";
    private static final String DEFAULT_NEXT = "Next";

    private final ListItem previous;
    private final ListItem next;

    public Pager() {
        setStyleName(Styles.PAGER);

        previous = new ListItem(DEFAULT_PREVIOUS);
        next = new ListItem(DEFAULT_NEXT);

        add(previous);
        add(next);
    }

    public void setAlignToSides(final boolean alignToSides) {
        if (alignToSides) {
            previous.setStyleName(Styles.PREVIOUS);
            next.setStyleName(Styles.NEXT);
        } else {
            previous.removeStyleName(Styles.PREVIOUS);
            next.removeStyleName(Styles.NEXT);
        }
    }

    public void setPreviousText(final String text) {
        previous.setText(text);
    }

    public void setPreviousIcon(final IconType icon) {
        previous.setIcon(icon);
    }

    public void setPreviousIconSize(final IconSize iconSize) {
        previous.setIconSize(iconSize);
    }

    public void setNextText(final String text) {
        next.setText(text);
    }

    public void setNextIcon(final IconType icon) {
        next.setIcon(icon);
        next.setIconPosition(IconPosition.RIGHT);
    }

    public void setNextIconSize(final IconSize iconSize) {
        next.setIconSize(iconSize);
    }
}
