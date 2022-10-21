package com.nft.controller.mh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.blockchain.dao.BlockChainDao;
import com.nft.dao.MemberDao;
import com.nft.dto.EwalletVo;
import com.nft.dto.MemberVo;

@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// updateMember.jsp로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/updateMember.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();	
		
		// 로그인 시 설정된 loginUser 세션을 불러와서 MemberVo에 할당
		HttpSession session = request.getSession();
		MemberVo mVo = (MemberVo) session.getAttribute("loginUser");

		// 데이터베이스에 수정된 정보를 업데이트
		String userid = mVo.getUserid();
		String idPwd = request.getParameter("newIdPwd");
		String e_walletPwd = request.getParameter("newE_walletPwd");
		String phone = request.getParameter("phone");
		int email_agree = Integer.parseInt(request.getParameter("email_agree"));
		int phone_agree = Integer.parseInt(request.getParameter("phone_agree"));
		
//		// 멤버Dao 객체를 생성 및 mVo에 데이터 삽입 후 updateMemeber 함수 실행
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.updateMember(mVo);
		
		
		if(result == 1) {
			out.println("<script>alert('개인정보변경에 성공했습니다.'); location.href='login.do';</script>\r\n");
			out.close();
		}else {
			out.println("<script>alert('개인정보변경에 실패했습니다.'); location.href='login.do';</script>\r\n");
			out.close();
		}
		
//		// 블록체인 구현할때 쓸 코드		
//		mVo.setUserid(userid);
//		mVo.setIdPwd(idPwd);
//		mVo.setE_walletPwd(e_walletPwd);
//		mVo.setPhone(phone);
//		mVo.setEmail_agree(email_agree);
//		mVo.setPhone_agree(phone_agree);
		
		
//		// 유저가 개인정보 변경을 하면 NFT지갑의 e_wallet 비밀번호도 변경
//		BlockChainDao bcDao = BlockChainDao.getInstance();
//		EwalletVo eVo = new EwalletVo();
//		eVo.setUserid(userid);
//		eVo.setE_walletPwd(e_walletPwd);
//		int result2 = bcDao.updateNFT_wallet(eVo);
			
		
//		// 블록체인 구현할때 쓸 코드		
//		if(result == 1 && result2 == 1) {
	}

}
