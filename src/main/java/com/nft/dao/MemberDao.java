package com.nft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nft.dto.MemberVo;
import com.nft.util.DBManager;

//데이터 베이스 접근
public class MemberDao {
	// 필드
	// 싱글톤으로 작성
	// 자기 자신이 객체를 하나 생성(싱글톤-이거하나만 생성 후 다른곳에서 생성하지 않음)
	private static MemberDao instance = new MemberDao();
	
	// 생성자
	private MemberDao(){
	}
	
	// 메소드
	// MemberDao 호출함수
	public static MemberDao getInstance() {
		return instance;
	}
	
	
	
	// 로그인(사용자 인증) : select
	// 입력값 : 로그인 페이지에서 입력받은 사용자 아이디와 비밀번호 
	// 반환값 : result (1:암호일치) (0:암호불일치) (-1: DB에 사용자 아이디 없음)
	public int checkUser(String userid, String idPwd) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = "select idPwd from NFT_MEMBER where userid=?";
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();

			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
//				System.out.println(rs.getString("idPwd"));
				// 아이디/암호 비교 후 페이지 이동
				if(rs.getString("idPwd") != null && rs.getString("idPwd").equals(idPwd)) {
					result = 1;		// 암호 일치
				} else {
					result = 0;		// 암호 불일치
				}
			}else {
				result = -1;		// DB에 userid가 없는 경우
			}
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}

	// 회원가입 : DB에 회원정보 삽입 : insert
	public int insertMember(MemberVo mVo) {
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

	// 회원 정보 가져오기 : select
	// 입력값 : userid를 사용 
	// 반환값 : 성공여부
	public MemberVo getMember(String userid) {
		String sql = "select * from NFT_MEMBER where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo mVo = null;
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
				// DB로부터 회원 정보를 획득
				// mVo에 데이터를 넣기
				mVo = new MemberVo();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setIdPwd(rs.getString("idPwd"));
				mVo.setBirth(rs.getString("birth"));
				mVo.setGender(rs.getString("gender"));
				mVo.setE_wallet(rs.getString("e_wallet"));
				mVo.setE_walletPwd(rs.getString("e_walletPwd"));
				mVo.setNationPhone(rs.getString("nationPhone"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setEmail_agree(rs.getInt("email_agree"));
				mVo.setPhone_agree(rs.getInt("phone_agree"));
			}else {
				System.out.println("아이디가 존재하지 않습니다.");		// DB에 userid가 없는 경우
			}
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}	
		// mVo값을 리턴값으로 설정
		return mVo;
	}
	
	// 회원 정보 업데이트 : update
	// 입력값 : 회원 테이블 정보
	// 반환값 : 성공여부
	public int updateMember(MemberVo mVo) {
		int result = -1;
		String sql = "update NFT_MEMBER set idPwd=?, e_walletPwd=?, phone=?, email_agree=?, phone_agree=? where userid=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getIdPwd());
			pstmt.setString(2, mVo.getE_walletPwd());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setInt(4, mVo.getEmail_agree());
			pstmt.setInt(5, mVo.getPhone_agree());
			pstmt.setString(6, mVo.getUserid());
			
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
	
	// 회원 정보 업데이트 : update
	// 입력값 : 회원 테이블 정보
	// 반환값 : 성공여부
	public int changePwd(MemberVo mVo) {
		int result = -1;
		String sql = "update NFT_MEMBER set idPwd=? where userid=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getIdPwd());
			pstmt.setString(2, mVo.getUserid());
			
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
	
	// 아이디를 확인 : select
	// 입력값 : 중복체크하려는 userid
	// 반환값 : userid가 DB에 존재 여부, result(-1:사용가능 / 1:중복)
	public int confirmID(String userid) {
		int result = -1;
		String sql ="select userid from NFT_MEMBER where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
				// DB로부터 회원 정보를 획득
				result = 1;			// DB에 userid가 있는 경우
			}else {
				result = -1;		// DB에 userid가 없는 경우
			}
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
	
		return result;
	}

	// 이름, 핸드폰, 이메일(인증)으로 아이디 찾기
	// 아이디를 확인:select
	// 반환값 : DB에 이름,핸드폰,이메일에 맞는 존재 여부, result(1:성공/ -1:실패)
	public int findId(MemberVo mVo) {
		int result = -1;
		String sql ="select userid from NFT_MEMBER where name=? and phone=? and e_wallet=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getPhone());
			pstmt.setString(3, mVo.getE_wallet());
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();

			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
				// DB로부터 회원 정보를 획득
				result = 1;			// DB에 userid가 있는 경우
				mVo.setUserid(rs.getString("userid"));
				System.out.println(result);
			}else {
				result = -1;		// DB에 userid가 없는 경우
				System.out.println(result);
			}		
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
		
		return result;
	}
	
	// 이름, 핸드폰, 이메일(인증)으로 아이디 찾기
	// 아이디를 확인:select
	// 반환값 : DB에 이름,핸드폰,이메일에 맞는 존재 여부, result(1:성공/ -1:실패)
	public int findPwd(MemberVo mVo) {
		int result = -1;
		String sql ="select idPwd from NFT_MEMBER where userid=? and phone=? and e_wallet=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// DBManager에 정의된 DB연결 함수
			// JDBC 드라이버 로드 및 데이터 베이스 연결 객체 생성
			conn = DBManager.getConnection();
			
			// Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getUserid());
			pstmt.setString(2, mVo.getPhone());
			pstmt.setString(3, mVo.getE_wallet());
			
			
			// SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			
			// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
			if(rs.next()){
				// DB로부터 회원 정보를 획득
				result = 1;			// DB에 userid가 있는 경우
				System.out.println(result);
				mVo.setIdPwd(rs.getString("idPwd"));
				System.out.println(rs.getString("idPwd"));
			}else {
				result = -1;		// DB에 userid가 없는 경우
				System.out.println(result);
			}		
		} catch(Exception e) {			
			e.printStackTrace();
		} finally {
			// 사용한 리소스 해제
			DBManager.close(conn, pstmt, rs);
		}		
		
		return result;
	}



////////////////// 추가
	
	//전체 회원 조회
	public List<MemberVo> selectAllmembers() {
		String sql = "select * from NFT_MEMBER order by userid";

		List<MemberVo> list = new ArrayList<MemberVo>(); // List 컬렉션 객체 생성

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
				// rs.getInt("컬럼명");
				MemberVo mVo = new MemberVo();
				// 디비로부터 회원 정보 획득
				
				mVo.setName(rs.getString("name")); // DB에서 가져온 정보를 pVo객체에 저장
				mVo.setUserid(rs.getString("userid")); // 컬럼명 userid인 정보를 가져옴
				mVo.setIdPwd(rs.getString("idPwd"));
				mVo.setBirth(rs.getString("birth"));
				mVo.setGender(rs.getString("gender"));
				mVo.setE_wallet(rs.getString("e_wallet"));
				mVo.setE_walletPwd(rs.getString("e_walletPwd"));
				mVo.setNationPhone(rs.getString("nationPhone"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setEmail_agree(rs.getInt("email_agree"));
				mVo.setPhone_agree(rs.getInt("phone_agree"));

				list.add(mVo); // list 객체에 데이터 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 상품 삭제
	public void deleteMember(String userid) {
		int result = -1;
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
		PreparedStatement pstmt = null; // 동적 쿼리

		String sql = "delete from NFT_MEMBER where userid=?";

		try {
			conn = DBManager.getConnection();

			// (3 단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			// (4 단계) SQL문 실행 및 결과 처리
			// executeUpdate : 삽입(insert/update/delete)
			result = pstmt.executeUpdate(); // 쿼리 수행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}


}
