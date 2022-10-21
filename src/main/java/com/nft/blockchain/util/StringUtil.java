package com.nft.blockchain.util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;


public class StringUtil {
	// Sha256을 적용 - input을 받아 Sha256형식으로 16진수 hash 값을 생성
	public static String applySha256(String input) {
		try {
			// MessageDigest : 메시지 다이제스트는 임의 크기의 데이터를 사용하고 고정 길이 해시 값을 출력하는 안전한 단방향 해시 함수입니다.
			// MessageDigest.getInstance("SHA-256") : SHA-256 알고리즘을 구현하는 MessageDigest 객체를 반환
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			// input.getBytes("UTF-8") : 명명된 문자 집합을 사용하여 이 문자열을 바이트 시퀀스로 인코딩하고 결과를 새 바이트 배열에 저장합니다.
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				// toHexString(int) : 정수 인수의 문자열 표현을 16진법의 부호 없는 정수로 반환합니다.
				// hex 는 11111111과 hash[i]를 and 연산한 값
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// ECDSA 서명을 적용하고 결과를 바이트로 반환합니다.
	// Applies ECDSA Signature and returns the result ( as bytes ).
	public static byte[] applyECDSASig(PrivateKey privateKey, String input) {
		Signature dsa;
		byte[] output = new byte[0];
		try {
			// 입력 받은 privateKey와 input(data: A와 B의 공개키 + value)값을 byte[]로 받아 realSig을 반환
			
			// ECDSA 서명 알고리즘을 구현하는 Signature 객체를 반환
			dsa = Signature.getInstance("ECDSA", "BC");
			// initSign(privateKey)) : 서명을 위해 이 개체를 초기화, 이 메서드가 다른 인수로 다시 호출되면 무효화됨
			dsa.initSign(privateKey);
			byte[] strByte = input.getBytes();
			// update(strByte) : strByte 배열을 사용하여 서명하거나 확인할 데이터를 업데이트
			dsa.update(strByte);
			// sign() : 업데이트 된 모든 데이터의 서명바이트를 반환
			byte[] realSig = dsa.sign();
			output = realSig;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return output;
	}

	// Verifies a String signature
	// 문자열 서명 확인
	public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {
		try {
			// ECDSA 서명 알고리즘을 구현하는 Signature 객체를 반환
			Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
			// 확인을 위해 이 개체를 초기화
			// 이 메서드가 다른 인수로 다시 호출되면 이 호출의 효과가 무효화됩니다
			ecdsaVerify.initVerify(publicKey);
			// 지정된 바이트 배열을 사용하여 서명하거나 확인할 데이터를 업데이트
			ecdsaVerify.update(data.getBytes());
			
			// 개체가 재설정되고 initVerify 호출에서 공개 키가 지정된 ID의 다른 서명을 확인하는 데 사용
			// boolean 형식으로 반환 true : 서명 데이터 일치 
			return ecdsaVerify.verify(signature);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 입력받은 key 값을 Base64 인코딩 형식으로 인코딩
	public static String getStringFromKey(Key key) {
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}
}