import java.sql.*;

public class Exemple {
	static Connection conn = null;
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "Sport";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";
	
	
	public static void main(String[] args)  {
	
	try {
	Class.forName(driver).newInstance();
	conn = DriverManager.getConnection(url+dbName,userName,password);
	System.out.println("connected to the database");
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("Select * from Sportif");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		conn.close();
		System.out.println("disconnected from the database");
	}
	}
	catch(Exception e) {e.printStackTrace();}
	
}
	

}