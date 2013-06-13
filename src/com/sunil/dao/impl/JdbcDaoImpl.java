package com.sunil.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunil.jdbc.model.Circle;

public class JdbcDaoImpl {

	public Circle getCircle(int id) {
		Connection conn = null;
		Circle circle = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "USERNAME", "PASSWORD");

			String sql = "select * from circle where id = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while(rs.next()){
				circle = new Circle();
				circle.setId(rs.getInt("id"));
				circle.setName(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(ps!=null){
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

		return circle;
	}

}
