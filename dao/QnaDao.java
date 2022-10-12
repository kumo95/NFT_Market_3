package com.nft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.QnaVo;
import com.kenneth.dto.ProductVo;
import com.nft.dao.QnaDao;
import com.nft.util.DBManager;

public class QnaDao {

	// 생성자
	private QnaDao() {
	}

	// 싱글톤 생성 및 사용
	private static QnaDao instance = new QnaDao();

	// 메소드
	public static QnaDao getInstance() {
		return instance;
	}

	// (사용자 입장) 게시글 등록
	// 입력값 : 전체 게시글 정보
	// 반환값 : 쿼리 수행 결과
	public int insertQna(QnaVo qVo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리

		String sql = "insert into QNA values(QNA_seq.nextval,?,?,?,?,?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			/* pstmt.setInt(1, qVo.getNo()); */
			pstmt.setString(1, qVo.getUserid());
			pstmt.setString(2, qVo.getTitle());
			pstmt.setString(3, qVo.getContent()); 
			pstmt.setString(4, qVo.getFiles()); 
			pstmt.setDate(5, qVo.getWriteDate()); // 날짜형
			
			// (4 단계) SQL문 실행 및 결과 처리
			// executeUpdate : 삽입(insert/update/delete)
			result = pstmt.executeUpdate(); // 쿼리 수행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);	
		}
		return result;
	}

	// (사용자) 전체 qna 조회
	public List<QnaVo> selectAllQna() {
		String sql = "select * from QNA order by userid";

		List<QnaVo> list = new ArrayList<QnaVo>(); // List 컬렉션 객체 생성

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			while (rs.next()) {
				QnaVo qVo = new QnaVo();
				// 디비로부터 회원 정보 획득
				qVo.setNo(rs.getInt("no")); // 컬럼명 no인 정보를 가져옴
				qVo.setUserid(rs.getString("userid")); // DB에서 가져온 정보를 pVo객체에 저장
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content"));
				qVo.setFiles(rs.getString("files"));
				qVo.setWriteDate(rs.getDate("writeDate"));

				list.add(qVo); // list 객체에 데이터 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 단일 상품 조회 (상품코드) => 단일 상품 정보 반환
	public QnaVo selectQnaByUserid(String userid) {
		String sql = "select * from QNA where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaVo qVo = null;

		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			while (rs.next()) {
				// rs.getInt("컬럼명");
				qVo = new QnaVo();
				// 디비로부터 회원 정보 획득
				qVo.setUserid(rs.getString("userid")); 	// 컬럼명 userid인 정보를 가져옴
				qVo.setTitle(rs.getString("title")); 		// DB에서 가져온 정보를 qVo객체에 저장
				qVo.setContent(rs.getString("content"));
				qVo.setFiles(rs.getString("files"));
				qVo.setWriteDate(rs.getDate("writeDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qVo;
	}

	// (관리자 입장) 게시글 전체 조회
	public List<QnaVo> selectAll() {
		String sql = "select * from QNA";

		List<QnaVo> list = new ArrayList<QnaVo>(); // List 컬렉션 객체 생성

		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		ResultSet rs = null;

		// sql 쿼리 실행
		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()) {

				QnaVo qVo = new QnaVo();
				// 디비로부터 상품 정보 획득
				qVo.setNo(rs.getInt("no"));
				qVo.setUserid(rs.getString("userid")); // DB에서 가져온 정보를 qVo객체에 저장
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content")); // 컬럼명 content인 정보를 가져옴
				qVo.setFiles(rs.getString("files"));
				qVo.setWriteDate(rs.getDate("writeDate"));
				

				list.add(qVo); // list 객체에 데이터 추가
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// (사용자 입장) 전체 게시글 조회
	public List<QnaVo> selectUserAll() {
		String sql = "select * from QNA";

		List<QnaVo> list = new ArrayList<QnaVo>(); // List 컬렉션 객체 생성

		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		ResultSet rs = null;

		// sql 쿼리 실행
		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()) {

				QnaVo qVo = new QnaVo();
				// 디비로부터 상품 정보 획득
				qVo.setNo(rs.getInt("no"));
				qVo.setUserid(rs.getString("userid")); // DB에서 가져온 정보를 qVo객체에 저장
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content")); // 컬럼명 content인 정보를 가져옴
				qVo.setFiles(rs.getString("files"));
				qVo.setWriteDate(rs.getDate("writeDate"));
				

				list.add(qVo); // list 객체에 데이터 추가
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 단일 게시글 조회(no) => 단일 게시글 정보 반환
	public QnaVo selectQna(int no) {
		String sql = "select * from QNA";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaVo qVo = null;

		// sql 쿼리 실행
		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			while (rs.next()) {
				// rs.getInt("컬럼명");
				qVo = new QnaVo();
				// 디비로부터 회원 정보 획득
				qVo.setNo(rs.getInt("no")); // 컬럼명 code인 정보를 가져옴
				qVo.setUserid(rs.getString("userid"));
				qVo.setTitle(rs.getString("title")); // DB에서 가져온 정보를 pVo객체에 저장
				qVo.setContent(rs.getString("content"));
				qVo.setFiles(rs.getString("files"));
				qVo.setWriteDate(rs.getDate("writeDate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qVo;
	}

}
