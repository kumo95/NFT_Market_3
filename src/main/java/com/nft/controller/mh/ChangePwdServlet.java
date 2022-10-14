package com.nft.controller.mh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.dao.MemberDao;
import com.nft.dto.MemberVo;


@WebServlet("/changePwd.do")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// 포스트 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();	
		
		// 데이터베이스에 수정된 정보를 업데이트
		String userid = request.getParameter("userid");
		String idPwd = request.getParameter("idPwd");
		System.out.println(userid);
		System.out.println(idPwd);
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		mVo.setUserid(userid);
		mVo.setIdPwd(idPwd);

		
		int result = mDao.changePwd(mVo);
		
		HttpSession saveKey = request.getSession();
		saveKey.invalidate();
		
		if(result == 1) {
			out.println("<script>alert('비밀번호변경에 성공했습니다.'); location.href='login.do';</script>\r\n");
			out.close();
		}else {
			out.println("<script>alert('비밀번호변경에 실패했습니다.'); location.href='login.do';</script>\r\n");
			out.close();
		}


	}

}
