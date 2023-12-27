package in.connection;

import java.sql.Connection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds = null;
	public static Connection getConnection(){
		Connection con = null;
		try {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl("jdbc:mysql://localhost:3306/adv_java");
			config.setUsername("root");
			config.setPassword("s123456789");
			config.setDriverClassName("com.mysql.cj.jdbc.Driver");
			
			HikariDataSource ds = new HikariDataSource(config);
			 con = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
 }
