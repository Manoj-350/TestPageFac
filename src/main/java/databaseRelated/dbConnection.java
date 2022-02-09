package databaseRelated;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		
public class  dbConnection {				
	
/*	public static void sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException
{
  InetAddress geek = InetAddress.getByName(ipAddress);
  System.out.println("Sending Ping Request to " + ipAddress);
  if (geek.isReachable(5000))
    System.out.println("Host is reachable");
  else
    System.out.println("Sorry ! We can't reach to this host");
}
	*/
	
	public static void  main(String[] args) throws  ClassNotFoundException, SQLException, UnknownHostException, IOException {	
		// String ipAddress = "127.0.0.1";
		    //sendPingRequest(ipAddress);
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name" 		
		String dbUrl = "jdbc:mysql://localhost:3036/demo";					

		//Database Username		
		String username = "root";	

		//Database Password		
		String password = "Mady@9868";				

		//Query to Execute		
		String query = "select *  from emp;";	

		//Load mysql jdbc driver		
		Class.forName("com.mysql.cj.jdbc.Driver");			

		//Create Connection to DB		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=Mady@9868");
//Connection con=DriverManager.getConnection(dbUrl, username, password);
		//Create Statement Object		
		Statement stmt = con.createStatement();					

		// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);							

		// While Loop to iterate through all data and print results		
		while (rs.next()){
			String Rollno = rs.getString(1);								        
			String name = rs.getString(2);	
			String c3=rs.getString(3);
			String c4=rs.getString(4);
			String c5=rs.getString(5);
			String c6=rs.getString(6);
			System. out.println(Rollno+"  "+name+" "+c3+" "+c4+" "+c5+" "+c6);		
		}		
		// closing DB Connection		
		con.close();			
	}
}