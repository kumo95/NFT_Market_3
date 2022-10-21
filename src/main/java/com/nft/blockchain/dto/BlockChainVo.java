package com.nft.blockchain.dto;

import java.util.Date;

public class BlockChainVo {
	private int num;
	private String hash;			/* 해시값 */
	private String previousHash;	/* 이전 블럭의 해시값 */
	private String data; 		/* 블럭의 data */
	private long timestamp; 	/* timestamp */
	// nonce의 초기값은 default로 0으로 시작한다
	private int nonce;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = new Date().getTime();
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	@Override
	public String toString() {
		return "BlockChainVo [num=" + num + ", hash=" + hash + ", previousHash=" + previousHash + ", data=" + data
				+ ", timestamp=" + timestamp + ", nonce=" + nonce + "]";
	}
	
}
