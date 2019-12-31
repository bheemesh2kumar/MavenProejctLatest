package Com.FirstAutomation.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.FirstAutomation.Utilities.ReadConfigUtility;

public class DatabaseConnections

{
	Connection con = null;
	ResultSet rs;

	ReadConfigUtility ReadConfigUtilityref = new ReadConfigUtility();

	public Connection getconnection() throws ClassNotFoundException, SQLException {

		con = getconnection(ReadConfigUtilityref.getDriver(), ReadConfigUtilityref.geturl(),
				ReadConfigUtilityref.getdbusername(), ReadConfigUtilityref.getdbpwd());
		return con;
	}

	public Connection getconnection(String Drivername, String conurl, String username, String pwd)
			throws ClassNotFoundException, SQLException {
		Class.forName(Drivername);

		System.out.println("*************" + "My Driver is loaded");
		con = DriverManager.getConnection(conurl, username, pwd);

		return con;

	}

	public void gettablerecords(String query) throws ClassNotFoundException, SQLException {

		// Connection con = getconnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next())

		{

			int colcount = rs.getMetaData().getColumnCount();

			for (int i = 1; i < colcount; i++) {
				System.out.print(rs.getObject(i));
				System.out.print(" ");
			}

			System.out.println();

		}

		System.out.println("All table records are printed successfully");

	}

	public ResultSet gettablerecordsasresultset(String query) throws ClassNotFoundException, SQLException {

		con = getconnection();
		System.out.println("**************" + "MySQL establisehd successfully");
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);

		return rs;

	}

}
