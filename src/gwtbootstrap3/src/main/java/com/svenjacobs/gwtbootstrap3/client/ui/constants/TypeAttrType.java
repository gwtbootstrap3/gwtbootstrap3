package com.svenjacobs.gwtbootstrap3.client.ui.constants;

/**
 * Represents values for the {@code type=""} HTML attribute.
 *
 * @author Sven Jacobs
 */
public enum TypeAttrType implements Type {
    BUTTON("button"),
    SUBMIT("submit"),
    TEXT("text"),
    RADIO("radio"),
    CHECKBOX("checkbox");

    private final String inputType;

    private TypeAttrType(final String inputType) {
        this.inputType = inputType;
    }

    public String getInputType() {
        return inputType;
    }
}
