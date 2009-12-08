/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
 */
package org.seasar.blazeds.factories;

import flex.messaging.FlexConfigurable;
import flex.messaging.config.ConfigMap;
import flex.messaging.factories.JavaFactory;
import flex.messaging.factories.JavaFactoryInstance;
import flex.messaging.util.ClassUtil;

/**
 * Seasar2用のファクトリインスタンスです。
 * 
 * @version 1.0
 * @author higa
 * 
 */
public class S2FactoryInstance extends JavaFactoryInstance {

	/**
	 * コンストラクタです。
	 * 
	 * @param factory
	 *            Javaファクトリ
	 * @param id
	 *            識別子
	 * @param properties
	 *            コンポーネントの設定情報
	 */
	public S2FactoryInstance(JavaFactory factory, String id,
			ConfigMap properties) {
		super(factory, id, properties);
	}

	public Object createInstance() {
		Class clazz = getInstanceClass();
		if (clazz == null) {
			return null;
		}
		Object inst = ClassUtil.createDefaultInstance(clazz, null);
		if (inst instanceof FlexConfigurable)
			((FlexConfigurable) inst).initialize(getId(), getProperties());

		return inst;
	}

	public Class getInstanceClass() {
		if (getSource() == null) {
			return null;
		}
		return super.getInstanceClass();
	}
}
