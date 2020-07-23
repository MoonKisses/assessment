
package model.dao;

import java.sql.Connection;

/**
 *
 * @author webdevelopacc
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/bookdb";//replace this string with your jdbc:derby local host url   
    protected String db = "bookdb";//name of the database   
    protected String dbuser = "bookuser";//db root user   
    protected String dbpass = "admin"; //db root password   
    protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
    protected Connection conn; //connection null-instance to be initialized in sub-classes
}