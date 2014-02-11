package org.gwtbootstrap3.client.shared.event;

import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.ui.TabListItem;

/**
 * @author godi
 */
public interface TabEvent {
    TabListItem getTab();

    Event getNativeEvent();
}
