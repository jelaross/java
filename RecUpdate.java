import java.sql.*;
class RecUpdate
{
	public static void main(String arg[])
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection cn=DriverManager.getConnection("jdbc:odbc:dbdsn");
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery("update student set sname='Harish' where sid=2");
		}catch(Exception e1){}
		System.out.println("Records Successfully Updated");
	}
}