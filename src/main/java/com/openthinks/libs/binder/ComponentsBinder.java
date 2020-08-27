package com.openthinks.libs.binder;

import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.beans.VetoableChangeListener;
import java.util.concurrent.ConcurrentHashMap;

import com.openthinks.libs.binder.component.ComponentBinder;
import com.openthinks.libs.binder.component.support.ComponentSupport;
import com.openthinks.libs.binder.support.BinderSupportFactory;
import com.openthinks.libs.binder.support.PropertyChangeSupportted;

/**
 * 
 * @author dailey
 *
 */
public class ComponentsBinder {
	private Object binderBean = null;
	private ConcurrentHashMap<String, ComponentBinder> binderMapping = null;

	/**
	 * 
	 * @param binderBean
	 *            Object model data object
	 */
	public ComponentsBinder(Object binderBean) {
		this.binderBean = binderBean;
		binderMapping = new ConcurrentHashMap<String, ComponentBinder>();
		init();
	}

	private void init() {
		if (binderBean instanceof PropertyChangeSupportted) {
			PropertyChangeSupportted propertyChangeSupportted = (PropertyChangeSupportted) binderBean;
			propertyChangeSupportted.addPropertyChangeListener(new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					String property = evt.getPropertyName();
					ComponentBinder componentBinder = binderMapping.get(property);
					if (componentBinder != null) {
						componentBinder.loadProperty(evt.getNewValue());
					}
				}
			});
		}
	}

	/**
	 * bind a control to model object property value, it usually us for
	 * TextBaseControl; such as
	 * {@linkplain javax.swing.JTextField},{@linkplain javax.swing.JTextArea} etc.
	 * It usually update model corresponding property value after control focus
	 * lost. Also model object can add {@linkplain PropertyChangeListener} or
	 * {@link VetoableChangeListener} for itself.
	 * 
	 * @param property
	 *            property name in binder model object
	 * @param component
	 *            the UI control need bind to model object one property value
	 * @throws IntrospectionException
	 *             if an exception occurs during introspection.
	 */
	public void bindProperty(String property, Object component) throws IntrospectionException {
		PropertyDescriptor pd = new PropertyDescriptor(property, binderBean.getClass());
		binderMapping.put(property,
				new ComponentBinder(binderBean, pd, BinderSupportFactory.createComponentSupport(component)));
	}

	/**
	 * bind a control to model object property value, it usually us for Control has
	 * options; such as {@linkplain javax.swing.JComboBox} or
	 * {@linkplain javax.swing.JList} etc.
	 * 
	 * @param property
	 *            property name in binder model object
	 * @param component
	 *            the UI control need bind to model object one property value
	 * @param optionals
	 *            the initial values for control's options
	 * @throws IntrospectionException
	 *             if an exception occurs during introspection.
	 */
	public void bindProperty(String property, Object component, Object[] optionals) throws IntrospectionException {
		PropertyDescriptor pd = new PropertyDescriptor(property, binderBean.getClass());
		binderMapping.put(property,
				new ComponentBinder(binderBean, pd, BinderSupportFactory.createComponentSupport(component, optionals)));
	}

	/**
	 * bind a {@link ComponentSupport} to model object property value, it usually us
	 * for customized;
	 * 
	 * @param property
	 *            property name in binder model object
	 * @param componentSupport
	 *            {@link ComponentSupport}
	 * @throws IntrospectionException
	 *             if an exception occurs during introspection.
	 */
	public void bindProperty(String property, ComponentSupport componentSupport) throws IntrospectionException {
		PropertyDescriptor pd = new PropertyDescriptor(property, binderBean.getClass());
		binderMapping.put(property, new ComponentBinder(binderBean, pd, componentSupport));
	}

	/**
	 * bind a group of same type controls to model object property value, it usually
	 * us for a group check box or radio button ; such as
	 * {@linkplain javax.swing.JCheckBox}, {@linkplain javax.swing.JRadioButton}
	 * etc. Make sure the components and values have the same length. All the Radio
	 * buttons' text will be set from the optionals input.
	 * 
	 * @param property
	 *            property name in binder model object
	 * @param components
	 *            a group of same type control
	 * @param values
	 *            corresponding every control initial value
	 * @throws IntrospectionException
	 *             if an exception occurs during introspection.
	 */
	public void bindProperty(String property, Object[] components, Object[] values) throws IntrospectionException {
		PropertyDescriptor pd = new PropertyDescriptor(property, binderBean.getClass());
		binderMapping.put(property,
				new ComponentBinder(binderBean, pd, BinderSupportFactory.createComponentSupport(components, values)));
	}

	/**
	 * refresh model object, and get its bind property's value to update all binded
	 * control view
	 */
	public void loadProperties() {
		for (ComponentBinder binder : binderMapping.values()) {
			binder.loadProperty();
		}
	}
}
