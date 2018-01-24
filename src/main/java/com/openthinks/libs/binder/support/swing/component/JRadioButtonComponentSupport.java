/**   
 *  Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * @Title: JRadioButtonComponentSupport.java 
 * @Package binder.object.support.swing 
 * @Description: TODO
 * @author dailey  
 * @date 2012-3-18
 * @version V1.0   
 */
package com.openthinks.libs.binder.support.swing.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import com.openthinks.libs.binder.support.SupportUtilities;

/**
 * @author dailey
 * 
 */
public class JRadioButtonComponentSupport extends AbstractGroupFocusableComponentSupport<JRadioButton>
		implements ActionListener {

	public JRadioButtonComponentSupport(JRadioButton[] components, Object[] values) {
		super(components, values);
		init();
	}

	private void init() {
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < components.length; i++) {
			components[i].setText(SupportUtilities.convertToString(values[i]));
			components[i].addActionListener(this);
			group.add(components[i]);
		}
	}

	@Override
	public void setComponentValue(Object object) {
		for (int i = 0; i < values.length; i++) {
			if (values[i].equals(object)) {
				components[i].setSelected(true);
			} else {
				components[i].setSelected(false);
			}
		}
	}

	@Override
	public Object getComponentValue() {
		for (int i = 0; i < components.length; i++) {
			if (components[i].isSelected()) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	public void requestFocusComponent() {
		for (int i = 0; i < components.length; i++) {
			if (components[i].isSelected()) {
				components[i].requestFocus();
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateComponentModel();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// Nothing to do
	}

}
