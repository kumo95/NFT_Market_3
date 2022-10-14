package com.nft.controller.mh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.dao.MemberDao;
import com.nft.dto.MemberVo;


@WebServlet("/findId.do")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String e_wallet = request.getParameter("e_wallet");
		int result;
		MemberDao mDao = MemberDao.getInstance();
		
		MemberVo mVo = new MemberVo();
		mVo.setName(name);
		mVo.setE_wallet(e_wallet);
		mVo.setPhone(phone);
		
		result = mDao.findId(mVo);
		request.setAttribute("result", result);
		System.out.println(result);
//		if(result==1) {
//			String userid = mVo.getUserid();
//			request.setAttribute("userid", userid);
//		}else {
//			out.println("<script>");
//			out.println("alert('아이디를 찾지 못했습니다. <br> 입력 정보를 확인해주세요.')");
//			out.println("</script>");
//			out.close();
//		}
		
		String userid = mVo.getUserid();
		request.setAttribute("userid", userid);
		
		HttpSession saveKey = request.getSession();
		saveKey.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/FindId.jsp");
		dispatcher.forward(request, response);		// 페이지 이동
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
