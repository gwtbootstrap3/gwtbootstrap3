package org.gwtbootstrap3.client.ui.constants;

/**
 * @author Joshua Godi
 */
public enum HeadingSize implements Size {
    H1(1),
    H2(2),
    H3(3),
    H4(4),
    H5(5),
    H6(6);

    private final int headingSize;

    HeadingSize(int headingSize) {
        this.headingSize = headingSize;
    }

    public int getHeadingSize() {
        return headingSize;
    }
}