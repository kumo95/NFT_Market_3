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

import com.nft.dao.ProductDao;
import com.nft.dto.MemberVo;
import com.nft.dto.ProductVo;

@WebServlet("/creatorProduct.do")
public class CreatorProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo mVo = (MemberVo) session.getAttribute("loginUser"); 
		String creator = mVo.getUserid();
		
		ProductDao pDao = ProductDao.getInstance();
		
		// 모든 상품 리스트를 디비로부터 조회하여 저장		
//		ProductVo[] productList = pDao.selectAllProducts();
		List<ProductVo> MyproductList = pDao.selectCreatorProducts(creator);
		request.setAttribute("MyproductList", MyproductList);
//		System.out.println(productList.size());
//		System.out.println(productList.get(0));
		
		// 리스트 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/myPageCreator.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
