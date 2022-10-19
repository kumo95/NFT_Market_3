package com.nft.controller.sy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.MemberDao;
import com.nft.dao.ProductDao;
import com.nft.dto.MemberVo;
import com.nft.dto.ProductVo;
import com.nft.dao.QnaDao;
import com.nft.dto.QnaVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/qnaWrite.do")
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("qna/write.jsp");
		dispatcher.forward(request, response); // 포워드 방식으로 페이지 이동
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // post방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// QNA 등록 데이터 처리
		QnaDao qDao = QnaDao.getInstance();
		QnaVo qVo = new QnaVo();

		int result = -1;

		String savePath = "upload";
		ServletContext context = getServletContext(); // 이 서블릿이 실행되고 있는 컨택스트 가져오기
		String uploadFilePath = context.getRealPath(savePath); // 실제 경로를 리턴
		System.out.println("저장파일 서버경로: " + uploadFilePath);
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";

		try {
			MultipartRequest multi = new MultipartRequest(request, // request 객체
					uploadFilePath, // 서버상의 실제 디렉토리
					uploadFileSizeLimit, // 최대 업로드 파일 크기
					encType, // 인코딩 방식
					new DefaultFileRenamePolicy()); // 정책 : 동일한 이름이 존재하면 새로운 이름이 부여됨

			// 입력 양식을 통해 정보를 획득
			/* int code = Integer.parseInt(multi.getParameter("code")); */
			String userid = multi.getParameter("userid");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			String files = multi.getFilesystemName("files");
			//int readcount = Integer.parseInt(multi.getParameter("readcount"));
			//Date writeDate = Date.valueOf(multi.getParameter("writeDate"));
			

			// pVo.setCode(code); // 입력된 상품 정보 Vo에 저장
			qVo.setUserid(userid);
			qVo.setTitle(title);
			qVo.setContent(content);
			qVo.setFiles(files);
			//qVo.setWriteDate(writeDate);
			
			System.out.println("qVo: "+qVo);

		} catch (Exception e) {
			System.out.println("파일 업로드 예외 발생: " + e);
		}

		System.out.println("입력: "+qVo); // 입력된 상품 정보 디버깅
		result = qDao.insertQna(qVo); // 입력된 상품 정보 삽입
		
		System.out.println("result: "+ result);

		// 정상적인 상품 등록 여부 확인 / 정상 등록 메세지를 브라우저에 출력을 위해 속성값 저장
		if (result == 1) {
			// 상품 등록 완료시, 상품 코드 저장
			System.out.println("게시글 등록 성공");
			request.setAttribute("message", "상품 등록 성공");
		} else {
			System.out.println("계시글 등록 실패");
			request.setAttribute("message", "상품 등록 실패");
		}
		response.sendRedirect("qnaList.do"); // 상품 등록 후 리스트 확인 위해 페이지 이동

		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("qna/list.jsp");
		 * dispatcher.forward(request, response); // 포워드 방식으로 페이지 이동
		 */		 
	}

}
