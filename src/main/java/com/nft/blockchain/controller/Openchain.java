package com.nft.blockchain.controller;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.GsonBuilder;
import com.nft.blockchain.util.StringUtil;


/**
 * 블럭체인의 간단한 구현으로 이해를 돕기 위해 목적으로 구성하고 있습니다.
 * 
 * @author comnic
 *
 */
public class Openchain {

	// blockchain ArrayList
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	// list of all unspent transactions.
	// 사용되지 않은 모든 거래 목록.
	public static HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>(); 
	
	//difficulty - 숫자가 클수록 어렵다. target생성 규칙상.
	//3이상은 좀 오래걸리는 듯 합니다. 초기에 3으로 하시고 숫자를 조절해 보시면 이해가 되실듯 합니다.^^
	public static int difficulty = 1;
	public static float minimumTransaction = 0.1f;
	
	public static Wallet walletA;
	public static Wallet walletB;
	public static Wallet walletC;
	
	/**
	 * main
	 * @param arg
	 */
	public static void main(String[] arg){

		// Setup Bouncey castle as a Security Provider
		// 보안 공급자로 바운시 캐슬 설정
		// 설정하지 않으면 wallet의 key생성 불가능
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); 
		
		//Create the new wallets
		// 지갑 A,B 객체 생성
		
		walletB = new Wallet();
		walletC = new Wallet();

		// A에 PublicKey, PrivateKey를 생성
		walletA.generateKeyPair();
		// B에 PublicKey, PrivateKey를 생성
		walletB.generateKeyPair();
		walletC.generateKeyPair();
		// Test public and private keys
		// A의 public and private keys 값을 확인
//		System.out.println("Private and public keys:");
		System.out.println(StringUtil.getStringFromKey(walletA.privateKey));
		System.out.println(StringUtil.getStringFromKey(walletA.privateKey).length());
		System.out.println(StringUtil.getStringFromKey(walletA.publicKey));
		System.out.println(StringUtil.getStringFromKey(walletA.publicKey).length());
		// 생성된 walletA와 B의 키로 서명을 만들수있는지 확인하기 위한 코드
		// 테스트를 위한 Transaction생성(WalletA -> walletB : 100)  
		Transaction transaction = new Transaction(walletA.publicKey, walletB.publicKey, 100, null);
		// 생성된 Transaction에 서명합니다. 서명생성 
		transaction.generateSignature(walletA.privateKey);
//		transaction.generateSignature(walletB.privateKey);
		//서명한 Transaction을 검증합니다. 
		System.out.println("Is this Transaction Verify? " + transaction.verifiySignature());
//		System.out.println("Is this Transaction Verify? " + transaction.verifiySignature());
		transaction.processTransaction();
		System.out.println(transaction.transactionId);
		System.out.println(UTXOs);
		
		Transaction transaction2 = new Transaction(walletA.publicKey, walletC.publicKey, 100, null);
		// 생성된 Transaction에 서명합니다. 서명생성 
		transaction2.generateSignature(walletA.privateKey);
//		transaction.generateSignature(walletB.privateKey);
		//서명한 Transaction을 검증합니다. 
		System.out.println("Is this Transaction Verify? " + transaction2.verifiySignature());
//		System.out.println("Is this Transaction Verify? " + transaction.verifiySignature());
		transaction2.processTransaction();
		System.out.println(transaction2.transactionId);
		System.out.println(UTXOs);
		
		// 위는 월렛 관련부분
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
		// 아래는 해시 및 채굴관련 부분
		
		// 초기 블럭을 만듭니다.
		// 제네시스블록(genesis block)은 블록체인에서 생성된 첫 번째 블록을 말한다.
		// 첫 번째 블록이 생성된 이후에 다음 블록이 지속적으로 생성되어 마치 체인처럼 이전 블록에 연결되기 때문에,
		// 제네시스블록이 생성되었다는 것은 해당 블록체인 네트워크가 시작되었다는 상징적 의미를 가지고 있다.
		// 초기블럭인 Genesis block 생성, 이전 해시는 0으로 입력
		blockchain.add(new Block("Genesis block", "0"));
		System.out.println("\nTrying to Mine Genesis block!");
		blockchain.get(0).mineBlock(difficulty);
		
		// 이후 블럭을 생성합니다.
		for(int i = 1 ; i <= 10 ; i++){
			// blockchain 리스트에 block 값을 생성해서 추가하는 로직
			// i 값의 변화로 Block(data 변함, i-1의 해시값(= previousHash))
			blockchain.add(new Block("block " + i, blockchain.get(blockchain.size()-1).hash));
			System.out.printf("\nTrying to Mine block #%d", i+1 );
			blockchain.get(i).mineBlock(difficulty);
		}
		
		//전체 blockchain이 정상인지 체크합니다.
		System.out.println("\nBlockchain is Valid : " + isChainValid());
		
		//전체 블럭을 출력합니다.
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nOpenchain Block list : ");
		System.out.println(blockchainJson);
		

	}
	
	/**
	 * blockchain이 유효한지 체크합니다.
	 *  - 현재 블럭의 hash가 유효한 값인지 체크한다.
	 *  - 이전 블럭의 hash값과 동일한지 체크한다.
	 * @return
	 */
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;

		//전체 블럭을 체크합니다.
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			
			//현재 블럭의 hash가 맞는지 체크합니다.
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			
			//이전 블럭의 hash값과 동일한지 체크합니다.
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}	
}
