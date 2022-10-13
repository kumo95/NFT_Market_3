package com.nft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.ProductVo;
import com.nft.util.DBManager;

public class ProductDao {
	
	// 싱글톤
	// 1. 생성자 private : 객체를 외부에서 만들지 못하도록
	// 2. 객체 생성 private static : 자신이 객체를 생성
	// 3. 객체 제공 기능 getInstance() : 자신의 객체(단지 1개)를 사용할 수 있도록 제공
	private ProductDao() {		
	}

	private static ProductDao instance = new ProductDao();
	
	public static ProductDao getInstance() {
		return instance;
	}
	
	// 상품 등록
	// 입력값 : 전체 상품 정보
	// 반환값 : 쿼리 수행 결과
	public int insertProduct(ProductVo pVo) {
		int result= -1;
		Connection conn = null;
		PreparedStatement pstmt = null;		// 동적 쿼리
		String sql_insert = "insert into nft_product values(?,?,?,?,?,?,?,?,?)";			
		
		try {
		conn = DBManager.getConnection();
		// (3단계)객체 생성
		pstmt = conn.prepareStatement(sql_insert);
		
//		pstmt.setInt(1, pVo.getCode());
		pstmt.setString(1, pVo.getCreator());
		pstmt.setString(2, pVo.getOwner());
		pstmt.setString(3, pVo.getUnique_no());
		pstmt.setString(4, pVo.getP_name());
		//pstmt.setInt(5, pVo.getPrice());
		pstmt.setDouble(5, pVo.getPrice());
		pstmt.setString(6, pVo.getNftUrl());
		pstmt.setString(7, pVo.getDescription());
		pstmt.setInt(8, pVo.getEdition());
		pstmt.setDate(9, pVo.getReg_date());		// 날짜형
		
		// (4단계)SQL문 실행 및 결과 처리
		result = pstmt.executeUpdate();		// 쿼리 수행
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}
		return result;
	}


	// 전제 상품 조회
	public List<ProductVo> selectAllProducts() {
		String sql = "select* from nft_product order by unique_no desc";
		
		List<ProductVo> list = new ArrayList<ProductVo>();		// List 컬렉션 객체 생성
	
		Connection conn = null;
		PreparedStatement pstmt =null;		// 동적 쿼리
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			  
			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()){
				
				ProductVo pVo = new ProductVo();
				// 디비로부터 상품 정보 획득
				pVo.setCreator(rs.getString("creator"));
				pVo.setOwner(rs.getString("owner"));
				pVo.setUnique_no(rs.getString("unique_no"));			// 컬럼명 code인 정보를 가져옴
				pVo.setP_name(rs.getString("p_name"));		// DB에서 가져온 정보를 pVo객체에 저장
				pVo.setPrice(rs.getDouble("price"));
				pVo.setNftUrl(rs.getString("nftUrl"));
				pVo.setDescription(rs.getString("description"));
				pVo.setEdition(rs.getInt("edition"));
				pVo.setReg_date(rs.getDate("reg_date"));
				
				list.add(pVo);		// list 객체에 데이터 추가
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt ,rs);
	}
		return list;
}	

	
	// 단일 상품 조회 (unique_no) => 단일 상품 정보 반환
	public ProductVo selectProductByCode(String unique_no) {
		String sql = "select * from nft_product where unique_no=?";
		Connection conn = null;
		PreparedStatement pstmt =null;		// 동적 쿼리
		ResultSet rs = null;
		ProductVo pVo = null;
		
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, unique_no);
			
			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()){
				
				pVo = new ProductVo();
				pVo.setCreator(rs.getString("creator"));
				pVo.setOwner(rs.getString("owner"));
				pVo.setUnique_no(rs.getString("unique_no"));			// 컬럼명 code인 정보를 가져옴
				pVo.setP_name(rs.getString("p_name"));		// DB에서 가져온 정보를 pVo객체에 저장
				pVo.setPrice(rs.getInt("price"));
				pVo.setNftUrl(rs.getString("nftUrl"));
				pVo.setDescription(rs.getString("description"));
				pVo.setEdition(rs.getInt("edition"));
				pVo.setReg_date(rs.getDate("reg_date"));
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt ,rs);
	}
		return pVo;
	}
	
	
	// 상품 수정
	public int updateProduct(ProductVo pVo) {
		int result= -1;
		Connection conn = null;
		
		PreparedStatement pstmt = null;		// 동적 쿼리
		String sql = "update nft_product set creator=?, owner=?, p_name=?, unique_no=? , price=?, description=?, edition=? ,reg_date=? where unique_no=?";			
		
		try {

		conn = DBManager.getConnection();

		// (3단계)객체 생성
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, pVo.getCreator());
		pstmt.setString(2, pVo.getOwner());
		pstmt.setString(3, pVo.getP_name());
		pstmt.setDouble(4, pVo.getPrice());
		pstmt.setString(5, pVo.getNftUrl());
		pstmt.setString(6, pVo.getDescription());
		pstmt.setInt(7, pVo.getEdition());
		pstmt.setDate(8, pVo.getReg_date());		// 날짜형
		// (4단계)SQL문 실행 및 결과 처리
		result = pstmt.executeUpdate();		// 쿼리 수행
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}
		return result;
	}
	
	// 상품 삭제
	public void deleteProduct(String unique_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;		// 동적 쿼리
		String sql_insert = "delete from nft_product where unique_no=?";			
		
		try {
			conn = DBManager.getConnection();
	
			// (3단계)객체 생성
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, unique_no);
			
			// (4단계)SQL문 실행 및 결과 처리
			pstmt.executeUpdate();		// 쿼리 수행
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}

	}
	
	// 상품 검색
	// 입력값 : column: 검색 대상(분야), keyword: 검색어
	// 반환값 : 검색 결과 리스트
	public List<ProductVo> searchProduct(String column, String keyword) {
		String sql = "select * from nft_product where "+column+" like ? order by unique_no desc";
		
		List<ProductVo> list = new ArrayList<ProductVo>();		// List 컬렉션 객체 생성
		
		Connection conn = null;
		PreparedStatement pstmt =null;		// 동적 쿼리
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" +keyword+ "%");
			  
			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()){
				
				ProductVo pVo = new ProductVo();
				// 디비로부터 상품 정보 획득
				pVo = new ProductVo();
				pVo.setCreator(rs.getString("creator"));
				pVo.setOwner(rs.getString("owner"));
				pVo.setUnique_no(rs.getString("unique_no"));			// 컬럼명 code인 정보를 가져옴
				pVo.setP_name(rs.getString("p_name"));		// DB에서 가져온 정보를 pVo객체에 저장
				pVo.setPrice(rs.getDouble("price"));
				pVo.setNftUrl(rs.getString("nftUrl"));
				pVo.setDescription(rs.getString("description"));
				pVo.setEdition(rs.getInt("edition"));
				pVo.setReg_date(rs.getDate("reg_date"));
				
				list.add(pVo);		// list 객체에 데이터 추가
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt ,rs);
	}
		return list;
		
	}
	
	
	
	
	
	// creator 가 만든 상품 조회
		public List<ProductVo> selectCreatorProducts(String creator) {
			String sql = "select * from nft_product where creator=?";
			
			List<ProductVo> list = new ArrayList<ProductVo>();		// List 컬렉션 객체 생성
		
			Connection conn = null;
			PreparedStatement pstmt =null;		// 동적 쿼리
			ResultSet rs = null;
				
			try {
				conn = DBManager.getConnection();
				
				// (3단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, creator);
				  
				// (4단계) SQL문 실행 및 결과 처리
				rs = pstmt.executeQuery();

				// rs.next() : 다음 행(row)을 확인
				// rs.getString("컬럼명")
				
				if (creator != null) {
				
					while (rs.next()){
					
					ProductVo pVo = new ProductVo();
					// 디비로부터 상품 정보 획득
					pVo.setCreator(rs.getString("creator"));
					pVo.setOwner(rs.getString("owner"));
					pVo.setUnique_no(rs.getString("unique_no"));			// 컬럼명 code인 정보를 가져옴
					pVo.setP_name(rs.getString("p_name"));		// DB에서 가져온 정보를 pVo객체에 저장
					pVo.setPrice(rs.getDouble("price"));
					pVo.setNftUrl(rs.getString("nftUrl"));
					pVo.setDescription(rs.getString("description"));
					pVo.setEdition(rs.getInt("edition"));
					pVo.setReg_date(rs.getDate("reg_date"));
					
					list.add(pVo);		// list 객체에 데이터 추가
					
					System.out.println();
					}
				} else {
					System.out.println("로그인 하시오");
				} 
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt ,rs);
		}
			return list;
	}	
			
}
	

