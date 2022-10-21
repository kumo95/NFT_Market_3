package com.nft.blockchain.controller;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

import com.nft.blockchain.util.StringUtil;
import com.nft.blockchain.controller.Openchain;

public class Transaction {
	
	// This is also the hash of the transaction.
	// 이것은 트랜잭션의 해시이기도 합니다.
	public String transactionId; 
	// senders address/public key.
	// 발신자 주소/공개 키
	public PublicKey sender; 
	// Recipients address/public key.
	// 받는 사람 주소/공개 키.
	public PublicKey reciepient; 
	public float value;
	// 이것은 다른 사람이 우리 지갑에 자금을 지출하는 것을 방지하기 위한 것입니다
	// this is to prevent anybody else from spending funds in our wallet.
	public byte[] signature; 
	
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
	
	// a rough count of how many transactions have been generated.
	// 얼마나 많은 트랜잭션이 생성되었는지에 대한 대략적인 계산입니다
	// 시퀀스를 사용하기 위해서는 DB에서 생성해야 할듯?
	private static int sequence = 0;  
	
	// Constructor: 생성자
	public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.reciepient = to;
		this.value = value;
		this.inputs = inputs;
	}
	
	// This Calculates the transaction hash (which will be used as its Id)
	// 이것은 트랜잭션 해시(ID로 사용됨)를 계산합니다.
	private String calulateHash() {
		// //increase the sequence to avoid 2 identical transactions having the same hash
		// 동일한 해시를 갖는 2개의 동일한 트랜잭션을 피하기 위해 시퀀스를 늘립니다.
		sequence++; 
		return StringUtil.applySha256(
				StringUtil.getStringFromKey(sender) +
				StringUtil.getStringFromKey(reciepient) +
				Float.toString(value) + sequence
				);
	}
	
	// Signs all the data we dont wish to be tampered with.
	// 변조를 원하지 않는 모든 데이터에 서명합니다.
	public void generateSignature(PrivateKey privateKey) {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value)	;
		signature = StringUtil.applyECDSASig(privateKey,data);	
//		System.out.println("data 확인 1 : " + data);
	}
	// Verifies the data we signed hasnt been tampered with
	// 서명한 데이터가 변조되지 않았는지 확인합니다.
	// 일치하면 true
	public boolean verifiySignature() {
		String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value)	;
//		System.out.println("data 확인 2 : " + data);
		return StringUtil.verifyECDSASig(sender, data, signature);
	}
	
	// Returns true if new transaction could be created.	
	// 새로운 트랜잭션을 생성할 수 있으면 true를 반환합니다.
	public boolean processTransaction() {
			// 서명이 일치하지 않을 시 동작
			if(verifiySignature() == false) {
				System.out.println("#Transaction Signature failed to verify");
				return false;
			}
					
			// gather transaction inputs (Make sure they are unspent):
			// 트랜잭션 입력 수집(사용되지 않았는지 확인)
//			for(TransactionInput i : inputs) {
//				i.UTXO = Openchain.UTXOs.get(i.transactionOutputId);
//			}

			// check if transaction is valid:
			// 트랜잭션이 유효한지 확인:
//			if(getInputsValue() < Openchain.minimumTransaction) {
//				System.out.println("#Transaction Inputs to small: " + getInputsValue());
//				return false;
//			}
			
			// generate transaction outputs:
			// 트랜잭션 출력 생성:
			// get value of inputs then the left over change:
			// leftOver : 기존에 있던 value - (sender->recipient로)보내주는 value
//			float leftOver = getInputsValue() - value;
			transactionId = calulateHash();
			outputs.add(new TransactionOutput( this.reciepient, value,transactionId)); //send value to recipient
//			outputs.add(new TransactionOutput( this.sender, leftOver,transactionId)); //send the left over 'change' back to sender		
					
			// add outputs to Unspent list
			// 미사용 목록에 출력 추가
			for(TransactionOutput o : outputs) {
				Openchain.UTXOs.put(o.id , o);
			}
			
			// remove transaction inputs from UTXO lists as spent:
			// 지출된 UTXO 목록에서 트랜잭션 입력을 제거합니다.
//			for(TransactionInput i : inputs) {
//				if(i.UTXO == null) continue; //if Transaction can't be found skip it 
//				Openchain.UTXOs.remove(i.UTXO.id);
//			}
			
			return true;
		}
		
	// returns sum of inputs(UTXOs) values
	// 입력(UTXO) 값의 합을 반환
		public float getInputsValue() {
			float total = 0;
			for(TransactionInput i : inputs) {
				// if Transaction can't be found skip it
				// 트랜잭션을 찾을 수 없으면 건너뜁니다.
				if(i.UTXO == null) continue;  
				total += i.UTXO.value;
			}
			return total;
		}
			
}