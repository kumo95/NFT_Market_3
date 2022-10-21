package com.nft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.NoticeVo;
import com.nft.dto.ProductVo;
import com.nft.dto.QnaVo;
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
		System.out.println("qVo: " + qVo);
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		String sql = "insert into qna(bno,userid,title,content,files) values(qna_seq.nextval, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// pstmt.setInt(1, qVo.getNo());
			pstmt.setString(1, qVo.getUserid());
			pstmt.setString(2, qVo.getTitle());
			pstmt.setString(3, qVo.getContent());
			pstmt.setString(4, qVo.getFiles());
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
		String sql = "select * from qna order by bno";

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
				qVo.setBno(rs.getInt("bno"));
				qVo.setUserid(rs.getString("userid")); // DB에서 가져온 정보를 pVo객체에 저장
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content"));
				qVo.setFiles(rs.getString("files"));
				//qVo.setWriteDate(rs.getDate("writeDate"));

				list.add(qVo); // list 객체에 데이터 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// (관리자) 전체 qna 조회
		public List<QnaVo> selectAllQnaAdmin() {
			String sql = "select * from qna order by bno";

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
					//qVo.setBno(rs.getInt("bno"));
					//qVo.setUserid(rs.getString("userid")); // DB에서 가져온 정보를 pVo객체에 저장
					qVo.setTitle(rs.getString("title"));
					qVo.setContent(rs.getString("content"));
					//qVo.setFiles(rs.getString("files"));
					//qVo.setWriteDate(rs.getDate("writeDate"));

					list.add(qVo); // list 객체에 데이터 추가
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

	
	
	
	// 단일 qna 조회 (bno) => 단일 qna 정보 반환
	public QnaVo selectQnaBybno(String bno) {
		String sql = "select * from qna where bno=?";
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		ResultSet rs = null;
		QnaVo qVo = null;

		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);

			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()) {
				qVo = new QnaVo();
				qVo.setBno(rs.getInt("bno"));
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

	// 회원 정보 가져오기: select
	// 입력값: 사용자id(userid)
	// 반환값: 해당 회원 정보
	public QnaVo getQna(String bno) {
		/* int result = -1; */
		String sql = "select * from qna where bno = ?";
		QnaVo qVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);

			// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if (rs.next()) {
				// 디비로부터 회원 정보 획득
				qVo = new QnaVo();
				// 디비로부터 회원 정보 획득
				qVo.setBno(rs.getInt("bno"));
				qVo.setUserid(rs.getString("userid"));
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
	public void deleteQna(String bno) {
		int result = -1;
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
		PreparedStatement pstmt = null; // 동적 쿼리

		String sql = "delete from qna where bno=?";

		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);

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
		String sql = "insert into qna(bno,title,content) values(qna_seq.nextval, ?, ?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// pstmt.setInt(1, qVo.getNo());
			pstmt.setString(1, qVo.getTitle());
			pstmt.setString(2, qVo.getContent());

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

	// 한 페이지에 10개의 게시물 표시
	// 게시판 하단에 표시

	// 게시글 검색
	public List<QnaVo> getQnaList() {
		return getQnaList("title", "", 1);
	}

	// 페이지별 리스트 표시
	public List<QnaVo> getQnaList(int page) {
		return getQnaList("title", "", page);
	}

	// 검색기능과 페이징을 구현
	public List<QnaVo> getQnaList(String column, String keyword, int page) {
		String sql = "SELECT * FROM (" 
				+ "select rownum n, b.* " 
				+ "from (select * from qna where "+column+" like ? order by bno desc) b" 
				+ ") "
				+ "where n between ? and ?";

		QnaVo qVo = null;
		List<QnaVo> list = new ArrayList<QnaVo>(); // List 컬렉션 객체 생성

		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, 1+(page-1)*10);
			pstmt.setInt(3, page*5);
			
			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()) {
				qVo = new QnaVo();
				// 디비로부터 상품 정보 획득
				qVo.setBno(rs.getInt("bno"));
				qVo.setUserid(rs.getString("userid"));
				qVo.setPass(rs.getString("pass"));
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content")); // DB에서 가져온 정보를 qVo객체에 저장
				qVo.setFiles(rs.getString("files"));
				qVo.setCount(rs.getInt("count"));
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

	// 특정 컬럼의 키워드를 통해 게시물 수 조회
	public int getQnaCount() {
		return getQnaCount("title", "");
	}

	public int getQnaCount(String column, String keyword) {
		int count = 0;
		String sql = "SELECT count(bno) count FROM (" 
				+ "select rownum n, b.* " 
				+ "from (select * from qna where "+column+" like ? order by bno desc) b"
				+ ") ";
		
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword +"%");
	
			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	// 게시물 번호로 특정 게시물의 다음 게시물 데이터 조회
	public QnaVo getNextQna(int bno) {
		QnaVo qVo = null;
		return qVo;
	}

	// 게시물 번호로 특정 게시물 이전 게시물 데이터 조회
	public QnaVo getPrevQna(int bno) {
		QnaVo qVo = null;
		return qVo;
	}
}
