package com.nft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.dao.CartProductDao;
import com.nft.dto.CartProductVo;
import com.nft.dto.MemberVo;

@WebServlet("/cartList.do")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo mVo = (MemberVo) session.getAttribute("loginUser"); 
		String userid = mVo.getUserid();	

		
		// 카트 목록 불러오기
		CartProductDao cpDao = CartProductDao.getInstance();
		System.out.println(cpDao);
		
		// 모든 상품 리스트를 디비로부터 조회하여 저장		
//		ProductVo[] productList = pDao.selectAllProducts();
		List<CartProductVo> cartList = cpDao.selectAllCartProducts(userid);
		request.setAttribute("cartList", cartList);
		
		System.out.println("userid  "+userid);
		System.out.println(cartList);
		
		// 리스트 페이지로 이동
		// 리다이렉트 방식 페이지 이동
		//response.sendRedirect("product/cartList.jsp");
		// 포워드 방식 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/cartList.jsp");
		dispatcher.forward(request, response);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
