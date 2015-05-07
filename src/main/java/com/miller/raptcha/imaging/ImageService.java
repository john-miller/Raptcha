package com.miller.raptcha.imaging;

import java.awt.Image;

public interface ImageService {

	public Image createImageFromString(String imageData, int width, int height);
	
	
}
