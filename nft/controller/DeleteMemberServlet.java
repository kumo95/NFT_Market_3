package com.nft.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.MemberDao;
import com.nft.dto.MemberVo;


@WebServlet("/deleteMember.do")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 링크 클릭시 삭제할 상품 정보를 표시
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		// 퀘리 스트링으로 전달 받은 code를 획득
		String userid = request.getParameter("userid");

		// DB에서 삭제할 데이터 정보 확인
		mVo = mDao.getMember(userid);
		
		System.out.println("삭제할 정보 확인: "+ userid);
		
		request.setAttribute("member", mVo);

		// 페이지 이동 : 삭제 페이지
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("nft/deleteMember.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 코드 : DB에서 상품 삭제
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();	
		
		String userid = request.getParameter("userid");
		System.out.println("userid 삭제: "+ userid);
		
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();

		// DB로부터 해당 코드의 정보 삭제
		mDao.deleteMember(userid);

		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("memberList.do");
	}

}
