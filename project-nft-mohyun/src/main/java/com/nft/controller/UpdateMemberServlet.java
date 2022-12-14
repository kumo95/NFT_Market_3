package com.nft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.dao.MemberDao;
import com.nft.dto.MemberVo;

@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		세션 사용하지 않을 때
//		String userid = request.getParameter("loginUser.userid");
//		System.out.println("userid: "+ userid);
//		
//		MemberDao mDao = MemberDao.getInstance();		// 데이터베이스 연동
//		MemberVo mVo = mDao.getMember(userid);			// 데이터베이스로부터 회원정보 로딩
//		
//		request.setAttribute("mVo", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/updateMember.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();	
		HttpSession session = request.getSession();
		
		// 데이터베이스에 수정된 정보를 업데이트
		String userid = request.getParameter("userid");
		String idPwd = request.getParameter("newIdPwd");
		String e_walletPwd = request.getParameter("newE_walletPwd");
		String phone = request.getParameter("phone");
		int email_agree = Integer.parseInt(request.getParameter("email_agree"));
		int phone_agree = Integer.parseInt(request.getParameter("phone_agree"));
		
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		mVo.setUserid(userid);
		mVo.setIdPwd(idPwd);
		mVo.setE_walletPwd(e_walletPwd);
		mVo.setPhone(phone);
		mVo.setEmail_agree(email_agree);
		mVo.setPhone_agree(phone_agree);
		
		int result = mDao.updateMember(mVo);
		
		if(result == 1) {
			out.println("<script>alert('개인정보변경에 성공했습니다.'); location.href='login.do';</script>\r\n");
			out.close();
		}else {
			out.println("<script>alert('개인정보변경에 실패했습니다.'); location.href='login.do';</script>\r\n");
			out.close();
		}

	}

}
