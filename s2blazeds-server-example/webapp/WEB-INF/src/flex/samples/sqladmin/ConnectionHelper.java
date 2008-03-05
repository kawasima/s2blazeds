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

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.net.URLDecoder;

public class ConnectionHelper {
	
    private static ConnectionHelper instance;

    private ConnectionHelper() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionHelper getInstance() {
        if(instance==null)
            instance=new ConnectionHelper();
        return instance;
    }

    public Connection getConnection(DatabaseVO db) throws java.sql.SQLException {
    	try {
    		Connection connection = DriverManager.getConnection("jdbc:hsqldb:" + db.getPath() + "/" + db.getName());
            return connection; 
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    public List getAllDatabases() {
    	ArrayList databases = new ArrayList();
    	String rPath = getClass().getClassLoader().getResource("flex/samples/sqladmin").getPath();
    	try {
    		rPath = URLDecoder.decode(rPath,"UTF-8");
    	}
    	catch (Exception e)
    	{
    	}

    	File dbRootDir = new File(rPath.substring(0, rPath.indexOf("classes/flex/samples")) + "db/");
    	File[] dbDirs = dbRootDir.listFiles();
    	for (int i = 0; i < dbDirs.length; i++) {
    		DatabaseVO dbVO = new DatabaseVO(dbDirs[i].getName(),dbDirs[i].getPath());
    		File f = new File(dbVO.getPath() + "/" + dbVO.getName() + ".properties");
    		if (f.exists()) {
    			databases.add(dbVO);
    		}
    	}
    	return databases;
    }

}
