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
			//version1
			//배경이미지를 불러온다. 유저가 업로드한 사진
			//image1 = ImageIO.read(getClass().getClassLoader().getResource("호랑이.png"));
			//image1 = ImageIO.read(new File("c:\\image1.gif"));
			image1 = ImageIO.read(new File("C:\\java_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\NFT_MARKET\\upload\\"+nftUrl));
			System.out.println(nftUrl);
			//그 위에 덮씌울 이미지를 불러온다. 우리가 준비한 사진
			if(select.equals("1")) {
				System.out.println(1);
				image2 = ImageIO.read(getClass().getClassLoader().getResource("트리1.png"));
			} if(select.equals("2")) {
				image2 = ImageIO.read(getClass().getClassLoader().getResource("고양이1.png"));
				System.out.println(2);
			} if(select.equals("3")){
				image2 = ImageIO.read(getClass().getClassLoader().getResource("개1.png"));
				System.out.println(3);
			}
			
//			image2 = ImageIO.read(getClass().getClassLoader().getResource("개1.png"));
//			image2 = ImageIO.read(getClass().getClassLoader().getResource("고양이1.png"));
//			image2 = ImageIO.read(getClass().getClassLoader().getResource("트리1.png"));
			

//			image2 = ImageIO.read(new File("c:\\image2.gif"));
		
			
//			//배경이미지의 크기대로 메모리이미지 크기를 구성한다. 
//			int width = bg.getWidth(); 
//			int height = bg.getHeight(); 
//			BufferedImage tmp = new BufferedImage( width, height, page.getType() ); 
			
//			//메모리이미지에서 Graphics2D를 얻어온다. 
//			Graphics2D g = tmp.createGraphics(); 
			
//			//메모리이미지에 그림을 그리자. 으싸 으싸~ 
//			g.drawImage( bg, null, 0, 0 ); 
//			g.drawImage( front, 10, 10, 100, 100, null ); 
			
//			//메모리 이미지를 파일로 저장한다. 
//			File file = new File( "c:/3.jpg" ); 
//			ImageIO.write(tmp, "jpeg", file); 
			
			
			//combinedImage = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
			combinedImage = new BufferedImage(300,300, BufferedImage.TYPE_INT_ARGB);
			
			Graphics2D g = combinedImage.createGraphics();
			
			// 좌표 위치??
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
						ImageIO.write(combinedImage, "PNG", new File("C:\\java_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\NFT_MARKET\\upload\\"
								+fileName));
					} catch(IOException e) {
						
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
		//window.pack();
		//window.setVisible(true);
		return fileName;

	
	}

	
}
