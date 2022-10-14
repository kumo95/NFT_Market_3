package com.nft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nft.util.DBManager;

public class EmailDao {
	// 필드
	// 싱글톤으로 작성
	// 자기 자신이 객체를 하나 생성(싱글톤-이거하나만 생성 후 다른곳에서 생성하지 않음)
	private static EmailDao instance = new EmailDao();
	
	// 생성자
	private EmailDao(){
	}
	
	// 메소드
	// MemberDao 호출함수
	public static EmailDao getInstance() {
		return instance;
	}
	

	public int checkSameEmail(String e_wallet) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select e_wallet from NFT_MEMBER where e_wallet=?";
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
	
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e_wallet);
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
	//			System.out.println(rs.getString("idPwd"));
				// 아이디/암호 비교 후 페이지 이동
				if(rs.getString("e_wallet").equals(e_wallet)) {
					result = 1;		// 이메일 중복
				}
			}else {
				result = 0;		// 이메일 사용 가능
			}
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	
	public int checkFindIdEmail(String name, String phone, String e_wallet) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select e_wallet from NFT_MEMBER where name=? and phone=? and e_wallet=?";
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
	
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, e_wallet);
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
	//			System.out.println(rs.getString("idPwd"));
				// 아이디/암호 비교 후 페이지 이동
				if(rs.getString("e_wallet").equals(e_wallet)) {
					result = 1;		// 이메일 찾기 성공
				}
			}else {
				result = 0;		// 이메일 찾기 실패
			}
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	
	public int checkFindPwdEmail(String userid, String phone, String e_wallet) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select e_wallet from NFT_MEMBER where userid=? and phone=? and e_wallet=?";
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
	
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, phone);
			pstmt.setString(3, e_wallet);
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
	//			System.out.println(rs.getString("idPwd"));
				// 아이디/암호 비교 후 페이지 이동
				if(rs.getString("e_wallet").equals(e_wallet)) {
					result = 1;		// 이메일 찾기 성공
				}
			}else {
				result = 0;		// 이메일 찾기 실패
			}
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	
}

