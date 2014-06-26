package org.gwtbootstrap3.client.ui;

import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.mixin.IdMixin;

public class FocusWidget extends com.google.gwt.user.client.ui.FocusWidget
        implements HasId {

	private final IdMixin<FocusWidget> idMixin = new IdMixin<FocusWidget>(this);

	@Override
	public void setId(String id) {
		idMixin.setId(id);
	}

	@Override
	public String getId() {
		return idMixin.getId();
	}

}
