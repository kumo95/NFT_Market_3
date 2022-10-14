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

@WebServlet("/signUp.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String warning_text = request.getParameter("warning_text");
//		String warning_text = "중복 체크해주세요.";
//		request.setAttribute("warning_text", warning_text);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/signUp.jsp");
		dispatcher.forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
			
		// 회원 가입에서 작성한 데이터를 데이터 베이스에 삽입 insert
		String userid = request.getParameter("userid");
		String idPwd = request.getParameter("idPwd");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String e_wallet = request.getParameter("e_wallet");
		String e_walletPwd = request.getParameter("e_walletPwd");
		int email_agree = Integer.parseInt(request.getParameter("email_agree"));
		String nationPhone = request.getParameter("nationPhone");
		String phone = request.getParameter("phone");
		int phone_agree = Integer.parseInt(request.getParameter("phone_agree"));
		
//		System.out.println((userid));
//		System.out.println((idPwd));
//		System.out.println((name));
//		System.out.println((birth));
//		System.out.println((gender));
//		System.out.println((e_wallet));
//		System.out.println((e_walletPwd));
//		System.out.println((email_agree));
//		System.out.println((nationPhone));
//		System.out.println((phone));
//		System.out.println((phone_agree));
		
		MemberDao mDao = MemberDao.getInstance();
		
		MemberVo mVo = new MemberVo();
		mVo.setUserid(userid);
		mVo.setIdPwd(idPwd);
		mVo.setName(name);
		mVo.setBirth(birth);
		mVo.setGender(gender);
		mVo.setE_wallet(e_wallet);
		mVo.setE_walletPwd(e_walletPwd);
		mVo.setEmail_agree(email_agree);
		mVo.setNationPhone(nationPhone);
		mVo.setPhone(phone);
		mVo.setPhone_agree(phone_agree);
		
		// 세선설정
		HttpSession saveKey = request.getSession();
		saveKey.invalidate();
		
		int result = mDao.insertMember(mVo);
		if (result == 1) {
//			System.out.println("회원가입 성공");
			out.println("<script>");
			out.println("alert('회원가입 성공'); location.href = 'login.do';");
			out.println("</script>");
			out.close();
		}else {
//			System.out.println("회원가입 실패");
			out.println("<script>");
			out.println("alert('회원가입 실패');");		// 다시 회원가입창으로 가는방법 생각해보기 location.href = 'login.do';
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
//		dispatcher.forward(request, response);		// 페이지 이동
		

		
	}

}
