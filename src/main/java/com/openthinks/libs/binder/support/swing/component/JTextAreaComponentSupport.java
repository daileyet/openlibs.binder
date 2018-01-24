package com.openthinks.libs.binder.support.swing.component;

import javax.swing.JTextArea;

import com.openthinks.libs.binder.support.SupportUtilities;

public class JTextAreaComponentSupport extends AbstractSingleFocusableComponentSupport<JTextArea> {

	public JTextAreaComponentSupport(JTextArea component) {
		super(component);
	}

	@Override
	public void setComponentValue(Object object) {
		getComponent().setText(SupportUtilities.convertToString(object));
	}

	@Override
	public Object getComponentValue() {
		return getComponent().getText();
	}

}
