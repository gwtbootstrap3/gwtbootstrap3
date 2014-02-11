package org.gwtbootstrap3.client.shared.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.ui.TabListItem;

/**
 * @author godi
 */
public class TabShowEvent extends GwtEvent<TabShowHandler> implements TabEvent {

    private static final Type<TabShowHandler> TYPE = new Type<TabShowHandler>();

    private final TabListItem tab;
    private final Event nativeEvent;

    public static Type<TabShowHandler> getType() {
        return TYPE;
    }

    public TabShowEvent(final TabListItem tab, final Event nativeEvent) {
        this.tab = tab;
        this.nativeEvent = nativeEvent;
    }

    @Override
    public TabListItem getTab() {
        return tab;
    }

    @Override
    public Event getNativeEvent() {
        return nativeEvent;
    }

    @Override
    public Type<TabShowHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final TabShowHandler handler) {
        handler.onShow(this);
    }
}