package Com.FirstAutomation.TestScripts;

import java.sql.SQLException;

import org.testng.annotations.Test;

import Com.FirstAutomation.Database.DatabaseConnections;
import Com.FirstAutomation.Database.SQLqueries;

public class DBtestcases {

	@Test
	public void employeetablevalidation() throws ClassNotFoundException, SQLException {

		DatabaseConnections DatabaseConnectionsref = new DatabaseConnections();
		DatabaseConnectionsref.getconnection();
		System.out.println("**************" + "MySQL establisehd successfully");

		DatabaseConnectionsref.gettablerecords(SQLqueries.employeequery);

	}

}
