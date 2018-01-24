package com.openthinks.libs.binder.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

import com.openthinks.libs.binder.action.support.ActionSupport;

/**
 * link {@link ActionSupport} to a method in action bean
 * 
 * @author dailey
 *
 */
public class ActionBinder implements Observer {
	private Object actionObject = null;
	private Method method = null;

	public ActionBinder(Object actionObject, Method method, Observable trigger) {
		this.actionObject = actionObject;
		this.method = method;
		trigger.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			method.invoke(actionObject);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
