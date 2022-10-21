package com.nft.blockchain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nft.dto.EwalletVo;
import com.nft.dto.MemberVo;
import com.nft.util.DBManager;

public class BlockChainDao {
	// 필드
		// 싱글톤으로 작성
		// 자기 자신이 객체를 하나 생성(싱글톤-이거하나만 생성 후 다른곳에서 생성하지 않음)
		private static BlockChainDao instance = new BlockChainDao();
		
		// 생성자
		private BlockChainDao(){
		}
		
		// 메소드
		// MemberDao 호출함수
		public static BlockChainDao getInstance() {
			return instance;
		}
	
		public int insertNFT_wallet(EwalletVo eVo) {
			int result = -1;
		
			Connection conn = null;
			// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야할 때
			// 매개변수가 많아서 쿼리문 정리가 필요할 때
			PreparedStatement pstmt = null;
			
			String sql_insert = "insert into NFT_WALLET values(?, ?, ?, ?, ?, ?)";
//			System.out.println(sql_insert);
			
			
			try {
				// DBManager에 정의된 DB연결 함수
				// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
				conn = DBManager.getConnection();
				
				// Statement 객체 생성
				pstmt = conn.prepareStatement(sql_insert);
				
				pstmt.setString(1, eVo.getUserid());
				pstmt.setString(2, eVo.getE_wallet());
				pstmt.setString(3, eVo.getE_walletPwd());
				pstmt.setString(4, eVo.getPrivatekey());
				pstmt.setString(5, eVo.getPublickey());
				pstmt.setLong(6, eVo.getMoney());
				
				// SQL문 실행 및 결과 처리 
				// executeQuery : 조회(select)
				result = pstmt.executeUpdate();		// 쿼리 수행
			} catch(Exception e) {			
//				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				// 사용한 리소스 해제
				DBManager.close(conn, pstmt);
			}
			return result;
		}
		
		// 회원 정보 업데이트 : update
		// 입력값 : 회원 NFT_wallet 테이블 정보
		// 반환값 : 성공여부
		public int updateNFT_wallet(EwalletVo eVo) {
			int result = -1;
			String sql = "update NFT_wallet set e_walletPwd=? where userid=?";

			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				// DBManager에 정의된 DB연결 함수
				// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
				conn = DBManager.getConnection();
				
				// Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, eVo.getE_walletPwd());
				pstmt.setString(2, eVo.getUserid());
				
				// SQL문 실행 및 결과 처리 => executeUpdate : 수정(update)
				result = pstmt.executeUpdate();

			} catch(Exception e) {			
				e.printStackTrace();
			} finally {
				// 사용한 리소스 해제
				DBManager.close(conn, pstmt);
			}		
			
			return result;
		}
	
	
}
