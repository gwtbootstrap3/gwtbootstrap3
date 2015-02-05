package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.gwtbootstrap3.client.ui.base.button.CloseButton;
import org.gwtbootstrap3.client.ui.constants.ButtonDismiss;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import com.google.gwt.dom.client.Element;

/**
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see Modal
 */
public class ModalHeader extends FlowPanel implements ModalComponent, IsClosable {

    private final Heading heading = new Heading(HeadingSize.H4);
    private final CloseButton closeButton = new CloseButton();

    public ModalHeader() {
        setStyleName(Styles.MODAL_HEADER);

        heading.setStyleName(Styles.MODAL_TITLE);
        closeButton.setDataDismiss(ButtonDismiss.MODAL);

        add(closeButton);
    }

    @Override
    public void setTitle(final String title) {
        heading.setText(title);

        if (heading.getParent() == null) {
            add(heading);
        }
    }

    @Override
    public void setClosable(final boolean closable) {
        if (closable) {
            insert(closeButton, (Element) getElement(), 0, true);
        } else {
            closeButton.removeFromParent();
        }
    }

    @Override
    public boolean isClosable() {
        return closeButton.getParent() != null;
    }
}
