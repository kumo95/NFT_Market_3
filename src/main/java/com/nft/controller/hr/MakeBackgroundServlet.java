package com.nft.controller.hr;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.dto.MemberVo;


@WebServlet("/makeBackground.do")
public class MakeBackgroundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		MemberVo mVo = (MemberVo) session.getAttribute("loginUser");
		
		// NFTURL 파일명을 다르게 설정하기 위해 새로운파일명(newNftUrl)을 userid+날짜+시간으로 설정
		//date 쓰고 java.util.Date 임포트
		Date d = new Date();
		//java.text.SimpleDateFormat 임포트 형식 이렇게 쓰면 가능
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		// time에 sdf로 가져온 포맷 d 담기
		String time = sdf.format(d);

		System.out.println(time);
		
		String fileName = mVo.getUserid() + time;
		System.out.println(fileName);
		String nftUrl = request.getParameter("nftUrl");		
//		System.out.println("url="+nfturl);
		//request.setAttribute("nftUrl", nftUrl);
		
		// 사용자가 선택한 배경 (select=1,2,3)
		String select = request.getParameter("select");
		System.out.println(select);
		Main main1 = new Main();
		String newNftUrl = main1.makeNFT(nftUrl, fileName, select);
		
		request.setAttribute("nftUrl", nftUrl);
		request.setAttribute("newNftUrl", newNftUrl);

		// 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/makeNFT.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("makeNFT.do");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
}
