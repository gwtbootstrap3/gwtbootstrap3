package com.svenjacobs.gwtbootstrap3.client.ui;

import com.svenjacobs.gwtbootstrap3.client.ui.constants.ValidationState;

/**
 * @author Sven Jacobs
 */
public interface HasValidationState {
    void setValidationState(ValidationState state);

    ValidationState getValidationState();
}
