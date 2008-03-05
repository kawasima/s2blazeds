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

public class ColumnVO {

    private String name;
    private String type;
    private int size;
    private int decimals;
    private boolean nullable;

    public ColumnVO(String name, String type, int size, int decimals, boolean nullable) {
		this.name = name;
		this.type = type;
		this.size = size;
		this.decimals = decimals;
		this.nullable = nullable;
	}

	public int getDecimals() {
		return decimals;
	}

    public void setDecimals(int decimals) {
		this.decimals = decimals;
	}

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}

    public boolean isNullable() {
		return nullable;
	}

    public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

    public int getSize() {
		return size;
	}

    public void setSize(int size) {
		this.size = size;
	}

    public String getType() {
		return type;
	}

    public void setType(String type) {
		this.type = type;
	}
    
}