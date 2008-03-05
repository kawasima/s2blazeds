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

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseService {

    public List getDatabases() throws SQLException {
    	List databaseList = ConnectionHelper.getInstance().getAllDatabases();
    	
    	Iterator i = databaseList.iterator();
    	
    	while (i.hasNext())
    	{
    		Connection connection=null;
    		try {
    			DatabaseVO dbVO = (DatabaseVO)i.next();
	        	DatabaseMetaData metadata;
	            connection = ConnectionHelper.getInstance().getConnection(dbVO);
	            metadata = connection.getMetaData();
	            String[] types = {"TABLE"};
	            ResultSet tables = metadata.getTables(null, null, "%", types);
	        	List tableList = new ArrayList();
	        	while (tables.next())
	        	{
	        		String tableName = tables.getString("TABLE_NAME");
	            	ResultSet columns = metadata.getColumns(null, "%", tableName, "%");
	            	List columnList = new ArrayList();
	            	while (columns.next()) {
	            		columnList.add(new ColumnVO(
	            				columns.getString("COLUMN_NAME"),
	            				columns.getString("TYPE_NAME"),
	            				columns.getInt("COLUMN_SIZE"),
	            				columns.getInt("DECIMAL_DIGITS"),
	            				columns.getInt("NULLABLE") == 1));
	            	}
	            	tableList.add(new TableVO(tableName, columnList));
	        	}
	            dbVO.setTables(tableList);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        } finally {
	            try {
	                connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
    	}
    	return databaseList;
    }

    public List executeSQL(String databaseName, String databasePath, String sql) throws SQLException {

        List list=null;
        Connection connection=null;
        try {
            connection=ConnectionHelper.getInstance().getConnection(new DatabaseVO(databaseName,databasePath));
            Statement stmt=connection.createStatement();
            boolean result=stmt.execute(sql);
            if (result) {
                list=rsToList(stmt.getResultSet());
            } else {
                HashMap map=new HashMap();
                map.put("AffectedRows", new Integer(stmt.getUpdateCount()));
                list=new ArrayList();
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private List rsToList(ResultSet rs) throws SQLException {
        List list=new ArrayList();
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        HashMap row=null;
        while (rs.next()) {
            row=new HashMap();
            for (int i = 1; i <= colCount; i++) {
                row.put(rsmd.getColumnName(i), rs.getString(i));
            }
            list.add(row);
        }
        return list;
    }

}