package org.gwtbootstrap3.client.ui.gwt;

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

import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.TableType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ProvidesKey;

/**
 * @author Joshua Godi
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
     * @param keyProvider an instance of ProvidesKey, or null if the record
     *                    object should act as its own key
     */
    public DataGrid(final int pageSize, final ProvidesKey<T> keyProvider) {
        super(pageSize, getDefaultResources(), keyProvider);
        getTableBodyElement().getParentElement().addClassName(TableType.DEFAULT.getCssName());
    }

    /**
     * Constructs a table with the given page size with the specified
     * {@link Resources}.
     *
     * @param pageSize  the page size
     * @param resources the resources to use for this widget
     */
    public DataGrid(final int pageSize, final DataGrid.Resources resources) {
        super(pageSize, resources, null);
        getTableBodyElement().getParentElement().addClassName(TableType.DEFAULT.getCssName());
    }

    /**
     * Constructs a table with the given page size, the specified
     * {@link Resources}, and the given key provider.
     *
     * @param pageSize         the page size
     * @param resources        the resources to use for this widget
     * @param keyProvider      an instance of ProvidesKey, or null if the record
     *                         object should act as its own key
     * @param loadingIndicator the widget to use as a loading indicator, or null
     *                         to disable
     */
    public DataGrid(final int pageSize, final Resources resources, final ProvidesKey<T> keyProvider, final Widget loadingIndicator) {
        super(pageSize, resources, keyProvider, loadingIndicator);
        getTableBodyElement().getParentElement().addClassName(TableType.DEFAULT.getCssName());
    }

    /**
     * Constructs a table with a default page size of 50, and the given
     * {@link ProvidesKey key provider}.
     *
     * @param keyProvider an instance of ProvidesKey, or null if the record
     *                    object should act as its own key
     */
    public DataGrid(final ProvidesKey<T> keyProvider) {
        this(DEFAULT_PAGESIZE, keyProvider);
    }

    private static DataGrid.Resources getDefaultResources() {
        if (DEFAULT_RESOURCES == null) {
            final DataGrid.Resources dataGridResources = GWT.create(Resources.class);
            DEFAULT_RESOURCES = new ResourcesAdapter(dataGridResources);
        }
        return DEFAULT_RESOURCES;
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
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

    /**
     * Resources/Styles to remove the GWT styling of the tables!
     */
    private static class ResourcesAdapter implements DataGrid.Resources {
        private final DataGrid.Resources resources;
        private final StyleAdapter style;

        public ResourcesAdapter(final DataGrid.Resources resources) {
            this.resources = resources;
            this.style = new StyleAdapter();
        }

        @Override
        public ImageResource dataGridLoading() {
            return resources.dataGridLoading();
        }

        @Override
        public ImageResource dataGridSortAscending() {
            return resources.dataGridSortAscending();
        }

        @Override
        public ImageResource dataGridSortDescending() {
            return resources.dataGridSortDescending();
        }

        @Override
        public DataGrid.Style dataGridStyle() {
            return style;
        }
    }

    private static class StyleAdapter implements DataGrid.Style {
        private static final String B = "gwtb3-";
        private static final String DUMMY = B + "d";

        @Override
        public boolean ensureInjected() {
            return true;
        }

        @Override
        public String getText() {
            return B;
        }

        @Override
        public String getName() {
            return B;
        }

        @Override
        public String dataGridCell() {
            return B + "cell";
        }

        @Override
        public String dataGridEvenRow() {
            return "even";
        }

        @Override
        public String dataGridEvenRowCell() {
            return DUMMY;
        }

        @Override
        public String dataGridFirstColumn() {
            return DUMMY; // Bootstrap3 uses "smart selectors"
        }

        @Override
        public String dataGridFirstColumnFooter() {
            return DUMMY;
        }

        @Override
        public String dataGridFirstColumnHeader() {
            return DUMMY;
        }

        @Override
        public String dataGridFooter() {
            return DUMMY;
        }

        @Override
        public String dataGridHeader() {
            return DUMMY;
        }

        @Override
        public String dataGridHoveredRow() {
            return "active";
        }

        @Override
        public String dataGridHoveredRowCell() {
            return "active";
        }

        @Override
        public String dataGridKeyboardSelectedCell() {
            return DUMMY;
        }

        @Override
        public String dataGridKeyboardSelectedRow() {
            return DUMMY;
        }

        @Override
        public String dataGridKeyboardSelectedRowCell() {
            return DUMMY;
        }

        @Override
        public String dataGridLastColumn() {
            return DUMMY;
        }

        @Override
        public String dataGridLastColumnFooter() {
            return DUMMY;
        }

        @Override
        public String dataGridLastColumnHeader() {
            return DUMMY;
        }

        @Override
        public String dataGridOddRow() {
            return "odd";
        }

        @Override
        public String dataGridOddRowCell() {
            return DUMMY;
        }

        @Override
        public String dataGridSelectedRow() {
            return "info";
        }

        @Override
        public String dataGridSelectedRowCell() {
            return DUMMY;
        }

        @Override
        public String dataGridSortableHeader() {
            return DUMMY;
        }

        @Override
        public String dataGridSortedHeaderAscending() {
            return DUMMY;
        }

        @Override
        public String dataGridSortedHeaderDescending() {
            return DUMMY;
        }

        @Override
        public String dataGridWidget() {
            return "table";
        }
    }
}