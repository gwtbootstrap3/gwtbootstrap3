package com.svenjacobs.gwtbootstrap3.client.ui;

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

import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.ComplexWidget;
import com.svenjacobs.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ColumnOffset;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ColumnPull;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ColumnPush;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ColumnSize;

/**
 * A column of Bootstrap's fluid grid system.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Row
 */
public class Column extends ComplexWidget implements HasResponsiveness {
    private static final String SEPARATOR = ",";

    private Column() {
        setElement(DOM.createDiv());
    }

    public Column(final ColumnSize size, final Widget... widgets) {
        this(size);

        for (Widget widget : widgets) {
            add(widget);
        }
    }

    /**
     * Creates column with primary size.
     * <p/>
     * Additional sizes can be added with {@link #addSizes(ColumnSize...)}
     *
     * @param size Size of column
     * @see #Column(ColumnSize...)
     * @see #addSizes(ColumnSize...)
     */
    public Column(final ColumnSize size) {
        this();
        setStyleName(size.getCssName());
    }

    /**
     * Creates column with multiple sizes.
     *
     * @param sizes Column sizes
     */
    public Column(final ColumnSize... sizes) {
        this();
        addSizes(sizes);
    }

    /**
     * Convenience constructor for UiBinder to create a Column with one or more sizes.
     * <p/>
     * Size needs to be a comma-separated String of {@link ColumnSize} enum names, e.g. "SM_SIZE_3,LG_SIZE_3"
     *
     * @param size Comma-separated String of {@link ColumnSize}
     * @see ColumnSize
     */
    @UiConstructor
    public Column(final String size) {
        this();
        addSizes(size);
    }

    /**
     * Adds one or more additional column sizes.
     *
     * @param sizes Additional column sizes
     */
    public void addSizes(final ColumnSize... sizes) {
        addEnumVarargsValues(sizes);
    }

    public void setPull(final ColumnPull... pulls) {
        addEnumVarargsValues(pulls);
    }

    public void setPull(final String pulls) {
        addEnumStringValues(pulls, ColumnPull.class);
    }

    public void setPush(final ColumnPush... pulls) {
        addEnumVarargsValues(pulls);
    }

    public void setPush(final String pushs) {
        addEnumStringValues(pushs, ColumnPush.class);
    }

    public void setOffset(final ColumnOffset... offsets) {
        addEnumVarargsValues(offsets);
    }

    public void setOffset(final String offsets) {
        addEnumStringValues(offsets, ColumnOffset.class);
    }

    @Override
    public void setVisibleOn(String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    private void addSizes(final String sizes) {
        addEnumStringValues(sizes, ColumnSize.class);
    }

    private <E extends Style.HasCssName> void addEnumVarargsValues(final E[] values) {
        for (final E value : values) {
            addStyleName(value.getCssName());
        }
    }

    private <E extends Enum<? extends Style.HasCssName>> void addEnumStringValues(final String values,
                                                                                  final Class<E> enumClass) {
        String[] valuesSplit = values.split(SEPARATOR);
        for (String value : valuesSplit) {
            for (final Enum<? extends Style.HasCssName> constant : enumClass.getEnumConstants()) {
                if (value.equalsIgnoreCase(constant.name())) {
                    addStyleName(((Style.HasCssName) constant).getCssName());
                }
            }
        }
    }
}
