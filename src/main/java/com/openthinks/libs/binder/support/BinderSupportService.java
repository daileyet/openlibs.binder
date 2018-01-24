package com.openthinks.libs.binder.support;

import com.openthinks.libs.binder.action.support.ActionSupport;
import com.openthinks.libs.binder.action.support.ActionSupportEvent;
import com.openthinks.libs.binder.component.support.ComponentSupport;

/**
 * action binder and component binder support interface
 * 
 * @author dailey
 *
 */
public interface BinderSupportService {

	/**
	 * create single component support
	 * 
	 * @param component
	 *            UI component
	 * @return ComponentSupport {@link ComponentSupport}
	 */
	public ComponentSupport createComponentSupport(Object component);

	/**
	 * create component with options support
	 * 
	 * @param component
	 *            list style UI component
	 * @param optionals
	 *            optional values
	 * @return ComponentSupport {@link ComponentSupport}
	 */
	public ComponentSupport createListableComponentSupport(Object component, Object[] optionals);

	/**
	 * create a group of component support
	 * 
	 * @param buttons
	 *            group style UI component
	 * @param optionals
	 *            optional values
	 * @return ComponentSupport {@link ComponentSupport}
	 */
	public ComponentSupport createGroupableComponentSupport(Object[] buttons, Object[] optionals);

	/**
	 * create action support for component by action event
	 * 
	 * @param component
	 *            UI component
	 * @param event
	 *            {@link ActionSupportEvent}
	 * @return ActionSupport {@link ActionSupport}
	 */
	public ActionSupport createActionSupport(Object component, ActionSupportEvent event);
}
