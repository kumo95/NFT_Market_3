package com.nft.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	// DB연결
	public static Connection getConnection() {
		Connection conn = null;
		try {
//			// (1 단계) JDBC 드라이버 로드
//			Class.forName("oracle.jdbc.driver.OracleDriver");	// Oracle
//			
//			// (2 단계) 데이터 베이스 연결 객체 생성 
//			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			String uid = "ora_user";
//			String pass = "1234";
//			conn = DriverManager.getConnection(url, uid, pass);
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			//etc.
		}catch(Exception e) {
			
		}
		return conn;
	}

	
	
	// DB 닫기(close)
	// DB 조회한 후 close한 경우
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			//(5 단계) 사용한 리소스 해제
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
			pstmt.close();
			}
			if(conn != null) {
			conn.close();
			}
		} catch(SQLException e) {
//			e.getMessage();
		}
	}
	
	// DB 삽입/수정/삭제한 후 close한 경우
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			//(5 단계) 사용한 리소스 해제
			pstmt.close();
			conn.close();
		} catch(Exception e) {		
			System.out.println(e.getMessage());
		}
	}
		
		

}
