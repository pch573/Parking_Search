package SPL;

import java.sql.*;

class myJDBC {

	Connection mycon=null;
	public myJDBC(String id,String passwd)
	{
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		
		try {
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		//System.out.println("연결 성공");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public Connection getConn() {
		return mycon;
	}
	public void selectSQL(Connection conn,String sql)
	{
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			int count=1;
			while(rs.next()) {
				String name = rs.getString("sname");
				String id = rs.getString("sid");
				int age = rs.getInt("sage");
				double gpa = rs.getDouble("gpa");
				Date bday = rs.getDate("bday");
				System.out.println("Select"+count+" = "+name+"/"+id+"/"+age+"/"+gpa+"/"+bday);
				count++;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void insertSQL(Connection conn,String sname,String sid,int sage,double gpa,Date d)
	{
		try {
			String sql = "insert into jdbctest.student values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sname);
			pstmt.setString(2,sid);
			pstmt.setInt(3,sage);
			pstmt.setDouble(4,gpa);
			pstmt.setDate(5,d);
			
			int rs =pstmt.executeUpdate();
			System.out.println("insert rs="+rs);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void deleteSQL(Connection conn,String sid)
	{
		try {
			String sql = "delete from jdbctest.student where sid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sid);
			
			int rs =pstmt.executeUpdate();

			System.out.println("delete rs="+rs);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void updateSQL(Connection conn,String sid,String setValue)
	{
		try {
			String sql = "update jdbctest.student set sname=?  where sid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,setValue);
			pstmt.setString(2,sid);
			
			int rs =pstmt.executeUpdate();

			System.out.println("update rs="+rs);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public boolean disconnect(Connection conn) {
		try {
			conn.close();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}
	
}
