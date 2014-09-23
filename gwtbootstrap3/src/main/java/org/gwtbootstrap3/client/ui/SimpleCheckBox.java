package org.gwtbootstrap3.client.ui;

import org.gwtbootstrap3.client.ui.base.HasFormValue;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.EnabledMixin;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A simple checkbox widget, with no label.
 */
public class SimpleCheckBox extends com.google.gwt.user.client.ui.SimpleCheckBox implements HasResponsiveness, HasId,
        HasPull, HasFormValue {

    /**
     * Creates a SimpleCheckBox widget that wraps an existing &lt;input
     * type='checkbox'&gt; element.
     * 
     * This element must already be attached to the document. If the element is
     * removed from the document, you must call
     * {@link RootPanel#detachNow(Widget)}.
     * 
     * @param element
     *            the element to be wrapped
     */
    public static SimpleCheckBox wrap(Element element) {
        // Assert that the element is attached.
        assert Document.get().getBody().isOrHasChild(element);

        SimpleCheckBox checkBox = new SimpleCheckBox(InputElement.as(element));

        // Mark it attached and remember it for cleanup.
        checkBox.onAttach();
        RootPanel.detachOnWindowClose(checkBox);

        return checkBox;
    }

    private final IdMixin<SimpleCheckBox> idMixin = new IdMixin<SimpleCheckBox>(this);
    private final PullMixin<SimpleCheckBox> pullMixin = new PullMixin<SimpleCheckBox>(this);
    private final EnabledMixin<SimpleCheckBox> enabledMixin = new EnabledMixin<SimpleCheckBox>(this);

    /**
     * Creates a new simple checkbox.
     */
    public SimpleCheckBox() {
        super(Document.get().createCheckInputElement());
    }

    /**
     * This constructor may be used by subclasses to explicitly use an existing
     * element. This element must be an &lt;input&gt; element whose type is
     * 'checkbox'.
     * 
     * @param element
     *            the element to be used
     */
    protected SimpleCheckBox(InputElement element) {
        super(element);
    }

    @Override
    public void setEnabled(boolean enabled) {
        enabledMixin.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return enabledMixin.isEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final String id) {
        idMixin.setId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return idMixin.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

}
