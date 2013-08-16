package com.svenjacobs.gwtbootstrap3.client.ui.constants;

/**
 * @author Sven Jacobs
 */
public enum Toggle {
    BUTTON("button"),
    BUTTONS("buttons"),
    DROPDOWN("dropdown"),
    MODAL("modal");

    private final String toggle;

    private Toggle(final String toggle) {
        this.toggle = toggle;
    }

    public String getToggle() {
        return toggle;
    }
}
