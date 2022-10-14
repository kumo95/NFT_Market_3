package com.nft.controller.sy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.NoticeDao;
import com.nft.dto.NoticeVo;


@WebServlet("/noticeDatail.do")
public class NoticeDatailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String no = request.getParameter("no");
		
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeVo nVo = new NoticeVo();
		
		nVo = nDao.getNotice(no);
		//System.out.println(pVo);
		
		request.setAttribute("notice", nVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice/detail.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
