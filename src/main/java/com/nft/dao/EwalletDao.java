package com.nft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nft.dto.MemberVo;
import com.nft.util.DBManager;

public class EwalletDao {
	// 필드
	// 싱글톤으로 작성
	// 자기 자신이 객체를 하나 생성(싱글톤-이거하나만 생성 후 다른곳에서 생성하지 않음)
	private static EwalletDao instance = new EwalletDao();
	
	// 생성자
	private EwalletDao(){
	}
	
	// 메소드
	// EwalletDao 호출함수
	public static EwalletDao getInstance() {
		return instance;
	}
	
	// 전자지갑 생성 : DB에 전자지갑 정보 삽입 : insert
	public int insertE_wallet(MemberVo mVo) {
		int result = -1;
	
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야할 때
		// 매개변수가 많아서 쿼리문 정리가 필요할 때
		PreparedStatement pstmt = null;
		
		String sql_insert = "insert into NFT_MEMBER values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		System.out.println(sql_insert);
		
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql_insert);
			
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getIdPwd());
			pstmt.setString(4, mVo.getBirth());
			pstmt.setString(5, mVo.getGender());
			pstmt.setString(6, mVo.getE_wallet());
			pstmt.setString(7, mVo.getE_walletPwd());
			pstmt.setString(8, mVo.getNationPhone());
			pstmt.setString(9, mVo.getPhone());
			pstmt.setInt(10, mVo.getEmail_agree());
			pstmt.setInt(11, mVo.getPhone_agree());
			
			// SQL문 실행 및 결과 처리 
			// executeQuery : 조회(select)
			result = pstmt.executeUpdate();		// 쿼리 수행
		} catch(Exception e) {			
//			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
}
