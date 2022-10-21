package com.nft.controller.hr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/makeNewNftUrl.do")
public class MakeNewNftUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newNftUrl = request.getParameter("newNftUrl");
		
		request.setAttribute("fileControl", 1);
		request.setAttribute("newNftUrl", newNftUrl);
		
		
		// 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/regist.jsp");
		dispatcher.forward(request, response);	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
