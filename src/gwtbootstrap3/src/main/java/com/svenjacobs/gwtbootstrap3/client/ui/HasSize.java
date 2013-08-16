package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.constants.Size;

/**
 * @author Sven Jacobs
 */
public interface HasSize<T extends Size> {
    void setSize(T size);

    T getSize();
}
