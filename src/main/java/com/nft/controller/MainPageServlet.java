package com.nft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;

@WebServlet("/main.do")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 상품 리스트를 디비로부터 조회하여 저장		
		ProductDao pDao = ProductDao.getInstance();
		
		List<ProductVo> productList = pDao.selectAllProducts();
		request.setAttribute("productList", productList);
		System.out.println(productList);
		
		// 페이지 이동 forward 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
		dispatcher.forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 상품 리스트를 디비로부터 조회하여 저장		
		ProductDao pDao = ProductDao.getInstance();
		
		List<ProductVo> productList = pDao.selectAllProducts();
		request.setAttribute("productList", productList);
		System.out.println(productList);
		
		// 페이지 이동 forward 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher("mainPage.jsp");
		dispatcher.forward(request,response);
		
	}

}
