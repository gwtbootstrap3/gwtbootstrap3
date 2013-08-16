package com.svenjacobs.gwtbootstrap3.client.ui.constants;

/**
 * @author Sven Jacobs
 */
public enum Spy {
    SCROLL("scroll"),
    AFFIX("affix");

    private final String spy;

    private Spy(final String spy) {
        this.spy = spy;
    }

    public String getSpy() {
        return spy;
    }
}
