package com.nft.controller.hr;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	BufferedImage image1;
	BufferedImage image2;
	
	public String makeNFT(String nftUrl, String fileName, String select) {
		fileName = fileName + ".png";
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BufferedImage combinedImage;
	
		try {
			//배경이미지를 불러온다. 유저가 업로드한 사진
			//image1 = ImageIO.read(getClass().getClassLoader().getResource("호랑이.png"));
			//image1 = ImageIO.read(new File("c:\\image1.gif"));
			image1 = ImageIO.read(new File("C:\\java_work\\.metadata\\.plugins\\org.eclipse.wst.server.core"
					+ "\\tmp0\\wtpwebapps\\NFT_MARKET\\upload\\"+nftUrl));
			
			System.out.println(nftUrl);
			//그 위에 덮씌울 이미지를 불러온다. 우리가 준비한 사진
			if(select.equals("1")) {
				System.out.println(1);
				image2 = ImageIO.read(getClass().getClassLoader().getResource("할로윈1.png"));
			} if(select.equals("2")) {
				image2 = ImageIO.read(getClass().getClassLoader().getResource("트리1.png"));
				System.out.println(2);
			} if(select.equals("3")){
				image2 = ImageIO.read(getClass().getClassLoader().getResource("네온1.png"));
				System.out.println(3);
			}
			
			// 합쳐진 이미지 사이즈
			//combinedImage = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
			combinedImage = new BufferedImage(300,300, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = combinedImage.createGraphics();			
			// 좌표 위치
			g.drawImage(image1, 0, 0, null);
			g.drawImage(image2, 0, 0, null);
			
					g.dispose();
					
					JLabel label = new JLabel();
					window.add(label);
					label.setIcon(new ImageIcon(combinedImage));
				
					System.out.println("받은 파일이름"+fileName);
					
					// 파일저장 
					try {
						// ImageIO.write(combinedImage, "PNG", new File("C:\\java_work\\NFT_MARKET20221013\\img\\combinedImage.png"));
						ImageIO.write(combinedImage, "PNG", new File("C:\\java_work\\.metadata\\.plugins\\"
								+ "org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\NFT_MARKET\\upload\\"
								+fileName));
					} catch(IOException e) {
						
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
		//window.pack();
		//window.setVisible(true);	// 이미지 화면에 띄우기
		return fileName;
	}
}
