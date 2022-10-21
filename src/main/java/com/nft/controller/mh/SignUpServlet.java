package com.nft.controller.mh;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nft.blockchain.controller.Wallet;
import com.nft.blockchain.dao.BlockChainDao;
import com.nft.blockchain.util.StringUtil;
import com.nft.dao.MemberDao;
import com.nft.dto.EwalletVo;
import com.nft.dto.MemberVo;

@WebServlet("/signUp.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Wallet wallet;
	
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
		
		int result = mDao.insertMember(mVo);		

		// 세선설정
		HttpSession saveKey = request.getSession();
		saveKey.invalidate();
		
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
		
//		// 블록체인 구현할 때 쓸 코드
//		// oracle에 있는 nft_wallet에 userid, e_wallet, e_walletPwd, privateKey, publicKey, money 값 넣기
//		EwalletVo eVo = new EwalletVo();
//		BlockChainDao bcDao = BlockChainDao.getInstance();
//		
//		// Setup Bouncey castle as a Security Provider
//		// 보안 공급자로 바운시 캐슬 설정
//		// 설정하지 않으면 wallet의 key생성 불가능
//		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
//		// wallet클래스를 객체로 생성해서 private/public key를 생성
//		wallet = new Wallet();
//		wallet.generateKeyPair();
//		String privatekey = StringUtil.getStringFromKey(wallet.privateKey);
//		String publickey = StringUtil.getStringFromKey(wallet.publicKey);
//		
//		// EwalletVo에 데이터 설정
//		eVo.setUserid(userid);
//		eVo.setE_wallet(e_wallet);
//		eVo.setE_walletPwd(e_walletPwd);
//		eVo.setPrivatekey(privatekey);
//		eVo.setPublickey(publickey);
//		eVo.setMoney(0);	// 계좌 생성 시 0원으로 생성
//		
//		// DB의 NFT_wallet에 데이터를 넣어주는 함수
//		int result2 = bcDao.insertNFT_wallet(eVo);
				
//		if (result == 1 && result2 == 1) {
		

		
	}

}
