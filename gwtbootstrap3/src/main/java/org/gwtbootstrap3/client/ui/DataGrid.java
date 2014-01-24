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

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.TableType;

/**
 * @author godi
 */
public class DataGrid<T> extends com.google.gwt.user.cellview.client.DataGrid<T> implements HasResponsiveness {
    private static final int DEFAULT_PAGESIZE = 50;
    private static Resources DEFAULT_RESOURCES;

    /**
     * Constructs a table with a default page size of 50.
     */
    public DataGrid() {
        this(DEFAULT_PAGESIZE);
    }

    /**
     * Constructs a table with the given page size.
     *
     * @param pageSize the page size
     */
    public DataGrid(final int pageSize) {
        this(pageSize, getDefaultResources());
    }

    /**
     * Constructs a table with the given page size and the given
     * {@link ProvidesKey key provider}.
     *
     * @param pageSize    the page size
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public DataGrid(final int pageSize, final ProvidesKey<T> keyProvider) {
        this(pageSize, getDefaultResources(), keyProvider);
    }

    /**
     * Constructs a table with the given page size with the specified
     * {@link Resources}.
     *
     * @param pageSize  the page size
     * @param resources the resources to use for this widget
     */
    public DataGrid(final int pageSize, final Resources resources) {
        this(pageSize, resources, null);
    }

    /**
     * Constructs a table with the given page size, the specified
     * {@link Resources}, and the given key provider.
     *
     * @param pageSize    the page size
     * @param resources   the resources to use for this widget
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public DataGrid(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider) {
        this(pageSize, resources, keyProvider, createDefaultLoadingIndicator(resources));
    }

    /**
     * Constructs a table with the given page size, the specified
     * {@link Resources}, and the given key provider.
     *
     * @param pageSize         the page size
     * @param resources        the resources to use for this widget
     * @param keyProvider      an instance of ProvidesKey<T>, or null if the record
     *                         object should act as its own key
     * @param loadingIndicator the widget to use as a loading indicator, or null
     *                         to disable
     */
    public DataGrid(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider,
                    final Widget loadingIndicator) {
        super(pageSize, resources, keyProvider, loadingIndicator);
        getTableBodyElement().getParentElement().addClassName(TableType.DEFAULT.getCssName());
    }

    /**
     * Constructs a table with a default page size of 50, and the given
     * {@link ProvidesKey key provider}.
     *
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public DataGrid(final ProvidesKey<T> keyProvider) {
        this(DEFAULT_PAGESIZE, keyProvider);
    }

    private static Resources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(Resources.class);
        }
        return DEFAULT_RESOURCES;
    }

    /**
     * Create the default loading indicator using the loading image in the
     * specified {@link Resources}.
     *
     * @param resources the resources containing the loading image
     * @return a widget loading indicator
     */
    private static Widget createDefaultLoadingIndicator(final Resources resources) {
        final ImageResource loadingImg = resources.dataGridLoading();
        if (loadingImg == null) {
            return null;
        }
        final com.google.gwt.user.client.ui.Image image = new Image(loadingImg);
        image.getElement().getStyle().setMarginTop(30.0, com.google.gwt.dom.client.Style.Unit.PX);
        return image;
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    public void setStriped(final boolean striped) {
        if (striped) {
            addToDataGrid(TableType.STRIPED);
        } else {
            removeFromDataGrid(TableType.STRIPED);
        }
    }

    public void setBordered(final boolean bordered) {
        if (bordered) {
            addToDataGrid(TableType.BORDERED);
        } else {
            removeFromDataGrid(TableType.BORDERED);
        }
    }

    public void setCondensed(final boolean condensed) {
        if (condensed) {
            addToDataGrid(TableType.CONDENSED);
        } else {
            removeFromDataGrid(TableType.CONDENSED);
        }
    }

    public void setHover(final boolean hover) {
        if (hover) {
            addToDataGrid(TableType.HOVER);
        } else {
            removeFromDataGrid(TableType.HOVER);
        }
    }

    private void addToDataGrid(final TableType tableType) {
        getTableHeadElement().getParentElement().addClassName(tableType.getCssName());
        getTableBodyElement().getParentElement().addClassName(tableType.getCssName());
        getTableFootElement().getParentElement().addClassName(tableType.getCssName());
    }

    private void removeFromDataGrid(final TableType tableType) {
        getTableHeadElement().getParentElement().removeClassName(tableType.getCssName());
        getTableBodyElement().getParentElement().removeClassName(tableType.getCssName());
        getTableFootElement().getParentElement().removeClassName(tableType.getCssName());
    }
}