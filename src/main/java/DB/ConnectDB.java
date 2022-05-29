package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB implements DatabaseInfo{
    private static ConnectDB instance;

    public ConnectDB() {
    }

    public Connection OpenConnection() throws Exception {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }
    //Get instance of dbms only one time
    public static ConnectDB getInstance(){
        if(instance==null) instance = new ConnectDB();
        return instance;
    }


}
