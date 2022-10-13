package com.nft.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.MemberDao;


@WebServlet("/checkId.do")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// js에서 보낸 userid 받아서 변수에 할당
		String userid = request.getParameter("userid");		
		
		// 입력한 아이디를 DB에서 조회하여 동일한 아이디가 없는지 확인
		MemberDao mDao = MemberDao.getInstance();
		
		int result = mDao.confirmID(userid);
		if(result==1) {
			request.setAttribute("message", "이 아이디는 사용 불가능 합니다.");
		}else if(result==-1) {
			request.setAttribute("message", "이 아이디는 사용 가능 합니다.");			
		}
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/checkId.jsp");
		dispatcher.forward(request, response);		// 페이지 이동
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
