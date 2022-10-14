package com.nft.controller.mh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션을 사용하는 경우
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 종료
		
		// 페이지 이동 : 로그인
		// 리다이렉트 방식 페이지 이동
//		response.sendRedirect("member/login.jsp");
		// 포워드 방식 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
		dispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
