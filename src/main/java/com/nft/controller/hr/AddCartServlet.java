package com.nft.controller.hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.CartProductDao;
import com.nft.dto.CartProductVo;

@WebServlet("/addCart.do")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		
		CartProductDao cpDao = CartProductDao.getInstance();
		CartProductVo cpVo = new CartProductVo();

		String userid = request.getParameter("userid");
		String creator = request.getParameter("creator");
		String unique_no = request.getParameter("unique_no");
		String nftUrl = request.getParameter("nftUrl");
		String p_name = request.getParameter("p_name");
		//int price = Integer.parseInt(request.getParameter("price"));
		Double price = Double.parseDouble(request.getParameter("price"));

		System.out.println(price);
	//상품 정보 Vo에 저장
		cpVo.setUserid(userid);
		cpVo.setCreator(creator);
		cpVo.setUnique_no(unique_no);			
		cpVo.setNftUrl(nftUrl);
		cpVo.setP_name(p_name);		
		cpVo.setPrice(price);
		
		cpDao.cartAdd(cpVo);
		
		System.out.println(cpVo);
		System.out.println(price);
		
		System.out.println();
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("product/cartList.jsp");
//		dispatcher.forward(request, response);
		
		response.sendRedirect("cartList.do");
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
