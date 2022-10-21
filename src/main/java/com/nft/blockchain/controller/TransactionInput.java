package com.nft.blockchain.controller;

public class TransactionInput {
	// Reference to TransactionOutputs -> transactionId
	// TransactionOutputs -> transactionId에 대한 참조
	public String transactionOutputId;	
	// Contains the Unspent transaction output
	// 미사용 트랜잭션 출력을 포함합니다.
	public TransactionOutput UTXO;
	
	public TransactionInput(String transactionOutputId) {
		this.transactionOutputId = transactionOutputId;
	}
}