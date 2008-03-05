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
package flex.samples.sqladmin;

import java.util.List;

public class TableVO {

    private String name;
    private List columns;
    
    public TableVO(String name, List columns) {
		this.name = name;
		this.columns = columns;
	}

	public List getColumns() {
		return columns;
	}

    public void setColumns(List columns) {
		this.columns = columns;
	}

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}
    
}