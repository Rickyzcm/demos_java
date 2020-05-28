package mysqlDemo;

import java.sql.*;

public class Mysql_JDBC_Connection {
	
	//mysql8.0以下的版本
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//优化部分
	static final String URL = "jdbc:mysql://";
	static final String serverName = "localhost";	//数据库服务名称
	static final String portNumber = "3306";	//数据库连接端口
	static final String databaseName = "vags";	//数据库名称
	
//	static final String DB_URL = null;
	
	// MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/vags?useSSL=false&serverTimezone=UTC";
	
	//数据库的用户名和密码
	static final String USER = "root";
	static final String PASS = "123456";
	
	static final String selectMethod = "cursor";
	
	static String getConnectionUrl(){ 
		return URL+serverName+":"+portNumber+"/"+databaseName;
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement state = null;
		DatabaseMetaData dm = null;
		ResultSet catalog = null;
		int catalog_count = 0;
		
		try{
			//注册JDBC驱动
			Class.forName(JDBC_DRIVER);
			
			//建立连接
			System.out.println("Database connecting>>>");
			conn = DriverManager.getConnection(getConnectionUrl(),USER,PASS);
			
			//返回数据库参数
			dm = conn.getMetaData();
			
			// \t 为制表符
			System.out.println("----驱动器信息----");
			System.out.println("\t驱动器名字："+dm.getDriverName());
			System.out.println("\t驱动器版本："+dm.getDriverVersion());
			System.out.println("----数据库信息----");
			System.out.println("\t数据库名字："+dm.getDatabaseProductName());
			System.out.println("\t数据库版本："+dm.getDatabaseProductVersion());
			
			catalog = dm.getCatalogs();
			while(catalog.next()) {				
				System.out.println("\t可用的数据库("+(++catalog_count)+") "+catalog.getString(1));
			}
			
			// 执行查询
			System.out.println("实例化Statement对象>>>");
			state = conn.createStatement();
			String sql="SELECT * FROM user";
			ResultSet rs = state.executeQuery(sql);
			
			//展开结果集数据库
			while(rs.next()) {
				//通过字段解锁
				int user_id = rs.getInt("User_id");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String email = rs.getString("Email");
				
				System.out.println(" 用户ID: "+user_id+" \t用户名 "+username+" \t密码 "+password+" \t注册邮箱 "+email);
				
			}
			
			catalog.close();	//
			catalog = null;
			rs.close();
			state.close();
			conn.close();	// 关闭连接
			
		}catch(SQLException se){
			// 处理 JDBC 的错误
			se.printStackTrace();
		}catch (Exception e) {
			// 处理 Class.forname 的错误
			e.printStackTrace();
		}finally {
			//关闭资源
			try {
				if(state!= null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
		System.out.println("Query OK!!!");
	}

}
