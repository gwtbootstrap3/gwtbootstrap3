package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

import com.google.gwt.user.client.ui.HasText;
import com.svenjacobs.gwtbootstrap3.client.ui.HasIcon;
import com.svenjacobs.gwtbootstrap3.client.ui.HasIconPosition;
import com.svenjacobs.gwtbootstrap3.client.ui.Icon;
import com.svenjacobs.gwtbootstrap3.client.ui.base.Text;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.IconPosition;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.IconType;

/**
 * Base class for buttons that can contain an icon.
 *
 * @author Sven Jacobs
 * @see Icon
 */
public abstract class AbstractIconButton extends AbstractButton implements HasText, HasIcon, HasIconPosition {

    final Text text = new Text();
    Icon icon;
    IconPosition iconPosition = IconPosition.LEFT;

    protected AbstractIconButton() {
    }

    protected AbstractIconButton(final ButtonType type) {
        super(type);
    }

    @Override
    public void setText(final String text) {
        this.text.setText(" " + text + " ");
    }

    @Override
    public String getText() {
        return text.getText();
    }

    @Override
    public void setIcon(final IconType iconType) {
        render(new Icon(iconType));
    }

    @Override
    public IconType getIcon() {
        return icon == null ? null : icon.getType();
    }

    @Override
    public void setIconPosition(final IconPosition iconPosition) {
        this.iconPosition = iconPosition;
        render(icon);
    }

    @Override
    public IconPosition getIconPosition() {
        return iconPosition;
    }

    private void render(final Icon newIcon) {
        text.removeFromParent();

        if (icon != null) {
            icon.removeFromParent();
        }

        icon = newIcon;

        if (iconPosition == IconPosition.LEFT) {
            add(icon, getElement());
        }

        add(text, getElement());

        if (iconPosition == IconPosition.RIGHT) {
            add(icon, getElement());
        }
    }
}
