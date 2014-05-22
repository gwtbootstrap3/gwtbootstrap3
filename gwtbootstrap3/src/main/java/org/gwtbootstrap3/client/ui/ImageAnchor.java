package org.gwtbootstrap3.client.ui;

import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.ImageType;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * An anchor that contains an image as the click action, used in Media Objects
 *
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.MediaList
 */
public class ImageAnchor extends Anchor implements HasType<ImageType> {
    private final Image image = new Image();

    /**
     * Creates the base anchor with the image
     */
    public ImageAnchor() {
        add(image);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(final ImageType type) {
        StyleHelper.addEnumStyleName(this, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImageType getType() {
        return ImageType.fromStyleName(getStyleName());
    }

    /**
     * Set the image as responsive
     *
     * @param responsive boolean, whether or not the image has the responsive styles
     */
    public void setResponsive(final boolean responsive) {
        StyleHelper.toggleStyleName(this, responsive, Styles.IMG_RESPONSIVE);
    }

    /**
     * Set the image as a media object
     *
     * @param asMediaObject boolean, whether or not the image has the media object styles
     */
    public void setAsMediaObject(final boolean asMediaObject) {
        StyleHelper.toggleStyleName(this, asMediaObject, Styles.MEDIA_OBJECT);
    }

    /**
     * Set the URL of the image
     *
     * @param url String image url
     */
    public void setUrl(final String url) {
        image.setUrl(url);
    }

    /**
     * Gets the URL of the image
     *
     * @return String image url
     */
    public String getUrl() {
        return image.getUrl();
    }

    /**
     * Sets the alt text of the image
     *
     * @param alt String image alt text
     */
    public void setAlt(final String alt) {
        image.setAltText(alt);
    }

    /**
     * Gets the alt text of the image
     *
     * @return String image alt text
     */
    public String getAlt() {
        return image.getAltText();
    }
}
