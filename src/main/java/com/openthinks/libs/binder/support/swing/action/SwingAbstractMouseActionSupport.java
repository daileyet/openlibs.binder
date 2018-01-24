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
* @Title: SwingAbstractMouseActionSupport.java 
* @Package binder.action.support.swing 
* @Description: TODO
* @author dailey  
* @date 2012-3-20
* @version V1.0   
*/
package com.openthinks.libs.binder.support.swing.action;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.openthinks.libs.binder.action.support.AbstractActionSupport;

/**
 * @author dailey
 *
 */
public abstract class SwingAbstractMouseActionSupport extends AbstractActionSupport
		implements MouseListener, MouseMotionListener, MouseWheelListener {

	public SwingAbstractMouseActionSupport(Object actionComponent) {
		super(actionComponent, SwingActionEvent.MOUSE_CLICK_ACTION);
	}

	@Override
	protected void registerActionListener(Object component) {
		if (component instanceof Component) {
			Component c = (Component) component;
			c.addMouseListener(this);
		}

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
