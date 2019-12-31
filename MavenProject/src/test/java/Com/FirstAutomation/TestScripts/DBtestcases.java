package Com.FirstAutomation.TestScripts;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Com.FirstAutomation.Database.DatabaseConnections;
import Com.FirstAutomation.Database.SQLqueries;
import Com.FirstAutomation.Pojos.Employeepojo;

public class DBtestcases {

	@Test(enabled = false)
	public void employeetablevalidation() throws ClassNotFoundException, SQLException {

		DatabaseConnections DatabaseConnectionsref = new DatabaseConnections();
		DatabaseConnectionsref.getconnection();
		System.out.println("**************" + "MySQL establisehd successfully");

		DatabaseConnectionsref.gettablerecords(SQLqueries.employeequery);

	}

	@Test(enabled = true)
	public void employeerecordstojsonfile()
			throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {

		Connection con = null;

		DatabaseConnections DatabaseConnectionsref = new DatabaseConnections();

		Employeepojo Employeepojoref = new Employeepojo();

		try {
			ResultSet rs = DatabaseConnectionsref.gettablerecordsasresultset(SQLqueries.empramesh);

			while (rs.next())

			{

				String empid = rs.getString("empid");

				Employeepojoref.setEmpid(Integer.parseInt(empid));

				String empname = rs.getString("empname");
				Employeepojoref.setEmpname(empname);

				String empsal = rs.getString("empsal");
				Employeepojoref.setEmpsal(Integer.parseInt(empsal));

				String empdept = rs.getString("empdept");

				Employeepojoref.setEmpdept(empdept);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {

			if (con != null) {
				con.close();
				System.out.println("Connection closed");
			}

		}

		File jsonfile = new File(
				"C:/Users/home/Documents/MavenTDDPRoject/MavenProejctLatest/MavenProject/Jsonfiles/empramesh.json");

		ObjectMapper objmapper = new ObjectMapper();
		objmapper.writeValue(jsonfile, Employeepojoref);

		System.out.println("Json File is generated");

	}

}
