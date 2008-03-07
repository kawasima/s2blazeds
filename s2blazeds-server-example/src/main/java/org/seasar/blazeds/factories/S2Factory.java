/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
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

import org.seasar.framework.container.SingletonS2Container;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;

/**
 * Seasar2用のコンポーネントのファクトリクラスです。
 * 
 * @version 1.0
 * @author higa
 */
public class S2Factory implements FlexFactory {

	private static final long serialVersionUID = 1L;

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
		return new FactoryInstance(this, id, configMap);
	}

	/**
	 * コンポーネントを見つけます。
	 * 
	 * @param factoryInstance
	 *            ファクトリインスタンス
	 * @return S2コンテナで管理されているコンポーネント
	 */

	public Object lookup(FactoryInstance factoryInstance) {
		String name = factoryInstance.getId();
		return SingletonS2Container.getComponent(name);
	}

	/**
	 * 
	 * 初期化のためのメソッドですが何もしません。
	 * 
	 * @param id
	 *            識別子
	 * @param configMap
	 *            コンポーネントの設定情報
	 */

	public void initialize(String id, ConfigMap configMap) {
	}

}