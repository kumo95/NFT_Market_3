package com.nft.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nft.dao.ProductDao;
import com.nft.dto.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/updateProduct.do")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링으로 전달 받은 code를 획득
		String unique_no = request.getParameter("unique_no");
		
		// 상품 삭제 링크 클릭시 이동하여 수정할 상품 정보를 표시
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 데이터베이스에서 수정할 데이터 정보 확인
		pVo = pDao.selectProductByCode(unique_no);
		
		request.setAttribute("product", pVo);
		
		// 페이지 이동 : 수정 페이지
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/regist.jsp");
		dispatcher.forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 수정 코드 : 데이터베이스에서 상품 수정
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 파일 업로드 코드 작성
		
		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("저장파일 서버경로: "+uploadFilePath);
		int uploadFileSizeLimit = 5* 1024 * 1024;
		String encType = "UTF-8";
		
		try {
		
			MultipartRequest multi = new MultipartRequest(
					request,						// request 객체
					uploadFilePath,					// 서버상 실제 디렉토리
					uploadFileSizeLimit,			// 최대 업로드 파일 크기
					encType,						// 인코딩 방식
					new DefaultFileRenamePolicy()	// 정책: 동일 이름 존재시, 새로운 이름 부여
					);
			
			// 입력 양식을 통해 정보를 획득
			String creator = multi.getParameter("creator");
			String owner = multi.getParameter("owner");
			String unique_no = multi.getParameter("unique_no");
			String p_name = multi.getParameter("p_name");
			//int price = Integer.parseInt(multi.getParameter("price"));
			Double price = Double.parseDouble(multi.getParameter("price"));
			String nftUrl = multi.getFilesystemName("nftUrl");
			String description = multi.getParameter("description");
			int edition = Integer.parseInt(multi.getParameter("edition"));
			Date reg_date = Date.valueOf(multi.getParameter("reg_date"));
			
			pVo.setCreator(creator);
			pVo.setOwner(owner);
			pVo.setUnique_no(unique_no);
			pVo.setP_name(p_name);
			pVo.setPrice(price);
			pVo.setNftUrl(nftUrl);
			pVo.setDescription(description);
			pVo.setEdition(edition);
			pVo.setReg_date(reg_date);
		
		} catch (Exception e) {
			System.out.println("파일 업로드간 예외 발생: " + e);
		}
		
		// 데이터베이스로부터 해당 코드의 정보를 수정
		result = pDao.updateProduct(pVo);
		
		// 정상적인 상품 수정 여부를 확인
		if(result == 1) {
			System.out.println("상품수정 성공");
		} else {
			System.out.println("상품수정 실패");
		}
//		수정후 마이 페이지로 이동
		response.sendRedirect("myPage.do");
	}

}
