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

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";			// 현재 URL 페이지
		request.setAttribute("control", 1);
		
		// 세선설정
		HttpSession session = request.getSession();
		// 만약, 세션 속성이 유지되고 있는 동안(즉, 로그인이 되어있는 상태)에 main.jsp 페이지로 이동
		// session의 loginUser가 null이 아니면 이미 로그인이 되어있는 상태
		if(session.getAttribute("loginUser") != null) {
			url = "mainPage.jsp";
		}
		
		// 페이지 이동 forward 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		String url = "member/login.jsp";			// 현재 URL

		MemberDao mDao = MemberDao.getInstance();			// 데이터 베이스 연동
		
		String userId = request.getParameter("userId");		// 입력 양식으로 부터 가져온 ID
		String idPwd = request.getParameter("idPwd");	// 입력 양식으로 부터 가져온 PWD
		
		// 디비 연동 후, 가져올 (아이디,암호)
		int result = mDao.checkUser(userId, idPwd);
		
		if(result == 1) {
//			System.out.println("암호 일치");
			url = "mainPage.jsp";
			
			MemberVo mVo = mDao.getMember(userId);
//			System.out.println("회원 이름" +  mVo.getName());
			
			// 세선설정
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			
			request.setAttribute("name", mVo.getName());
			request.setAttribute("id", mVo.getUserid());
			request.setAttribute("control", 1);
			
		}else if(result == 0){
			System.out.println("비밀번호 불일치");
		}else {
			System.out.println("존재하지 않는 회원입니다.");
//			out.println("<html><head>");
//			out.println("<script> alert('존재하지 않는 회원입니다.') </script>");
//			out.println("<body></body></html>");
//			out.println("<script>alert('알럿메세지'); location.href='"+PageUrl+"';</script>"); 
//			out.close();
			//			url = "member/login.jsp";
		}		
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
		
	}

}
