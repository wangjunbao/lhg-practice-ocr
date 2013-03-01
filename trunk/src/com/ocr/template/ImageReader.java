package com.ocr.template;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.MemoryCacheImageInputStream;

public class ImageReader {

	private int imageNumber = 0;
	
//	private Log log = LogFactory.getLog(ImageReader.class);
	public ImageInfo readFromDisk(String imagePath){
		if(!imagePath.endsWith(".bmp")&&!imagePath.endsWith(".jpg")&&!imagePath.endsWith(".png")){
			// TODO
		}
		ImageInfo imageInfo = new ImageInfo();
		File imageFile = new File(imagePath);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnImageInfo(imageInfo, imageFile, bufferedImage);
	}
	public ImageInfo readFromJar(String imagePath){
		if(!imagePath.endsWith(".bmp")&&!imagePath.endsWith(".jpg")&&!imagePath.endsWith(".png")){
			// TODO
		}
		InputStream in=null;
		ImageInfo imageInfo = new ImageInfo();
		File imageFile = new File(imagePath);
		BufferedImage bufferedImage = null;
		try {
			String currentJarPath = URLDecoder.decode(ImageReader.class.getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
//			log.error(currentJarPath);
//			log.error(imagePath);
			JarFile currentJar = new JarFile(currentJarPath);
			JarEntry dbEntry = currentJar.getJarEntry(imagePath);//获取当前Jar文件名，并对其解码，防止出现中文乱码
			in = currentJar.getInputStream(dbEntry); 
			bufferedImage = ImageIO.read(in);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnImageInfo(imageInfo, imageFile, bufferedImage);
	}
	private ImageInfo returnImageInfo(ImageInfo imageInfo, File imageFile,
			BufferedImage bufferedImage) {
		int[][] template = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];
		imageInfo.setHeight(bufferedImage.getHeight());
		imageInfo.setWidth(bufferedImage.getWidth());
//		Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
		for(int y=0;y<template.length;y++){
			for(int x=0;x<template[y].length;x++){
				template[y][x] = bufferedImage.getRGB(x, y) & 0x00FFFFFF;
//				System.out.print(template[y][x]==0?"*":" ");
			}
//			System.out.println();
		}
		
		imageInfo.setColor(template);
		imageInfo.setName(imageFile.getName());
		imageInfo.setPath(imageFile.getPath());
		return imageInfo;
	}
	public ImageInfo readFromInputStream(InputStream imageStream){
		ImageInfo imageInfo = new ImageInfo();
//		File imageFile = new File(imagePath);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new MemoryCacheImageInputStream(imageStream));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[][] template = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];
		imageInfo.setHeight(bufferedImage.getHeight());
		imageInfo.setWidth(bufferedImage.getWidth());
//		Graphics2D graphics = (Graphics2D)bufferedImage.getGraphics();
		for(int y=0;y<template.length;y++){
			for(int x=0;x<template[y].length;x++){
				template[y][x] = bufferedImage.getRGB(x, y) & 0x00FFFFFF;
//				System.out.print(template[y][x]==0?"*":" ");
			}
//			System.out.println();
		}
		
		imageInfo.setColor(template);
//		imageInfo.setName(imageFile.getName());
//		imageInfo.setPath(imageFile.getPath());
		return imageInfo;
	}
	public void initTemplate(String imageDir){
//		TemplateBuffer.getInstance().clear();
		if(imageDir==null||"".equals(imageDir)) {
			imageDir = ImageReader.class.getResource("imagefile/1_1").getPath();
//			log.info(imageDir);
		}
		File imageFiles = new File(imageDir);
		if(imageFiles.isDirectory()){
			File[] files = imageFiles.listFiles();
			for(File file : files){
				if(file.isFile()){
					if(!file.getName().endsWith(".bmp")&&!file.getName().endsWith(".jpg")&&!file.getName().endsWith(".png")){
						// TODO 
						continue;
					}
					TemplateBuffer.getInstance().addTemplate("TEMPLATE_"+(++imageNumber), readFromDisk(file.getPath()));
				}else{
					initTemplate(file.getPath());
				}
			}
		}else{
			TemplateBuffer.getInstance().addTemplate("TEMPLATE_"+(++imageNumber), readFromDisk(imageFiles.getPath()));
		}
	}
	
	public void initTemplateByJar(String filePath) {
		int start = filePath.lastIndexOf("/");
		int end =filePath.indexOf(".");
//		log.info(filePath.substring(start+1, end));
//		TemplateBuffer.getInstance().addTemplate(filePath.substring(start+1, end), readFromJar(filePath));
		TemplateBuffer.getInstance().addTemplate("TEMPLATE_"+(++imageNumber), readFromJar(filePath));
	}
//	private void findImageFromDir(String path){
//		File imageFiles = new File(path);
//		if(imageFiles.isDirectory()){
//			String[] files = imageFiles.list();
//			for(String file : files){
//				File _file = new File(file);
//				if(_file.isFile()){
//					TemplateBuffer.getInstance().addTemplate(_file.getName(), readFromDisk(_file.getPath()));
//				}else{
//					findImageFromDir(_file.getPath());
//				}
//			}
//		}else{
//			TemplateBuffer.getInstance().addTemplate(imageFiles.getName(), readFromDisk(imageFiles.getPath()));
//		}
//	}
	
}
