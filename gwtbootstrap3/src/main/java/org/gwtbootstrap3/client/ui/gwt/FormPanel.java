package org.gwtbootstrap3.client.ui.gwt;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.NamedFrame;

import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.DeviceSize;
import org.gwtbootstrap3.client.ui.constants.FormType;

public class FormPanel extends com.google.gwt.user.client.ui.FormPanel
        implements HasType<FormType>, HasResponsiveness {

    public FormPanel() {
        super();
    }

    public FormPanel(Element element, boolean createIFrame) {
        super(element, createIFrame);
    }

    public FormPanel(Element element) {
        super(element);
    }

    public FormPanel(NamedFrame frameTarget) {
        super(frameTarget);
    }

    public FormPanel(String target) {
        super(target);
    }

    @Override
    public void setType(final FormType type) {
        StyleHelper.addUniqueEnumStyleName(this, FormType.class, type);
    }

    @Override
    public FormType getType() {
        return FormType.fromStyleName(getStyleName());
    }

    @Override
    public void setVisibleOn(final DeviceSize deviceSize) {
        StyleHelper.setVisibleOn(this, deviceSize);
    }

    @Override
    public void setHiddenOn(final DeviceSize deviceSize) {
        StyleHelper.setHiddenOn(this, deviceSize);
    }

}
