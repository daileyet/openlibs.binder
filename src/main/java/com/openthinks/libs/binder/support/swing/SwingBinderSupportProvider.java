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
 * @Title: SwingBinderSupportProvider.java 
 * @Package binder.swing 
 * @Description: TODO
 * @author dailey_dai  
 * @date Mar 21, 2012
 * @version V1.0   
 */
package com.openthinks.libs.binder.support.swing;

import com.openthinks.libs.binder.support.BinderSupportManager;
import com.openthinks.libs.binder.support.BinderSupportProvider;
import com.openthinks.libs.binder.support.BinderSupportService;


/**
 * @author dailey_dai
 * 
 */
public class SwingBinderSupportProvider implements BinderSupportProvider {
	/**
	 * register self as default provider
	 */
	static {
		BinderSupportManager
				.registerDefaultProvider(new SwingBinderSupportProvider());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see binder.BinderSupportProvider#newBinderSupportService()
	 */
	@Override
	public BinderSupportService newBinderSupportService() {
		return new SwingBinderSupportService();
	}

	private SwingBinderSupportProvider() {
	}

}
