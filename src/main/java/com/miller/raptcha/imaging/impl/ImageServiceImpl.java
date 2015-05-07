package com.miller.raptcha.imaging.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.miller.raptcha.imaging.ImageService;

public class ImageServiceImpl implements ImageService {

	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(new ImageServiceImpl().createImageFromString("This is a test sentence", 500, 50))));
	}
	
	@Override
	public Image createImageFromString(String imageData, int width, int height) {
		
		int padding = width / (imageData.length() == 0 ? 1 : imageData.length());
		
		/* Get all available fonts */
		Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_GRAY);
		Graphics graphics2D = image.createGraphics();
		graphics2D.setColor(Color.white);
		graphics2D.fillRect(0, 0, width, height);
		
		for(int i = 0; i < imageData.length(); i++)
			drawText(graphics2D, String.valueOf(imageData.toCharArray()[i]), (i * 20) + padding, Color.black, chooseRandomFont(fonts));
		
		return image;
	}
	
	private void drawText(Graphics graphics2D, String imageData, int index, Color color, Font font)
	{
		font = font.deriveFont(20f);
		graphics2D.setFont(font);
		graphics2D.setColor(Color.black);
		String drawString = (getRandomBool() ? imageData : imageData.toUpperCase());
		graphics2D.drawString(drawString, index, 25 + new Random().nextInt(10));
	}
	
	private boolean getRandomBool()
	{
		return Math.random() < 0.5;
	}
	
	private Font chooseRandomFont(Font[] fonts)
	{
		Random random = new Random();
		int index = random.nextInt(fonts.length);
		return fonts[index];
	}
	
}
