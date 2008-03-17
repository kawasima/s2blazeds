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

import java.util.List;

/**
 * データベースのメタデータ用のDTOです。
 * 
 */
public class DatabaseDto {

	/**
	 * 名前です。
	 */
	public String name;

	/**
	 * パスです。
	 */
	public String path;

	/**
	 * テーブルのメタデータのリストです。
	 */
	public List<TableDto> tables;
}