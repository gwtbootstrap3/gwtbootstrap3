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

import org.gwtbootstrap3.client.ui.constants.ColumnOffset;
import org.gwtbootstrap3.client.ui.constants.ColumnPull;
import org.gwtbootstrap3.client.ui.constants.ColumnPush;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.client.ui.html.Div;

import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

/**
 * A column of Bootstrap's fluid grid system.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author Pontus Enmark
 * @see Row
 */
public class Column extends Div {

    private static final String SEPARATOR = "[, ]+";

    /**
     * Creates a column with one size, and with one or more additional widgets added.
     * <p/>
     * Additional sizes can be added with {@link #addSize(ColumnSize...)}.
     * Additional widgets can be added with {@link #add(Widget)}.
     *
     * @param size         Size of column
     * @param firstWidget  Widget to add
     * @param otherWidgets Other widgets to add
     */
    public Column(final ColumnSize size, final Widget firstWidget, final Widget... otherWidgets) {
        this(size);

        add(firstWidget);
        for (final Widget widget : otherWidgets) {
            add(widget);
        }
    }

    /**
     * Creates column with one or more additional sizes.
     * <p/>
     * Additional sizes can be added with {@link #addSize(ColumnSize...)}
     *
     * @param firstSize  Size of column
     * @param otherSizes Other sizes of column
     * @see #addSize(ColumnSize...)
     */
    public Column(final ColumnSize firstSize, final ColumnSize... otherSizes) {
        setSize(firstSize, otherSizes);
    }

    /**
     * Convenience constructor for UiBinder to create a Column with one or more
     * sizes.
     * <p/>
     * Size needs to be a space-separated String of {@link ColumnSize} enum
     * names, e.g. "SM_3 LG_3"
     *
     * @param size Space-separated String of {@link ColumnSize}
     * @see ColumnSize
     */
    @UiConstructor
    public Column(final String size) {
        setSize(size);
    }

    /**
     * Adds one or more additional column sizes.
     *
     * @param firstSize  Column size
     * @param otherSizes Additional column sizes
     */
    public void setSize(final ColumnSize firstSize, final ColumnSize... otherSizes) {
        addEnumVarargsValues(new ColumnSize[]{firstSize}, ColumnSize.class, true);
        addEnumVarargsValues(otherSizes, ColumnSize.class, false);
    }

    public void setSize(final String sizes) {
        addEnumStringValues(sizes, ColumnSize.class, true);
    }

    public void addSize(final ColumnSize... sizes) {
        addEnumVarargsValues(sizes, ColumnSize.class, false);
    }

    public void addSize(final String sizes) {
        addEnumStringValues(sizes, ColumnSize.class, false);
    }

    public void setPull(final ColumnPull... pulls) {
        addEnumVarargsValues(pulls, ColumnPull.class, true);
    }

    public void setPull(final String pulls) {
        addEnumStringValues(pulls, ColumnPull.class, true);
    }

    public void addPull(final ColumnPull... pulls) {
        addEnumVarargsValues(pulls, ColumnPull.class, false);
    }

    public void addPull(final String pulls) {
        addEnumStringValues(pulls, ColumnPull.class, false);
    }

    public void setPush(final ColumnPush... pushes) {
        addEnumVarargsValues(pushes, ColumnPush.class, true);
    }

    public void setPush(final String pushes) {
        addEnumStringValues(pushes, ColumnPush.class, true);
    }

    public void addPush(final ColumnPush... pushes) {
        addEnumVarargsValues(pushes, ColumnPush.class, false);
    }

    public void addPush(final String pushes) {
        addEnumStringValues(pushes, ColumnPush.class, false);
    }

    public void setOffset(final ColumnOffset... offsets) {
        addEnumVarargsValues(offsets, ColumnOffset.class, true);
    }

    public void setOffset(final String offsets) {
        addEnumStringValues(offsets, ColumnOffset.class, true);
    }

    public void addOffset(final ColumnOffset... offsets) {
        addEnumVarargsValues(offsets, ColumnOffset.class, false);
    }

    public void addOffset(final String offsets) {
        addEnumStringValues(offsets, ColumnOffset.class, false);
    }

    private <E extends Enum<? extends Style.HasCssName>> void addEnumVarargsValues(final E[] values,
                                                                                   final Class<E> enumClass,
                                                                                   final boolean clearOld) {
        if (clearOld) {
            // Remove the previous values
            removeStyleNames(enumClass);
        }

        for (final E value : values) {
            addStyleName(((Style.HasCssName) value).getCssName());
        }
    }

    private <E extends Enum<? extends Style.HasCssName>> void addEnumStringValues(final String values,
                                                                                  final Class<E> enumClass,
                                                                                  final boolean clearOld) {
        if (clearOld) {
            // Remove the previous values
            removeStyleNames(enumClass);
        }

        // Add new ones
        final String[] valuesSplit = values.split(SEPARATOR);
        for (final String value : valuesSplit) {
            for (final E constant : enumClass.getEnumConstants()) {
                if (value.equalsIgnoreCase(constant.name())) {
                    addStyleName(((Style.HasCssName) constant).getCssName());
                }
            }
        }
    }

    private <E extends Enum<? extends Style.HasCssName>> void removeStyleNames(final Class<E> enumClass) {
        for (final E constant : enumClass.getEnumConstants()) {
            removeStyleName(((Style.HasCssName) constant).getCssName());
        }
    }
}