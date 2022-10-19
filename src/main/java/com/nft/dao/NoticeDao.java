package com.nft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.NoticeVo;
import com.nft.util.DBManager;

public class NoticeDao {

	// 생성자
	private NoticeDao() {
	}

	// 싱글톤 생성 및 사용
	private static NoticeDao instance = new NoticeDao();

	// 메소드
	public static NoticeDao getInstance() {
		return instance;
	}

	// 공지사항 등록
	// 입력값 : 공지사항 게시글
	// 반환값 : 쿼리 수행 결과
	public int insertNotice(NoticeVo nVo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		String sql = "insert into notice(no, title, content, files, writeDate) "
				+ "values(notice_seq.nextval, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVo.getTitle());
			pstmt.setString(2, nVo.getContent());
			pstmt.setString(3, nVo.getFiles());
			pstmt.setDate(4, nVo.getWriteDate()); // 날짜형

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

	// 전제 목록 조회
	public List<NoticeVo> selectAllNotice() {
		String sql = "select * from notice";

		List<NoticeVo> list = new ArrayList<NoticeVo>(); // List 컬렉션 객체 생성

		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// (4단계) SQL문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인
			// rs.getString("컬럼명")
			while (rs.next()) {

				NoticeVo nVo = new NoticeVo();
				// 디비로부터 상품 정보 획득
				nVo.setNo(rs.getInt("no"));
				nVo.setTitle(rs.getString("title"));
				nVo.setContent(rs.getString("content")); // DB에서 가져온 정보를 pVo객체에 저장
				nVo.setFiles(rs.getString("files"));
				nVo.setWriteDate(rs.getDate("writeDate"));

				list.add(nVo); // list 객체에 데이터 추가
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 정보 가져오기: select
	// 입력값: 게시글 번호 (no)
	// 반환값: 해당 게시글 정보
	public NoticeVo getNotice(String no) {
		String sql = "select * from notice where no=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		NoticeVo nVo = null;
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
				nVo = new NoticeVo();
				// 디비로부터 회원 정보 획득
				nVo.setNo(rs.getInt("no"));
				nVo.setTitle(rs.getString("title"));
				nVo.setContent(rs.getString("content"));
				nVo.setFiles(rs.getString("files"));
				nVo.setWriteDate(rs.getDate("writeDate"));
				/*
				 * } else { result = -1;
				 */ // 디비에 userid 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nVo;
	}

	

	public void deleteNotice(String no) {
		int result=-1;
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
		PreparedStatement pstmt = null; // 동적 쿼리

		String sql = "delete from notice where no=?";

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
	
	// 단일 공지사항 조회 (번호) => 단일 정보 반환
		public NoticeVo selectNoticeByNo(String no) {			
			String sql = "select * from notice where no=?";	
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			NoticeVo nVo = null;
			
			try {
				conn = DBManager.getConnection();
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, no);
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
				rs = pstmt.executeQuery();
				// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
				while(rs.next()){				
					// rs.getInt("컬럼명");
					nVo = new NoticeVo();
					// 디비로부터 회원 정보 획득
					nVo.setNo(rs.getInt("no"));		// 컬럼명 code인 정보를 가져옴
					nVo.setTitle(rs.getString("title"));	// DB에서 가져온 정보를 pVo객체에 저장
					nVo.setContent(rs.getString("content"));
					nVo.setFiles(rs.getString("files"));
					nVo.setWriteDate(rs.getDate("writeDate"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return nVo;
		}
	
	// 한 페이지에 10개의 게시물 표시
	// 게시판 하단에 표시
	
	/*
	 * // 게시글 검색 public List<NoticeVo> getNoticeList(){ return
	 * getNoticeList("title", "", 1); } // 페이지별 리스트 표시 public List<NoticeVo>
	 * getNoticeList(int page){ return getNoticeList("title", "", page); } // 검색기능과
	 * 페이징을 구현 public List<NoticeVo> getNoticeList(String column, String keyword,
	 * int page){ String sql = "SELECT * FROM (" + "select rownum n, b.* " +
	 * "from (select * from notice order by no desc) b" + ") " +
	 * "where n between ? and ?";
	 * 
	 * NoticeVo nVo = null; List<NoticeVo> list = new ArrayList<NoticeVo>(); // List
	 * 컬렉션 객체 생성
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null; // 동적 쿼리 ResultSet rs
	 * = null;
	 * 
	 * try { conn = DBManager.getConnection();
	 * 
	 * // (3단계) Statement 객체 생성 pstmt = conn.prepareStatement(sql); pstmt.setInt(1,
	 * 1+(page-1)*10); pstmt.setInt(2, page*10);
	 * 
	 * // (4단계) SQL문 실행 및 결과 처리 rs = pstmt.executeQuery();
	 * 
	 * // rs.next() : 다음 행(row)을 확인 // rs.getString("컬럼명") while (rs.next()) { nVo =
	 * new NoticeVo(); // 디비로부터 상품 정보 획득 nVo.setNo(rs.getInt("no"));
	 * nVo.setTitle(rs.getString("title")); nVo.setContent(rs.getString("content"));
	 * // DB에서 가져온 정보를 pVo객체에 저장 nVo.setFiles(rs.getString("files"));
	 * nVo.setWriteDate(rs.getDate("writeDate"));
	 * 
	 * list.add(nVo); // list 객체에 데이터 추가 } } catch (Exception e) {
	 * e.printStackTrace(); } finally { DBManager.close(conn, pstmt, rs); } return
	 * list; }
	 * 
	 * // 특정 컬럼의 키워드를 통해 게시물 수 조회 public int getNoticeCount() { return
	 * getNoticeCount("title", ""); }
	 * 
	 * public int getNoticeCount(String column, String keyword) { int count = 0;
	 * return 0; }
	 * 
	 * // 게시물 번호로 특정 게시물의 다음 게시물 데이터 조회 public NoticeVo getNextNotice(int no) {
	 * NoticeVo nVo = null; return nVo; }
	 * 
	 * // 게시물 번호로 특정 게시물 이전 게시물 데이터 조회 public NoticeVo getPrevNotice(int no) {
	 * NoticeVo nVo = null; return nVo; }
	 */
	
}
