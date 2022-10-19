package com.nft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.MemberDao;
import com.nft.dto.MemberVo;


@WebServlet("/memberList.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mDao = MemberDao.getInstance();
		
		// 모든 회원 리스트를 DB로부터 조회하여 출력
		List<MemberVo> memberList = mDao.selectAllmembers();
		// System.out.println(memberList.size());
		request.setAttribute("memberList", memberList);		
		System.out.println("memberList: " + memberList);
		
		// 리스트 페이지로 이동
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("nft/memberList.jsp");
		dispatcher.forward(request, response);
		
		System.out.println("nft/memberList: " +memberList);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
