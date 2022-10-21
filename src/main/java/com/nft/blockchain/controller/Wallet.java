package com.nft.blockchain.controller;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
	public PrivateKey privateKey;
	public PublicKey publicKey;

	public void generateKeyPair() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA",	"BC");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");

			// Initialize the key generator and generate a KeyPair
			// 키 생성기 초기화 및 KeyPair 생성
			// 256 bytes provides an acceptable security level
			// 허용 가능한 보안 수준을 제공하는 256바이트
			keyGen.initialize(ecSpec, random); 

			KeyPair keyPair = keyGen.generateKeyPair();
			
			// Set the public and private keys from the keyPair
			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
