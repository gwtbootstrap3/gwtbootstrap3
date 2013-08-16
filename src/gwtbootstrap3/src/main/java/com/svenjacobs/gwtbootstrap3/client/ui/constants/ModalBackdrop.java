package com.svenjacobs.gwtbootstrap3.client.ui.constants;

/**
 * @author Sven Jacobs
 */
public enum ModalBackdrop {
    /**
     * Shows backdrop (greyed out background).
     */
    TRUE("true"),

    /**
     * Don't show backdrop.
     */
    FALSE("false"),

    /**
     * Show a static backdrop (modal won't be closed when user clicks on backdrop).
     */
    STATIC("static");

    private final String backdrop;

    private ModalBackdrop(final String backdrop) {
        this.backdrop = backdrop;
    }

    public String getBackdrop() {
        return backdrop;
    }
}
