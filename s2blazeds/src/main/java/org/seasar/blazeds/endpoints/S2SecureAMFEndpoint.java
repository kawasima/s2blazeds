/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */package org.seasar.blazeds.endpoints;

import org.seasar.framework.util.Disposable;

/**
 * Seasar2用のSecureAMFEndpointです。
 * 
 * @version 1.0.2 
 * @author nod
 *
 */
public class S2SecureAMFEndpoint extends S2AMFEndpoint implements Disposable {

	/**
	 * コンストラクタです。
	 */
	public S2SecureAMFEndpoint() {
	}

	/**
	 * コンストラクタです。
	 * 
	 * @param enableManagement
	 *            JMXによる管理を可能にするかどうか
	 */
	public S2SecureAMFEndpoint(boolean enableManagement) {
		super(enableManagement);
		registerDisposable();
	}
    /**
     * このEndpointがSecureであるか、そうでないかを決定します。
     *
     * @return <code>true</code>.
     */
    public boolean isSecure()
    {
        return true;
    }
}
