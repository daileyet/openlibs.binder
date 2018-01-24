package com.openthinks.libs.binder.action.support;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * Action event for one control, it usually likes
 * {@link MouseEvent}, {@link ActionEvent} User can
 * implements by its owner event.
 * 
 * @author dailey
 *
 */
public interface ActionSupportEvent {

	public ActionSupport getActionSupport(Object component);

}
