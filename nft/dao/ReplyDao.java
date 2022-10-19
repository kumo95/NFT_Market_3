package com.nft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nft.dto.QnaVo;
import com.nft.dto.ReplyVo;
import com.nft.util.DBManager;

public class ReplyDao {
	// 생성자
	private ReplyDao() {
	}

	// 싱글톤 생성 및 사용
	private static ReplyDao instance = new ReplyDao();

	// 메소드
	public static ReplyDao getInstance() {
		return instance;
	}

	// 답변글 등록
	// 입력값 : 전체 게시글 정보
	// 반환값 : 쿼리 수행 결과
	public int insertReply(ReplyVo rVo) {

		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null; // 동적 쿼리
		String sql = "insert into reply(bno,reply,replyer,replyDate,updateDate) values(reply_seq.nextval, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// pstmt.setInt(1, rVo.getNo());
			pstmt.setString(1, rVo.getReply());
			pstmt.setString(2, rVo.getReplyer());
			pstmt.setDate(3, (Date) rVo.getReplyDate());
			pstmt.setDate(4, (Date) rVo.getUpdateDate());
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

	// 회원 정보 가져오기: select
	// 입력값: 사용자id(userid)
	// 반환값: 해당 회원 정보
	public ReplyVo getReply(String bno) {
		/* int result = -1; */
		String sql = "select * from reply where bno = ?";
		ReplyVo rVo = null;
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
				rVo = new ReplyVo();
				// 디비로부터 회원 정보 획득
				rVo.setRno((long) rs.getInt("rno"));
				rVo.setBno((long) rs.getInt("bno"));
				rVo.setReply(rs.getString("reply"));
				rVo.setReplyer(rs.getString("replyer"));
				rVo.setReplyDate(rs.getDate("replyDate"));
				rVo.setUpdateDate(rs.getDate("updateDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rVo;
	}

}
