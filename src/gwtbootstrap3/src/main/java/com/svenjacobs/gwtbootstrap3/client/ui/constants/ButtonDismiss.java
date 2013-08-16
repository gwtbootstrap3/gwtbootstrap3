package com.svenjacobs.gwtbootstrap3.client.ui.constants;

/**
 * @author Sven Jacobs
 */
public enum ButtonDismiss {
    MODAL("modal"),
    ALERT("alert");

    private final String dismiss;

    private ButtonDismiss(final String dismiss) {
        this.dismiss = dismiss;
    }

    public String getDismiss() {
        return dismiss;
    }
}
