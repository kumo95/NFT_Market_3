package com.nft.blockchain.controller;

public class testAES256 {
	public static void main(String args[])  throws Exception  {
        AES256 aes256 = new AES256();
        String text = "펭수의 우울한 하루-jophinesss-111-20221020";
        String cipherText = aes256.encrypt(text);
        System.out.println(text);
        System.out.println(cipherText);
        System.out.println(aes256.decrypt(cipherText));
        
        String saveUniqueCode = cipherText;
        System.out.println(saveUniqueCode);
        String decCode = aes256.decrypt(saveUniqueCode);
        System.out.println(decCode);
        System.out.println(text.length());
	}
}
