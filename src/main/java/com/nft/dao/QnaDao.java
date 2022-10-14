package com.nft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.QnaVo;
import com.kenneth.dto.MemberVo;
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
		String sql = "insert into qna(no,userid,email,pass,title,content,files) values(qna_seq.nextval, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// pstmt.setInt(1, qVo.getNo());
			pstmt.setString(1, qVo.getUserid());
			pstmt.setString(2, qVo.getEmail());
			pstmt.setString(3, qVo.getPass());
			pstmt.setString(4, qVo.getTitle());
			pstmt.setString(5, qVo.getContent());
			pstmt.setString(6, qVo.getFiles());
			// pstmt.setDate(7, qVo.getWriteDate()); // 날짜형

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
		String sql = "select * from qna order by no desc";

		List<QnaVo> list = new ArrayList<QnaVo>(); // List 컬렉션 객체 생성

		System.out.println("list: " + list);

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
			System.out.println("rs.next(): " + rs.next());

			while (rs.next()) {
				QnaVo qVo = new QnaVo();
				// 디비로부터 회원 정보 획득
				qVo.setNo(rs.getInt("no"));
				qVo.setUserid(rs.getString("userid")); // DB에서 가져온 정보를 pVo객체에 저장
				qVo.setEmail(rs.getString("email"));
				qVo.setPass(rs.getString("pass"));
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

	// 회원 정보 가져오기: select
	// 입력값: 사용자id(userid)
	// 반환값: 해당 회원 정보
	public QnaVo getQna(String no) {
		/* int result = -1; */
		String sql = "select * from qna where no = ?";
		QnaVo qVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);

			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if (rs.next()) {
				// 디비로부터 회원 정보 획득
				qVo = new QnaVo();
				// 디비로부터 회원 정보 획득
				qVo.setNo(rs.getInt("no"));
				qVo.setUserid(rs.getString("userid"));
				qVo.setEmail(rs.getString("email"));
				qVo.setPass(rs.getString("pass"));
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content"));
				qVo.setFiles(rs.getString("files"));
				qVo.setWriteDate(rs.getDate("writeDate"));
				/*
				 * } else { result = -1;
				 */ // 디비에 userid 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qVo;
	}

	// QNA 삭제
	public void deleteQna(String no) {
		int result = -1;
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
		PreparedStatement pstmt = null; // 동적 쿼리

		String sql = "delete from qna where no=?";

		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);

			// (4 단계) SQL문 실행 및 결과 처리
			// executeUpdate : 삽입(insert/update/delete)
			result = pstmt.executeUpdate(); // 쿼리 수행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	// (관리자) QnA 답글 등록하기
	public int reInsertQna(QnaVo qVo) {
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		String sql = "insert into qna(no,title,content,writeDate) values(qna_seq.nextval, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// pstmt.setInt(1, qVo.getNo());
			pstmt.setString(1, qVo.getTitle());
			pstmt.setString(2, qVo.getContent());
			pstmt.setDate(3, qVo.getWriteDate()); // 날짜형

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
	
}
