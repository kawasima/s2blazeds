////////////////////////////////////////////////////////////////////////////////
//
// Copyright (C) 2003-2007 Adobe Systems Incorporated
// All Rights Reserved.
// The following is Sample Code and is subject to all restrictions on such code
// as contained in the End User License Agreement accompanying this product.
// If you have received this file from a source other than Adobe,
// then your use, modification, or distribution of it requires
// the prior written permission of Adobe.
//
////////////////////////////////////////////////////////////////////////////////
package flex.samples.dto;

import java.io.Serializable;

/**
 * カラムのメタデータ用のDTOです。
 * 
 */
public class ColumnDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 名前です。
	 */
	public String name;

	/**
	 * 型の名前です。
	 */
	public String type;

	/**
	 * サイズです。
	 */
	public int size;

	/**
	 * 小数点以下の桁数です
	 */
	public int decimals;

	/**
	 * nullが可能かどうかです。
	 */
	public boolean nullable;
}