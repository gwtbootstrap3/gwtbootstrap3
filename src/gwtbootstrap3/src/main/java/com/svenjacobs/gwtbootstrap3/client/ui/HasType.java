package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.constants.Type;

/**
 * @author Sven Jacobs
 */
public interface HasType<T extends Type> {
    void setType(T type);

    T getType();
}
