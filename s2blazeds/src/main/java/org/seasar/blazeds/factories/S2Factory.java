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
 */
package org.seasar.blazeds.factories;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

import flex.messaging.FactoryInstance;
import flex.messaging.config.ConfigMap;
import flex.messaging.factories.JavaFactory;

/**
 * Seasar2用のコンポーネントのファクトリクラスです。
 * 
 * @version 1.0
 * @author higa
 */
public class S2Factory extends JavaFactory {

	/**
	 * ファクトリインスタンスを作成します。
	 * 
	 * @param id
	 *            識別子
	 * @param configMap
	 *            コンポーネントの設定情報
	 * @return FatoryInstance ファクトリインスタンス
	 * 
	 */
	public FactoryInstance createFactoryInstance(String id, ConfigMap configMap) {
		return new S2FactoryInstance(this, id, configMap);
	}

	/**
	 * コンポーネントを見つけます。
	 * 
	 * @param factoryInstance
	 *            ファクトリインスタンス
	 * @return S2コンテナで管理されているコンポーネント
	 */

	public Object lookup(FactoryInstance factoryInstance) {
		S2Container container = SingletonS2ContainerFactory.getContainer();
		if (container.hasComponentDef(factoryInstance.getId())) {
			return container.getComponent(factoryInstance.getId());
		}
		return super.lookup(factoryInstance);
	}
}