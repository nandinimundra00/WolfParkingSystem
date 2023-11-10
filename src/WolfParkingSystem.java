import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class WolfParkingSystem{
public static void main(String args[]) {
Connection conn = null;
String url = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/";
String user = "nmundra";
String pswd = "200475534";
try {
conn = DriverManager.getConnection(url, user, pswd);
} catch (SQLException e){
e.printStackTrace();
} finally {
close(conn);}
System.out.println("Successfully connected to DB");
}

static void close(Connection connection) {
if(connection != null) {
try {
connection.close();
} catch(Throwable whatever) {}
}
}
}

