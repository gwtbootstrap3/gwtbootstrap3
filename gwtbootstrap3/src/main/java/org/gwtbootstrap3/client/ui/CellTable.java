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
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.TableType;

/**
 * @author godi
 */
public class CellTable<T> extends com.google.gwt.user.cellview.client.CellTable<T> implements HasResponsiveness {
    private static final int DEFAULT_PAGESIZE = 15;
    private static Resources DEFAULT_RESOURCES;

    /**
     * Constructs a table with a default page size of 15.
     */
    public CellTable() {
        this(DEFAULT_PAGESIZE);
    }

    /**
     * Constructs a table with the given page size.
     *
     * @param pageSize the page size
     */
    public CellTable(final int pageSize) {
        this(pageSize, getDefaultResources());
    }

    /**
     * Constructs a table with a default page size of 15, and the given
     * {@link ProvidesKey key provider}.
     *
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public CellTable(final ProvidesKey<T> keyProvider) {
        this(DEFAULT_PAGESIZE, keyProvider);
    }

    /**
     * Constructs a table with the given page size with the specified
     * {@link Resources}.
     *
     * @param pageSize  the page size
     * @param resources the resources to use for this widget
     */
    public CellTable(final int pageSize, final Resources resources) {
        this(pageSize, resources, null);
    }

    /**
     * Constructs a table with the given page size and the given
     * {@link ProvidesKey key provider}.
     *
     * @param pageSize    the page size
     * @param keyProvider an instance of ProvidesKey<T>, or null if the record
     *                    object should act as its own key
     */
    public CellTable(final int pageSize, final ProvidesKey<T> keyProvider) {
        this(pageSize, getDefaultResources(), keyProvider);
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
    public CellTable(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider) {
        this(pageSize, resources, keyProvider, createDefaultLoadingIndicator(resources));
    }

    /**
     * Constructs a table with the specified page size, {@link Resources}, key
     * provider, and loading indicator.
     *
     * @param pageSize         the page size
     * @param resources        the resources to use for this widget
     * @param keyProvider      an instance of ProvidesKey<T>, or null if the record
     *                         object should act as its own key
     * @param loadingIndicator the widget to use as a loading indicator, or null
     *                         to disable
     */
    public CellTable(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider,
                     final Widget loadingIndicator) {
        this(pageSize, resources, keyProvider, loadingIndicator, true, true);
    }

    /**
     * Constructs a table with the specified page size, {@link Resources}, key
     * provider, and loading indicator.
     *
     * @param pageSize           the page size
     * @param resources          the resources to use for this widget
     * @param keyProvider        an instance of ProvidesKey<T>, or null if the record
     *                           object should act as its own key
     * @param loadingIndicator   the widget to use as a loading indicator, or null
     *                           to disable
     * @param enableColGroup     enable colgroup element. This is used when the table is using fixed
     *                           layout and when column style is added. Ignoring this element will boost rendering
     *                           performance. Note that when colgroup is disabled, {@link #setColumnWidth}
     * @param attachLoadingPanel attaching the table section that contains the empty table widget and
     *                           the loading indicator. Attaching this to the table significantly improve the rendering
     *                           performance in webkit based browsers but also introduces significantly larger latency
     *                           in IE. If the panel is not attached to the table, it won't be displayed. But the user
     *                           can call {@link #getTableLoadingSection} and attach it to other elements outside the
     *                           table element
     */
    public CellTable(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider,
                     final Widget loadingIndicator, final boolean enableColGroup, final boolean attachLoadingPanel) {
        super(pageSize, resources, keyProvider, loadingIndicator, enableColGroup, attachLoadingPanel);
        StyleHelper.addEnumStyleName(this, TableType.DEFAULT);
    }

    /**
     * Create the default loading indicator using the loading image in the
     * specified {@link Resources}.
     *
     * @param resources the resources
     * @return a widget loading indicator
     */
    private static Widget createDefaultLoadingIndicator(final Resources resources) {
        final ImageResource loadingImg = resources.cellTableLoading();
        return (loadingImg == null) ? null : new com.google.gwt.user.client.ui.Image(loadingImg);
    }

    private static Resources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            DEFAULT_RESOURCES = GWT.create(Resources.class);
        }
        return DEFAULT_RESOURCES;
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
            StyleHelper.addEnumStyleName(this, TableType.STRIPED);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.STRIPED);
        }
    }

    public void setBordered(final boolean bordered) {
        if (bordered) {
            StyleHelper.addEnumStyleName(this, TableType.BORDERED);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.BORDERED);
        }
    }

    public void setCondensed(final boolean condensed) {
        if (condensed) {
            StyleHelper.addEnumStyleName(this, TableType.CONDENSED);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.CONDENSED);
        }
    }

    public void setHover(final boolean hover) {
        if (hover) {
            StyleHelper.addEnumStyleName(this, TableType.HOVER);
        } else {
            StyleHelper.removeEnumStyleName(this, TableType.HOVER);
        }
    }
}
