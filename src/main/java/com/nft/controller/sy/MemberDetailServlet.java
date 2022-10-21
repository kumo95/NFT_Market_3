package com.nft.controller.sy;

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


@WebServlet("/memberDetail.do")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		//out.println(code);
		
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		mVo = mDao.getMember(userid);
		//System.out.println(pVo);
		
		request.setAttribute("member", mVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("nft/member_detail.jsp");
		dispatcher.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
