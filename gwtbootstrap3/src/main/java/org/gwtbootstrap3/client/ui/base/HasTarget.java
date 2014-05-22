package org.gwtbootstrap3.client.ui.base;

/**
 * Simple interface that will set/get the objects 'target' attribute
 *
 * <b:Anchor target="_blank"/>
 *
 * Anchor anchor = new Anchor();
 * anchor.setTarget(BLANK);
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.constants.Attributes
 */
public interface HasTarget {
    public static final String BLANK = "_blank";

    /**
     * Set the target attribute of the object
     *
     * @param target target attribute
     */
    void setTarget(String target);

    /**
     * Get the target attribute of the object
     *
     * @return target attribute
     */
    String getTarget();
}
