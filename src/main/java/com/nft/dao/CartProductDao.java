package com.nft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.CartProductVo;
import com.nft.util.DBManager;

public class CartProductDao {
	
	// 싱글톤
	// 1. 생성자 private : 객체를 외부에서 만들지 못하도록
	// 2. 객체 생성 private static : 자신이 객체를 생성
	// 3. 객체 제공 기능 getInstance() : 자신의 객체(단지 1개)를 사용할 수 있도록 제공
	private CartProductDao() {		
	}

	private static CartProductDao instance = new CartProductDao();
	
	public static CartProductDao getInstance() {
		return instance;
	}
		
	
	//장바구니 DB에 담기
	public int cartAdd(CartProductVo cpVo) {
		int result= -1;
		Connection conn = null;
		PreparedStatement pstmt = null;		// 동적 쿼리
		String sql_insert = "insert into nft_cart values(?,?,?,?,?,?)";			
		
//		MemberVo mVo = new MemberVo();
//		ProductVo pVo = new ProductVo();
//		CartProductVo cpVo = new CartProductVo();
		
//		int b_num = 0;
		try{
			conn = DBManager.getConnection();
//			getCon();
//			//1. 장바구니 번호계산		
//			sql = "select max(b_num) from itwill_basket";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if(rs.next()){
//				b_num = rs.getInt(1)+1; //인덱스 사용 호출
//				//rs.getInt("max(bno)"); // 컬럼명 사용 호출
//			}
//			System.out.println("DAO : b_num은 "+b_num);

			//2.나머지 전달정보 DB에 저장
			pstmt = conn.prepareStatement(sql_insert);
			
//			pstmt.setString(1, mVo.getUserid());
//			pstmt.setString(2, pVo.getCreator());
//			pstmt.setString(3, pVo.getUnique_no());
//			pstmt.setString(4, pVo.getNftUrl());
//			pstmt.setString(5, pVo.getP_name());
//			pstmt.setInt(6, pVo.getPrice());
			
//			System.out.println(cpVo.getUserid());
//			System.out.println(cpVo.getCreator());
//			System.out.println(cpVo.getUnique_no());
//			System.out.println(cpVo.getNftUrl());
//			System.out.println(cpVo.getP_name());
//			System.out.println(cpVo.getPrice());
			
			pstmt.setString(1, cpVo.getUserid());
			pstmt.setString(2, cpVo.getCreator());
			pstmt.setString(3, cpVo.getUnique_no());
			pstmt.setString(4, cpVo.getNftUrl());
			pstmt.setString(5, cpVo.getP_name());
			//pstmt.setint(6, cpVo.getPrice());
			pstmt.setDouble(6, cpVo.getPrice());
			
			pstmt.executeUpdate();
//			System.out.println("장바구니 담기 성공");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}//end of basketAdd()
	
	
	
	// 장바구니 상품 조회
		public List<CartProductVo> selectAllCartProducts(String userid) {
			String sql = "select * from NFT_CART where userid=?";
			
			List<CartProductVo> cartList = new ArrayList<CartProductVo>();		// List 컬렉션 객체 생성
			Connection conn = null;
			PreparedStatement pstmt =null;		// 동적 쿼리
			ResultSet rs = null;
			CartProductVo cpVo = null;
		
			try {
				conn = DBManager.getConnection();
				
				// (3단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				// (4단계) SQL문 실행 및 결과 처리
				rs = pstmt.executeQuery();

				// rs.next() : 다음 행(row)을 확인
				// rs.getString("컬럼명")
				
				if (userid != null) {
				
				while (rs.next()){
							
					cpVo = new CartProductVo();
					System.out.println(cpVo);
					System.out.println(rs.getDouble("price"));
					// 디비로부터 상품 정보 획득
					cpVo.setUserid(rs.getString("userid"));
					cpVo.setCreator(rs.getString("creator"));
					cpVo.setUnique_no(rs.getString("unique_no"));			// 컬럼명 code인 정보를 가져옴
					cpVo.setP_name(rs.getString("p_name"));		// DB에서 가져온 정보를 pVo객체에 저장
					cpVo.setPrice(rs.getDouble("price"));
					cpVo.setNftUrl(rs.getString("nftUrl"));

					cartList.add(cpVo);		// list 객체에 데이터 추가
				}
			} else {
				System.out.println("로그인하세요");
			}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt ,rs);
		}
			return cartList;
	}	
	
	
		
		
	// 장바구니 상품 삭제
		// 상품 삭제
		public void deleteCartProduct(String unique_no, String userid) {
			Connection conn = null;
			PreparedStatement pstmt = null;		// 동적 쿼리
			String sql_insert = "delete from NFT_CART where unique_no=? and userid=?";			
			
			try {
				conn = DBManager.getConnection();
		
				// (3단계)객체 생성
				pstmt = conn.prepareStatement(sql_insert);
				pstmt.setString(1, unique_no);
				pstmt.setString(2, userid);
				
				
				// (4단계)SQL문 실행 및 결과 처리
				pstmt.executeUpdate();		// 쿼리 수행
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);

			}

		}
	
	
	
	

//	//동일한 상품이 있는지 체크
//	public int checkGoods(BasketDTO bkdto) {
//		int result = 0;
//
//		try{
//			getCon();
//			//sql : id, gno, size, color 모두 만족하는 대상 검색
//			sql ="select * from itwill_basket "
//					+ "where b_m_id=? and b_g_num=? and b_g_size=? and b_g_color=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, bkdto.getB_m_id());
//			pstmt.setInt(2, bkdto.getB_g_num());
//			pstmt.setString(3, bkdto.getB_g_size());
//			pstmt.setString(4, bkdto.getB_g_color());
//			rs = pstmt.executeQuery();
//			if(rs.next()){ //중복상품인 경우
//				result = 1;
//				//구매수량 수정
//				sql ="update itwill_basket set b_g_amount=b_g_amount+? "
//						+ "where b_m_id=? and b_g_num=? and "
//						+ "b_g_size=? and b_g_color=?";
//				pstmt = con.prepareStatement(sql);
//				pstmt.setInt(1, bkdto.getB_g_amount());
//				pstmt.setString(2, bkdto.getB_m_id());
//				pstmt.setInt(3, bkdto.getB_g_num());
//				pstmt.setString(4, bkdto.getB_g_size());
//				pstmt.setString(5, bkdto.getB_g_color());
//				pstmt.executeUpdate();
//				System.out.println("기존의 상품에 수량 변경완료!");
//			}
//			System.out.println("기존의 상품 확인 결과: "+(result==1? "중복상품이 있다":"중복상품이 없다"));
//			sql = "insert into itwill_basket";
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			closeDB();
//		}
//		return result;
//	}//end of checkGoods()
	

}
