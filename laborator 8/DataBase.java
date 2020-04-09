import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static Connection conn=null;
    public static Connection create(String name,String pass)
    {
        if(conn==null)
        {
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:XE",name,pass);


            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }



        }
        return conn;
    }
}
