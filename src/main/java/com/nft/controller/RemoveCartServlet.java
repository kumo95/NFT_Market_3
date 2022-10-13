package com.nft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.CartProductDao;

@WebServlet("/removeCart.do")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 코드 : 데이터베이스에서 상품 삭제
		CartProductDao cpDao = CartProductDao.getInstance();
		
		String unique_no = request.getParameter("unique_no");
		String userid = request.getParameter("userid");
		
		// 데이터베이스로 부터 해당 코드의 정보를 삭제
		cpDao.deleteCartProduct(unique_no, userid);
		
		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("cartList.do");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
