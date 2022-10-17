package com.nft.controller.hr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.CartProductDao;

@WebServlet("/removeAllCart.do")
public class RemoveAllCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 삭제 코드 : 데이터베이스에서 상품 삭제
		CartProductDao cpDao = CartProductDao.getInstance();
		
		String userid = request.getParameter("userid");
		
		// 데이터베이스로 부터 해당 코드의 정보를 삭제
		cpDao.deleteCartAllProducts(userid);
		
		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("cartList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
