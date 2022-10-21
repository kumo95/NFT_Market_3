package com.nft.blockchain.controller;

import java.security.PublicKey;

import com.nft.blockchain.util.StringUtil;



public class TransactionOutput {
	public String id;
	
	// also known as the new owner of these coins.
	// 이 코인의 새 소유자라고도 합니다.
	public PublicKey reciepient; 
	
	// the amount of coins they own
	// 자신이 소유한 코인의 양
	public float value;
	
	// the id of the transaction this output was created in
	// 이 출력이 생성된 트랜잭션의 ID
	public String parentTransactionId; 
	
	// Constructor 생성자
	public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTransactionId;
		// applySha256(String input) 인풋 값
		// 코인 새 소유자의 PublicKey를 base64 인코딩 형식 + 자신이 소유한 코인의 양 + 이 출력이 생성된 트랜잭션의 ID
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
		
	}
	
	// Check if coin belongs to you
	// 코인이 본인 소유인지 확인
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == reciepient);
	}
	
}