

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class link {
    public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con=DriverManager.getConnection("jdbc:derby://localhost:1527/student","root","root");
			System.out.println("Connection Successful");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Exception:"+cnfe);
		}
		catch(SQLException se){
			System.out.println("Exception:"+se);
		}
		return con;
	}
    public static void main(String[] a){
        getConnection();
    }
}

