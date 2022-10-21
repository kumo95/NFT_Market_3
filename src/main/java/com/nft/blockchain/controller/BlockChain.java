package com.nft.blockchain.controller;

import com.nft.blockchain.dto.BlockChainVo;
import com.nft.blockchain.util.StringUtil;

public class BlockChain {
	/**
	 * 새로운 해시값을 생성합니다.
	 * @return
	 */
	BlockChainVo bcVo = new BlockChainVo(); 
	String hash = bcVo.getHash();
	
	public String calculateHash(BlockChainVo bcVo) {
		String calculatedhash = StringUtil.applySha256( 
				bcVo.getPreviousHash() +
				Long.toString(bcVo.getTimestamp()) +
				Integer.toString(bcVo.getNonce()) + 
				bcVo.getData()
				);
		return calculatedhash;
	}

	
	/**
	 * 채굴합니다.
	 * 
	 * @param difficulty
	 */
	public void mineBlock(BlockChainVo bcVo) {
		int difficulty = 3; // 난이도
		//간단한 테스트와 이해를 돕기위해 target을 difficulty 숫자 만큼 앞에 0으로 채웁니다.
		String target = new String(new char[difficulty]).replace('\0', '0');
		
		//생성된 hash가 target과 동일하면 채굴 성공입니다.
		//ex) difficulty가 3이면 target은 000이 되고, 생성된 hash가 000으로 시작하는 값이면 채굴 성공입니다.
		//  채굴된 모든 hash가 000으로 시작하겠죠...ㅋㅋ
		while(!hash.substring( 0, difficulty).equals(target)) {
//			nonce ++;
			hash = calculateHash(bcVo);
			
			System.out.printf("\nGEN Hash #%d : %s", /*nonce,*/ hash);
		}
		System.out.println("\n채굴 성공!!! : " + hash);
	}
	
}
